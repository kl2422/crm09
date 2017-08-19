package com.shsxt.crm.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.github.miemiedev.mybatis.paginator.domain.Paginator;
import com.shsxt.crm.dao.CustomerDao;
import com.shsxt.crm.dao.CustomerLossDao;
import com.shsxt.crm.dao.OrderDao;
import com.shsxt.crm.dto.CustomerLossQuery;
import com.shsxt.crm.model.Customer;
import com.shsxt.crm.model.CustomerLoss;
import com.shsxt.crm.util.AssertUtil;

@Service
public class CustomerLossService {
	
	@Autowired
	private CustomerDao customerDao;
	@Autowired
	private CustomerLossDao customerLossDao;
	@Autowired
	private OrderDao orderDao;
	
	/**
	 * 定时获取流失客户存入数据库
	 */
	public void runLossCustomer() {
		List<CustomerLoss> customerLosses = new ArrayList<>();
		
		// 没有产生过订单的客户 + 六月前创建客户
		List<Customer> customers = customerDao.findLossCustomer();
		List<Integer> customerIds = new ArrayList<>();
		addCustomerLosses(customers, 0, customerLosses, customerIds);
		
		// 六个月前产生的订单的客户
		List<Customer> customersOrders = customerDao.findLossCustomerNoOrderLongTime();
		addCustomerLosses(customersOrders, 1, customerLosses, customerIds);
		
		// 批量插入
		if(customerLosses.size() > 0) {
			customerLossDao.insertBatch(customerLosses);
		}
		
		// 更新客户状态 
		Integer[] customerIdArr = customerIds.toArray(new Integer[]{});
		customerDao.updateStates(StringUtils.join(customerIdArr));
	}
	
	public Map<String, Object> selectForPage(CustomerLossQuery 
			query) {

		PageList<CustomerLoss> customerLosses = customerLossDao.selectForPage
				(query, query.buildPageBounds());
		Paginator paginator = customerLosses.getPaginator(); // 分页对象
		Map<String, Object> result = new HashMap<>();
		result.put("rows", customerLosses);
		result.put("total", paginator.getTotalCount());
		return result;
	}

	public void confirmLoss(Integer lossId, String lossReason) {
		// 更新流失原因
		AssertUtil.isTrue(lossId == null || lossId < 1, "请选择记录");
		AssertUtil.isTrue(StringUtils.isEmpty(lossReason), "请输入流失原因");
		CustomerLoss customerLoss = customerLossDao.loadById(lossId);
		AssertUtil.notNull(customerLoss, "该客户并没有流失， 请确定");
		customerLoss.setLossReason(lossReason);
		customerLoss.setState(1);
		customerLossDao.update(customerLoss);
		// 更新t_customer的状态为 1:已流失
		customerDao.updateLossState(customerLoss.getCusNo());
	}

	public CustomerLoss loadById(Integer id) {
		AssertUtil.isTrue(id == null || id < 1, "请选择记录");
		return customerLossDao.loadById(id);
	}
	
	/**
	 * 将数据添加到集合
	 * @param customers
	 * @param type
	 * @param customerLosses
	 */
	private void addCustomerLosses(List<Customer> customers, int type,
			List<CustomerLoss> customerLosses, List<Integer> customerIds) {
		for (Customer customer : customers) {
			CustomerLoss customerLoss = new CustomerLoss();
			customerLoss.setCreateDate(new Date());
			customerLoss.setCusManager(customer.getCusManager());
			customerLoss.setCusName(customer.getName());
			customerLoss.setCusNo(customer.getKhno());
			customerLoss.setIsValid(1);
			customerLoss.setState(0);
			customerLoss.setUpdateDate(new Date());
			if (type == 1) {
				Date orderDate = orderDao.findCustomerOrderDate(customer.getId());
				customerLoss.setLastOrderTime(orderDate);
			}
			customerLosses.add(customerLoss);
			customerIds.add(customer.getId());
		}
	}
}

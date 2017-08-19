package com.shsxt.crm.service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.shsxt.crm.constant.CustomerServeStatus;
import com.shsxt.crm.dao.CustomerServeDao;
import com.shsxt.crm.dto.CustomerServeQuery;
import com.shsxt.crm.model.CustomerServe;
import com.shsxt.crm.util.AssertUtil;

@Service
public class CustomerServeService {
	
	@Autowired
	private CustomerServeDao customerServeDao;
	
	/**
	 * 添加或者修改
	 * @param customerServe
	 */
	public void addOrUpdate(CustomerServe customerServe) {
		
		if (customerServe.getId() == null || customerServe.getId() < 1) { // 添加
			// 基本参数验证
			String serveType = customerServe.getServeType();
			AssertUtil.isNotEmpty(serveType, "请选择服务类型");
			String customer = customerServe.getCustomer();
			AssertUtil.isNotEmpty(customer, "请输入客户名称");
			String overview = customerServe.getOverview();
			AssertUtil.isNotEmpty(overview, "请输入概要");
			String serveRequest = customerServe.getServiceRequest();
			AssertUtil.isNotEmpty(serveRequest, "请输入服务请求");
			customerServeDao.insert(customerServe);
		} else { // 修改
			if (CustomerServeStatus.ASSIGNED.getName().equals(customerServe.getState())) { // 已分配状态
				// 要有分配人
				String assigner = customerServe.getAssigner();
				AssertUtil.isNotEmpty(assigner, "请选择分配人");
				// 分配时间
				customerServe.setAssignTime(new Date());
			} else if (CustomerServeStatus.HANDLED.getName().equals(customerServe.getState())) { // 已处理
				String serviceProce = customerServe.getServiceProce();
				AssertUtil.isNotEmpty(serviceProce, "请输入处理内容");
				customerServe.setServiceProceTime(new Date());
			} else if (CustomerServeStatus.ARCHIVE.getName().equals(customerServe.getState())) {
				String serviceProceResult = customerServe.getServiceProceResult();
				AssertUtil.isNotEmpty(serviceProceResult, "请输入反馈结果");
				String myd = customerServe.getMyd();
				AssertUtil.isNotEmpty(myd, "请选择客户满意度");
			}
			customerServe.setUpdateDate(new Date());
			customerServeDao.update(customerServe);
		}
	}
	
	/**
	 * 分页查询
	 * @param query
	 * @return
	 */
	public Map<String, Object> selectForPage(CustomerServeQuery query) {
		PageList<CustomerServe> customerServes = customerServeDao.selectForPage(query, query.buildPageBounds());
		Map<String, Object> result = new HashMap<>();
		result.put("rows", customerServes);
		result.put("total", customerServes.getPaginator().getTotalCount());
		return result;
	}
	
	
	
	
}

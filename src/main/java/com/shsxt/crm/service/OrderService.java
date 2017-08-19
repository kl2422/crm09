package com.shsxt.crm.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.github.miemiedev.mybatis.paginator.domain.Paginator;
import com.shsxt.crm.dao.OrderDao;
import com.shsxt.crm.dto.ContactQuery;
import com.shsxt.crm.model.Order;
import com.shsxt.crm.util.AssertUtil;

@Service
public class OrderService {
	
	@Autowired
	private OrderDao orderDao;

	public Map<String, Object> selectForPage(ContactQuery query) {
		AssertUtil.intIsNotEmpty(query.getCustomerId(), "请选择客户");
		PageList<Order> orders = orderDao.selectForPage(query, query.buildPageBounds());
		Paginator paginator = orders.getPaginator(); // 分页对象
		Map<String, Object> result = new HashMap<>();
		result.put("rows", orders);
		result.put("total", paginator.getTotalCount());
		return result;
	}
	
	public Order findById(Integer orderId) {
		AssertUtil.intIsNotEmpty(orderId, "请选择订单");
		Order order = orderDao.findById(orderId);
		return order;
	}
}

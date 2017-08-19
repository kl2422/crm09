package com.shsxt.crm.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shsxt.crm.base.BaseController;
import com.shsxt.crm.dto.ContactQuery;
import com.shsxt.crm.model.Customer;
import com.shsxt.crm.model.Order;
import com.shsxt.crm.service.CustomerService;
import com.shsxt.crm.service.OrderService;

@RequestMapping("order")
@Controller
public class OrderController extends BaseController {
	
	@Autowired
	private OrderService orderService;
	@Autowired
	private CustomerService customerService;
	
	@RequestMapping("index")
	public String index(Model model, Integer customerId) {
		model.addAttribute("customerId", customerId);
		Customer customer = customerService.findById(customerId);
		model.addAttribute("customer", customer);
		return "order";
	}
	
	@RequestMapping("list")
	@ResponseBody
	public Map<String, Object> list(ContactQuery query) {
		Map<String, Object> result = orderService.selectForPage(query);
		return result;
	}
	
	@RequestMapping("detail")
	@ResponseBody
	public Order detail(Integer orderId) {
		Order order = orderService.findById(orderId);
		return order;
	}
	
	
}

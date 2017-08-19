package com.shsxt.crm.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shsxt.crm.base.BaseController;
import com.shsxt.crm.base.BaseQuery;
import com.shsxt.crm.base.ResultInfo;
import com.shsxt.crm.service.OrderDetailService;

@RequestMapping("order_details")
@Controller
public class OrderDetailController extends BaseController {
	
	@Autowired
	private OrderDetailService orderDetailService;
	
	@RequestMapping("getTotalPrice")
	@ResponseBody
	public ResultInfo getTotalPrice(Integer orderId) {
		Integer total = orderDetailService.getTotalPrice(orderId);
		return success(total);
	}
	
	@RequestMapping("list")
	@ResponseBody
	public Map<String, Object> getTotalPrice(Integer orderId, BaseQuery query) {
		Map<String, Object> result = orderDetailService.selectForPage(orderId, query);
		return result;
	}
	
}

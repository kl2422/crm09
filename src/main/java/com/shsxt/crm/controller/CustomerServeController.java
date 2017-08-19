package com.shsxt.crm.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shsxt.crm.base.BaseController;
import com.shsxt.crm.base.ResultInfo;
import com.shsxt.crm.dto.CustomerServeQuery;
import com.shsxt.crm.model.CustomerServe;
import com.shsxt.crm.service.CustomerServeService;

@Controller
@RequestMapping("customer_serve")
public class CustomerServeController extends BaseController {
	
	@Autowired
	private CustomerServeService customerServeService;
	
	@RequestMapping("index/{state}")
	public String index(@PathVariable Integer state) {
		switch (state) {
		case 1:
			return "customer_serve_create";
		case 2:
			return "customer_serve_assign";
		case 3:
			return "customer_serve_handle";
		case 4:
			return "customer_serve_feedback";
		case 5:
			return "customer_serve_archive";
		}
		return null;
		
	}

	
	@RequestMapping("add_update")
	@ResponseBody
	public ResultInfo addOrUpdate(CustomerServe customerServe) {
		customerServeService.addOrUpdate(customerServe);
		return success("操作成功");
	}
	
	@RequestMapping("list")
	@ResponseBody
	public Map<String, Object> list(CustomerServeQuery query) {
		Map<String, Object> result = customerServeService.selectForPage(query);
		return result;
	}

}

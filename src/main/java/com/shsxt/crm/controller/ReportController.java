package com.shsxt.crm.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shsxt.crm.base.BaseController;
import com.shsxt.crm.base.ResultInfo;
import com.shsxt.crm.dto.KhgxQuery;
import com.shsxt.crm.service.CustomerServeService;
import com.shsxt.crm.service.CustomerService;
import com.shsxt.crm.vo.CustomerFw;
import com.shsxt.crm.vo.CustomerGc;

@Controller
@RequestMapping("report")
public class ReportController extends BaseController {
	
	@Autowired
	private CustomerService customerService;
	@Autowired
	private CustomerServeService customerServeService;
	
	@RequestMapping("{type}")
	public String index(@PathVariable Integer type) {
		
		switch (type) {
		case 0:
			return "khgxfx";
		case 1:
			return "khgcfx";
		case 2:
			return "khfwfx";
		case 3:
			return "khlsfx";
		}
		
		return "khgxfx";
	}
	
	@RequestMapping("khgxfx")
	@ResponseBody
	public Map<String, Object> findKhgx(KhgxQuery query) {
		Map<String, Object> result = customerService.findKhgx(query);
		return result;
	}
	
	@RequestMapping("khgcfx")
	@ResponseBody
	public ResultInfo findKhgc() {
		List<CustomerGc> result = customerService.findKhgc();
		return success(result);
	}
	
	@RequestMapping("khfwfx")
	@ResponseBody
	public ResultInfo findKhfw() {
		List<CustomerFw> result = customerServeService.findCustomerFw();
		return success(result);
	}
	
}

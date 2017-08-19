package com.shsxt.crm.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shsxt.crm.base.BaseController;
import com.shsxt.crm.base.ResultInfo;
import com.shsxt.crm.dto.ContactQuery;
import com.shsxt.crm.model.Customer;
import com.shsxt.crm.model.LinkMan;
import com.shsxt.crm.service.CustomerService;
import com.shsxt.crm.service.LinkManService;

@Controller
@RequestMapping("linkman")
public class LinkManController extends BaseController {
	
	@Autowired
	private LinkManService linkManService;
	@Autowired
	private CustomerService customerService;
	
	@RequestMapping("index")
	public String index(Integer customerId, Model model) {
		Customer customer = customerService.findById(customerId);
		model.addAttribute("id", 100000);
		model.addAttribute("customer", customer);
		return "linkman";
	}
	
	@RequestMapping("list")
	@ResponseBody
	public Map<String, Object> list(ContactQuery query) {
		Map<String, Object> result = linkManService.selectForPage(query);
		return result;
	}
	
	@RequestMapping("add")
	@ResponseBody
	public ResultInfo add(LinkMan linkMan) {
		linkManService.save(linkMan);
		return success("添加成功");
	}
	
	@RequestMapping("update")
	@ResponseBody
	public ResultInfo update(LinkMan linkMan) {
		linkManService.update(linkMan);
		return success("修改成功");
	}
	
	@RequestMapping("delete")
	@ResponseBody
	public ResultInfo delete(Integer id) {
		linkManService.delete(id);
		return success("删除成功");
	}
}

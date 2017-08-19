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
import com.shsxt.crm.model.Contact;
import com.shsxt.crm.service.ContactService;
import com.shsxt.crm.service.CustomerService;

@Controller
@RequestMapping("contact")
public class ContactController extends BaseController {
	
	@Autowired
	private ContactService contactService;
	@Autowired
	private CustomerService customerService;
	
	@RequestMapping("index")
	public String index(Integer customerId, Model model) {
		Customer customer = customerService.findById(customerId);
		model.addAttribute("customer", customer);
		return "contact";
	}
	
	@RequestMapping("list")
	@ResponseBody
	public Map<String, Object> list(ContactQuery query) {
		Map<String, Object> result = contactService.selectForPage(query);
		return result;
	}
	
	@RequestMapping("add")
	@ResponseBody
	public ResultInfo add(Contact contact) {
		contactService.save(contact);
		return success("添加成功");
	}
	
	@RequestMapping("update")
	@ResponseBody
	public ResultInfo update(Contact contact) {
		contactService.update(contact);
		return success("修改成功");
	}
	
	@RequestMapping("delete")
	@ResponseBody
	public ResultInfo delete(Integer id) {
		contactService.delete(id);
		return success("删除成功");
	}
}

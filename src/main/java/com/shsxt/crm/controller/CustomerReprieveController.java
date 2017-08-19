package com.shsxt.crm.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shsxt.crm.base.BaseController;
import com.shsxt.crm.base.ResultInfo;
import com.shsxt.crm.model.CustomerLoss;
import com.shsxt.crm.service.CustomerLossService;
import com.shsxt.crm.service.CustomerReprieveService;

@Controller
@RequestMapping("customer_reprieve")
public class CustomerReprieveController extends BaseController {
	
	@Autowired
	private CustomerLossService customerLossService;
	@Autowired
	private CustomerReprieveService customerReprieveService;
	
	@RequestMapping("index")
	public String index(Model model, Integer lossId) {
		CustomerLoss customerLoss = customerLossService.loadById(lossId);
		model.addAttribute("customerLoss", customerLoss);
		return "customer_reprieve";
	}
	
	@RequestMapping("list")
	@ResponseBody
	public Map<String, Object> list(Integer lossId) {
		Map<String, Object> result = customerReprieveService.findAll(lossId);
		return result;
	}
	
	@RequestMapping("add")
	@ResponseBody
	public ResultInfo add(Integer lossId, String measure) {
		customerReprieveService.save(lossId, measure);
		return success("添加成功");
	}
	
	@RequestMapping("update")
	@ResponseBody
	public ResultInfo update(Integer id, String measure) {
		customerReprieveService.update(id, measure);
		return success("修改成功");
	}
	
	@RequestMapping("delete")
	@ResponseBody
	public ResultInfo delete(Integer id) {
		customerReprieveService.delete(id);
		return success("删除成功");
	}
}

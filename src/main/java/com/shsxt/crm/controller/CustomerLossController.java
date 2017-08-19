package com.shsxt.crm.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shsxt.crm.base.BaseController;
import com.shsxt.crm.base.ResultInfo;
import com.shsxt.crm.dto.CustomerLossQuery;
import com.shsxt.crm.model.CustomerLoss;
import com.shsxt.crm.service.CustomerLossService;

@Controller
@RequestMapping("customer_loss")
public class CustomerLossController extends BaseController {
	
	@Autowired
	private CustomerLossService customerLossService;
	
	@RequestMapping("index")
	public String index() {
		return "customer_loss";
	}

	@RequestMapping("list")
	public @ResponseBody Map<String, Object> selectForPage(CustomerLossQuery 
			customerLossQuery) {
		return customerLossService.selectForPage(customerLossQuery);
	}

	@RequestMapping("confirmLoss")
	@ResponseBody
	public ResultInfo confirmLoss(Integer lossId, String lossReason) {
		customerLossService.confirmLoss(lossId, lossReason);
		return success("操作成功");
	}

	@RequestMapping("detail")
	public @ResponseBody CustomerLoss loadById(Integer id) {
		CustomerLoss customerLoss = customerLossService.loadById(id);
		return customerLoss;
	}
}

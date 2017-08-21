package com.shsxt.crm.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shsxt.crm.annotation.RequirePermissions;
import com.shsxt.crm.base.BaseController;
import com.shsxt.crm.base.ResultInfo;
import com.shsxt.crm.constant.Constant;
import com.shsxt.crm.util.CookieUtil;

@Controller
public class IndexController extends BaseController {
	
	@RequestMapping("index")
	public String index() {
		return "index";
	}
	
	@RequestMapping("main")
	@RequirePermissions(permission = "1010")
	public String main(HttpServletRequest request, Model model) {
		
		String userName = CookieUtil.getCookieValue(request, "userName");
		model.addAttribute("userName", userName);
		String realName = CookieUtil.getCookieValue(request, "realName");
		model.addAttribute("realName", realName);
		
		return "main";
	}
	
	@RequestMapping("logout")
	@ResponseBody
	public ResultInfo logout(HttpServletRequest request, HttpServletResponse response) {
		// 清空权限的session
		request.getSession().removeAttribute(Constant.USER_PERMISSION_SESSION_KEY);
		// 清空cookie
		CookieUtil.deleteCookie("userIdString", request, response);
		CookieUtil.deleteCookie("userName", request, response);
		CookieUtil.deleteCookie("realName", request, response);
		
		return success("退出成功");
	}
}

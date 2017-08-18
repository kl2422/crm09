package com.shsxt.crm.base;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.shsxt.crm.exception.AuthException;
import com.shsxt.crm.exception.LoginException;
import com.shsxt.crm.exception.ParamException;

@ControllerAdvice // == Controller + ResponseBody
public class GlobalExceptionHandler extends BaseController {
	
	private static Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);
	
	@ExceptionHandler( value = {ParamException.class, IllegalAccessError.class})
	@ResponseBody
	public ResultInfo handlerParamException(ParamException paramException) {
		logger.error("参数异常：{}", paramException);
		return failure(paramException);
	}
	
	@ExceptionHandler( value = LoginException.class)
	public String handlerLoginException(LoginException loginException, 
			HttpServletRequest request, HttpServletResponse response, Model model) {
		
		logger.error("登录异常：{}", loginException);
		String xmlHttpRequest = request.getHeader("X-Requested-With");
		ResultInfo resultInfo = failure(loginException.getErrorCode(), 
				loginException.getMessage());
		if ("XMLHttpRequest".equals(xmlHttpRequest)) { // 如果是异步请求返回json
			response.setContentType("application/json;charset=utf-8");
			PrintWriter pw = null;
			try {
				pw = response.getWriter();
				pw.write(JSON.toJSONString(resultInfo));
			} catch (IOException e) {
				logger.error("传出json失败：{}", e);
			} finally {
				if (pw != null) {
					pw.close();
				}
			}
			return null;
		} else { // 跳转到登录
			model.addAttribute("resultInfo", resultInfo);
			model.addAttribute("ctx", request.getContextPath());
			return "error";
		}
	}
	
	@ExceptionHandler( value = AuthException.class)
	@ResponseBody
	public ResultInfo handlerLoginException(AuthException authException) {
		logger.error("权限认证异常：{}", authException);
		return failure(authException.getMessage());
	}
	
	@ExceptionHandler( value = Exception.class)
	@ResponseBody
	public ResultInfo handlerException(Exception paramException) {
		logger.error("系统异常：{}", paramException);
		return failure("系统异常");
	}
}

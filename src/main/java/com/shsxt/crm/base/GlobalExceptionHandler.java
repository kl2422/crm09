package com.shsxt.crm.base;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.shsxt.crm.exception.ParamException;

@RestControllerAdvice // == Controller + ResponseBody
public class GlobalExceptionHandler extends BaseController {
	
	private static Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);
	
	@ExceptionHandler( value = {ParamException.class, IllegalAccessError.class})
//	@ResponseBody
	public ResultInfo handlerParamException(ParamException paramException) {
		logger.error("参数异常：{}", paramException);
		return failure(paramException);
	}
	
//	@ExceptionHandler( value = ParamException.class)
////	@ResponseBody
//	public ResultInfo handlerException(ParamException paramException) {
//		logger.error("参数异常：{}", paramException);
//		return failure(paramException);
//	}
	
	@ExceptionHandler( value = Exception.class)
//	@ResponseBody
	public ResultInfo handlerException(Exception paramException) {
//		return failure(paramException);
		return null;
	}
//	
}

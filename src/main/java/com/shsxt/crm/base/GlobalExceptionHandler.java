package com.shsxt.crm.base;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shsxt.crm.exception.ParamException;

@ControllerAdvice
public class GlobalExceptionHandler extends BaseController {
	
	@ExceptionHandler( value = {ParamException.class, IllegalAccessError.class})
	@ResponseBody
	public ResultInfo handlerParamException(ParamException paramException) {
		return failure(paramException);
	}
	
//	@ExceptionHandler( value = Exception.class)
//	@ResponseBody
//	public ResultInfo handlerException(Exception paramException) {
//		return failure(paramException);
//	}
//	
}

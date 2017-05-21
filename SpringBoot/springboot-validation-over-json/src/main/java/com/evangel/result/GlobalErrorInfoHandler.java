package com.evangel.result;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 统一错误码异常处理
 *
 * Created by bysocket on 14/03/2017.
 */
// @RestControllerAdvice 是 @ControllerAdvice 和 @ResponseBody 的语义结合
@RestControllerAdvice
public class GlobalErrorInfoHandler {
	@ExceptionHandler(value = GlobalErrorInfoException.class)
	public ResultBody errorHandlerOverJson(HttpServletRequest request,
			GlobalErrorInfoException exception) {
		ErrorInfoInterface errorInfo = exception.getErrorInfo();
		ResultBody result = new ResultBody(errorInfo);
		return result;
	}
}

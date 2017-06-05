package org.jxjz.framework.exception;
import javax.servlet.http.HttpServletRequest;   
import javax.servlet.http.HttpServletResponse;   
  

import org.apache.log4j.Logger;
import org.jxjz.framework.util.LogUtil;
import org.springframework.web.servlet.HandlerExceptionResolver;   
import org.springframework.web.servlet.ModelAndView;   

public class ExceptionHandler implements HandlerExceptionResolver {   
	private Logger log = LogUtil.getLogger();
	@Override  
	    public ModelAndView resolveException(HttpServletRequest request,   
	            HttpServletResponse response, Object handler, Exception ex) {
			log.error("【系统发生异常】....."+ex.getMessage());
	        return new ModelAndView("error/error");   
	    }   
}

package org.jxjz.framework.exception;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jxjz.base.spring.BaseAction;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
 
/**
 * 系统管理员管理
 */
@Controller  
@RequestMapping("/sys/exception") 
public class ExceptionAction extends BaseAction {

	/**
	 *  
	 */
	@RequestMapping(params = "error")   
	public String error(Model model,HttpServletRequest request,HttpServletResponse response)  throws Exception{
			return "error/error";
	} 
	/**
	 *  
	 */
	@RequestMapping(params = "error500")   
	public String error500(Model model,HttpServletRequest request,HttpServletResponse response)  throws Exception{
		return "error/error_500";
	} 
	/**
	 *  
	 */
	@RequestMapping(params = "error404")   
	public String error404(Model model,HttpServletRequest request,HttpServletResponse response)  throws Exception{
		return "error/error_404";
	} 
	/**
	 *  
	 */
	@RequestMapping(params = "error403")   
	public String error403(Model model,HttpServletRequest request,HttpServletResponse response)  throws Exception{
		return "error/error_403";
	} 
	 
}

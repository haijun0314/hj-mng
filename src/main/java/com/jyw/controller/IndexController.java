package com.jyw.controller;
import org.jxjz.base.spring.BaseAction;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
 
/**
 * 
 */
@Controller  
@RequestMapping("/index") 
public class IndexController extends BaseAction {
	 
	/**
	 *  首页
	 */
	@RequestMapping(params = "sysIndex")  
	public String sysIndex() {
		 
		return "jyw/index";
	}    	
 
	
	
	
	
	
	
	
	 
}

package com.jyw.controller;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jxjz.base.spring.BaseAction;
import org.jxjz.framework.search.solr.SolrUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
/**
 *  用户管理
 *  @author chenjin
 *	createTime 2014-12-9
 */
@Controller
@RequestMapping("/customer")
public class CustomerController extends BaseAction{ 
	
	/**
	 * 分页查询日志记录列表
	 * author chenjin
	 * createTime   2014-12-20
	 */
	@RequestMapping(params="customerGridView")
	public ModelAndView customerGridView(HttpServletRequest request,HttpServletResponse response) throws Exception{
		pm = getPageInfo(new String[]{}, request);
		SolrUtil solr=new SolrUtil();
		pm = solr.getIndexListPM(pm);
		return null;
	}	
	
	
}

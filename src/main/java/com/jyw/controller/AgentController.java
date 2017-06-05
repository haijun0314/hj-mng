package com.jyw.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.jxjz.base.spring.BaseAction;
import org.jxjz.common.util.JsonUtil;
import org.jxjz.common.util.ResponseUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.jyw.service.AgentService;

@Controller
@RequestMapping("/agent")
public class AgentController extends BaseAction{
	@Resource AgentService 		 agentService;
	String detail	   ="jyw/agent/detail";
	String layout      ="jyw/agent/layout";
	String dataList    ="jyw/agent/dataList";
	String add    	   ="jyw/agent/add";
	String ext    	   ="jyw/agent/ext";	 
	
	 
	/**
	 *   代理商列表查询
	 */
	@RequestMapping(params = "gridView")
	public ModelAndView gridView(Model model,HttpServletRequest request,HttpServletResponse response) throws Exception{
		String viewflag =request.getParameter("viewflag");//跳转标记1 表示ajax请求数据刷新jsp页面
		pm=getPageInfo(new String[] {"account"},request); //分页参数
		pm = agentService.getAgentPageList(pm);//查询数据
		ModelAndView mav = null;
		if(StringUtils.isBlank(viewflag)){
			mav = new ModelAndView(layout);	
		}else{
			mav = new ModelAndView(dataList);
		}
		mav.addObject("pm", pm);
		return mav;
	}
	
	/**
	 *   代理商列表查询
	 */
	@RequestMapping(params = "loadAgent")
	public void loadAgent(Model model,HttpServletRequest request,HttpServletResponse response) throws Exception{
		List datas= agentService.getAgentList(query);//查询数据
		String json=JsonUtil.getStringFromList(datas);
		ResponseUtils.renderJson(response, json);
	}	 
	
	
	
	
	
	 
}

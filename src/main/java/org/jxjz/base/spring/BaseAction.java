package org.jxjz.base.spring;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringUtils;
import org.jxjz.base.model.PageBean;
import org.jxjz.base.model.PageModel;
import org.jxjz.base.mybatis.Query;
import org.jxjz.common.bean.resultMsg.BaseRespBean;
import org.jxjz.common.util.JsonUtil;
import org.jxjz.common.util.RequestUtils;
import org.jxjz.common.util.ResponseUtils;
import org.jxjz.framework.enums.ActionType;
import org.jxjz.framework.log.SysLogUtil;
import org.jxjz.framework.pojo.SysLog;
import org.jxjz.framework.security.MyUserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

@Controller  
public class BaseAction {
	protected Query query = new Query();
	public    PageModel pm=new PageModel();
	public    ModelAndView  page_404=new ModelAndView("error/error_404");
	/**
	 * 添加代理商参数
	 */
	public Integer   getAgentId( ){
		Integer agentId=MyUserDetails.getCurUserDetails().getAgentId();
		 return agentId;
	}	
	 
	/**
	 * ajax数据请求 返回
	 */
	public BaseRespBean   returnMsg(Object resultData)throws Exception{
		 return new BaseRespBean(resultData);
	}		
	
	/**
	 * 获取实例化参数
	 */
	public Object   getParamsObj(HttpServletRequest request,String[] params,String  objName)throws Exception{
		 Map paramMap=(HashMap)RequestUtils.getParameter(request, params);
		 Class<?> obj=Class.forName("org.jxjz.framework.pojo."+objName);
		 Object o = obj.newInstance(); //创建一个实例
		 try {
			 BeanUtils.copyProperties(o, paramMap);
		} catch (Exception e) {
			e.getStackTrace();
		}
		
		 return o;
	}
	/**
	 * 获取实例化参数
	 */
	public Object   getParamsObj_jyw(HttpServletRequest request,String[] params,String  objName)throws Exception{
		 Map paramMap=(HashMap)RequestUtils.getParameter(request, params);
		 Class<?> obj=Class.forName("com.jyw.entity."+objName);
		 Object o = obj.newInstance(); //创建一个实例
		 try {
			 BeanUtils.copyProperties(o, paramMap);
		} catch (Exception e) {
			e.getStackTrace();
		}
		
		 return o;
	}
	/**
	 * 获取分页信息
	 */
	public PageModel   getPageInfo(String [] params,HttpServletRequest request){
		Map paramMap=RequestUtils.getParameter(request, params);//取得页面查询参数
		PageBean.getPageInfo(request,pm);//获取分页参数
		pm.setParams(paramMap);
		return pm;
	}	
	
	/**
	 * 记录操作日志
	 */
	public void   addSysLog(HttpServletRequest request,SysLog syslog){
		syslog.setLogIp(request.getLocalAddr());
		syslog.setUserId(MyUserDetails.getCurUserDetails().getUserid());
		syslog.setUserName(MyUserDetails.getCurUserDetails().getUsername());
		syslog.setCreatedBy(MyUserDetails.getCurUserDetails().getUsername());
		syslog.setLogTime(new Date());
		SysLogUtil.addOperLogToCache(syslog);
	}	 
	
	 
	/**
	 *  检查时提交数据还是请求跳转到jsp页面
	 */
	public boolean  pageRequest(HttpServletRequest request){
		String  reqType =request.getParameter("reqType");//【0 请求数据[执行方法 比如更新update]  1 跳转页面【比如跳转分页layout页面或者添加数据页面】  2 Ajax 请求数据】
		if (StringUtils.isBlank(reqType)) {
			return true;
		}else if(reqType.equals(ActionType.Page.getValue())) {
			return true;
		}
		return false;
	}	
	
	public void  respMsgObj(HttpServletResponse response,Object obj) {
		String jsonStr=JsonUtil.obj2Json(obj);
		ResponseUtils.renderJson(response,jsonStr);
	} 	 

	public Query getQuery() {
		return query;
	}

	public void setQuery(Query query) {
		this.query = query;
	}	 

			
}

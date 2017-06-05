package com.jyw.controller;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.jxjz.base.mybatis.Query;
import org.jxjz.base.spring.BaseAction;
import org.jxjz.common.util.JsonUtil;
import org.jxjz.common.util.MsgUtil;
import org.jxjz.common.util.ResponseUtils;
import org.jxjz.framework.enums.LogType;
import org.jxjz.framework.enums.StartOrStop;
import org.jxjz.framework.log.SysLogUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.jyw.entity.DictOpenCity;
import com.jyw.service.DictAreaService;
import com.jyw.service.DictOpenCityService;

/**
 * 区域管理
 * author libin
 * createTime   2014-11-25
 */
@Controller
@RequestMapping("/dict/dictArea")
public class DictAreaController extends BaseAction{
	@Resource DictAreaService dictAreaService;
	@Resource DictOpenCityService dictOpenCityService;
	
	String layout      ="jyw/dict/dictAreaLayout";//地区查询页面
	String dataList    ="jyw/dict/dictAreaList";//地区列表页面
	
	String openDataList 	= "jyw/dict/dictOpenCityList";				//开放地区列表页面
	String openDataLayout 	= "jyw/dict/dictOpenCityLayout";			//开放地区列表查询页面
	private Logger log 					 = Logger.getLogger("jxjz");
	
	/**
	 * 区域查询页面【页面显示】
	 * author libin
	 * createTime   2014-11-25
	 */
	@RequestMapping(params = "gridView")   
	public ModelAndView gridView(Model model,HttpServletRequest request,HttpServletResponse response)  throws Exception{
		String  viewflag =request.getParameter("viewflag");//跳转标记1 表示ajax请求数据刷新jsp页面
		String ShengCode=request.getParameter("ShengCode");
		String ShiCode=request.getParameter("ShiCode");
		pm = getPageInfo(new String[] {"areaname"},request);
		if(StringUtils.isNotBlank(ShiCode)){
			pm.append("ShiCode", ShiCode);	
		}else{
			pm.append("ShengCode", ShengCode);
		}
		pm.setPageSize(20);
		pm=dictAreaService.getDictAreaPageList(pm);//查询数据	
		ModelAndView mav=null;
		if (StringUtils.isBlank(viewflag)) {
			 mav=new ModelAndView(layout);
		}else { 
			 mav=new ModelAndView(dataList);
		}
		mav.addObject("pm", pm);
		return mav;  
	} 
	/**
	 *  下拉框区域查询
	 *  author libin
	 * createTime   2014-11-25
	 */
	@RequestMapping(params = "getAreaList")   
	public void getAreaList(HttpServletRequest request,HttpServletResponse response)  throws Exception{
		String  pcode =request.getParameter("pcode");
		query.append("pcode", pcode);
		List areaList= dictAreaService.getAreaList(query);
		String jsonStr=JsonUtil.getStringFromList(areaList) ; 
		ResponseUtils.renderJson(response, jsonStr);
	} 
	
	/**
	 * 开放城市下拉框查询
	 * author:chenjin
	 * createTime:2014-11-27
	 */
	
	@RequestMapping(params = "getOpenCityList") 
	public void getOpenCityList(HttpServletRequest request,HttpServletResponse response)  throws Exception{
		List openCityList= dictOpenCityService.getOpenCityList(query);
		String jsonStr=JsonUtil.getStringFromList(openCityList) ; 
		ResponseUtils.renderJson(response, jsonStr);
	} 
	/**
	 * 开放城市下拉框查询
	 * author:chenjin
	 * createTime:2014-11-27
	 */
	
	@RequestMapping(params = "getOpenCity") 
	public void getOpenCity(HttpServletRequest request,HttpServletResponse response)  throws Exception{
		List openCityList= dictOpenCityService.getOpenCity(query);
		String jsonStr=JsonUtil.getStringFromList(openCityList) ; 
		ResponseUtils.renderJson(response, jsonStr);
	} 
	
	/**
	 * 开放区域查询页面【页面显示】
	 * author libin
	 * createTime   2014-11-25
	 * 
	 * author chenjin
	 * updateTime   2015-1-12
	 */
	@RequestMapping(params = "dicrOpenCityView")   
	public ModelAndView dicrOpenCity(HttpServletRequest request,HttpServletResponse response)  throws Exception{
		String  viewflag =request.getParameter("viewflag");
		query=new Query();
		List openList= dictAreaService.getDictOpenCityList(query);//查询数据	
		ModelAndView mav = null;
		if(StringUtils.isBlank(viewflag)){
			mav=new ModelAndView(openDataLayout);
		}else{			
			mav=new ModelAndView(openDataList);
		}
		mav.addObject("openList", openList);
		return mav;  
	} 
	
	/**
	 * 添加开放城市
	 * @author chenjin
	 * createTime 2015-1-12
	 */
	@RequestMapping(params ="openCityAdd")
	public void openCityAdd(@ModelAttribute DictOpenCity dictOpenCity,HttpServletRequest request,HttpServletResponse response) throws Exception{
		try{
			String shengCode = request.getParameter("shengCode");
			String shengName = request.getParameter("shengName");
			if(StringUtils.isBlank(dictOpenCity.getCityCode())){
				dictOpenCity.setCityCode(shengCode);
				dictOpenCity.setCityName(shengName);
			}
			query = new Query();
			query.append("cityCode", dictOpenCity.getCityCode());
			List openCityList = dictOpenCityService.getOpenCityList(query);
			if(openCityList == null||openCityList.size()<1){
				log.info("【开放城市添加】....开放城市编号为"+dictOpenCity.getCityCode());
				dictOpenCityService.addOpenCity(dictOpenCity);
			}else{
				MsgUtil.operMsg(response,"对不起，城市已存在，请重新添加！");
				return ;
			}
		 }catch(Exception e){
		  	addSysLog(request,SysLogUtil.failLog("开放区域城市编号"+dictOpenCity.getCityCode()+"添加失败",LogType.Add));
		  	MsgUtil.operFail(response,e);
			return ;
		 }
		addSysLog(request,SysLogUtil.successLog("开放区域城市编号"+dictOpenCity.getCityCode()+"添加成功",LogType.Add));
		MsgUtil.operSuccess(response);
    }
	
	/**
	 * 启用、停用开放城市
	 * @author liubin
	 *  createTime 2014-12-29
	 */
	@RequestMapping(params = "startOrStop_city")   
	public void  startOrStop_city(@ModelAttribute DictOpenCity dictOpenCity,HttpServletRequest request,HttpServletResponse response) throws Exception {
		try {
			 String cityCode=request.getParameter("cityCode");
			 String opertype=request.getParameter("operType");
			 DictOpenCity dictOpenCitys=new DictOpenCity();
			 if (opertype.equals(StartOrStop.Start.getValue())) {
				 dictOpenCitys.setStatus(StartOrStop.Start);
			 }else {
				 dictOpenCitys.setStatus(StartOrStop.Stop);
			}
			 dictOpenCitys.setCityCode(cityCode);
			 dictAreaService.updateStarOrStop(dictOpenCitys);
		 }catch (Exception e) {
			 MsgUtil.operFail(response,e);
			 addSysLog(request,SysLogUtil.failLog("开放城市状态改变"+dictOpenCity.getCityCode()+"失败",LogType.Update));
			 return;
		 }
		MsgUtil.operSuccess(response);
		addSysLog(request,SysLogUtil.successLog("开放城市状态改变"+dictOpenCity.getCityCode()+"成功",LogType.Update));
	}	
}

package org.jxjz.framework.sysmanage.action;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.jxjz.base.mybatis.Query;
import org.jxjz.base.spring.BaseAction;
import org.jxjz.common.util.MsgUtil;
import org.jxjz.common.util.StringUtil;
import org.jxjz.framework.enums.DefaultStatus;
import org.jxjz.framework.enums.LogType;
import org.jxjz.framework.enums.StartOrStop;
import org.jxjz.framework.enums.UserType;
import org.jxjz.framework.log.SysLogUtil;
import org.jxjz.framework.pojo.SysMenubar;
import org.jxjz.framework.pojo.SysUser;
import org.jxjz.framework.security.MyUserDetails;
import org.jxjz.framework.sysmanage.service.SessionService;
import org.jxjz.framework.sysmanage.service.SysRoleService;
import org.jxjz.framework.sysmanage.service.SysUserService;
import org.jxjz.framework.util.ConfigUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
 
/**
 * 系统管理员管理
 * author lihaijun
 * createTime   2014-11-21
 */
@Controller  
@RequestMapping("/sys/sysUser") 
public class SysUserAction extends BaseAction {
	@Resource	SysUserService sysUserService;
	@Resource	SysRoleService sysRoleService;
	@Resource   SessionService sessionService;
	String onlineUserList    ="framework/sysmanage/session/onlineUserList";
	
	//系统操作页面
	String layout      ="framework/sysmanage/user/sys/layout";   //系统管理员查询页面
	String add    	   ="framework/sysmanage/user/sys/add";		  //系统管理员添加页面
	String dataList    ="framework/sysmanage/user/sys/dataList";  //系统管理员列表页面
	
	//公用操作页面
	String detail 	       ="framework/sysmanage/user/detail";	  //系统管理员显示页面
	String update	   	   ="framework/sysmanage/user/update"; 	  //系统管理员修改页面
	String resetPassword   ="framework/sysmanage/user/resetPassword"; 	  //系统管理员修改页面
	
	//代理商操作页面
	String addAgent     	="framework/sysmanage/user/agent/add";//城市账号添加页面
	String layoutAgent      ="framework/sysmanage/user/agent/layout";//城市账号查询页面
	String dataListAgent    ="framework/sysmanage/user/agent/dataList";		//城市账号搜索页面
	
	//个人设置页面
	String mySet 	     ="framework/sysmanage/user/mySet";
	String myInfo      	 ="framework/sysmanage/user/myInfo";
	String setPassword   ="framework/sysmanage/user/setPassword";	
	
	/**
	 * 在线用户展示
	 */
	 @RequestMapping(params = "onlineUserList")   
		public ModelAndView onlineUserList(Model model,HttpServletRequest request,HttpServletResponse response)  throws Exception{
			pm=getPageInfo(new String[] {},request);
			pm=sessionService.getOnlineUserPM(pm);//查询数据	
			ModelAndView mav=new ModelAndView(onlineUserList);
			mav.addObject("pm", pm);
			return mav;  
		} 
    /**
	 * 踢出用户
	 */
	@RequestMapping(params = "kickOutUser")   
	public void kickOurUser(HttpServletRequest request,HttpServletResponse response) throws Exception {
		try {
			 String userId=request.getParameter("userId");
			 sessionService.kickOutOnlineUser(new Integer(userId));
		 }catch (Exception e) {
			 MsgUtil.operFail(response,e);
			 return;
		 }
		MsgUtil.operSuccess(response);
	}	
	 
	
	/**
	 *  管理员查询页面【页面显示】
	 */
	@RequestMapping(params = "gridView")   
	public ModelAndView gridView(HttpServletRequest request,HttpServletResponse response)  throws Exception{
		pm=getPageInfo(new String[] {"userName", "status"},request);
		pm=sysUserService.getUserPageList(pm);//查询数据	
		ModelAndView mav=null;
		if (pageRequest(request)) {
			 mav=new ModelAndView(layout);
		}else { 
			 mav=new ModelAndView(dataList);
		}
		mav.addObject("pm", pm);
		return mav;  
	} 
	
	/**
	 * 添加系统用户
	 */
	@RequestMapping(params = "add")   
	public ModelAndView add(HttpServletRequest request,HttpServletResponse response) throws Exception {
		if (pageRequest(request)) {
			return new ModelAndView(add);
		}else {
			 SysUser sysUser=(SysUser) getParamsObj(request,new String[] {  "userName", "realName","password","roles","telePhone","email","remark","sex","isSuper"}, "SysUser");
			 String [] roleStr=request.getParameterValues("roles");
			 sysUser.setRoles(StringUtil.StringArrayToString(roleStr, ","));
			 sysUser.setUserType(UserType.SystemUser.getValue());
			try {
				 boolean isexist=sysUserService.checkUserName(sysUser.getUserName());
				 if (isexist) {
					 MsgUtil.operMsg(response,"对不起 该用户名已经存在 请用其他用户名！");
					 return null;
				 }
				sysUserService.addSysUser(sysUser);
			 }catch (Exception e) {
				 addSysLog(request,SysLogUtil.failLog("新增系统用户"+sysUser.getUserName()+"失败",LogType.Add));
				 MsgUtil.operFail(response,e);
				 return null;
			 }
			addSysLog(request,SysLogUtil.successLog("新增系统用户"+sysUser.getUserName()+"成功",LogType.Add));
			MsgUtil.operSuccess( response);
			return null;
		}
	}
	
	/**
	 * 添加代理商账号
	 */
	@RequestMapping(params = "addAgent")   
	public ModelAndView addAgent(HttpServletRequest request,HttpServletResponse response) throws Exception {
		if (pageRequest(request)) {
			String userType=request.getParameter("userType");//账户类型 0  系统账户 1  城市管理账户   2  城市普通账户
			query = new Query();
			query.append("resource", 2);//角色来源  1 总部 2 代理商
			query.append("status", 0);
			List roleList=sysRoleService.getSysRoleList(query);
			ModelAndView  mav=new ModelAndView(addAgent);
			mav.addObject("roleList", roleList);
			mav.addObject("userType", userType);
			return mav;
		}else {
			 SysUser sysUser=(SysUser) getParamsObj(request,new String[] {  "userName", "realName","password","telePhone","email","remark","agentId","userType","roles"}, "SysUser");
			 String [] roleStr=request.getParameterValues("roles");
			 sysUser.setRoles(StringUtil.StringArrayToString(roleStr, ","));
			 if (sysUser.getUserType().equals(UserType.AgentUser.getValue())) {
				 sysUser.setAgentId(getAgentId());
				 sysUser.setIsSuper(DefaultStatus.No.getValue());
				 sysUser.setPassword(ConfigUtil.sys_user_defaultPassword);
			 }
			try {
				 boolean isexist=sysUserService.checkUserName(sysUser.getUserName());
				 if (isexist) {
					 MsgUtil.operMsg(response,"对不起 该用户名已经存在 请用其他用户名！");
					 return null;
				 }
				sysUserService.addSysUser(sysUser);
			 }catch (Exception e) {
				 addSysLog(request,SysLogUtil.failLog("新增城市用户"+sysUser.getUserName()+"失败",LogType.Add));
				 MsgUtil.operFail(response,e);
				 return null;
			 }
			addSysLog(request,SysLogUtil.successLog("新增用户"+sysUser.getUserName()+"成功",LogType.Add));
			MsgUtil.operSuccess( response);
			return null;
		}
	}	
	
	/**
	 * 更新系统用户
	 */
	@RequestMapping(params = "update")   
	public ModelAndView  update(HttpServletRequest request,HttpServletResponse response) throws Exception {
		if(pageRequest(request)) {
			String userid=request.getParameter("userId");
			SysUser sysUser=sysUserService.getSysUserById(new Integer(userid));
			List roleList = sysRoleService.getUserRoles(new Integer(userid));
			ModelAndView  mav=new ModelAndView(update);
			mav.addObject("roleList", roleList);
			mav.addObject("sysUser", sysUser);
			return mav;
		}else {
			SysUser sysUser=(SysUser) getParamsObj(request,new String[] { "userId", "userName", "realName","telePhone","email","remark","isSuper"}, "SysUser");
			String [] roleStr=request.getParameterValues("roles");
			 sysUser.setRoles(StringUtil.StringArrayToString(roleStr, ","));
			try {
				 sysUserService.update(sysUser);
			 }catch (Exception e) {
				 MsgUtil.operFail(response,e);
				 addSysLog(request,SysLogUtil.failLog("更新系统用户"+sysUser.getRealName()+"失败",LogType.Update));
				 return null;
			 }
			addSysLog(request,SysLogUtil.successLog("更新系统用户"+sysUser.getRealName()+"成功",LogType.Update));
			MsgUtil.operSuccess( response);
			 return null;
		}
	}
	/**
	 * 详情页面
	 */
	@RequestMapping(params = "detail")   
	public ModelAndView  detail(HttpServletRequest request,HttpServletResponse response) throws Exception {
		try {
			String userId=request.getParameter("userId");
			SysUser sysUser=sysUserService.detail(new Integer(userId));
			ModelAndView  mav=new ModelAndView(detail);
			mav.addObject("sysUser", sysUser);
			return mav;
		} catch (Exception e) {
			return page_404;
		}
	}	
	
	
	/**
	 * 删除系统用户
	 * @author liubin
	 *  createTime 2014-12-3
	 */
	@RequestMapping(params = "delete")   
	public void delete(HttpServletRequest request,HttpServletResponse response) throws Exception {
		try {
			 String userId=request.getParameter("userId");
			 sysUserService.delete(new Integer(userId));
		 }catch (Exception e) {
			 MsgUtil.operFail(response,e);
			 return;
		 }
		MsgUtil.operSuccess( response);
	}
		
	
	/**
	 * 启用、停用系统管理员
	 * @author liubin
	 *  createTime 2014-12-3
	 */
	@RequestMapping(params = "startOrStop")   
	public void  startOrStop(@ModelAttribute SysUser sysUser,HttpServletRequest request,HttpServletResponse response) throws Exception {
		try {
			 String userid=request.getParameter("userId");
			 String opertype=request.getParameter("operType");
			 if (opertype.equals(StartOrStop.Start.getValue())) {
				 sysUser.setStatus(StartOrStop.Start.getValue());
			 }else {
				 sysUser.setStatus(StartOrStop.Stop.getValue());
			}
			 sysUser.setUserId(new Integer(userid));
			 sysUserService.update(sysUser);
		 }catch (Exception e) {
			 MsgUtil.operFail(response,e);
			 addSysLog(request,SysLogUtil.failLog("管理员状态改变"+sysUser.getUserId()+"失败",LogType.Update));
			 return;
		 }
		MsgUtil.operSuccess( response);
		addSysLog(request,SysLogUtil.successLog("管理员状态改变"+sysUser.getUserId()+"成功",LogType.Update));
	}	
	
	/**
	 *  管理员密码重置
	 *  @author liubin
	 *  createTime 2014-12-3
	 */
	@RequestMapping(params = "resetPassword")   
	public void  resetPassword(@ModelAttribute SysUser sysUser,HttpServletRequest request,HttpServletResponse response) throws Exception {
		try {
			 String userid=request.getParameter("userId");
			 sysUser.setUserId(new Integer(userid));
			 sysUser.setPassword(ConfigUtil.sys_user_defaultPassword);
			 sysUserService.update(sysUser);
		 }catch (Exception e) {
			 MsgUtil.operFail(response,e);
			 addSysLog(request,SysLogUtil.failLog("更新系统用户"+sysUser.getUserId()+"失败",LogType.Update));
			 return;
		 }
		MsgUtil.operSuccess( response);
		addSysLog(request,SysLogUtil.successLog("更新系统用户"+sysUser.getUserId()+"成功",LogType.Update));
	}	
	
	 
	/**
	 * 检查用户名是否重复
	 */
	@RequestMapping(params = "checkUserName")   
	public void  checkUserName(HttpServletRequest request,HttpServletResponse response) throws Exception {
		String  username =request.getParameter("userName");//跳转标记0表示获取列表json数据，1 表示跳转到jsp页面
		if(StringUtils.isBlank(username)){
			MsgUtil.operMsg( response,"该登陆名称不可以使用");
			return ;
		}
		boolean flag=sysUserService.checkUserName(username);
		if (flag) {
			MsgUtil.operMsg( response,"该登陆名称不可以使用");
		}else {
			MsgUtil.operMsg( response,"该登陆名称可以使用");
		}
	}
	/**
	 * 城市管理员查询页面【页面显示】
	 * @author liubin
	 * createTime 2014-12-3
	 */
	@RequestMapping(params = "gridViewAgent")   
	public ModelAndView gridViewAgent(HttpServletRequest request,HttpServletResponse response)  throws Exception{
		pm=getPageInfo(new String[] {"userName", "status"},request);
		pm.append("agentId", getAgentId());
		pm=sysUserService.getUserPageList(pm);//查询数据
		ModelAndView mav=null;
		if (pageRequest(request)) {
			 mav=new ModelAndView(layoutAgent);
		}else { 
			 mav=new ModelAndView(dataListAgent);
		}
		mav.addObject("pm", pm);
		return mav; 
	} 
	
	
	
	
	
	/**
	 * 修改密码
	 */
	@RequestMapping(params = "setPassword")
	public ModelAndView changePwd(@ModelAttribute SysUser sysUser,Model model,HttpServletRequest request,HttpServletResponse response) throws Exception {
		if(pageRequest(request)){
				return new ModelAndView(setPassword);
		}else{
			try{
			String oldPassword = request.getParameter("oldPassword");
			String newPassword = request.getParameter("newPassword");
			if(!MyUserDetails.getCurUserDetails().getPassword().equals(oldPassword)){
				MsgUtil.operMsg(response,  "原密码不正确！");
				return null;
			}
				sysUser.setPassword(newPassword);
				sysUser.setUserId(MyUserDetails.getCurUserDetails().getUserid());
				sysUserService.update(sysUser);
				MyUserDetails.getCurUserDetails().setPassword(newPassword);
			}catch(Exception e){
				MsgUtil.operFail(response,e);
				addSysLog(request,SysLogUtil.failLog("修改密码"+sysUser.getUserId()+"失败",LogType.Update));
				return null;
			}
			MsgUtil.operSuccess( response);
			addSysLog(request,SysLogUtil.successLog("修改密码"+sysUser.getUserId()+"成功",LogType.Update));
			return null;
		}
	}	
	
	
	/**
	 * 我的设置
	 */
	@RequestMapping(params = "mySet")   
	public ModelAndView mySet(@ModelAttribute SysUser sysUser,HttpServletRequest request,HttpServletResponse response) throws Exception {
		if(pageRequest(request)){
			SysUser su = sysUserService.getSysUserById(MyUserDetails.getCurUserDetails().getUserid());
			ModelAndView mav = new ModelAndView(mySet);
			mav.addObject("sysUser",su);
			return mav;
		}else{
			try{
				sysUserService.update(sysUser);
			}catch (Exception e) {
				MsgUtil.operFail(response,e);
				addSysLog(request,SysLogUtil.failLog("用户设置"+sysUser.getUserId()+"失败",LogType.Update));
				return null;
			}
			addSysLog(request,SysLogUtil.successLog("用户设置"+sysUser.getUserId()+"成功",LogType.Update));
			MsgUtil.operSuccess( response);
			return null;
		}
	}
	
	/**
	 * 个人资料
	 */
	@RequestMapping(params = "myInfo")
	public ModelAndView myInfo(HttpServletRequest request,HttpServletResponse response) throws Exception {
		try {
			List  list =MyUserDetails.getCurUserDetails().getUserMenuBars();//将取到的登录者的信息放在list集合中
			List  datas=new  ArrayList();//实例化一个List集合,用来存放map
			Map map =new HashMap();//实例化一个map集合,用来存放权限名称
			int i=0;//声明变量i=0
			for(int j = 0 ; j < list.size(); j++){//循环遍历list集合
			SysMenubar smb=(SysMenubar)list.get(j);//将list中取出的数据强转为实体
			i++;
			map.put("menuName"+i, smb.getMenuName());//将取到的名字以键值对的方式放到map中
				if((j+1)%5==0){
					datas.add(map);//将map添加到list集合中
					i=0;
					map =new HashMap(); //重新实例化一个map
				}
			}
			SysUser su = sysUserService.getSysUserById(MyUserDetails.getCurUserDetails().getUserid());//从session中得到userId
			ModelAndView  mav=new ModelAndView(myInfo);
			mav.addObject("sysUser", su);
			mav.addObject("datas", datas);
			return mav;
		} catch (Exception e) {
			return page_404;
		}
	}	
	 
}

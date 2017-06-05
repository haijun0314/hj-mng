package org.jxjz.framework.portal.action;
import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jxjz.base.spring.BaseAction;
import org.jxjz.common.util.ResponseUtils;
import org.jxjz.framework.exception.ErrorCodeUtil;
import org.jxjz.framework.security.SessionUtil;
import org.jxjz.framework.sysmanage.service.SysUserService;
import org.jxjz.framework.util.ConfigUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 * 登录跳转
 * author lihaijun
 * createTime   2014-11-21
 */
@Controller  
@RequestMapping("/login") 
public class LoginAction extends BaseAction{
	@Resource SysUserService sysUserService;
 
	/**
	 *   
	 */
	@RequestMapping(params ="loginSuccess")   
	public void loginSuccess(Model model,HttpServletRequest request,HttpServletResponse response) {
		//SecurityContext sc=SecurityContextHolder.getContext();
		//addSysLog(request,SysLogUtil.successLog("系统用户"+MyUserDetails.getCurUserDetails().getUsername()+"登录",LogType.Login));
		//SessionUtil.setSession("userDetails", MyUserDetails.getCurUserDetails());
		ResponseUtils.renderJson(response,ErrorCodeUtil.success);
	}  
	/**
	 *  登录到错误页面
	 */
	@RequestMapping(params = "loginError")   
	public void loginError(HttpServletResponse response) {
		SessionUtil.clearSession();
		ResponseUtils.renderJson(response,ErrorCodeUtil.e_1105);
	}  
	
	/**
	 *  退出成功页面
	 */
	@RequestMapping(params = "logoutSuccess")   
	public void logoutSuccess(HttpServletResponse response) throws IOException {
		SessionUtil.removeSession(ConfigUtil.Session_global);
		response.sendRedirect("login.jsp");
	} 	
	
	
}

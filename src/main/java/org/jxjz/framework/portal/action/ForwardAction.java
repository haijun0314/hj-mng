package org.jxjz.framework.portal.action;
import java.util.Date;

import javax.annotation.Resource;

import org.jxjz.base.spring.BaseAction;
import org.jxjz.framework.pojo.SysUser;
import org.jxjz.framework.security.MyUserDetails;
import org.jxjz.framework.security.SessionUtil;
import org.jxjz.framework.sysmanage.service.SysUserService;
import org.jxjz.framework.util.ConfigUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 * 业务跳转
 * author lihaijun
 * createTime   2014-11-21
 */
@Controller  
@RequestMapping("/forward") 
public class ForwardAction extends BaseAction{
	@Resource SysUserService sysUserService;
	/**
	 *  登录跳转到首页
	 */
	@RequestMapping(params = "index")  
	public String welcomeIndex() {
		MyUserDetails userDetails=MyUserDetails.getCurUserDetails();
		SessionUtil.setSession(ConfigUtil.Session_global, userDetails);
		SysUser sysUser=new SysUser();
		sysUser.setLoginTime(new Date());
		sysUser.setUserId(userDetails.getUserid());
		sysUserService.update(sysUser);
		return "index";
	}
	
	 
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	 
	
}

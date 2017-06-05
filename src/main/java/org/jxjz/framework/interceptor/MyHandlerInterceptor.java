package org.jxjz.framework.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.jxjz.common.util.URLUtil;
import org.jxjz.framework.security.MyUserDetails;
import org.jxjz.framework.security.SessionUtil;
import org.jxjz.framework.util.ConfigUtil;
import org.jxjz.framework.util.LogUtil;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class MyHandlerInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request,HttpServletResponse response, Object handler) throws Exception {
		//就简单判断了一下，如果要详细控制可以用spring security
		String  url=URLUtil.buildRequestUrl(request);
		Logger log=LogUtil.getLogger(); 
		MyUserDetails user=(MyUserDetails) SessionUtil.getSession(ConfigUtil.Session_global);
		if (user!=null) {
			log.info("【访问系统URL】"+url+"【访问人】"+user.getUsername()+"【id=】"+user.getUserid());
		}else{
			log.info("【访问系统URL】"+url);
		}
		return true;
			
	}
	
}

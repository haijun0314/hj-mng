package org.jxjz.framework.security;

import java.io.Serializable;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.jxjz.common.util.EscapeEncode;
import org.jxjz.framework.util.ConfigUtil;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * 
 */
public class SessionUtil {
	// 获取Session
	public static synchronized Serializable getSession(String name) {
		return getSession().get(name);
	}

	public static synchronized Map<String, Serializable> getSession(){
		// 生产模式：保存在memcached中
		Map<String, Serializable> map = null;
		if (!isLocal()) {
			return map;
		} else {
			// 开发模式：保存在本地session中
			HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
			map = new HashMap<String, Serializable>();
			HttpSession session = request.getSession();
			Enumeration en = request.getSession().getAttributeNames();
			while (en.hasMoreElements()) {
				String key = (String) en.nextElement();
				map.put(key, (Serializable) session.getAttribute(key));
			}
			return map;
		}
	}

	

	/**
	 * 设置Session
	 */
	public static synchronized void setSession(String name, Serializable obj){
		// 生产模式：保存在memcached中
		if (!isLocal()) {
			 
		} else {
			// 开发模式：保存在本地session中
			HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
			HttpSession session = request.getSession();
			session.setAttribute(name, obj);
		}
	}

	/**
	 * 清理session
	 */
	public static synchronized void removeSession(String name){
		if (!isLocal()) {
		 
		} else {
			// 开发模式：保存在本地session中
			HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
			HttpSession session = request.getSession();
			session.removeAttribute(name);
		}
	}

	/**
	 * 清理session
	 */
	public static synchronized void clearSession() {
		// 生产模式：保存在memcached中
		if (!isLocal()) {
			 
		} else {
			// 开发模式：保存在本地session中
			HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
			HttpSession session = request.getSession();
			@SuppressWarnings("rawtypes")
			Enumeration en = request.getSession().getAttributeNames();
			while (en.hasMoreElements()) {
				String key = (String) en.nextElement();
				session.removeAttribute(key);
			}
		}
	}

	/**
	 * 获取 Session Model
	 */
	public static synchronized boolean isLocal(){
		boolean isLocal = "local".equalsIgnoreCase(ConfigUtil.sys_session_mode);
		return isLocal;
	}


}

package org.jxjz.framework.log;

import org.jxjz.base.spring.BaseAction;
import org.jxjz.framework.enums.LogType;
import org.jxjz.framework.log.service.SysLogService;
import org.jxjz.framework.pojo.SysLog;

public class SysLogUtil extends BaseAction {
	public static SysLogService sysLogService=(SysLogService)org.jxjz.base.spring.ApplicationFactory.getBean("sysLogService");
	
 
	
	/**
	 * 添加日志到缓存
	 */
	public static void addOperLogToCache(SysLog syslog){
		sysLogService.addCacheLog(syslog);
	}	
	
	/**
	 * 实例化成功日志
	 */
	public static SysLog successLog(String msg,LogType logtype){
		SysLog syslog=new SysLog(logtype,msg,"1");
		return syslog;
	}	 
	/**
	 * 实例化成功日志
	 */
	public static SysLog failLog(String msg,LogType logtype){
		SysLog syslog=new SysLog(logtype,msg,"2");
		return syslog;
	}	
}

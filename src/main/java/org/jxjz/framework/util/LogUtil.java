package org.jxjz.framework.util;

import org.apache.log4j.Logger;

public class LogUtil {
	 
 
	public static  Logger getLogger() {
		return  Logger.getLogger(ConfigUtil.logName); 
	}	
	public static  Logger getSysLogger() {
		return  Logger.getLogger(ConfigUtil.logName_sys); 
	}
	
	public static  Logger getLogger(String log) {
		return  Logger.getLogger(log); 
	}	
}

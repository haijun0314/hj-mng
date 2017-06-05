package com.jyw.core.util;

import java.text.SimpleDateFormat;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

/**
 * 订单工具类
 * lihaijun
 * 2014-12-03
 */
public class OrderUtil {
	static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	static Logger log = Logger.getLogger("common"); 
 
	public static String   getTableName(String orderId) {
		if (StringUtils.isBlank(orderId)) {
			return "";
		}
		return "orderinfo_"+orderId.substring(0, 6);
	}	
	 
	
}

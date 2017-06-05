package com.jyw.core.util;

public class KeysUtil {
	public static String  Sms_Register				="sms:register:%s";     //注册短信
	public static String  Cus_Detail				="cus:session:%s";    	//用户缓存
	public static String  Cus_Id					="cus:id:%s";    	    //用户缓存
	public static String  Cus_Count_List 			="cus:count"; 		 	//账户数据统计缓存
	public static String  Cus_Money_List 			="cus:money"; 		 	//账户资金变动统计缓存
	public static String  Condition_Type			="condition:type:%s";   // 定制条件
	public static String  Msg_List 				="msg"; 				//消息缓存
	public static String  GentleManDegree_List 	="gentleManDegree"; 	//君子度增减	
	public static String  GentlemanConfig			="gentlemanConfig";     // 君子度配置
	public static String  SystemConfig				="systemConfig";      	// 系统配置
	public static String  Ad_Cus_List 				="ad:cus:%s"; 	 	 	//用户广告缓存【未读广告列表】
	public static String  Ad_Id 					="ad:id:%s"; 		 	//广告缓存【所有广告 】
	public static String  Ad_Cus_Day 				="ad:cus:day:%s"; 		//用户本日读取广告缓存
	public static String  Ad_Shake					="ad:shake"; 		  	//摇一摇 缓存广告编号和过期时间戳
	public static String  Finance_Income_List		="finance:income"; 		//摇一摇 缓存广告编号和过期时间戳
	
	
	
	public static String getFinanceIncomeKey( ) {
        return Finance_Income_List;
	}	
	
	
	public static String getAdShakeKey( ) {
        return Ad_Shake;
	}	
	
	
	public static String getSystemConfigKey( ) {
        return SystemConfig;
	}
	
	
	 
	
	
	public static String getAdCusDayKey( String id) {
        return getKey(Ad_Cus_Day, id);
	}	
	
	
	public static String getAdIdKey( String id) {
        return getKey(Ad_Id, id);
	}	
	
	public static String getAdCusListKey( String id) {
	        return getKey(Ad_Cus_List, id);
    }	

	 
	
	public static String getCusMoneyListKey() {
		return Cus_Money_List;
	}		
	public static String getCusCountListKey() {
		return Cus_Count_List;
	}		
	public static String getGentleManDegreeListKey() {
		return GentleManDegree_List;
	}	
	public static String getGentlemanConfigKey() {
		return GentlemanConfig;
	}	
    public static String getKey(String format, String id) {
        return String.format(format, id);
    }	

	public static String getSms_Register(String id) {
		return getKey(Sms_Register, id);
	}
	public static String getCusDetailKey(String id) {
		return getKey(Cus_Detail, id);
	}
	public static String getCusIdKey(String id) {
		return getKey(Cus_Id, id);
	} 
	 
	/**
	 * 定制条件
	 */
	public static String getConditionTypeKey(String id) {
		return  getKey(Condition_Type, id);
	}
	 
	public static String getMsgListKey() {
		return Msg_List;
	}
	 
	 
	
}


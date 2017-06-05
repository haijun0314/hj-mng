package com.jyw.core.util;

import java.text.SimpleDateFormat;
import java.util.HashMap;

import org.apache.log4j.Logger;
import org.jxjz.common.util.MapUtil;

import com.jyw.entity.Customer;

/**
 * 账户工具类
 * lihaijun
 * 2014-12-03
 */
public class CustomerUtil {
	 static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	 static Logger log = Logger.getLogger("common");  
	 
	
	 /**
		 * 整理缓存用户数据
		 */
		@SuppressWarnings("unchecked")
		public static  HashMap getCatchMap(Customer cst) {
			HashMap redisMap=new HashMap();
			redisMap.put("customerId", cst.getCustomerId()+"");
			redisMap.put("customerName", cst.getCustomerName());
			redisMap.put("telephone", cst.getTelephone());
			redisMap.put("account", cst.getAccount());
			redisMap.put("career", cst.getCareer());
			redisMap.put("sex", cst.getSex()+"");
			redisMap.put("age", cst.getAge()+"");
			redisMap.put("gentleManDegree", cst.getGentleManDegree()+"");
			redisMap.put("isCheck", cst.getIsCheck().getValue());
			redisMap.put("countPublish",		cst.getCountPublish()+"");			//【发布单】发布单总数
			redisMap.put("countPublishSuccess",	cst.getCountPublishSuccess()+""  );		//【发布单】成功订单数
			redisMap.put("countPublishFail",	cst.getCountPublishFail()+""	);	//【发布单】失败单
			redisMap.put("countPublishTrade",	cst.getCountPublishTrade()+"");	//【发布单】交易单数量  [发布单   统计 ]
			redisMap.put("countServiceBindding",cst.getCountServiceBindding()+"");		//【服务单】竞标单总数  是一个变化的数据
			redisMap.put("countServiceFail",	cst.getCountServiceFail()+"");	//【服务单】失败单【服务】
			redisMap.put("countServiceSuccess", cst.getCountServiceSuccess()+""); 		//【服务单】成功订单数【服务】
			redisMap.put("countServiceTrade",	cst.getCountServiceTrade()+"");	//【服务单】交易单数量  [服务单   统计 ]
			redisMap.put("countTotal",    		cst.getCountTotal()+"");	//总订单数
			redisMap.put("countComplain",		cst.getCountComplain()+"");	//投诉订单数
			redisMap.put("countRevoke",			cst.getCountRevoke()+"");//撤销单总数	
			redisMap.put("moneyTotal", cst.getMoneyTotal()+"");		
			redisMap.put("moneyUsable", cst.getMoneyUsable()+"");		
			redisMap.put("headPic", cst.getHeadPic());
			redisMap.put("payPassword", cst.getPayPassword());
			redisMap.put("osType", cst.getOsType());
			redisMap.put("imei", cst.getImei());
			redisMap.put("imsi", cst.getImsi());
			redisMap.put("mModel", cst.getmModel());
			redisMap.put("cerId", cst.getCerId());
			redisMap.put("studentID", cst.getStudentID());
			redisMap.put("company", cst.getCompany());
			redisMap.put("school", cst.getSchool());
			redisMap.put("gentlemanNO", cst.getGentlemanNO());
			redisMap.put("duty", cst.getDuty());
			redisMap.put("label", cst.getLabel());
			redisMap.put("dynamicstate", cst.getDynamicState());
			redisMap.put("email", cst.getEmail());
			redisMap.put("QQ", cst.getQQ());
			redisMap.put("education", cst.getEducation());
			redisMap.put("companyAddress", cst.getCompanyAddress());
			redisMap.put("homeAddress", cst.getHomeAddress());
			redisMap.put("myWebsite", cst.getMyWebsite());
			redisMap.put("gentlemanAge", cst.getGentlemanAge());
			redisMap.put("homeAddressOrder", cst.getHomeAddressOrder());
			redisMap.put("companyAddressOrder", cst.getCompanyAddressOrder());
			redisMap.put("homeAddressDoorNoOrder", cst.getHomeAddressDoorNoOrder());
			redisMap.put("companyAddressDoorNoOrder", cst.getCompanyAddressDoorNoOrder());
			redisMap.put("sessionId", cst.getSessionId());
			MapUtil.removeEmptyValue(redisMap);
			log.info("redisMap......"+redisMap+"");
			return redisMap;
		}
}

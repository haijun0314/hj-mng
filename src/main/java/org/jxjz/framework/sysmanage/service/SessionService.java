package org.jxjz.framework.sysmanage.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.jxjz.base.model.PageModel;
import org.jxjz.base.mybatis.BaseService;
import org.jxjz.common.util.TimeUtil;
import org.jxjz.framework.pojo.OnlineUser;
import org.jxjz.framework.security.MyUserDetails;
import org.jxjz.framework.util.LogUtil;
import org.springframework.security.core.session.SessionInformation;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.stereotype.Service;
@Service
public class SessionService  extends  BaseService  {
	@Resource SessionRegistry sessionRegistry;
	Logger log=LogUtil.getLogger();
	
	/**
	 * 获取在线用户数据 用户登录创建session时候会在sessionRegistry进行登记
	 */
	@SuppressWarnings({ "unused", "rawtypes" })
	public  PageModel  getOnlineUserPM(PageModel pm) {
		List sessionList=sessionRegistry.getAllPrincipals();
		log.info("【在线用户】  当前在线人数"+sessionList.size()+"人");
		List dataList=new ArrayList();
		Map<Object, Date> lastActivityDates = new HashMap<Object, Date>();
		Integer ownUserid = MyUserDetails.getCurUserDetails().getUserid();
		for (Object principal : sessionList) {
			OnlineUser onlineUser=new OnlineUser();
			MyUserDetails mu=(MyUserDetails)principal;
			for (SessionInformation session : sessionRegistry.getAllSessions( principal, false)) {
				onlineUser.setLastRequestTime(session.getLastRequest());
				onlineUser.setSessionid(session.getSessionId());
				onlineUser.setOnlinetimes(TimeUtil.getTimeDistance(session.getLastRequest(), mu.getLoginTime()));
			}
			onlineUser.setOwnUserid(ownUserid);
			copyProperties(onlineUser,mu );
			dataList.add(onlineUser);
		}
		pm.setDatas(dataList);
		pm.setTotalRows(sessionList.size());
		pm.setTotalPage(sessionList.size()/pm.getPageSize()+1);
		pm.setCurRow(pm.getStartRow()+dataList.size());
		return pm;
	} 
	
	 /**
	  *退出在线用户
	  */
	public void kickOutOnlineUser(Integer userid) {
		log.info("【剔除在线用户】  userid..."+userid);
	    List<Object> userList=sessionRegistry.getAllPrincipals();  
	    log.info("【剔除在线用户】  当前在线人数"+userList.size()+"人");
	    for(int i=0; i<userList.size(); i++){  
	    	MyUserDetails userTemp=(MyUserDetails) userList.get(i);      
	        if(userTemp.getUserid().equals(userid)){   
	            List<SessionInformation> sessionInformationList =sessionRegistry.getAllSessions(userTemp, false);  
	            if (sessionInformationList!=null) {   
	                for (int j=0; j<sessionInformationList.size(); j++) {  
	                    sessionInformationList.get(j).expireNow();  
	                   sessionRegistry.removeSessionInformation(sessionInformationList.get(j).getSessionId());  
	                   userTemp=null;
	                }  
	            }  
	        }  
	    }
	}	
	
	
	
	
	
}

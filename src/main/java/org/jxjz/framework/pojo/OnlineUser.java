package org.jxjz.framework.pojo;

import java.util.Date;

public class OnlineUser {

private String  username;
private String  sessionid;
private Date    lastRequestTime;
private Date    loginTime;
private String  isSuper;
private String  ispredefine;
private String  telePhone;
private String  onlinetimes;
private String  realName;
private Integer userid;
//扩展
private Integer ownUserid;


public Integer getOwnUserid() {
	return ownUserid;
}
public void setOwnUserid(Integer ownUserid) {
	this.ownUserid = ownUserid;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getSessionid() {
	return sessionid;
}
public void setSessionid(String sessionid) {
	this.sessionid = sessionid;
}
public Date getLastRequestTime() {
	return lastRequestTime;
}
public void setLastRequestTime(Date lastRequestTime) {
	this.lastRequestTime = lastRequestTime;
}
public Date getLoginTime() {
	return loginTime;
}
public void setLoginTime(Date loginTime) {
	this.loginTime = loginTime;
}
public String getIspredefine() {
	return ispredefine;
}
public void setIspredefine(String ispredefine) {
	this.ispredefine = ispredefine;
}
public String getOnlinetimes() {
	return onlinetimes;
}
public void setOnlinetimes(String onlinetimes) {
	this.onlinetimes = onlinetimes;
}
public Integer getUserid() {
	return userid;
}
public void setUserid(Integer userid) {
	this.userid = userid;
}
public String getIsSuper() {
	return isSuper;
}
public void setIsSuper(String isSuper) {
	this.isSuper = isSuper;
}
public String getTelePhone() {
	return telePhone;
}
public void setTelePhone(String telePhone) {
	this.telePhone = telePhone;
}
public String getRealName() {
	return realName;
}
public void setRealName(String realName) {
	this.realName = realName;
}
 
}

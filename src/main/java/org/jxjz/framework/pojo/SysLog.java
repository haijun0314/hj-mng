package org.jxjz.framework.pojo;

import java.util.Date;

import org.jxjz.base.model.BaseModel;
import org.jxjz.framework.enums.LogType;

/**
 * 系统日志类
 * author lihaijun
 * createTime   2014-11-21
 */

public class SysLog extends BaseModel {

	private Integer logId;
	private Integer userId;
	private String  userName;
	private String  logMessage;//操作内容
	private Date    logTime;//操作时间
	private String  logIp;
	private String  module;
	private String  operResult;//存在结果 1 成功 2  失败
	private String  method;
	private String  action;
	private LogType logType;//操作类型    0 新增    1 修改    2 删除    3 查询    4 上传    5 下载  6 登录   可以自定义
	private Integer systemid;

	public SysLog() {
		
	}
	
	
	/** minimal constructor */
	public SysLog(LogType logType,String logMessage,String operResult) {
		this.logType = logType;
		this.logMessage=logMessage;
		this.operResult=operResult;
	}
	/** minimal constructor */
	public SysLog( String logMessage,String module,String operResult,String action,String method) {
		this.logMessage = logMessage;
		this.module = module;
		this.operResult = operResult;
		this.action=action;
		this.method=method;
	}
	/** minimal constructor */
	public SysLog( String logMessage, Date logTime) {
		this.logMessage = logMessage;
		this.logTime = logTime;
	}


	public Integer getLogId() {
		return logId;
	}


	public void setLogId(Integer logId) {
		this.logId = logId;
	}


	public Integer getUserId() {
		return userId;
	}


	public void setUserId(Integer userId) {
		this.userId = userId;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getLogMessage() {
		return logMessage;
	}


	public void setLogMessage(String logMessage) {
		this.logMessage = logMessage;
	}


	public Date getLogTime() {
		return logTime;
	}


	public void setLogTime(Date logTime) {
		this.logTime = logTime;
	}


	public String getLogIp() {
		return logIp;
	}


	public void setLogIp(String logIp) {
		this.logIp = logIp;
	}


	public String getModule() {
		return module;
	}


	public void setModule(String module) {
		this.module = module;
	}


	public String getOperResult() {
		return operResult;
	}


	public void setOperResult(String operResult) {
		this.operResult = operResult;
	}


	public String getMethod() {
		return method;
	}


	public void setMethod(String method) {
		this.method = method;
	}


	public String getAction() {
		return action;
	}


	public void setAction(String action) {
		this.action = action;
	}


	public LogType getLogType() {
		return logType;
	}


	public void setLogType(LogType logType) {
		this.logType = logType;
	}


	public Integer getSystemid() {
		return systemid;
	}


	public void setSystemid(Integer systemid) {
		this.systemid = systemid;
	}
 

	 
}
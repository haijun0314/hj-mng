package com.jyw.entity;

import java.util.Date;

import org.jxjz.base.model.BaseModel;

/**
 * 日志记录
 * @author chenjin
 * createTime 2014-12-20
 */
public class ClientLog extends BaseModel implements java.io.Serializable{
	
	private Integer logId;				//id
	private String content;				//日志内容
	private Date logTime;				//操作时间
	private Integer customerId;			//建议用户id
	
	//getter , setter方法
	public Integer getLogId() {
		return logId;
	}
	public void setLogId(Integer logId) {
		this.logId = logId;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getLogTime() {
		return logTime;
	}
	public void setLogTime(Date logTime) {
		this.logTime = logTime;
	}
	public Integer getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}
}

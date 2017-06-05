package com.jyw.entity;

import org.jxjz.base.model.BaseModel;
/**
 * 【代理商实体类】
 */
public class Agent extends BaseModel implements java.io.Serializable{
	private Integer agentId;	
	private String  agentName;
	private String  linkUserName;
	private String  linkTelephone;
	public Integer getAgentId() {
		return agentId;
	}
	public void setAgentId(Integer agentId) {
		this.agentId = agentId;
	}
	public String getAgentName() {
		return agentName;
	}
	public void setAgentName(String agentName) {
		this.agentName = agentName;
	}
	public String getLinkUserName() {
		return linkUserName;
	}
	public void setLinkUserName(String linkUserName) {
		this.linkUserName = linkUserName;
	}
	public String getLinkTelephone() {
		return linkTelephone;
	}
	public void setLinkTelephone(String linkTelephone) {
		this.linkTelephone = linkTelephone;
	}
	 
	
}

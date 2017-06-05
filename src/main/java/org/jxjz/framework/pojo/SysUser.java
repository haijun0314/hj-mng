package org.jxjz.framework.pojo;

import java.io.Serializable;
import java.util.Date;

import org.jxjz.base.model.BaseModel;
import org.jxjz.framework.enums.StartOrStop;
/**
 * 系统用户实体类
 * author lihaijun
 * createTime   2014-11-21
 */
public class SysUser extends BaseModel implements Serializable  {


	private Integer userId; //用户编号
	private String  userName;//用户名
	private String  password;//用户密码
	private String  realName;//真是姓名
	private Date    loginTime;//登陆时间
	private String  isSuper;//是否超级管理员【0 是 1 否】
	private String  isPredefine;//是否预定义【  0  是  1   否】
	private String status;//【0开启、1关闭】
	private String telePhone;//联系电话
	private String email;//邮箱
	private String remark;//备注
	private Integer agentId;//代理商编号
	private String userType;//账户类型 0  系统账户 1  代理商管理账户   2  代理商普通账户
	
	//附加字段
	private String roles;//角色
	private String roleDesc;//角色说明
    private Integer[] roleIds;//用户所属角色 用户登录后SecurityService.loadUserMenubars加载
	
    
    
    
    
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
	public Date getLoginTime() {
		return loginTime;
	}
	public void setLoginTime(Date loginTime) {
		this.loginTime = loginTime;
	}
	public String getIsSuper() {
		return isSuper;
	}
	public void setIsSuper(String isSuper) {
		this.isSuper = isSuper;
	}
	public String getIsPredefine() {
		return isPredefine;
	}
	public void setIsPredefine(String isPredefine) {
		this.isPredefine = isPredefine;
	}
	 
	public String getTelePhone() {
		return telePhone;
	}
	public void setTelePhone(String telePhone) {
		this.telePhone = telePhone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getRoles() {
		return roles;
	}
	public void setRoles(String roles) {
		this.roles = roles;
	}
	public String getRoleDesc() {
		return roleDesc;
	}
	public void setRoleDesc(String roleDesc) {
		this.roleDesc = roleDesc;
	}
	public Integer getAgentId() {
		return agentId;
	}
	public void setAgentId(Integer agentId) {
		this.agentId = agentId;
	}
	public Integer[] getRoleIds() {
		return roleIds;
	}
	public void setRoleIds(Integer[] roleIds) {
		this.roleIds = roleIds;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

	
	 
  

}
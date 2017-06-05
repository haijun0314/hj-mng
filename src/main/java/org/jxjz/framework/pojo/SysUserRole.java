package org.jxjz.framework.pojo;


import org.jxjz.base.model.BaseModel;

/**
 * SysUserrole entity.
 * 系统用户和角色对应关系
 *  
 */

public class SysUserRole extends BaseModel  implements java.io.Serializable {

	 
	private Integer userRoleId;
	private Integer userId;
	private Integer roleId;
	public Integer getUserRoleId() {
		return userRoleId;
	}
	public void setUserRoleId(Integer userRoleId) {
		this.userRoleId = userRoleId;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getRoleId() {
		return roleId;
	}
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
	
	 

	 
}
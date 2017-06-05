package org.jxjz.framework.pojo;

import org.jxjz.base.model.BaseModel;

 
/**
 * 系统角色实体类
 * author lihaijun
 * createTime   2014-11-21
 */
public class SysRole extends BaseModel {


	private Integer roleId;
	private String roleName;
	private String roleDesc;
	private String remark;
	private String resource;//角色来源  1 总部 2 城市 
	//扩展
	private String isUsed;//是否被用户使用【0 是 1 否】
	private String menuIds;//权限编号
	
	
	public String getMenuIds() {
		return menuIds;
	}
	public void setMenuIds(String menuIds) {
		this.menuIds = menuIds;
	}
	public String getIsUsed() {
		return isUsed;
	}
	public void setIsUsed(String isUsed) {
		this.isUsed = isUsed;
	}
	public Integer getRoleId() {
		return roleId;
	}
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public String getRoleDesc() {
		return roleDesc;
	}
	public void setRoleDesc(String roleDesc) {
		this.roleDesc = roleDesc;
	}
	 
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getResource() {
		return resource;
	}
	public void setResource(String resource) {
		this.resource = resource;
	}
	 

	 

}
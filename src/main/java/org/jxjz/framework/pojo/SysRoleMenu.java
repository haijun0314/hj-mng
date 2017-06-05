package org.jxjz.framework.pojo;

import org.jxjz.base.model.BaseModel;

/**
 * 角色权限对应关系
 * author lihaijun
 * createTime   2014-11-21
 */

public class SysRoleMenu  extends BaseModel implements java.io.Serializable {

	private Integer roleMenuId;
	private Integer menuId ;
	private Integer roleId;
	 
	public Integer getRoleMenuId() {
		return roleMenuId;
	}
	public void setRoleMenuId(Integer roleMenuId) {
		this.roleMenuId = roleMenuId;
	}
	public Integer getMenuId() {
		return menuId;
	}
	public void setMenuId(Integer menuId) {
		this.menuId = menuId;
	}
	public Integer getRoleId() {
		return roleId;
	}
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
 

}
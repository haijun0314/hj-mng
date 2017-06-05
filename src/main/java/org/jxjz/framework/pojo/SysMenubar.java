package org.jxjz.framework.pojo;

import org.jxjz.base.model.BaseModel;

 

/**
 * 系统菜单
 */

public class SysMenubar extends BaseModel  implements java.io.Serializable {

	private Integer menuId;
	private String menuName;
	private String menuLevel; 
	private String menuCode;
	private Integer parentId;
	private String title;
	private String location;
	private String image;//图标
	private String  status;//0启用  1停止
	private String  isDeaf;//按钮 0 是 1 否
	private String  descriptions;//描述
	private String authorityType;//权限类型
	private Integer systemId;//系统编号
	private String resource;//权限来源  1 总部 2 城市
	private String parentName;//上级菜单名称
	
	
	
	public String getParentName() {
		return parentName;
	}
	public void setParentName(String parentName) {
		this.parentName = parentName;
	}
	public Integer getMenuId() {
		return menuId;
	}
	public void setMenuId(Integer menuId) {
		this.menuId = menuId;
	}
	public String getMenuName() {
		return menuName;
	}
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}
	 
	public String getMenuLevel() {
		return menuLevel;
	}
	public void setMenuLevel(String menuLevel) {
		this.menuLevel = menuLevel;
	}
	public String getMenuCode() {
		return menuCode;
	}
	public void setMenuCode(String menuCode) {
		this.menuCode = menuCode;
	}
	public Integer getParentId() {
		return parentId;
	}
	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	 
	public String getIsDeaf() {
		return isDeaf;
	}
	public void setIsDeaf(String isDeaf) {
		this.isDeaf = isDeaf;
	}
	public String getDescriptions() {
		return descriptions;
	}
	public void setDescriptions(String descriptions) {
		this.descriptions = descriptions;
	}
	public String getAuthorityType() {
		return authorityType;
	}
	public void setAuthorityType(String authorityType) {
		this.authorityType = authorityType;
	}
	public Integer getSystemId() {
		return systemId;
	}
	public void setSystemId(Integer systemId) {
		this.systemId = systemId;
	}
	public String getResource() {
		return resource;
	}
	public void setResource(String resource) {
		this.resource = resource;
	}
 

	 
}
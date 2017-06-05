package org.jxjz.framework.pojo;

/**
 * SysRoleSystem entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class SysRoleSystem implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer roleid;
	private Integer systemid;	
	
	

	// Constructors

	/** default constructor */
	public SysRoleSystem() {
	}

	/** full constructor */
	public SysRoleSystem(Integer roleid, Integer systemid) {
		this.roleid = roleid;
		this.systemid = systemid;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getRoleid() {
		return this.roleid;
	}

	public void setRoleid(Integer roleid) {
		this.roleid = roleid;
	}

	public Integer getSystemid() {
		return this.systemid;
	}

	public void setSystemid(Integer systemid) {
		this.systemid = systemid;
	}

}
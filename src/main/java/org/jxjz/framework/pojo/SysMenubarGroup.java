package org.jxjz.framework.pojo;

import java.util.Date;

/**
 * SysMenubarGroup entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class SysMenubarGroup implements java.io.Serializable {

	// Fields

	private Long id;
	private Integer status;
	private Date addtime;
	private String code;
	private String name;
	private Integer systemid;

	// Constructors

	/** default constructor */
	public SysMenubarGroup() {
	}

	/** minimal constructor */
	public SysMenubarGroup(Integer status) {
		this.status = status;
	}

	/** full constructor */
	public SysMenubarGroup(Integer status, Date addtime, String code,
			String name, Integer systemid) {
		this.status = status;
		this.addtime = addtime;
		this.code = code;
		this.name = name;
		this.systemid = systemid;
	}

	// Property accessors

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Date getAddtime() {
		return this.addtime;
	}

	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getSystemid() {
		return this.systemid;
	}

	public void setSystemid(Integer systemid) {
		this.systemid = systemid;
	}

}
package com.jyw.entity;

import java.io.Serializable;

import org.jxjz.base.model.BaseModel;
/**
 * 区域实体管理
 * author libin
 * createTime   2014-11-25
 */
public class DictArea extends BaseModel implements Serializable{
	
	private String areacode;//区域编号
	private String areaname;//区域名称
	private String status;//状态
	private String pcode;//上级区域编号
	private String desc;//省市区
	private String type;//级别   1=省市  2=市  3=区
	
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getAreacode() {
		return areacode;
	}
	public void setAreacode(String areacode) {
		this.areacode = areacode;
	}
	public String getAreaname() {
		return areaname;
	}
	public void setAreaname(String areaname) {
		this.areaname = areaname;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getPcode() {
		return pcode;
	}
	public void setPcode(String pcode) {
		this.pcode = pcode;
	}
	

}

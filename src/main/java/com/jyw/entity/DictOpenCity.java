package com.jyw.entity;

import java.io.Serializable;
import java.util.Date;



import org.jxjz.base.model.BaseModel;
import org.jxjz.framework.enums.StartOrStop;
/**
 * 开放区域实体管理
 * author libin
 * createTime   2014-11-27
 */
public class DictOpenCity extends BaseModel implements Serializable{

	private String cityName;//城市名称
	private String cityCode;//城市编号
	private Date openTime;//开放时间
	private String remark;//备注
	private String telPhone;//电话
	private String contact;//联系人
	private StartOrStop status;//状态0开启1关闭
	private String address;//联系地址
	private String serviceAddress; //服务地址
	private Integer qq;
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public String getCityCode() {
		return cityCode;
	}
	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}
	 
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Date getOpenTime() {
		return openTime;
	}
	public void setOpenTime(Date openTime) {
		this.openTime = openTime;
	}
	public String getRemark() {
		return remark;
	}
	public String getTelPhone() {
		return telPhone;
	}
	public void setTelPhone(String telPhone) {
		this.telPhone = telPhone;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public StartOrStop getStatus() {
		return status;
	}
	public void setStatus(StartOrStop status) {
		this.status = status;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Integer getQq() {
		return qq;
	}
	public void setQq(Integer qq) {
		this.qq = qq;
	}
	public String getServiceAddress() {
		return serviceAddress;
	}
	public void setServiceAddress(String serviceAddress) {
		this.serviceAddress = serviceAddress;
	}
}

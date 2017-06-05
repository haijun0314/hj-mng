package com.jyw.entity;

import java.util.Date;

import org.jxjz.base.model.BaseModel;
import org.jxjz.framework.enums.DefaultStatus;

import com.jyw.enmu.CustomerStatus;

/**
 * 
 * 用户信息表
 * @author chenjin
 * createTime:2014-12-2
 */
public class Customer extends BaseModel implements java.io.Serializable {
	
	private Integer customerId;					//用户编号
	private String customerName; 				//用户名称
	private String telephone;					//电话号码
	private String password;					//账号密码
	private String career;						//职业
	private Integer age;						//年龄
	private String sex;							//性别(0男1女)
	private Integer gentleManDegree;				//君子度
	private DefaultStatus isCheck;				//验证(是否检测0是，1否)
	private Integer perfect;					//完善度
	
//	private Integer orderSuccessCount;  		//成功订单数
//	private Integer orderFailCount;				//失败订单数
//	private Integer orderTotalCount;    		//总订单数
//	private Integer orderComplainCount;			//投诉订单数
//	private Integer orderPublishCount;			//发布单总数  是一个变化的数据
//	private Integer orderBinddingCount;			//竞标单总数  是一个变化的数据
//	private Integer orderRevokeCount;			//撤销单总数
//	private Integer orderTradePublishCount;		//交易单数量  [发布单   统计 ]
//	private Integer orderTradeServiceCount;		//交易单数量  [服务单   统计 ]
	
	
	private Integer countPublish;			//【发布单】发布单总数
	private Integer countPublishSuccess;  	//【发布单】成功订单数
	private Integer countPublishFail;		//【发布单】失败单
	private Integer countPublishTrade;		//【发布单】交易单数量  [发布单   统计 ]
	private Integer countServiceBindding;	//【服务单】竞标单总数  是一个变化的数据
	private Integer countServiceFail;		//【服务单】失败单【服务】
	private Integer countServiceSuccess;  	//【服务单】成功订单数【服务】
	private Integer countServiceTrade;		//【服务单】交易单数量  [服务单   统计 ]
	private Integer countTotal;    			//总订单数
	private Integer countComplain;			//投诉订单数
	private Integer countRevoke;			//撤销单总数	
	
	
	
	private Date registTime;					//注册时间
	private Date activeTime;					//激活时间
	private Date checkTime;						//检测时间
	private String payPassword;					//支付密码
	private Double moneyTotal;					//总余额
	private Double moneyUsable;					//可用余额
	private String headPic;						//头像地址
	private CustomerStatus status;				//状态0.正常1.暂停
	private String osType;						//客户系统类型(0.安卓1.IOS)
	private String imei;						//imei号
	private String imsi;						//imsi号
	private String mModel;						//手机型号
	private Date loginTime;						//登录时间
	private String cerId;						//身份证
	private String studentID;					//学号
	private String company;						//工作单位
	private String school;						//毕业学校
	private String gentlemanNO;					//君子号码
	private String duty;						//职务
	private String label;						//个人标签
	private String dynamicState;				//当前动态
	private String email;						//email
	private String QQ;							//qq
	private String education;					//学历
	private String companyAddress;				//公司地址
	private String homeAddress;					//家庭地址
	private String myWebsite;					//个人网站
	private String gentlemanAge;				//君子年龄
	private String homeAddressOrder;			//家庭地址【交易】
	private String companyAddressOrder;			//公司地址【交易】
	private String homeAddressDoorNoOrder;		//家庭地址   门牌号【交易】
	private String companyAddressDoorNoOrder;	//公司地址  门牌号【交易】
	private String sessionId;					//每次请求的sessionId
	private String account;						//账户名称  登录名
	private String reportCount;					//举报数目
	private String cityCode;					//所属城市
	private String companySite;					//公司网址
	private String statusName;
	public Integer getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getCareer() {
		return career;
	}
	public void setCareer(String career) {
		this.career = career;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public Integer getGentleManDegree() {
		return gentleManDegree;
	}
	public void setGentleManDegree(Integer gentleManDegree) {
		this.gentleManDegree = gentleManDegree;
	}
	public DefaultStatus getIsCheck() {
		return isCheck;
	}
	public void setIsCheck(DefaultStatus isCheck) {
		this.isCheck = isCheck;
	}
	public Integer getPerfect() {
		return perfect;
	}
	public void setPerfect(Integer perfect) {
		this.perfect = perfect;
	}
	public Integer getCountPublish() {
		return countPublish;
	}
	public void setCountPublish(Integer countPublish) {
		this.countPublish = countPublish;
	}
	public Integer getCountPublishSuccess() {
		return countPublishSuccess;
	}
	public void setCountPublishSuccess(Integer countPublishSuccess) {
		this.countPublishSuccess = countPublishSuccess;
	}
	public Integer getCountPublishFail() {
		return countPublishFail;
	}
	public void setCountPublishFail(Integer countPublishFail) {
		this.countPublishFail = countPublishFail;
	}
	public Integer getCountPublishTrade() {
		return countPublishTrade;
	}
	public void setCountPublishTrade(Integer countPublishTrade) {
		this.countPublishTrade = countPublishTrade;
	}
	public Integer getCountServiceBindding() {
		return countServiceBindding;
	}
	public void setCountServiceBindding(Integer countServiceBindding) {
		this.countServiceBindding = countServiceBindding;
	}
	public Integer getCountServiceFail() {
		return countServiceFail;
	}
	public void setCountServiceFail(Integer countServiceFail) {
		this.countServiceFail = countServiceFail;
	}
	public Integer getCountServiceSuccess() {
		return countServiceSuccess;
	}
	public void setCountServiceSuccess(Integer countServiceSuccess) {
		this.countServiceSuccess = countServiceSuccess;
	}
	public Integer getCountServiceTrade() {
		return countServiceTrade;
	}
	public void setCountServiceTrade(Integer countServiceTrade) {
		this.countServiceTrade = countServiceTrade;
	}
	public Integer getCountTotal() {
		return countTotal;
	}
	public void setCountTotal(Integer countTotal) {
		this.countTotal = countTotal;
	}
	public Integer getCountComplain() {
		return countComplain;
	}
	public void setCountComplain(Integer countComplain) {
		this.countComplain = countComplain;
	}
	public Integer getCountRevoke() {
		return countRevoke;
	}
	public void setCountRevoke(Integer countRevoke) {
		this.countRevoke = countRevoke;
	}
	public Date getRegistTime() {
		return registTime;
	}
	public void setRegistTime(Date registTime) {
		this.registTime = registTime;
	}
	public Date getActiveTime() {
		return activeTime;
	}
	public void setActiveTime(Date activeTime) {
		this.activeTime = activeTime;
	}
	public Date getCheckTime() {
		return checkTime;
	}
	public void setCheckTime(Date checkTime) {
		this.checkTime = checkTime;
	}
	public String getPayPassword() {
		return payPassword;
	}
	public void setPayPassword(String payPassword) {
		this.payPassword = payPassword;
	}
	public Double getMoneyTotal() {
		return moneyTotal;
	}
	public void setMoneyTotal(Double moneyTotal) {
		this.moneyTotal = moneyTotal;
	}
	public Double getMoneyUsable() {
		return moneyUsable;
	}
	public void setMoneyUsable(Double moneyUsable) {
		this.moneyUsable = moneyUsable;
	}
	public String getHeadPic() {
		return headPic;
	}
	public void setHeadPic(String headPic) {
		this.headPic = headPic;
	}
	public CustomerStatus getStatus() {
		return status;
	}
	public void setStatus(CustomerStatus status) {
		this.status = status;
	}
	public String getOsType() {
		return osType;
	}
	public void setOsType(String osType) {
		this.osType = osType;
	}
	public String getImei() {
		return imei;
	}
	public void setImei(String imei) {
		this.imei = imei;
	}
	public String getImsi() {
		return imsi;
	}
	public void setImsi(String imsi) {
		this.imsi = imsi;
	}
	public String getmModel() {
		return mModel;
	}
	public void setmModel(String mModel) {
		this.mModel = mModel;
	}
	public Date getLoginTime() {
		return loginTime;
	}
	public void setLoginTime(Date loginTime) {
		this.loginTime = loginTime;
	}
	public String getCerId() {
		return cerId;
	}
	public void setCerId(String cerId) {
		this.cerId = cerId;
	}
	public String getStudentID() {
		return studentID;
	}
	public void setStudentID(String studentID) {
		this.studentID = studentID;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getSchool() {
		return school;
	}
	public void setSchool(String school) {
		this.school = school;
	}
	public String getGentlemanNO() {
		return gentlemanNO;
	}
	public void setGentlemanNO(String gentlemanNO) {
		this.gentlemanNO = gentlemanNO;
	}
	public String getDuty() {
		return duty;
	}
	public void setDuty(String duty) {
		this.duty = duty;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public String getDynamicState() {
		return dynamicState;
	}
	public void setDynamicState(String dynamicState) {
		this.dynamicState = dynamicState;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getQQ() {
		return QQ;
	}
	public void setQQ(String qQ) {
		QQ = qQ;
	}
	public String getEducation() {
		return education;
	}
	public void setEducation(String education) {
		this.education = education;
	}
	public String getCompanyAddress() {
		return companyAddress;
	}
	public void setCompanyAddress(String companyAddress) {
		this.companyAddress = companyAddress;
	}
	public String getHomeAddress() {
		return homeAddress;
	}
	public void setHomeAddress(String homeAddress) {
		this.homeAddress = homeAddress;
	}
	public String getMyWebsite() {
		return myWebsite;
	}
	public void setMyWebsite(String myWebsite) {
		this.myWebsite = myWebsite;
	}
	public String getGentlemanAge() {
		return gentlemanAge;
	}
	public void setGentlemanAge(String gentlemanAge) {
		this.gentlemanAge = gentlemanAge;
	}
	public String getHomeAddressOrder() {
		return homeAddressOrder;
	}
	public void setHomeAddressOrder(String homeAddressOrder) {
		this.homeAddressOrder = homeAddressOrder;
	}
	public String getCompanyAddressOrder() {
		return companyAddressOrder;
	}
	public void setCompanyAddressOrder(String companyAddressOrder) {
		this.companyAddressOrder = companyAddressOrder;
	}
	public String getHomeAddressDoorNoOrder() {
		return homeAddressDoorNoOrder;
	}
	public void setHomeAddressDoorNoOrder(String homeAddressDoorNoOrder) {
		this.homeAddressDoorNoOrder = homeAddressDoorNoOrder;
	}
	public String getCompanyAddressDoorNoOrder() {
		return companyAddressDoorNoOrder;
	}
	public void setCompanyAddressDoorNoOrder(String companyAddressDoorNoOrder) {
		this.companyAddressDoorNoOrder = companyAddressDoorNoOrder;
	}
	public String getSessionId() {
		return sessionId;
	}
	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getReportCount() {
		return reportCount;
	}
	public void setReportCount(String reportCount) {
		this.reportCount = reportCount;
	}
	public String getCityCode() {
		return cityCode;
	}
	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}
	public String getCompanySite() {
		return companySite;
	}
	public void setCompanySite(String companySite) {
		this.companySite = companySite;
	}
	public String getStatusName() {
		return statusName;
	}
	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}
	
	 
	
}

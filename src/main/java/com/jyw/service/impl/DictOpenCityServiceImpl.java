package com.jyw.service.impl;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.jxjz.base.mybatis.Query;
import org.jxjz.framework.enums.StartOrStop;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jyw.dao.DictOpenCityDAO;
import com.jyw.entity.DictOpenCity;
import com.jyw.service.DictOpenCityService;

@Service
@Transactional
public class DictOpenCityServiceImpl implements DictOpenCityService {

	@Resource
	DictOpenCityDAO dictOpenCityDAO;
	private Logger log 					 = Logger.getLogger("jxjz");

	/**
	 * 查询开放城市 author:chenjin createTime:2014-11-27
	 */
	public List getOpenCityList(Query query) {

		return dictOpenCityDAO.queryList(query);
	}
	/**
	 * 添加开放城市 author:chenjin createTime:2015-1-12
	 */
	public void addOpenCity(DictOpenCity dictOpenCity) {
		log.info("【开放城市添加】....开放城市编号为"+dictOpenCity.getCityCode());
		dictOpenCity.setOpenTime(new Date());
		dictOpenCity.setStatus(StartOrStop.Start);
		String sql = "create table orderinfo_"+dictOpenCity.getCityCode()+"" +
				"(orderId varchar(32)," +
				"serviceBigType varchar(2)," +
				"customerId int(20),"+
				"status varchar(2) ,"+
				"serviceId int(11) ,"+
				"activityTitle varchar(145)," +
				"askResultType char(255)," +
				"askPic varchar(300)," +
				"askLevelId int(11),"+
				"askTypeId int(11),"+
				"askContent varchar(255),"+
				"activityDesc varchar(5000),"+
				"biddingMoneyLow double DEFAULT '-1',"+
				"biddingCount int(11) DEFAULT '0',"+
				"biddingCustomerId int(11),"+
				"biddingCustomerName varchar(45),"+
				"biddingTime datetime,"+
				"biddingTelephone varchar(255),"+
				"customerName varchar(255),"+
				"completeTime datetime,"+
				"comment varchar(500),"+
				"commentTime datetime ,"+
				"complaintContent varchar(255),"+
				"complaintType varchar(45),"+
				"concelTime datetime,"+
				"concelCustomerId int(45),"+
				"content varchar(405),"+
				"cutPoint varchar(45),"+
  				"commentLevel varchar(45),"+
  				"createdBy varchar(45),"+
  				"createdTime datetime ,"+
  				"cityCode varchar(255),"+
  				"concelType char(255),"+
  				"cityName varchar(255),"+
  				"delFlag char(1) DEFAULT '0',"+
  				"endStreet varchar(100),"+
  				"endHouse varchar(100),"+
  				"freezeMoney double(45,0) DEFAULT '0',"+
  				"failCode varchar(255),"+
  				"failDesc varchar(45),"+
  				"freezeTime datetime ,"+
  				"isConcel varchar(2) DEFAULT '1',"+
  				"isByCommonly varchar(2) DEFAULT '1',"+
  				"isComplaint varchar(2) DEFAULT '1',"+
  				"isAgreeConcel char(1),"+
  				"isCommonly varchar(45) DEFAULT '1',"+
  				"isReport char(255) DEFAULT '1',"+
  				"isFree char(255),"+
  				"isAbortion char(255) DEFAULT '1',"+
  				"isVerify char(1) DEFAULT '1',"+
  				"longitude varchar(45) ,"+
  				"latitude varchar(45),"+
  				"longitudeStart varchar(45),"+
  				"latitudeEnd varchar(45),"+
  				"longitudeEnd varchar(45),"+
  				"latitudeStart varchar(45),"+
  				"longitudeService varchar(45),"+
  				"latitudeService varchar(45) ,"+
  				"members int(11) DEFAULT '0',"+
  				"notePic varchar(500),"+
  				"noteVoice varchar(500),"+
  				"orderTime varchar(50),"+
  				"orderAbortionReson varchar(255),"+
  				"orderFeedback varchar(255),"+
  				"partakeNum varchar(45) DEFAULT '1',"+
  				"predictNumber int(11),"+
  				"rewardLow double,"+
  				"rewardUp double,"+
  				"remark varchar(5000),"+
  				"reportTime datetime,"+
  				"startStreet varchar(100) ,"+
  				"startHouse varchar(100),"+
  				"serviceAddress varchar(200) ,"+
  				"serviceMoney double(45,0) DEFAULT '0',"+
  				"serviceTime datetime ,"+
  				"serviceTimelength int(11),"+
  				"serviceNum int(11) ,"+
  				"serviceName varchar(255),"+
  				"tradeMoney double DEFAULT '0',"+
  				"tradeCode varchar(45),"+
  				"tradeCodeErrorNum varchar(45) DEFAULT '0',"+
  				"telephone varchar(255) ,"+
  				"unFreezeTime datetime ,"+
  				"updatedBy varchar(45),"+
  				"updatedTime datetime ,"+
  				"verifyNotThroughType varchar(255),"+
  				"verifyTime datetime,"+
  				"verifySysUserId int(11),"+
  				"verifyReson varchar(400) ,"+
  				"verifyResult char(255) DEFAULT '2',"+
  				"isBlack char(255) ,"+
  				" PRIMARY KEY (orderId))" +
				"ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;";
		dictOpenCityDAO.getJdbcTemplateEx().execute(sql);
		dictOpenCityDAO.save(dictOpenCity);
	}

	/**
	 * 查询开放城市根据用户表 author:liubin createTime:2015-1-14
	 */
	public List getOpenCity(Query query) {
		return dictOpenCityDAO.getOpenCity(query);
	}
}

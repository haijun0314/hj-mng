package com.jyw.service;
import java.util.List;

import org.jxjz.base.mybatis.Query;

import com.jyw.entity.DictOpenCity;

public interface DictOpenCityService {
	
	//查询开放城市
	public List getOpenCityList(Query query);
	//查询开放城市根据用户表
	public List getOpenCity(Query query);
	//添加开放区域
	public void addOpenCity(DictOpenCity dictOpenCity);
}

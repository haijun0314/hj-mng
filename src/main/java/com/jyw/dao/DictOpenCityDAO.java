package com.jyw.dao;

import java.util.List;

import org.jxjz.base.model.PageModel;
import org.jxjz.base.mybatis.BaseIbatisDAO;
import org.jxjz.base.mybatis.Query;
import org.springframework.stereotype.Repository;

import com.jyw.entity.DictOpenCity;
@Repository
public class DictOpenCityDAO extends BaseIbatisDAO{
	/**
	 * 查询开放城市根据用户表author:liubin createTime:2015-1-14
	 * @param query
	 * @return
	 */
	public List getOpenCity(Query query) {
		return queryList("DictOpenCity.queryCity", query);
	}
	
	
	@Override
	public Class getEntityClass()
	{
		return DictOpenCity.class;
		
	}
	

}

package com.jyw.dao;

import org.jxjz.base.mybatis.BaseIbatisDAO;
import org.springframework.stereotype.Repository;

import com.jyw.entity.Agent;



/**
 */
@Repository
public class AgentDAO extends BaseIbatisDAO{
	 
	public Class getEntityClass() {
		return Agent.class;
	}	 
	
	 
 
	 
}
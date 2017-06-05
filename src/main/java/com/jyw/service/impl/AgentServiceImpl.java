package com.jyw.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.jxjz.base.model.PageModel;
import org.jxjz.base.mybatis.BaseService;
import org.jxjz.base.mybatis.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jyw.dao.AgentDAO;
import com.jyw.service.AgentService;

@Service
@Transactional
public class AgentServiceImpl extends BaseService implements AgentService{
	@Resource AgentDAO 				agentDAO;
 	
	
	
	public PageModel getAgentPageList (PageModel pm){
		return agentDAO.queryPageList(pm);
	}
	 
	public List 		 getAgentList (Query q){
		return agentDAO.queryList(q);
	}
	 
}

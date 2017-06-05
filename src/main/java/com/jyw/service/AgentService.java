package com.jyw.service;

import java.util.List;

import org.jxjz.base.model.PageModel;
import org.jxjz.base.mybatis.Query;

/**
 *
 */
public interface AgentService {
	public PageModel 	 getAgentPageList (PageModel pm);
	public List 		 getAgentList (Query q);
}

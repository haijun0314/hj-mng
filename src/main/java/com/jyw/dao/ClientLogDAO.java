package com.jyw.dao;
import org.jxjz.base.model.PageModel;
import org.jxjz.base.mybatis.BaseIbatisDAO;
import org.springframework.stereotype.Repository;

import com.jyw.entity.ClientLog;

/**
 * 日志记录
 * author:chenjin
 * createTime:2014-12-20
 */
@Repository
public class ClientLogDAO extends BaseIbatisDAO{
	
	/**
	 * 分页查询日志列表
	 * author:chenjin
	 * createTime:2014-12-19
	 */
	public PageModel getClientLogPageList(PageModel pm){
		pm = queryPageList(pm);
		return pm;
	}
	@Override
	public Class getEntityClass(){
		return ClientLog.class;
	}
	
}

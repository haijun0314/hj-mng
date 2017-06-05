package org.jxjz.framework.log.dao;

import java.util.List;

import org.jxjz.base.model.PageModel;
import org.jxjz.base.mybatis.BaseIbatisDAO;
import org.jxjz.framework.pojo.SysLog;
import org.springframework.stereotype.Repository;
@Repository
public class SysLogDAO extends BaseIbatisDAO{
	/**
	 *  查询日志分页
	 */
	public PageModel getSysLogPageList(PageModel pm){
		pm= queryPageList(pm);
		return  pm;
	}
	 
	
	@Override
	public Class getEntityClass() {
		return SysLog.class;
	}
	  
}
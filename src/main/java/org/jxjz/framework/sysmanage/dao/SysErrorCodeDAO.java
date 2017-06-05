package org.jxjz.framework.sysmanage.dao;

import org.jxjz.base.mybatis.BaseIbatisDAO;
import org.jxjz.framework.pojo.SysError;
import org.springframework.stereotype.Repository;
@Repository
public class SysErrorCodeDAO extends BaseIbatisDAO{
	 
	@Override
	public Class getEntityClass() {
		return SysError.class;
	}
	 
}
package org.jxjz.framework.sysmanage.dao;

import org.jxjz.base.mybatis.BaseIbatisDAO;
import org.jxjz.framework.pojo.SysMenubar;
import org.springframework.stereotype.Repository;
@Repository
public class SysMenubarDAO extends   BaseIbatisDAO{
	 
	
	@Override
	public Class getEntityClass() {
		return SysMenubar.class;
	}
	
	 
	
	

}
package org.jxjz.framework.sysmanage.dao;

import org.jxjz.base.mybatis.BaseIbatisDAO;
import org.jxjz.framework.pojo.SysUser;
import org.springframework.stereotype.Repository;
@Repository
public class SysUserDAO extends BaseIbatisDAO{
	
	/**
	 * 根据管理员用户名查询
	 */
	public SysUser getSysUserByUserName(String username){
		SysUser sysUser= (SysUser)getObjById(username,"SysUser.querySysUserByUserName");
		return  sysUser;
	}
	 
	@Override
	public Class getEntityClass() {
		return SysUser.class;
	}		
}

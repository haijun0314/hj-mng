package org.jxjz.framework.sysmanage.dao;

import org.jxjz.base.mybatis.BaseIbatisDAO;
import org.jxjz.framework.pojo.SysUserRole;
import org.springframework.stereotype.Repository;

 
@Repository
public class SysUserRoleDAO extends BaseIbatisDAO{
	 
	/**
	 *  根据用户删除
	 */
	public void deleteUserRole(Integer userid){
		  deleteByID(userid,"SysUserRole.deleteByUserId");
	}	
	
	
	@Override
	public Class getEntityClass() {
		return SysUserRole.class;
	}
 
}
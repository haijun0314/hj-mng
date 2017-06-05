package org.jxjz.framework.sysmanage.dao;

import java.util.List;

import org.jxjz.base.mybatis.BaseIbatisDAO;
import org.jxjz.framework.pojo.SysRole;
import org.springframework.stereotype.Repository;
@Repository
public class SysRoleDAO extends BaseIbatisDAO {
 
	/**
	 *  根据角色编号查询角色对应关系
	 */
	public List getRoleUsers(Integer roleid){
		return  super.queryList("SysRole.queryRoleUsers",roleid);
	}	 	
	
	public Class getEntityClass() {
		return SysRole.class;
	}
	 
}
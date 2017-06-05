package org.jxjz.framework.sysmanage.dao;

import java.util.List;

import javax.annotation.Resource;

import org.jxjz.base.jdbc.JdbcTemplateEx;
import org.jxjz.base.mybatis.BaseIbatisDAO;
import org.jxjz.base.mybatis.Query;
import org.jxjz.framework.pojo.SysRoleMenu;
import org.springframework.stereotype.Repository;

 
@Repository
public class SysRoleMenuDAO extends BaseIbatisDAO{
	
	@Resource JdbcTemplateEx jdbcTemplateEx;
	 
	 
	/**
	 * 根据角色id删除菜单
	 */
	public void deleteByRoleId(Integer roleid){
		delete(roleid, "SysRoleMenu.deleteByRoleId");
	}	
	
	@Override
	public Class getEntityClass() {
		return SysRoleMenu.class;
	}
	 
}
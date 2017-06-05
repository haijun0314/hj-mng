package org.jxjz.framework.sysmanage.service;

import java.util.List;

import org.jxjz.base.model.PageModel;
import org.jxjz.base.mybatis.Query;
import org.jxjz.framework.pojo.SysRole;

public interface SysRoleService {
	//添加角色
	public void add(SysRole sr) ;
	//删除角色
	public void delete(Integer roleId) ;
	//编辑角色
	public void update(SysRole sr) ;
	//分页查询系统管角色
	public PageModel getSysRolePageList(PageModel pm);
	//通用查询角色
	public List getSysRoleList(Query query) ;
	//【根据ID查询角色】
	public SysRole getSysRole(Integer roleId);
	//【查询用户角色 所有角色和用户所属角色】
	public List getUserRoles(Integer userid);
	//【查询角色拥有的用户】
	public List getRoleUsers(Integer roleId);
	//分配权限 
	public void assignPermission(Integer roleid ,String[] menuids) ;
	//检测角色是否被使用
	public boolean checkIsBindSysUser(Integer roleId);
	//【检查是否已经存在】
	public boolean checkExist(String roleDesc);
		
	
	
	
	
	
}

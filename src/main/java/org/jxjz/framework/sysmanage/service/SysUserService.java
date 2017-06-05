package org.jxjz.framework.sysmanage.service;

import org.jxjz.base.model.PageModel;
import org.jxjz.framework.pojo.SysUser;

public interface SysUserService {
	 
	//分页查询系统管理员
	public PageModel getUserPageList(PageModel pm);
	//添加系统用户
	public void  addSysUser(SysUser sysUser)  ;
	//根据管理员ID查询
	public SysUser getSysUserById(Integer userid);
	//更新账户
	public void update(SysUser sysUser);
	//删除用户
	public void delete(Integer userid);
	//系统用户详情
	public SysUser detail(Integer userid);
	//检查是否已经存在
	public boolean checkUserName(String username);
	
}

package org.jxjz.framework.sysmanage.service;

import java.util.List;

import org.jxjz.base.model.PageModel;
import org.jxjz.base.mybatis.Query;
import org.jxjz.framework.pojo.SysMenubar;

public interface SysMenuBarService {
	//分页查询系统菜单
	public PageModel getSysMenuBarPageList(PageModel pm);
	//增加功能
	public int add(SysMenubar smb);
	//检测权限是否被使用
	public boolean checkIsUsed(Integer menuId);
	//根据id删除菜单
	public void delete(Integer menuId);
	//查询系统导航菜单
	public List getBannerMenuBarList();
	//通用查询菜单
	public List  getMenuBarList(Query query)  ;
	//根据id查询
	public List getMenuListByRoleId(String roleId);
	//根据id查询(更新方法)
	public SysMenubar getSysMenuBar(Integer menuid);
	//更新功能(更新方法)
	public void update(SysMenubar smb);
}

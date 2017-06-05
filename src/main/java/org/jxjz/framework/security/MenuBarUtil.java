package org.jxjz.framework.security;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.jxjz.common.util.JsonUtil;
import org.jxjz.framework.enums.StartOrStop;
import org.jxjz.framework.pojo.SysMenubar;
import org.jxjz.framework.util.ConfigUtil;

public class MenuBarUtil {
	public static List<SysMenubar> sysAllMenuList=new ArrayList<SysMenubar>();//系统权限【系统初始化时候加载MySecurityMetadataSource.loadResourceDefine】
	
	/**
	 * 创建新的菜单【树形】
	 * @param mnenuBars：用菜单总和
	 * @return
	 */
	public static SysMenubar createNewMenubar(SysMenubar smb,SysMenubar psmb,List mnenuBars) {
		String  pmenuCode=psmb.getMenuCode();
		String  pmenuLevel=psmb.getMenuLevel();
		String  newmenuLevel="";
		String  newmenuCode="";
		List childList= getChildMenubarList(mnenuBars, pmenuCode, false);
		if (childList==null||childList.size()==0) {//没有同级菜单，生成第一个菜单
			newmenuCode=pmenuCode+ConfigUtil.MenuBar_Code_Add;
		}else {
			SysMenubar childMenubar=(SysMenubar)childList.get(childList.size()-1);
			BigDecimal codeValue = new BigDecimal(childMenubar.getMenuCode()); 
			newmenuCode=codeValue.add(new BigDecimal(1)).toString();
		}
		newmenuLevel=String.valueOf(Integer.parseInt(pmenuLevel)+1);
		smb.setMenuCode(newmenuCode);
		smb.setMenuLevel(newmenuLevel);
		smb.setCreatedTime(new Date());
		smb.setStatus(StartOrStop.Start.getValue());
		smb.setIsDeaf("");
		if (StringUtils.isBlank(smb.getTitle())) {
			smb.setTitle(smb.getMenuName());
		}
		return smb;
	}	
	/**
	 * 创建新的菜单【导航菜单】
	 * @param mnenuBars：用菜单总和
	 * @return
	 */
	public static SysMenubar createTopMenubar(SysMenubar smb,List mnenuBars) {
		String  newmenuCode="";
		List childList= getTopMenubarList(mnenuBars);
		SysMenubar childMenubar=(SysMenubar)childList.get(childList.size()-1);
		BigDecimal codeValue = new BigDecimal(childMenubar.getMenuCode()); 
		newmenuCode=codeValue.add(new BigDecimal(1)).toString();
		smb.setMenuCode(newmenuCode);
		smb.setMenuLevel("1");
		smb.setCreatedTime(new Date());
		smb.setStatus(StartOrStop.Start.getValue());
		smb.setIsDeaf("");
		smb.setParentId(0);
		if (StringUtils.isBlank(smb.getTitle())) {
			smb.setTitle(smb.getMenuName());
		}
		return smb;
	}		
	
 
	
	/**
	 * 查询子菜单【下级】
	 * @param userMenuBars：用菜单总和
	 * @param menubarcode：菜单code
	 * @param isoneself：是否包含自己
	 */
	public static List getChildMenubarList(List userMenuBars,String menubarcode,boolean isoneself) {
		List list=new ArrayList();
		for (int i = 0; i < userMenuBars.size(); i++) {
			SysMenubar smb=(SysMenubar)userMenuBars.get(i);
			String menucode=smb.getMenuCode();
			if (menucode.length()!=menubarcode.length()+3)  continue;
			if (isoneself) {
				if (menucode.startsWith(menubarcode)) {
					list.add(smb);
				}
			}else {
				if (menucode.startsWith(menubarcode)&&!menucode.equals(menubarcode)) {
					list.add(smb);
				}
			}
		}
		return list;
	}
	/**
	 * 查询子菜单【所有子菜单】
	 * @param userMenuBars：用菜单总和
	 * @param menubarcode：菜单code
	 * @param isoneself：是否包含自己
	 */
	public static List getAllChildMenubarList(List userMenuBars,String menubarcode,boolean isoneself) {
		List list=new ArrayList();
		for (int i = 0; i < userMenuBars.size(); i++) {
			SysMenubar smb=(SysMenubar)userMenuBars.get(i);
			String menucode=smb.getMenuCode();
			if (isoneself) {
				if (menucode.startsWith(menubarcode)) {
					list.add(smb);
				}
			}else {
				if (menucode.startsWith(menubarcode)&&!menucode.equals(menubarcode)) {
					list.add(smb);
				}
			}
		}
		return list;
	}
	 
	 
	 
	/**
	 * 查询菜单【获取系统的一级菜单】
	 * @return
	 */
	public static List getTopMenubarList(List menubarList) {
		 List topmenubarList=new ArrayList();
		 for(int i=0;i<menubarList.size();i++){
			SysMenubar smb=(SysMenubar)menubarList.get(i);
			if(!smb.getMenuLevel().equals("1"))continue;
			topmenubarList.add(smb);
		 }
		return topmenubarList;
	}
	
	 
	/**
	 *  菜单树【ztree 带选择框的】
	 *  menubarcode:上级菜单 如果为空则表示整个系统的菜单
	 *  selectedMenuStr:表示初始化被选中的菜单
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static String getTreeJson(String menubarcode,String selectedMenuStr) {
		List menuList;
		if (StringUtils.isBlank(menubarcode)){
			menuList=getSysAllMenuList();
		}else {
			 menuList=getAllChildMenubarList(sysAllMenuList, menubarcode, false);
		}
		 List tempList=new ArrayList();
		 for (int i = 0; i < menuList.size()&&menuList.size()>0; i++) {
			Map map=new HashMap();
			SysMenubar smb=(SysMenubar)menuList.get(i);
			map.put("id", smb.getMenuId());
			map.put("pId", smb.getParentId());
			map.put("name", smb.getMenuName());
			if (StringUtils.isNotBlank(selectedMenuStr)&&selectedMenuStr.toString().indexOf(smb.getMenuId()+"-")>-1) {
				map.put("checked", "true");
			}
			 
			tempList.add(map);
		}
		 String jsonStr=JsonUtil.getStringFromList(tempList);
		return jsonStr;
	}
	 

	public static List<SysMenubar> getSysAllMenuList() {
		return sysAllMenuList;
	}

	public static void setSysAllMenuList(List<SysMenubar> sysAllMenuList) {
		MenuBarUtil.sysAllMenuList = sysAllMenuList;
	}
	
}

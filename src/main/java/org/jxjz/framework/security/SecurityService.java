package org.jxjz.framework.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.jxjz.base.mybatis.Query;
import org.jxjz.framework.enums.DefaultStatus;
import org.jxjz.framework.enums.IsSuper;
import org.jxjz.framework.enums.MenuLevel;
import org.jxjz.framework.enums.StartOrStop;
import org.jxjz.framework.pojo.SysMenubar;
import org.jxjz.framework.pojo.SysRole;
import org.jxjz.framework.pojo.SysRoleMenu;
import org.jxjz.framework.pojo.SysUser;
import org.jxjz.framework.pojo.SysUserRole;
import org.jxjz.framework.sysmanage.dao.SysMenubarDAO;
import org.jxjz.framework.sysmanage.dao.SysRoleDAO;
import org.jxjz.framework.sysmanage.dao.SysRoleMenuDAO;
import org.jxjz.framework.sysmanage.dao.SysRoleSystemDAO;
import org.jxjz.framework.sysmanage.dao.SysUserDAO;
import org.jxjz.framework.sysmanage.dao.SysUserRoleDAO;
import org.jxjz.framework.util.ConfigUtil;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
@Service
/**
 * 权限管理service【主要负责查询功能】
 */
public class SecurityService {

	@Resource  SysUserDAO        sysUserDAO;
	@Resource  SysUserRoleDAO    sysUserRoleDAO;
	@Resource  SysMenubarDAO     sysMenuBarDAO;
	@Resource  SysRoleDAO 	     sysRoleDAO;
	@Resource  SysRoleMenuDAO    sysRoleMenuDAO;
	@Resource  SysRoleSystemDAO  sysRoleSystemDAO;
	@Resource SessionRegistry	 sessionRegistry;
	List<String> filterAuthorities=new ArrayList<String>();
	private Logger log 	= Logger.getLogger(ConfigUtil.logName_sys);
	/**
	 * 加载系统不需要安全控制的权限【就是action的一个方法】
	 */
	public  void loadSysFilterAuthorities() {
		//静态资源
		filterAuthorities.add("static");
		filterAuthorities.add("test");
		filterAuthorities.add("favicon");
		filterAuthorities.add("uploadFiles");
		filterAuthorities.add("loginAction");
		filterAuthorities.add("forwardAction.do");
		filterAuthorities.add("securityAction");
		filterAuthorities.add("download.jsp");
		filterAuthorities.add("files/Chrome.exe");
		
	}	
	/**
	 * 加载系统所有权限资源
	 */
	public  Map loadAuthorities(Map<String, Collection<ConfigAttribute>> resourceMap ){
		if(resourceMap==null){
			resourceMap = new HashMap<String, Collection<ConfigAttribute>>();
		}
		Query  query=new Query();
		query.append("status", StartOrStop.Start.getValue());
		List<SysMenubar> menuBaList=sysMenuBarDAO.queryList(query);
		for (SysMenubar sysMenubar :menuBaList) {
			String locationUrl=sysMenubar.getLocation();
			if (StringUtils.isBlank(locationUrl)) continue;
			List roleList=sysRoleMenuDAO.queryList("SysRoleMenu.loadMenuRoles",sysMenubar.getMenuId());
			Collection<ConfigAttribute> atts = new ArrayList<ConfigAttribute>();
			for (int i=0;i<roleList.size();i++) {
				Map map=(Map)roleList.get(i);
				Integer roueId=MapUtils.getInteger(map, "roleId");
				ConfigAttribute ca = new SecurityConfig("ROLE_"+roueId);
				atts.add(ca);
			}
			resourceMap.put(locationUrl, atts);
		}
		MenuBarUtil.setSysAllMenuList(menuBaList);
		return resourceMap;
	}
	
	/**
	 * 根据用户名查询并加载用户信息及权限
	 */
	public UserDetails loadUserByUsername(String userName){
		log.info("【账户登录】开始....登录账户名"+userName);
		SysUser sysUser=sysUserDAO.getSysUserByUserName(userName);
		if (sysUser==null) {
			log.info("【账户登录】...没有或者查询到该用户"+userName);
			return null;
		}
		MyUserDetails myUserDetails=new MyUserDetails();
		List<GrantedAuthority> auths= loadUserAuthorities( sysUser);
		myUserDetails.setAuthorities(auths);
		List<SysMenubar> userMenuBars=loadUserMenubars( sysUser);
		try {
			BeanUtils.copyProperties(myUserDetails, sysUser);
			myUserDetails.setUserMenuBars(userMenuBars);
			myUserDetails.setLoginTime(new Date());
			myUserDetails.setAccountNonExpired( true);
			myUserDetails.setAccountNonLocked( true);
			myUserDetails.setCredentialsNonExpired( true);
			myUserDetails.setEnabled(true);
			myUserDetails.setUsername(userName);
			myUserDetails.setPassword(sysUser.getPassword());
			myUserDetails.setUserid(sysUser.getUserId());
			MyUserDetails.setUserDetails(myUserDetails);
		} catch (Exception e) {
			log.error("系统账户登陆发生异常...."+e.getMessage());
			return null;
		} 
		return myUserDetails;
		
	}
	
	/**
	 *根据用户名查询并加载用户信息及权限
	 */
	public List<GrantedAuthority> loadUserAuthorities(SysUser sysUser) {
			log.info("【账户登录】 加载用户权限");
			List<GrantedAuthority> auths = new ArrayList<GrantedAuthority>();
			String isSuper = sysUser.getIsSuper();
			if (isSuper.equals(IsSuper.Yes.getValue())) {
				log.info("【账户登录】 该账户为超级账户  加载系统所有权限");
				Query query =new Query();
				query.append("resource", "1");
				List roleList=sysRoleDAO.queryList(query);
				Integer[] roleIds = new Integer[roleList.size()];//用户所属角色 
				for (int i=0;i<roleList.size();i++) {
					Map  sysRole=(Map)roleList.get(i);
					Integer roleId=MapUtils.getInteger(sysRole,"roleId");
					GrantedAuthorityImpl authority = new GrantedAuthorityImpl("ROLE_"+roleId);
					auths.add(authority);
					roleIds[i]=roleId;
					log.info("【账户登录】 拥有权限"+authority.getAuthority());
				}
				sysUser.setRoleIds(roleIds);
			}else {
				//根据userId查询userRole表
				List userRoleList=sysUserRoleDAO.queryList("SysUserRole.queryUserRoles",sysUser.getUserId());
				Integer[] roleIds = new Integer[userRoleList.size()];//用户所属角色 
				for (int i=0;i<userRoleList.size();i++) {
					Map userrole=(Map)userRoleList.get(i);
					Integer roleId=MapUtils.getInteger(userrole, "roleId");
					//拼接权限串
					GrantedAuthorityImpl authority = new GrantedAuthorityImpl("ROLE_"+roleId);
					auths.add(authority);
					roleIds[i]=roleId;
					log.info("【账户登录】 拥有权限"+authority.getAuthority());
				}
				sysUser.setRoleIds(roleIds);
			}
			return auths;
	}
	
	/**
	 *根据用户名查询并加载用户信息及权限
	 *
	 */
	public List<SysMenubar> loadUserMenubars(SysUser sysUser) {
		Query  query =new Query();
		query.append("roleIds", sysUser.getRoleIds());
		query.append("status", DefaultStatus.Yes.getValue());
		List<SysMenubar> menuList =sysMenuBarDAO.queryList("SysMenubar.loadUserMenubars",query);
		return menuList;
	}	
	
	 
	
	/**
	 *  检测是否是不要安全验证的
	 */
	public boolean decideFilterAuthorities(String url) {
		if (filterAuthorities==null||filterAuthorities.size()<1) {
			loadSysFilterAuthorities();
		}
		if (filterAuthorities==null||filterAuthorities.size()<1) {
			return false;
		}
		for (int i = 0; i <filterAuthorities.size(); i++) {
			String filterAuthoritie=filterAuthorities.get(i);
			if (url.indexOf(filterAuthoritie)>-1) {
				return true;
			};
		}
		return false;
	}
	
	/**
	 * 判断当前用户是否存在系统的活跃session当中  存在则允许访问 否则 没权限
	 * @param authentication
	 * @return
	 */
	public boolean decideSession(MyUserDetails curUserDetails) {
		if (curUserDetails==null) {
			return false;
		}
		List sessionList=sessionRegistry.getAllPrincipals();
		for (Object principal : sessionList) {
			MyUserDetails sessionUserDetails=(MyUserDetails)principal;
			 if (sessionUserDetails.getUsername().equals(curUserDetails.getUsername())) {
				 return true;
			}
		}
		return false;
	}	
	
	/**
	 * 判断当前用户是否存在系统的活跃session当中  存在则允许访问 否则 没权限
	 * @param authentication
	 * @return
	 */
	public boolean decideSession(Authentication authentication) {
		Object obj=authentication.getPrincipal();
		if (obj==null) {
			return false;
		}
		MyUserDetails curUserDetails=(MyUserDetails)authentication.getPrincipal();
		List sessionList=sessionRegistry.getAllPrincipals();
		for (Object principal : sessionList) {
			MyUserDetails sessionUserDetails=(MyUserDetails)principal;
			 if (sessionUserDetails.getUsername().equals(curUserDetails.getUsername())) {
				 return true;
			}
		}
		return false;
	}	
	
	
	
	
	
	
	
	
	
	
	
}

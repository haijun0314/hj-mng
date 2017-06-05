 
package org.jxjz.framework.security;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

/**
 *	实现了UserDetails，扩展几项信息，比如getSubSystem()方法等 sparta 11/4/13。
 */
public class  MyUserDetails implements UserDetails {

	private Integer userid;//账户编号
	private String username;//登录名称
	private String password;//密码
	private String realName;//真实姓名
	private Date   loginTime;//登录时间
	private String isSuper;//是否超级账户【0 是 1 否】
	private String isPredefine;//是否预定义【0是 1 否】
	private String status;//【1开启、0关闭】
	private String sex;//性别
	private String telePhone;//电话
	private String userType;//账户类型 0  系统账户 1  城市管理账户   2  城市普通账户
	
	//实现了UserDetails之后的相关变量
	private Boolean enabled;//
    private  List<GrantedAuthority> authorities;//
    private  boolean accountNonExpired;//
    private  boolean accountNonLocked;//
    private  boolean credentialsNonExpired;//
    
   //其它变量
    private List userMenuBars;	//用户拥有的菜单按钮用户登录后SecurityService.loadUserByUsername加载
    private List userPortlets;	//用户拥有的门户组件
    private String theme;		//页面风格
    private String[] roles;		//用户所属角色 用户登录后SecurityService.loadUserMenubars加载
    private List roleSystem;	//用户所属角色 用户登录后SecurityService.loadUserMenubars加载
    private List topMenus;		//用户所属角色 用户登录后SecurityService.loadUserMenubars加载
    private String authority;	//权限串  sys_menubar表的RESOURCEID来标记
	private String isAgentAdmin;//是否是城市管理员
	private Integer agentId;//代理商编号
	
	public String getIsAgentAdmin() {
		return isAgentAdmin;
	}

	public void setIsAgentAdmin(String isAgentAdmin) {
		this.isAgentAdmin = isAgentAdmin;
	}

	public Integer getAgentId() {
		return agentId;
	}

	public void setAgentId(Integer agentId) {
		this.agentId = agentId;
	}

	/**
	 * 获取登录用户信息
	 */
	public static MyUserDetails userDetails=null;
	public static MyUserDetails getCurUserDetails() {
		if (userDetails!=null) {
			//return userDetails;
		}
		Object o=SecurityContextHolder .getContext().getAuthentication().getPrincipal();
		if (o==null||o.equals("anonymousUser")) {
			return null;
		}else{
			userDetails = (MyUserDetails) SecurityContextHolder .getContext().getAuthentication().getPrincipal();
		}
		return userDetails;
	}	
	
	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}
	 

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

	public MyUserDetails() {
		
	}

	public boolean equals(Object rhs) {
		if (!(rhs instanceof MyUserDetails) || (rhs == null)) {
		return false;
		}
		MyUserDetails user = (MyUserDetails) rhs;
		if (!this.getPassword().equals(user.getPassword())) {
			return false;
		}
		if (!this.getUsername().equals(user.getUsername())) {
			return false;
		}
		return true;
		}
	  
	public int hashCode() {
		int code = 9792;
		if (this.getPassword() != null) {
		code = code * (this.getPassword().hashCode() % 7);
		}
		if (this.getUserid() != null) {
		code = code * (this.getUserid().hashCode() % 7);
		}
		return code;
		}

	public Integer getUserid() {
		return this.userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	 
	 

	 
	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public Date getLoginTime() {
		return loginTime;
	}

	public void setLoginTime(Date loginTime) {
		this.loginTime = loginTime;
	}

	public String getIsSuper() {
		return isSuper;
	}

	public void setIsSuper(String isSuper) {
		this.isSuper = isSuper;
	}

	public String getIsPredefine() {
		return isPredefine;
	}

	public void setIsPredefine(String isPredefine) {
		this.isPredefine = isPredefine;
	}

	public String getTelePhone() {
		return telePhone;
	}

	public void setTelePhone(String telePhone) {
		this.telePhone = telePhone;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	 


	public void setAuthorities(List<GrantedAuthority> auths) {
		this.authorities = auths;
	}

	public void setAccountNonExpired(boolean accountNonExpired) {
		this.accountNonExpired = accountNonExpired;
	}

	public void setAccountNonLocked(boolean accountNonLocked) {
		this.accountNonLocked = accountNonLocked;
	}

	public void setCredentialsNonExpired(boolean credentialsNonExpired) {
		this.credentialsNonExpired = credentialsNonExpired;
	}
	
	
	
	
	
	public Collection<GrantedAuthority> getAuthorities() {
		return authorities;
	}

	public boolean isAccountNonExpired() {
		return accountNonExpired;
	}

	public boolean isAccountNonLocked() {
		return this.accountNonLocked;
	}

	public boolean isCredentialsNonExpired() {
		 return credentialsNonExpired;
	}

	public boolean isEnabled() {
		return enabled;
	}

	 
	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public List getUserMenuBars() {
		return userMenuBars;
	}

	public void setUserMenuBars(List userMenuBars) {
		this.userMenuBars = userMenuBars;
	}

	public List getUserPortlets() {
		return userPortlets;
	}

	public void setUserPortlets(List userPortlets) {
		this.userPortlets = userPortlets;
	}

	public String getTheme() {
		return theme;
	}

	public void setTheme(String theme) {
		this.theme = theme;
	}

	public static MyUserDetails getUserDetails() {
		return userDetails;
	}

	public static void setUserDetails(MyUserDetails userDetails) {
		MyUserDetails.userDetails = userDetails;
	}

	public String[] getRoles() {
		return roles;
	}

	public void setRoles(String[] roles) {
		this.roles = roles;
	}

	public List getRoleSystem() {
		return roleSystem;
	}

	public void setRoleSystem(List roleSystem) {
		this.roleSystem = roleSystem;
	}

	public List getTopMenus() {
		return topMenus;
	}

	public void setTopMenus(List topMenus) {
		this.topMenus = topMenus;
	}

 

}


package org.jxjz.framework.security;


import javax.annotation.Resource;

import org.springframework.dao.DataAccessException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


/**
 * 账户登录 该类的主要作用是为Spring Security提供一个经过用户认证后的UserDetails。
 *该UserDetails包括用户名、密码、是否可用、是否过期等信息。
 */
@Service
public class MyUserDetailsService implements UserDetailsService {
	
	@Resource SecurityService securityService;
	@Override
	/**
	 * 账户登录
	 */
	public UserDetails loadUserByUsername(String username)throws UsernameNotFoundException, DataAccessException {
		return securityService.loadUserByUsername(username);
	}
	 
		
	 
	
}

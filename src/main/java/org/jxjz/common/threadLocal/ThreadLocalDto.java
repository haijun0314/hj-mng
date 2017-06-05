package org.jxjz.common.threadLocal;

import org.jxjz.framework.security.MyUserDetails;

public class ThreadLocalDto {

	private Class<?> entityClass;
	private MyUserDetails userDetails;
	public Class<?> getEntityClass() {
		return entityClass;
	}
	public void setEntityClass(Class<?> entityClass) {
		this.entityClass = entityClass;
	}
	public MyUserDetails getUserDetails() {
		return userDetails;
	}
	public void setUserDetails(MyUserDetails userDetails) {
		this.userDetails = userDetails;
	}
	
	
	
	
}

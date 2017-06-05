package org.jxjz.common.threadLocal;

import org.jxjz.framework.security.MyUserDetails;


public class ThreadLocalManager {
    private static final ThreadLocal<ThreadLocalDto> th = new ThreadLocal<ThreadLocalDto>();  
    
    public static void setEntityClazz(Class clazz){
    	ThreadLocalDto dto = th.get();
    	if(dto == null){
    		dto = new ThreadLocalDto();
    		th.set(dto);
    	}
    	dto.setEntityClass(clazz);
    }
    
    public static Class getEntityClazz(){
    	Class clazz = null;
    	ThreadLocalDto dto = th.get();
    	if(dto != null){
    		clazz = dto.getEntityClass();
    	}
    	return clazz; 
    }
    
    //设置当前的session
    public static void SetUserSession(MyUserDetails userDetails){
    	ThreadLocalDto dto = th.get();
    	if(dto == null){
    		dto = new ThreadLocalDto();
    		th.set(dto);
    	}
    	dto.setUserDetails(userDetails);
    }
    
    /**
     * 获得当前session
     * @return
     */
    public static MyUserDetails getUserSession(){
    	MyUserDetails userDetails = null;
    	ThreadLocalDto dto = th.get();
    	if(dto != null){
    		userDetails = dto.getUserDetails();
    	}
    	return userDetails;
    }    
	
}

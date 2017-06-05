package org.jxjz.framework.filter;
import javax.servlet.http.HttpSessionEvent;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.session.HttpSessionEventPublisher;

/**
 * 统计在心用户【目前没用到  已经在sessionRegistry 实现】
 */
public class EnhancedHttpSessionEventPublisher extends	HttpSessionEventPublisher {
	 @Override    
	    public void sessionCreated(HttpSessionEvent event) {    
	        
	        saveOrDeleteOnlineUser(event, Type.SAVE);    
	        super.sessionCreated(event);    
	    }    
	    
	    @Override    
	    public void sessionDestroyed(HttpSessionEvent event) {    
	         
	        saveOrDeleteOnlineUser(event, Type.DELETE);    
	        super.sessionDestroyed(event);    
	    }    
	    
	    public void saveOrDeleteOnlineUser(HttpSessionEvent event, Type type) {    
	        Authentication auth = SecurityContextHolder.getContext().getAuthentication();    
	        if (auth != null) {    
	            Object principal = auth.getPrincipal();    
	            if (principal instanceof User) {    
	                User user = (User) principal;    
	                switch (type) {    
	                case SAVE:    
//	                    OnlineUserList.add(user.getId);//List<String>   
	                    break;    
	                case DELETE:    
//	                    OnlineUserList.remove(user.getId);  
	                    break;    
	                }    
	            }    
	        }    
	    }    
	    
	      
	    private static enum Type {    
	        SAVE, DELETE;    
	    }    
}

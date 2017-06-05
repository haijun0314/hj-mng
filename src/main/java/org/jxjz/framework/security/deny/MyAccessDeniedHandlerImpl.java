package org.jxjz.framework.security.deny;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.WebAttributes;
import org.springframework.security.web.access.AccessDeniedHandler;

public class MyAccessDeniedHandlerImpl  implements AccessDeniedHandler  {
	 private String accessDeniedUrl;  
	public MyAccessDeniedHandlerImpl()  
    {  
    }  

   
    public void handle(HttpServletRequest request,  HttpServletResponse response, AccessDeniedException accessDeniedException) throws ServletException,  IOException {  
        boolean isAjax = "XMLHttpRequest".equals(request.getHeader("X-Requested-With"));  
        //如果是ajax请求  
        if (isAjax) {      
            PrintWriter out = response.getWriter();  
            response.setContentType("text/html; charset=UTF-8"); //转码
            out.flush();
            out.println("<script>");
            out.println("bootbox.alert('您没有操作此功能的权限！请找管理员索要权限');");
            out.println("</script>");
            return;  
        }else {  
        	/*spring mvc  代码*/
        	 if (StringUtils.isNotBlank(accessDeniedUrl)) {
                 request.setAttribute(WebAttributes.ACCESS_DENIED_403, accessDeniedException);
                 response.setStatus(HttpServletResponse.SC_FORBIDDEN);
                 RequestDispatcher dispatcher = request.getRequestDispatcher(accessDeniedUrl);
                 dispatcher.forward(request, response);
             } else {
                 response.sendError(HttpServletResponse.SC_FORBIDDEN, accessDeniedException.getMessage());
             }
         //自己代码
         // String path = request.getContextPath();  
         //String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";  
         // response.sendRedirect(basePath+accessDeniedUrl);  
        }  
    }
    public String getAccessDeniedUrl() {  
        return accessDeniedUrl;  
    }  
    public void setAccessDeniedUrl(String accessDeniedUrl) {  
        this.accessDeniedUrl = accessDeniedUrl;  
    }  
  
	public MyAccessDeniedHandlerImpl(String accessDeniedUrl)  
	{  
	    this.accessDeniedUrl=accessDeniedUrl;  
	}        
}

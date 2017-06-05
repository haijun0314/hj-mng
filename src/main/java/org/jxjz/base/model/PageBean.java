package org.jxjz.base.model;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
public class PageBean {
	
	public static PageModel getPageInfo(HttpServletRequest request,PageModel pm){
			String pageNum=request.getParameter("page");
			String numPerPage=request.getParameter("rows");
		    if(StringUtils.isBlank(pageNum)){
		    	pageNum="1";
		    }
		    if(StringUtils.isBlank(numPerPage)){
		    	numPerPage="10";
		    }
		    int page=Integer.parseInt(pageNum);
		    
			Integer rp=pm.getPageSize();
			if(rp==null){
				rp=Integer.parseInt(numPerPage);
			}
			 
			String qtype = request.getParameter("qtype"); 
			String query=request.getParameter("query");
		    String orderField = request.getParameter("sort"); //�����ֶ�
		    String orderDirection = request.getParameter("order");//������
		    String  sortby=null;
		    if( StringUtils.isNotBlank(orderDirection) && StringUtils.isNotBlank(orderField)){
		    	sortby=orderField+" "+orderDirection;
		    }
		    if(StringUtils.isBlank(query)){
		    	query=null;
		    }
		    int start=(page-1)*rp;
			int end=start+rp-1;
			pm.setStartRow(start);
			pm.setEndRow(end);
			pm.setCurPage(page);
			pm.setPageSize(rp);
			pm.setQtype(qtype);
			pm.setQuery(query);
			pm.setSortby(sortby);
			return pm;
	}
	public static void setPageInfo(HttpServletRequest request,PageModel pm){
	    String pageNum=request.getParameter("pageNum");
	    String numPerPage=request.getParameter("numPerPage");
	    if(StringUtils.isBlank(pageNum)){
	    	pageNum="1";
	    }
	    if(StringUtils.isBlank(numPerPage)){
	    	numPerPage="30";
	    }
	    int page=Integer.parseInt(pageNum);
		int rp=Integer.parseInt(numPerPage);
		String qtype = request.getParameter("qtype"); 
		String query=request.getParameter("query");
	    String orderField = request.getParameter("orderField"); //�����ֶ�
	    String orderDirection = request.getParameter("orderDirection");//������
	    String  sortby=null;
	    if( StringUtils.isNotBlank(orderDirection) && StringUtils.isNotBlank(orderField)){
	    	sortby=orderField+" "+orderDirection;
	    }
	    if(StringUtils.isBlank(query)){
	    	query=null;
	    }
	    int start=(page-1)*rp;
		int end=start+rp-1;
		pm.setStartRow(start);
		pm.setEndRow(end);
		pm.setCurPage(page);
		pm.setPageSize(rp);
		pm.setQtype(qtype);
		pm.setQuery(query);
		pm.setSortby(sortby);
}
}

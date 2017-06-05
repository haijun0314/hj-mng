package com.jyw.service;
import org.jxjz.base.model.PageModel;
public interface ClientLogService {
	
	//分页查询记录日志
	public PageModel getClientLogPageList (PageModel pm);
	
}

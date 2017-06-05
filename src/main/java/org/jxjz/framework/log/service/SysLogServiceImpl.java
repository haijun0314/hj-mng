package org.jxjz.framework.log.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.jxjz.base.model.PageModel;
import org.jxjz.framework.log.dao.SysLogDAO;
import org.jxjz.framework.pojo.SysLog;
import org.jxjz.framework.sysmanage.dao.SysUserDAO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 系统管理--日志管理
 * @author lihaijun
 */
@Service("sysLogService")
@Transactional
public class SysLogServiceImpl implements SysLogService {
	public Logger log = Logger.getLogger("hg");	
	@Resource SysLogDAO sysLogDAO;
	private List logList=new ArrayList();
	@Resource SysUserDAO sysUserDAO;
	/**
	 * 数据导出
	 */
	public List getExpData(PageModel pm){
		return sysLogDAO.queryExpList(pm);
	}	
	
	/**
	 * 增加系统日志到缓存
	 */
	public void addCacheLog(SysLog syslog){
		this.logList.add(syslog);
	}	
	/**
	 * 将缓存日志输入持久化到数据库
	 */
	public void persistenceCacheLog(){
		if (logList==null||logList.size()<1)return;
		for (int i = 0; i < logList.size(); i++) {
			SysLog syslog=(SysLog)logList.get(i);
			log.info("添加系统操作日志"+syslog.getLogMessage());
			sysLogDAO.saveNoSession(syslog);
		}
		logList.clear();
	}
	/**
	 * 分页查询系统管角色
	 */
	public PageModel getSysLogPageList(PageModel pm) {
		return sysLogDAO.getSysLogPageList(pm);
	}


	/**
	 * 根据id查询日志信息
	 */
	public SysLog getSysLogById(Integer logId) {
		
		return (SysLog) sysLogDAO.getObjById(logId);
	}
}

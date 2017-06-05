package com.jyw.service.impl;
import javax.annotation.Resource;
import org.jxjz.base.model.PageModel;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.jyw.dao.ClientLogDAO;
import com.jyw.service.ClientLogService;
/**
 * 记录日志
 * @author chenjin
 * createTime:2014-12-20
 */
@Service
@Transactional
public class ClientLogServiceImpl implements ClientLogService {
	
	@Resource ClientLogDAO clientLogDAO;
	
	/**
	 * 分页查询日志记录
	 */
	public PageModel getClientLogPageList(PageModel pm) {
		
		return clientLogDAO.queryPageList(pm);
	}

}

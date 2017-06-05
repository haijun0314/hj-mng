package org.jxjz.base.mybatis;

import java.io.Serializable;

import org.apache.commons.beanutils.BeanUtils;
import org.jxjz.framework.util.LogUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service
@Transactional 
public class BaseService<T, ID extends Serializable>  {
	
	public  void errorMsg(Exception e) {
		 LogUtil.getLogger().error("发生系统异常错误。。。错误信息"+e.getMessage());
		 LogUtil.getLogger().error("发生系统异常错误。。。错误信息"+e.getStackTrace());
	}

	public boolean copyProperties	(Object target,Object original){
		try {
			BeanUtils.copyProperties(target,original);
		} catch (Exception e) {
			errorMsg(e);
			return  false;	
		} 
		return  true;
	}
	
	 
	  
	 
}

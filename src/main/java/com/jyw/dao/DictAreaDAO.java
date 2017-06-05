package com.jyw.dao;

import java.util.List;

import org.jxjz.base.model.PageModel;
import org.jxjz.base.mybatis.BaseIbatisDAO;
import org.jxjz.base.mybatis.Query;
import org.springframework.stereotype.Repository;

import com.jyw.entity.DictArea;
@Repository
public class DictAreaDAO extends BaseIbatisDAO{
	
	/**
	 * 分页查询区域
	 */
	public PageModel getDictAreaPageList(PageModel pm){
		pm= queryPageList(pm);
		return  pm;
	}
	
	 
	@Override
	public Class getEntityClass()
	{
		return DictArea.class;
		
	}
	

}

package com.jyw.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.jxjz.base.model.PageModel;
import org.jxjz.base.mybatis.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jyw.dao.DictAreaDAO;
import com.jyw.dao.DictOpenCityDAO;
import com.jyw.entity.DictOpenCity;
import com.jyw.service.DictAreaService;

/**
 * 区域管理
 * @author libin
 * createTime   2014-11-25
 */

@Service
@Transactional
public class DictAreaServiceImpl implements DictAreaService{
	
	@Resource DictAreaDAO dictAreaDAO;
	@Resource DictOpenCityDAO dictOpenCityDAO;	
	/**
	 * 分页查询
	 * @author libin
	 * createTime   2014-11-25
	 */
	@Override
	public PageModel getDictAreaPageList(PageModel pm) {
		return dictAreaDAO.getDictAreaPageList(pm);
	}
	/**
	 * 通用查询
	 * author libin
	 * createTime   2014-11-25
	 */
	public List  getAreaList(Query query) {
		return dictAreaDAO.queryList(query);
		
	}
	/**
	 * 查询开发区域
	 * author libin
	 * createTime   2014-11-27
	 */
	@Override
	public List getDictOpenCityList(Query query) {
		return dictOpenCityDAO.queryList(query);
	}
	/**
	 * 更改状态
	 * author libin
	 * createTime   2014-12-29
	 */
	public void updateStarOrStop(DictOpenCity dictOpenCity) {
		dictOpenCityDAO.updateById(dictOpenCity);
		
	}
}

package com.jyw.service;

import java.util.List;

import org.jxjz.base.model.PageModel;
import org.jxjz.base.mybatis.Query;
import org.jxjz.framework.pojo.SysUser;

import com.jyw.entity.DictOpenCity;
/**
 * 区域管理
 * author libin
 * createTime   2014-11-25
 */
public interface DictAreaService {
	 
	//分页查询区域
	public PageModel getDictAreaPageList(PageModel pm);
	//通用查询
	public List  getAreaList(Query query)  ;
	//查询开放区域 
	public List getDictOpenCityList(Query query);
	//更改状态
	public void updateStarOrStop(DictOpenCity dictOpenCity);
	
}

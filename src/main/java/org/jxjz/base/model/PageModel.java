package org.jxjz.base.model;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jxjz.common.util.beans.Conversion;
public class PageModel<T> {
	private Integer totalRows;
	private Integer totalPage;
	private Integer curPage;
	private Integer startRow;
	private Integer endRow;
	private Integer curRow;

	private Integer pageSize;
	private String qtype;
	private String query;
	private String sortby;
	private String orderField;
	private String orderDirection;
	private String queryStr;
	private List datas;
	private Map<String, Object> params = new HashMap<String, Object>();
	
	public Map<String, Object> getParams() {
		return params;
	}
	public void setParams(Map<String, Object> params) {
		this.params = params;
	}	
	/**
	 * 将对象加入查询参数内
	 * @param bean 查询对象
	 */
	public void PutParams(T bean){
		try {
			if(bean == null){
				return;
			}
			params = Conversion.conversionToMapExcludeEmpty(bean);
			
		} catch (Exception e) {
		}
	}

	/**
	 * 单条加入查询条件
	 * @param key 字段名称
	 * @param value 值
	 * @return 查询条件
	 */
	public void append(String key, Object value) {
		params.put(key, value);
		 
	}	
	
	public Integer getCurRow() {
		return curRow;
	}
	public void setCurRow(Integer curRow) {
		this.curRow = curRow;
	}	
	
	public Integer getTotalRows() {
		return totalRows;
	}
	public void setTotalRows(Integer totalRows) {
		this.totalRows = totalRows;
	}
	public Integer getCurPage() {
		return curPage;
	}
	public void setCurPage(Integer curPage) {
		this.curPage = curPage;
	}
	public Integer getStartRow() {
		return startRow;
	}
	public void setStartRow(Integer startRow) {
		this.startRow = startRow;
	}
	public Integer getEndRow() {
		return endRow;
	}
	public void setEndRow(Integer endRow) {
		this.endRow = endRow;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public List getDatas() {
		return datas;
	}
	public void setDatas(List datas) {
		this.datas = datas;
	}
	public String getQtype() {
		return qtype;
	}
	public void setQtype(String qtype) {
		this.qtype = qtype;
	}
	public String getQuery() {
		return query;
	}
	public void setQuery(String query) {
		this.query = query;
	}
	public String getSortby() {
		return sortby;
	}
	public void setSortby(String sortby) {
		this.sortby = sortby;
	}
	public String getQueryStr() {
		return queryStr;
	}
	public void setQueryStr(String queryStr) {
		this.queryStr = queryStr;
	}
	public Integer getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}
	public String getOrderField() {
		return orderField;
	}
	public void setOrderField(String orderField) {
		this.orderField = orderField;
	}
	public String getOrderDirection() {
		return orderDirection;
	}
	public void setOrderDirection(String orderDirection) {
		this.orderDirection = orderDirection;
	}




}

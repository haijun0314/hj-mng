package org.jxjz.framework.enums;


/**
 *页面跳转类型【1 请求数据[执行方法 比如更新update]  0 跳转页面【比如跳转分页layout页面或者添加数据页面】  2 Ajax 请求数据】
 * @author  lihaijun
 * 2016-11-28
 */
public enum ActionType implements IHasValueEnum{
	Page("0"),Data("1"),Ajax("2");
	private String value;
	private ActionType(String value){
		this.value = value;
	}
	
	public String getName() {
		 
		return null;
	}

	public String getValue() {
		return this.value;
	}

}

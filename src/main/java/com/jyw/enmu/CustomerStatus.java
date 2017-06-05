package com.jyw.enmu;

import org.jxjz.framework.enums.IHasValueEnum;
/**
 * 状态枚举
 * @author chenjin
 *createTime:2014-12-5
 *账号状态 1.正常 2.暂停
 */

public enum CustomerStatus implements IHasValueEnum{
	
	 	normal("0"),stop("1");

		private String value;
		private CustomerStatus(String value){
			this.value = value;
		}
		
		/**
		 * 得到名字
		 */
		public String getName() {
			switch (this) {
			case normal:
				return "正常";
			case stop:
				return "暂停";
			default:
				break;
			}
			return null;
		}

		/**
		 * 取值
		 */
		public String getValue() {
			
			return this.value;
		}
}

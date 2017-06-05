package org.jxjz.framework.enums;
/**
 * 设置  账户类型
 * @author  liubin
 * 账户类型 0  系统账户 1  城市管理账户   2  城市普通账户义
 * 2015-2-7
 */
public enum UserType implements IHasValueEnum{
	SystemUser("0"),AgentAdminUser("1"),AgentUser("2");
	private String value;
	private UserType(String value){
		this.value = value;
	}
	
	public String getName() {
		switch (this) {
		case SystemUser:
			return "系统账户";
		case AgentAdminUser:
			return "城市管理账户";
		case AgentUser:
			return "城市普通账户";
		default:
			break;
		}
		return null;
	}

	public String getValue() {
		return this.value;
	}
}

package org.jxjz.framework.pojo;


/**
 * SysLog entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class SysError implements java.io.Serializable {


	private String errorcode;
	
	private String errordesc;

	public String getErrorcode() {
		return errorcode;
	}

	public void setErrorcode(String errorcode) {
		this.errorcode = errorcode;
	}

	public String getErrordesc() {
		return errordesc;
	}

	public void setErrordesc(String errordesc) {
		this.errordesc = errordesc;
	}
	

}
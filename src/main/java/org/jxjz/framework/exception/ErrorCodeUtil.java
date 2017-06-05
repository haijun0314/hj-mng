package org.jxjz.framework.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;
@Service
public class ErrorCodeUtil
{
	/**
	 * 代码说明:起始数字
	 * 9：系统错误
	 * 1、系统操作
	 * 5：公司、代理商  错误
	 */
	private static Map<String,String>  codeMap=new HashMap<String, String>();
	public static String success="0000";//通用成功
	public static String error="1111"; //操作失败
	public static String doing="2222"; //任务处理中
	public static String e_9999="9999";//参数错误
	public static String e_9998="9998";//更新数据出错
	public static String e_9997="9997";//插入数据出错
	public static String e_9996="9996";//查询数据出错
	public static String e_9995="9995";//删除数据出错
	public static String e_9994="9994";//数据重复
	public static String e_9993="9993";//文件上传失败
	
	
	public static String e_1101="1101";
	public static String e_1102="1102";
	public static String e_1103="1103";
	public static String e_1104="1104";
	public static String e_1105="1105";//账户登录错误  账户密码错误
	
	public static String e_1201="1201";
	public static String e_1202="1202";
	
	public static String e_1301="1301";
	 
	public static void initCode(){
		codeMap.put("0000", "操作成功");
		codeMap.put("1111", "操作失败");
		codeMap.put("2222", "任务处理中");
		codeMap.put("9999", "参数错误");
		codeMap.put("9998", "更新数据出错");
		codeMap.put("9997", "插入数据出错");
		codeMap.put("9996", "查询数据出错");
		codeMap.put("9995", "删除数据出错");
		codeMap.put("9994", "数据重复");
		codeMap.put("9993", "文件上传失败");
		
		//11系统用户  12角色  13权限 
		
		codeMap.put("1101", "原密码不正确！");
		codeMap.put("1102", "对不起 该用户名已经存在 请用其他用户名！");
		codeMap.put("1103", "该登陆名称不可以使用");
		codeMap.put("1104", "该登陆名称可以使用");
		codeMap.put("1105", "账户或密码错误");
		
		
		codeMap.put("1201", "该角色名称不可以使用");
		codeMap.put("1202", "该角色名称可以使用");
		codeMap.put("1301", "对不起！该权限已经被使用 删除失败！");
		 
	}
	
	
	public static String getCodeMsg(String code) {
		if (codeMap==null||codeMap.isEmpty()) {
			initCode();
		}
		return codeMap.get(code);
	}	 
	
}

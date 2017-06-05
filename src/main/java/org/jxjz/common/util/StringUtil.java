package org.jxjz.common.util;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;
	
public class StringUtil {
      
	public static String   createId(String prefix) {
		if (StringUtils.isNotBlank(prefix)) {
			return prefix+TimeUtil.getDateYMDHMS()+StringUtil.getRandNum(15);
		}
		return TimeUtil.getDateYMDHMS()+StringUtil.getRandNum(15);
	}	
	
	
	/**
	 * getStringSplit
	 * 分解字符串
	 * String str 被分解的字符串
	 * String type 分解类型 当传入","时就按逗号分解
	 */
	public static String[] getStringSplit(String str,String type){
		String[] getString =str.split(type);
		return getString;
		
	}
	/**
	 * getStringTokenizer
	 * 分解字符串
	 * String str 被分解的字符串
	 * String type 分解类型 当传入","时就按逗号分解
	 */
	public static String[] getStringTokenizer(String str,String type){
		StringTokenizer commaToker = new StringTokenizer(str, type);
		String[] result = new String[commaToker.countTokens()];
		int k=0;
		  while (commaToker.hasMoreTokens()) {
		   result[k] = commaToker.nextToken();
		  k++;
		  }
		return result;
	}
	/**
	 * getStringSplit
	 * 分解字符串 字符串转化为List列表
	 * String str 被分解的字符串
	 * String type 分解类型 当传入","时就按逗号分解
	 */
	public static List stringToList(String str,String type){
		List<String> list=CollectUtil.newArrayList();
		if(str!=null&&str.length()>0){
			String[] getString =str.split(type);
			for(int k=0;k<getString.length;k++){
				list.add(getString[k]);
			}
		}
		return list;
	}
	/**
	 * 去除字符串中重复的子串，按照type分割
	 * @param keys
	 * @return
	 */
	 public static String keepSeqUnique(String keys,String type)
	  {
	    String[] keysArray = StringUtils.split(keys, type);
	    List keyList = CollectUtil.newArrayList();
	    for (int i = 0; i < keysArray.length; i++) {
	      if (!keyList.contains(keysArray[i])) {
	        keyList.add(keysArray[i]);
	      }
	    }
	    StringBuilder keyBuf = new StringBuilder();
	    for (Iterator iter = keyList.iterator(); iter.hasNext(); ) {
	      keyBuf.append((String)iter.next());
	      if (iter.hasNext()) {
	        keyBuf.append(type);
	      }
	    }
	    return keyBuf.toString();
	  }
	/**
	 * listToString
	 * 将List集合转化为字符串
	 * List list 被分解的字符串
	 * String type 转化为以type分割的字符串
	 */
	public static String  listToString(List list,String type){
		String str="";
		if(list!=null&&list.size()>0){
			Iterator it=list.iterator();
			for(int j=0;j<list.size();j++){
				String s=(String)it.next();
				if(j==list.size()-1){
					str+=s;//组成商品相册字符串
				}else{
					str+=s+type;//组成商品相册字符串
				}
			}
		}
		return str;
		
	}
	/**
	 * String[]to Integer[]
	 * 将String数组转化为integer数组
	 * String str 被转化字符串数组
	 * Integer[] toInt 转化为Integer的数组
	 */
	public static Integer[]  StringArrayToIntegerArray(String[] str){
		Integer[] toInt=null;
		if(str!=null&&str.length>0){
			toInt=new Integer[str.length];
			for(int i=0;i<str.length;i++){
				toInt[i]=Integer.valueOf(str[i]);
			}
		}
		return toInt;
	}
	/**
	 * String[]to String
	 * 将String数组转化为integer数组
	 * String str 被转化字符串数组
	 * Integer[] toInt 转化为Integer的数组
	 */
	public static String  StringArrayToString(String[] str,String type){
		String result="";
		if(str!=null&&str.length>0){
			for(int i=0;i<str.length;i++){
				if(i==str.length-1){
					result+=str[i];//组成字符串
				}else{
					result+=str[i]+type;//组成字符串
				}
			}
		}
		return result;
	}
	/**
	 * 判断是不是数字字符串
	 * @param str
	 * @return
	 */
	public static boolean isNumeric(String str){
		for (int i = 0; i < str.length(); i++){
		   if (!Character.isDigit(str.charAt(i))){
		    return false;
		   }
		}
		return true;
		}

	public static String replace(String strSource, String strFrom, String strTo) {   
	    if (strSource == null) {       
	      return null;   
	    } 
	    int i = 0;
	    if ((i = strSource.indexOf(strFrom, i)) >= 0) {
	      char[] cSrc = strSource.toCharArray();
	      char[] cTo = strTo.toCharArray();
	      int len = strFrom.length(); 
	      StringBuffer buf = new StringBuffer(cSrc.length); 
	      buf.append(cSrc, 0, i).append(cTo);
	      i += len;   
	      int j = i;      
	      while ((i = strSource.indexOf(strFrom, i)) > 0) { 
	        buf.append(cSrc, j, i - j).append(cTo);  
	        i += len; 
	        j = i;       
	      }       
	      buf.append(cSrc, j, cSrc.length - j);
	      return buf.toString();
	    }
	    return strSource;
	  } 	
	
	
	
	/**
	 *  隐藏部分信息
	 * @param cardNO 原始证件号
	 * @param cardLength 返回长度  为0时候全返回
	 * 规则 卡号的前6后四显示
	 * 
	 */
	public static String hideSomeChar(String cardNO,Integer before_length,Integer after_length) {
		String resultStr="";
		if (before_length==null) {
			before_length=6;
		}
		if (after_length==null) {
			after_length=4;
		}
		if (StringUtils.isBlank(cardNO)) {
			return "";
		}
		String b_=StringUtils.substring(cardNO,0, before_length);
		String a_=StringUtils.substring(cardNO,  cardNO.length()-after_length,cardNO.length());
		resultStr=b_+"******"+a_;
		return resultStr;
	}	

	
	/**
	 * 字符串头补字符
	 * 
	 * @param source 源字符串
	 * @param length 总长度
	 * @param flag 字符
	 * @return length长度的字符串
	 */
	public static String appendFlagToStringHead(String source, int length, String flag) {

		if (source == null) {
			return null;
		} else if (source.length() > length || length < 1) {
			return source;
		}
		while (source.length() < length) {
			source = flag + source;
		}
		return source;
	}
	
	/**
	 * 字符串尾补字符
	 * 
	 * @param source 源字符串
	 * @param length 总长度
	 * @param flag 字符
	 * @return length长度的字符串
	 */
	public static String appendFlagToStringEnd(String source, int length, String flag) {

		if (source == null) {
			return null;
		} else if (source.length() > length || length < 1) {
			return source;
		}

		while (source.length() < length) {
			source = source + flag;
		}

		return source;
	}
	/**
	 * 
	 * @param email
	 * @return
	 */
	public static boolean emailFormat(String email)
    {
		if (StringUtils.isBlank(email)) {
			return false;
		}
        boolean tag = true;
        final String pattern1 = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
        final Pattern pattern = Pattern.compile(pattern1);
        final Matcher mat = pattern.matcher(email);
        if (!mat.find()) {
            tag = false;
        }
        return tag;
    }

	/**
	 * @param str
	 * @return
	 */
	public static boolean isNull(String str) {
		if (str == null)
			return true;
		return false;
	}

	/**
	 * @param str
	 * @return
	 */
	public static boolean isEmpty(String str) {
		if (str == null || "".equals(str))
			return true;
		return false;
	}

	/**
	 * @param str
	 * @return
	 */
	public static boolean isEmptyOr0(String str) {
		return "0".equals(str) || isEmpty(str);
	}

	/**
	 * @param str
	 * @return
	 */
	public static boolean isEmptyOrNullStr(Object str) {
		return str == null || "".equals(str) || "null".equalsIgnoreCase(str.toString());
	}
	
	/**
	 * @param str
	 * @return
	 */
	public static boolean isAccountType(String str) {
		return "1".equals(str) || "2".equals(str) || "3".equals(str);
	}

	/**
	 * 
	 * @param str
	 * @return
	 */
	public static boolean checkCertType(String str) {
		return "1".equals(str) || "2".equals(str) || "3".equals(str);
	}
	
	/**
	 * 
	 * @param str
	 * @return
	 */
	public static boolean checkCustType(String str) {
		return "1".equals(str) || "3".equals(str);
	}
	
	/**
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isNotNull(String str) {
		return !isNull(str);
	}

	/**
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isNotEmpty(String str) {
		return !isEmpty(str);
	}

	 

	 

	/**
	 */
	public static String getNumbers(int length) {
		length = valLength(length);
		String rtnStr = "";
		String tempStr = null;
		for (int i = 0; i < length; i++) {
			tempStr = String.valueOf((int) (Math.random() * 10));
			rtnStr = rtnStr + tempStr;
		}
		return rtnStr;
	}

	/**
	 */
	private static int valLength(int length) {
		if (length < 1) {
			return 1;
		} else if (length > 255) {
			return 255;
		} else
			return length;

	}

	/**
	 * @param str
	 * @return
	 */
	public static boolean isCustidentifiertype(String str) {
		return isAccountType(str);
	}

	/**
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isDate(String str) {
		return isDate1(str) || isDate2(str);
	}
	
	/**
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isDate1(String str) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		try {
			if (!sdf.format(sdf.parse(str)).equals(str))
				return false;
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	/**
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isDate2(String str) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			if (!sdf.format(sdf.parse(str)).equals(str))
				return false;
		} catch (Exception e) {
			return false;
		}
		return true;
	}
	
	/**
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isYMD(String str) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			if (!sdf.format(sdf.parse(str)).equals(str))
				return false;
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	/**
	 * 
	 * @param str
	 * @return
	 */
	public static String convertMoney(String str) {
		if (isEmpty(str))
			return "";
		if (str.matches("\\.\\d{1,2}"))
			return new BigDecimal(str).toString();
		return str;
	}

	/**
	 * 
	 * @param str
	 * @return
	 */
	public static String convertMoney2(String str) {
		if (isEmpty(str))
			return "";
		return new BigDecimal(str).setScale(2, BigDecimal.ROUND_HALF_UP).toString();
	}
	
	/**
	 * @param str
	 * @return
	 */
	public static String moneyAdd00(String str) {
		if (isEmpty(str))
			return "0.00";
		if (str.indexOf(".") < 0)
			return str.concat(".00");
		return str;
	}
	
	

	
	/**
	 * 
	 * @param str
	 * @return
	 */
	public static boolean checkOPType(String str) {
		return "1".equals(str) || "2".equals(str);
	}

	/**
	 * 
	 * @param str
	 * @return
	 */
	public static boolean checkSmsVerify(String str) {
		return checkOPType(str);
	}

	/**
	 * 
	 * @param str
	 * @return
	 */
	public static String getYMDHMS(String str) {
		return "to_char(" + str + ", 'yyyy-mm-dd hh24:mi:ss')";
	}

	/**
	 * 
	 * @param str
	 * @return
	 */
	public static String getYMDHM(String str) {
		return "to_char(" + str + ", 'yyyy-mm-dd hh24:mi')";
	}

	/**
	 * 
	 * @param str
	 * @return
	 */
	public static String getYMD(String str) {
		return "to_char(" + str + ", 'yyyy-mm-dd')";
	}
	
	/**
	 * 
	 * @param str
	 * @return
	 */
	public static String getDateYMDHMS(String str) {
		return "to_date(?, 'yyyy-mm-dd hh24:mi:ss')";
	}
	
	/**
	 * 
	 * @param str
	 * @return
	 */
	public static String getAlertFlag(String str) {
		return isEmpty(str) ? "1" : "0";
	}
	
	/**
	 * 
	 * @param str
	 * @return
	 */
	public static boolean checkApporderstatus(String str) {
		if ("0".equals(str) || "1".equals(str)) {
			return true;
		}
		return false;
	}
	
	/**
	 * 
	 * @param str
	 * @return
	 */
	public static boolean checkApporderstatus2(String str) {
		if ("0".equals(str) || "1".equals(str) || "2".equals(str)) {
			return true;
		}
		return false;
	}
	
	/**
	 * 
	 * @param obj
	 * @param length
	 * @return
	 */
	public static boolean isArrayValid(Object[] obj, int length) {
		if (!isArrayEmpty(obj) && obj.length == length) {
			return true;
		}
		return false;
	}
	
	/**
	 * 
	 * @param obj
	 * @return
	 */
	public static boolean isArrayEmpty(Object[] obj) {
		if (obj == null || obj.length == 0) {
			return true;
		}
		return false;
	}
	
	/**
	 * 
	 * @param obj
	 * @return
	 */
	public static boolean isArrayEmptyOr11111(Object[] obj) {
		if (isArrayEmpty(obj) || "11111".equals(obj[0])) {
			return true;
		}
		return false;
	}
	
	/**
	 * 
	 * @param obj
	 * @return
	 */
	public static boolean isNull(Object obj) {
		return obj == null;
	}
	
	/**
	 * 
	 * @param obj
	 * @return
	 */
	public static boolean isEmpty(Object obj) {
		return obj == null || "".equals(obj.toString());
	}
	
	/**
	 * 
	 * @param str
	 * @return
	 */
	public static String null2Empty(Object str) {
		return str == null ? "" : str.toString();
	}
	
	
	public static boolean is0Or1(String str){
		boolean ret 	= false;
		if("0".equals(str) || "1".equals(str)){
			ret = true;
		}
		return ret;
	}	
	
	/**
	 * String[]to String
	 * 返回一定位数的字符串
	 */
	public static String  getSpecialStr(String c,int len){
		String result="";
		for (int i = 0; i < len&&len>0; i++) {
			result=result+c;
		}
		return result;
	}	
	
	/**
	 * 返回一定位数的字符串
	 */
	public static String getRandNum(int num) {
		Random r = new Random(); 
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < num; i++) {
			sb.append(r.nextInt(10)+"");
		}
		return sb.toString();
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		
		 System.out.print("123456".substring("123456".length()-4, "123456".length()));
		}
	
}
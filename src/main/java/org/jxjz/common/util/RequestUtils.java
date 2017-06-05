package org.jxjz.common.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

import javax.servlet.ServletRequest;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.web.util.UrlPathHelper;


public class RequestUtils {
    public static Logger logger = Logger.getLogger(RequestUtils.class);

   
	
	/**
	 * 获取http提交请求参数
	 * @return
	 */
	public static Map getParameters(HttpServletRequest request){
		Map<String, String> hmInput = null;
		String paramName 			= null;
		String paramValue 			= null;
		// 获取接口请求的所有参数名、参数值
		Enumeration enm 			= request.getParameterNames();
		hmInput 					= new HashMap<String, String>();
		while (enm.hasMoreElements()) {
			paramName 				= enm.nextElement().toString();
			paramValue 				= request.getParameter(paramName);
			try{
				paramValue = java.net.URLDecoder.decode(paramValue, "UTF-8");
			}catch(Exception e){
				e.printStackTrace();
			}
			if (StringUtils.isNotBlank(paramValue)) {
				hmInput.put(paramName, paramValue);
			}
		}
		return hmInput;
	}     
    
    
    
    
    
    
    
    
    
    public static Map getParameter(ServletRequest request, String[] paras) {
        HashMap map = new HashMap();
        if ((paras == null) || (paras.length == 0)) {
            return map;
        }
        for (int i = 0; i < paras.length; i++) {
            String para = paras[i];
            if ((para == null) || (para.trim().length() == 0)) {
                continue;
            }
            String value = request.getParameter(para);
            if ((value == null) || (value.trim().length() == 0)) {
                continue;
            } else {
                value = value.trim();
            }
            map.put(para, URLUtil.decodeURL(value));
        }
        return map;
    }

    public static String getParamValue(HttpServletRequest request, String name) {
        if (StringUtils.isBlank(name)) {
            return null;
        }
        if (request.getMethod().equalsIgnoreCase("POST")) {
            return request.getParameter(name);
        }
        String s = request.getQueryString();
        if (StringUtils.isBlank(s)) {
            return null;
        }
        try {
            s = URLDecoder.decode(s, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            logger.error("encoding UTF-8 not support?", e);
        }
        String[] values = (String[]) parseParamStr(s).get(name);
        if ((values != null) && (values.length > 0)) {
            return values[(values.length - 1)];
        }
        return null;
    }

    public static Map<String, String[]> parseParamStr(String s) {
        String[] valArray = null;
        if (s == null) {
            throw new IllegalArgumentException();
        }
        Map ht = new HashMap();
        StringTokenizer st = new StringTokenizer(s, "&");
        while (st.hasMoreTokens()) {
            String pair = st.nextToken();
            int pos = pair.indexOf(61);

            if (pos == -1) {
                continue;
            }
            String key = pair.substring(0, pos);
            String val = pair.substring(pos + 1, pair.length());
            if (ht.containsKey(key)) {
                String[] oldVals = (String[]) (String[]) ht.get(key);
                valArray = new String[oldVals.length + 1];

                for (int i = 0; i < oldVals.length; ++i) {
                    valArray[i] = oldVals[i];
                }

                valArray[oldVals.length] = val;
            } else {
                valArray = new String[1];
                valArray[0] = val;
            }
            ht.put(key, valArray);
        }
        return ht;
    }

    

    public static String getIp(HttpServletRequest request) {
        String ip = request.getHeader("X-Real-IP");

        if ((!(StringUtils.isBlank(ip))) &&
                (!("unknown".equalsIgnoreCase(ip)))) {
            return ip;
        }
        ip = request.getHeader("X-Forwarded-For");
        if ((!(StringUtils.isBlank(ip))) &&
                (!("unknown".equalsIgnoreCase(ip)))) {
            int index = ip.indexOf(44);

            if (index != -1) {
                return ip.substring(0, index);
            }

            return ip;
        }

        return request.getRemoteAddr();
    }

    public static String getLocation(HttpServletRequest request) {
        UrlPathHelper helper = new UrlPathHelper();
        StringBuffer buff = request.getRequestURL();
        String uri = request.getRequestURI();
        String origUri = helper.getOriginatingRequestUri(request);
        buff.replace(buff.length() - uri.length(), buff.length(), origUri);

        String queryString = helper.getOriginatingQueryString(request);

        if (queryString != null) {
            buff.append("?").append(queryString);
        }

        return buff.toString();
    }

    public static String getRequestedSessionId(HttpServletRequest request) {
        String sid = request.getRequestedSessionId();
        String ctx = request.getContextPath();

        if ((request.isRequestedSessionIdFromURL()) ||
                (StringUtils.isBlank(ctx))) {
            return sid;
        }
        Cookie cookie = CookieUtil.getCookie(request, "JSESSIONID");
        if (cookie != null) {
            return cookie.getValue();
        }
        return null;
    }
}

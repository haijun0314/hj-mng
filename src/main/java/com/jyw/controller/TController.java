package com.jyw.controller;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.jxjz.base.spring.BaseAction;
import org.jxjz.common.util.ResponseUtils;
import org.jxjz.framework.jms.JmsSender;
import org.jxjz.framework.util.LogUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
/**
 * 
 */
@Controller  
@RequestMapping("/t") 
public class TController extends BaseAction {
	Logger logger =LogUtil.getLogger();
	@Resource  private JmsSender jmsSender;

    @RequestMapping(params = "jmsSend")
    @ResponseBody
    public void jmsSend(HttpServletResponse response,Model model,HttpServletRequest request) {
    	String   data =request.getParameter("data");
        jmsSender.sendMessage(data);
        ResponseUtils.renderJson(response, "0000");
    }

    
	 
}

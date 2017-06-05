package com.jyw.controller;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.jxjz.base.spring.BaseAction;
import org.jxjz.common.util.MsgUtil;
import org.jxjz.common.util.TimeUtil;
import org.jxjz.framework.enums.LogType;
import org.jxjz.framework.log.SysLogUtil;
import org.jxjz.framework.security.MyUserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.jyw.enmu.CustomerStatus;
import com.jyw.entity.Customer;
import com.jyw.service.CustomerService;
/**
 *  用户管理
 *  @author chenjin
 *	createTime 2014-12-9
 */
@Controller
@RequestMapping("/customer")
public class CustomerController extends BaseAction{ 
	
	
	
	
}

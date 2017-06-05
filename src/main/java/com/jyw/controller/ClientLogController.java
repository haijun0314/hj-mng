package com.jyw.controller;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.lang.StringUtils;
import org.jxjz.base.spring.BaseAction;
import org.jxjz.common.util.TimeUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.jyw.service.ClientLogService;

/**
 * 日志记录查询
 * author chenjin
 * createTime   2014-12-20
 */
@Controller
@RequestMapping("/client/log")
public class ClientLogController extends BaseAction{
	
	@Resource ClientLogService clientLogService;							//客户端日志service
	
	String clientLogList  			="jyw/client/clientLogList";			//日志记录列表页面
	String clientLogLayout			="jyw/client/clientLogLayout";			//日志记录搜索页面
	
	
	/**
	 * 分页查询日志记录列表
	 * author chenjin
	 * createTime   2014-12-20
	 */
	@RequestMapping(params="girdView")
	public ModelAndView girdView(HttpServletRequest request,HttpServletResponse response) throws Exception{
		String viewflag = request.getParameter("viewflag");//跳转标记1，表示ajax请求数据刷新页面
		pm = getPageInfo(new String[]{"startTime","endTime","delFlag","content"}, request);
		String endTime = request.getParameter("endTime");
		if(StringUtils.isNotBlank(endTime)){				//结束日期为23:59:59
			endTime = TimeUtil.getEndDateStr(endTime);
			pm.append("endTime", endTime);
		}
		String delFlag = request.getParameter("delFlag");//查询delFlag为0的
		if(StringUtils.isBlank(delFlag)){
			delFlag ="0";
		}
		pm.append("delFlag", delFlag);
		pm = clientLogService.getClientLogPageList(pm);	//查询客户端日志信息
		ModelAndView mav = null;
		if(StringUtils.isBlank(viewflag)){
			mav = new ModelAndView(clientLogLayout);
		}else{
			mav = new ModelAndView(clientLogList);
		}
		mav.addObject("pm",pm);
		return mav;
	}
}

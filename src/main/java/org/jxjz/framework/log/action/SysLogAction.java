package org.jxjz.framework.log.action;
import java.util.List;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.lang.StringUtils;
import org.jxjz.base.spring.BaseAction;
import org.jxjz.common.util.DataExpUtil;
import org.jxjz.framework.log.service.SysLogService;
import org.jxjz.framework.pojo.SysLog;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
 
/**
 * 系统日志处理类
 * author lihaijun
 * createTime   2014-11-21
 */
@Controller  
@RequestMapping("/sys/sysLogAction.do")
public class SysLogAction extends BaseAction{
	@Resource	SysLogService sysLogService;
	String layout      ="framework/log/sysLogListLayout";
	String dataList    ="framework/log/sysLogList";
	String detail      ="framework/log/sysLogDetail";
	
	/**
	 * 数据导出
	 */
	@RequestMapping(params = "expData")   
	public void expData(Model model,HttpServletRequest request,HttpServletResponse response) throws Exception{
		try {
			pm=getPageInfo(new String[] {"logMessage", "operResult"},request);
			List datas=sysLogService.getExpData(pm);//查询数据
			String Title []={"账户编号","账户名称","日志内容","操作时间","IP地址"};
			String fields[]={"userId","userName","logMessage","logTime","logIp"};
			short widths[]={7000,7000,7000,7000,8000};
			DataExpUtil.dataExpForMap(response, Title, fields, widths, datas, "account", "account");
		} catch (Exception e) {
			 e.getMessage();
		}
		
	}
		
	/**
	 * 系统日志详情
	 */
	@RequestMapping(params = "sysDetail")   
	public ModelAndView sysDetail(HttpServletRequest request,HttpServletResponse response) throws Exception {
		try {
			String logId=request.getParameter("logId");
			SysLog sysLog = sysLogService.getSysLogById(new Integer(logId));
			ModelAndView  mav=new ModelAndView(detail);
			mav.addObject("sysLog", sysLog);
			return mav;
		} catch (Exception e) {
			return page_404;
		}
	}	
	
	/**
	 *  系统日志查询页面
	 */
	@RequestMapping(params = "gridView")   
	public ModelAndView gridView(Model model,HttpServletRequest request,HttpServletResponse response)  throws Exception{
		pm=getPageInfo(new String[] {"logMessage", "operResult"},request);
		pm=sysLogService.getSysLogPageList(pm);//查询数据	
		ModelAndView mav=null;
		if (pageRequest(request)) {
			 mav=new ModelAndView(layout);
		}else { 
			 mav=new ModelAndView(dataList);
		}
		mav.addObject("pm", pm);
		return mav;  
		 
	}  
}

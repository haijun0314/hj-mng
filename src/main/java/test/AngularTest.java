package test;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jxjz.base.spring.BaseAction;
import org.jxjz.common.util.JsonUtil;
import org.jxjz.common.util.RequestUtils;
import org.jxjz.common.util.ResponseUtils;
import org.jxjz.framework.sysmanage.service.SysUserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
 
/**
 *  
 */
@Controller  
@RequestMapping("/angular.do") 
public class AngularTest extends BaseAction {
	@Resource	SysUserService sysUserService;
	 
	@RequestMapping(params = "getListData")   
	public void getListData(Model model,HttpServletRequest request,HttpServletResponse response)  throws Exception{
		Map paramMap=(HashMap)RequestUtils.getParameter(request, new String[] {});//取得页面查询参数
		pm=getPageInfo(new String[] {},  request);
		pm=sysUserService.getUserPageList(pm);//查询数据	 
		String json=JsonUtil.getStringFromList(pm.getDatas());
		ResponseUtils.renderJson(response, json);
		
	} 	
	
	
	
	
	
}

package test;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jxjz.base.spring.BaseAction;
import org.jxjz.common.util.JsonUtil;
import org.jxjz.common.util.ResponseUtils;
import org.jxjz.framework.cache.redis.RedisCacheUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
 
/**
 *  
 */
@Controller  
@RequestMapping("/redis.do") 
public class Redis extends BaseAction {
	 
	@RequestMapping(params = "saveData")   
	public void saveData(Model model,HttpServletRequest request,HttpServletResponse response)  throws Exception{
		RedisCacheUtil r=new RedisCacheUtil();
		HashMap map=new HashMap();
		map.put("sex", "男");
		map.put("name", "李海军");
		r.saveMap("001", map);
	} 
	@RequestMapping(params = "searchData")   
	public void searchData(Model model,HttpServletRequest request,HttpServletResponse response)  throws Exception{
		RedisCacheUtil r=new RedisCacheUtil();
		
		Map<String, String>  map=r.getAllMap("001");
		String json=JsonUtil.obj2Json(map);
		ResponseUtils.renderJson(response, json);
//		
		
	} 	
	
	
	
	
	
}

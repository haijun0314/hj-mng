package org.jxjz.framework.upload;

import java.io.File;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.jxjz.base.spring.BaseAction;
import org.jxjz.common.bean.resultMsg.UploadRespBean;
import org.jxjz.common.util.PropUtils;
import org.jxjz.framework.exception.ErrorCodeUtil;
import org.jxjz.framework.util.LogUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

/**
 * 文件上传 
 * author lihaijun 
 * createTime 2015-1-02
 */
@Controller
@RequestMapping("/upload")
public class UploadController extends BaseAction {

	/**
	 * 文件上传
	 */
	@RequestMapping(method = RequestMethod.POST, params = "upload")
	public void upload(HttpServletRequest request,HttpServletResponse response) {
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
		UploadRespBean rb   = new UploadRespBean();
		String module  =request.getParameter("module");
		if (StringUtils.isBlank(module)) {
			LogUtil.getLogger().error("【文件上传参数验证】..检查参数失败  缺失模块module");
			respMsgObj(response, rb);
			return;
		} 
		/** 构建图片保存的目录 **/
		String pathDir = PropUtils.getMsgStr("uploadPath") +module;
		/** 得到图片保存目录的真实路径 **/
		String realPathDir = request.getSession().getServletContext().getRealPath(pathDir);
		/** 根据真实路径创建目录 **/
		File saveFile = new File(realPathDir);
		if (!saveFile.exists()){
			saveFile.mkdirs();
		}
		/** 页面控件的文件流 **/
		MultipartFile multipartFile = multipartRequest.getFile("file");
		/** 获取文件的后缀 **/
		String suffix = multipartFile.getOriginalFilename().substring(multipartFile.getOriginalFilename().lastIndexOf("."));
		// /**使用UUID生成文件名称**/
		String picName = UUID.randomUUID().toString() + suffix;// 构建文件名称
		// String logImageName = multipartFile.getOriginalFilename();
		/** 拼成完整的文件保存路径加文件 **/
		String fileName = realPathDir + File.separator + picName;
		String filePath = request.getContextPath() + pathDir + "/" + picName; // 文件存储路径【绝对对】
		File file = new File(fileName);
		try {
			multipartFile.transferTo(file);
		} catch (Exception e) {
			e.printStackTrace();
			LogUtil.getLogger().error("【文件上传】....发生异常 ");
			rb.fail(ErrorCodeUtil.e_9999);
			respMsgObj(response, rb);
			return;
		}
		LogUtil.getLogger().error("【文件上传】....上传成功 文件名 fileName=" + fileName);
		rb.setFileName(filePath);
		rb.success();
		respMsgObj(response, rb);
	}	
	
 

}

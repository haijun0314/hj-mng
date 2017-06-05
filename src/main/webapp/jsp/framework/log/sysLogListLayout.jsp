<!-- 系统用户管理页面 -->
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/jsp/common/taglibs.jsp"%>
<!DOCTYPE html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
</head>	
	
<script>
$(document).ready(function(){

	 
});
/*************数据导出*************************/
function dataExp(){
 		 var dataExpUrl="${contextPath}/sys/sysLogAction.do?expData";
	 var conditionstr="&"+$('#searchForm').formSerialize();
	 var  url=dataExpUrl+conditionstr;
	 window.location.href=url;
} 

/***************请求查询***************************/
function searchSubmit(){
	 var conditionstr="&"+$('#searchForm').formSerialize();
	 var data=encodeURI(conditionstr); 
	 AjaxRequest.urlRequest("/sys/sysLogAction.do?gridView&ajax=true&reqType=1"+data,"tblist");
}

/***************更新系统用户**********************/	
function detailSysUser_open(userid){
	 BootstrapDialog.show({
		 title:'用户详情',
         message: $('<div></div>').load('/sys/sysLogAction.do?detail&Ajax=true&userid='+userid)//加载远程地址
     });
}
/***************系统日志详情***************************/

function detailSysLog(logId){
	
	 BootstrapDialog.show({
		 title:'系统日志详情',
         message: $('<div></div>').load('/sys/sysLogAction.do?sysDetail&Ajax=true&logId='+logId)//加载远程地址
     });
}


</script>	

<div class="clearfix form-search" style="height: 80px;">
	<form  id="searchForm" >
		<div class="row">
			<div class="col-sm-4">
				<input type="text" placeholder="关键词" class="form-control" name="logMessage">
			</div>
			<div class=" col-sm-3">
				<select  name="operResult" class="form-control">
					<option value=""> 操作结果</option>
					<option value="1"> 成功</option>
					<option value="2"> 失败</option>
				</select>
			</div>
			<div class=" col-sm-5">
					<button class="btn btn-purple " type="button" onclick="searchSubmit()">
						查询
						<i class="icon-search icon-on-right"></i>
					</button>
					<button class="btn btn-inverse " type="button" onclick="dataExp()">
						导出
						<i class="icon-glyph icon-share"></i>
					</button>
			</div>
		</div>
	</form> 	
</div>
<div id="tblist">
	<%@ include file="sysLogList.jsp"%>
</div>

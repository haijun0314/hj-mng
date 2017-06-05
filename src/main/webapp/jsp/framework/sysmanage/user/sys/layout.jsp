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
 

/***************请求查询***************************/
function searchSubmit(type){
	 var conditionstr="&"+$('#searchForm').formSerialize();
	 var data=encodeURI(conditionstr); 
	  HJF.searchSubmit("/sys/sysUser?gridView"+data,type);
}
/***************添加系统用户**********************/	
function addSysUser(){
	 BootstrapDialog.show({
		 title:'添加系统用户',
         message: $('<div></div>').load('/sys/sysUser?add&Ajax=true&'),//加载远程地址
         buttons: [{
             label: '确定',
             icon: 'glyphicon glyphicon-ok',
             cssClass: 'btn-primary',
             action: function(dialog) {
                 if($('#userForm').valid()){
                 	AjaxRequest.submitFormForModel("userForm",dialog,searchSubmit);//提交数据表单
                 }
             }
         }, {
             label: '取消',
             icon: 'glyphicon glyphicon-remove',
             cssClass: 'btn-danger',
             action: function(dialog) {
            	 dialog.close();
             }
         }]
     });
}	

/***************添加开放城市账号**********************/	
function addAgentUser(){
	 BootstrapDialog.show({
		 title:'添加开放城市账号',
         message: $('<div></div>').load('/sys/sysUser?addAgent&Ajax=true&userType=1'),//加载远程地址
         buttons: [{
             label: '确定',
             icon: 'glyphicon glyphicon-ok',
             cssClass: 'btn-primary',
             action: function(dialog) {
                 if($('#userForm').valid()){
                 	AjaxRequest.submitFormForModel("userForm",dialog,searchSubmit);//提交数据表单
                 }
             }
         }, {
             label: '取消',
             icon: 'glyphicon glyphicon-remove',
             cssClass: 'btn-danger',
             action: function(dialog) {
            	 dialog.close();
             }
         }]
     });
}	
 	

 
</script>	

<div class="clearfix form-search" style="height: 80px;">
	<form  id="searchForm" >
		<div class="row">
			<div class="col-sm-3">
				<input type="text" placeholder="用户名称" class="form-control" name="userName">
			</div>
			<div class=" col-sm-2">
				<select  name="status" class="form-control">
					<option value=""> 用户状态</option>
					<option value="1"> 正常</option>
					<option value="0"> 停用</option>
				</select>
			</div>
			 
			<div class=" col-sm-5" style="margin-left: 600px;margin-top: -36px">
					<button class="btn btn-purple " type="button" onclick="searchSubmit(1)">
						查询
						<i class="icon-search icon-on-right"></i>
					</button>
					<button class="btn btn-info" type="button" onclick="addSysUser()">
						添加
						<i class="icon-plus icon-on-right"></i>
					</button>
					<button class="btn btn-info" type="button" onclick="addAgentUser()">
						添加城市账号
						<i class="icon-plus icon-on-right"></i>
					</button>
			</div>
		</div>
	</form> 	
</div>
<div id="tblist">
	<%@ include file="dataList.jsp"%>
</div>

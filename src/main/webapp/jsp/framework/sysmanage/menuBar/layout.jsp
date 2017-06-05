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
/***************添加菜单**********************/	
function add(){
	 BootstrapDialog.show({
		 title:'添加菜单',
         message: $('<div></div>').load('/sys/security?add&Ajax=true'),//加载远程地址
         buttons: [{
             label: '确定',
             icon: 'glyphicon glyphicon-ok',
             cssClass: 'btn-primary',
             action: function(dialog) {
                 if($('#menuBarForm').valid()){
                 	AjaxRequest.submitFormForModel("menuBarForm",dialog,searchSubmit);//提交数据表单
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
/***************更新菜单**********************/	
function update(menuid){
	 BootstrapDialog.show({
		 title:'更新菜单',
         message: $('<div></div>').load('sys/security?update&Ajax=true&menuid='+menuid),//加载远程地址
         buttons: [{
             label: '确定',
             icon: 'glyphicon glyphicon-ok',
             cssClass: 'btn-primary',
             action: function(dialog) {
                 if($('#menuBarUpdateForm').valid()){
                 	AjaxRequest.submitFormForModel("menuBarUpdateForm",dialog,searchSubmit);//提交数据表单
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
/***************删除菜单***************************/
function delete_(menuid){
	bootbox.confirm("确认要删除数据吗?", function(result) {
		if(result) {
			var  url ="${contextPath}/sys/security?delete&menuid="+menuid;
			AjaxRequest.urlRequestWithMsg(url,searchSubmit) ;
			}
		});
}
/***************启用，停用服务类型**********************/
function updateStatus(menucode,operType){
	bootbox.confirm("确认要改变该菜单状态吗?", function(result) {
		if(result) {
			var  url ="${contextPath}/sys/security?updateStatus&menucode="+menucode+"&operType="+operType;
				AjaxRequest.urlRequestWithMsg(url,searchSubmit()) ;
			}
		});
}
	 	  
/***************请求查询***************************/
function searchSubmit(type){
	 var conditionstr="&"+$('#searchForm').formSerialize();
	 var data=encodeURI(conditionstr); 
	 HJF.searchSubmit("/sys/security?gridView"+data,type);
}	
	
</script>	
<div class="clearfix form-search" style="height: 80px;">
	<form  id="searchForm" >
		<div class="row">
			 <div class="col-sm-3">
				<input type="text" placeholder="菜单名称" class="form-control" name="menuName">
			</div>
			 <div class="col-sm-3">
				<input type="text" placeholder="菜单编码" class="form-control" name="menuCode">
			</div>
			<div class=" col-sm-5">
				<button class="btn btn-purple " type="button" onclick="searchSubmit(1)">
					查询
					<i class="icon-search icon-on-right"></i>
				</button>
				<button class="btn btn-info" type="button" onclick="add()">
					添加
					<i class="icon-plus icon-on-right"></i>
				</button>
			</div>
		</div>
	</form> 	
</div>
 
<div id="tblist">
	<%@ include file="dataList.jsp"%>
</div>

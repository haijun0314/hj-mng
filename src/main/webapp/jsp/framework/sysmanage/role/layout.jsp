<!-- 系统角色管理页面 -->
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/jsp/common/taglibs.jsp"%>
<!DOCTYPE html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
</head>	
<script>
    


/***************删除用户***************************/
function deleteRole(roleId){
	bootbox.confirm("确认要删除数据吗?", function(result) {
		if(result) {
			var  url ="${contextPath}/sys/role?delete&roleId="+roleId;
			AjaxRequest.urlRequestWithMsg(url,searchSubmit) ;
			}
		});
}	 
 
/***************添加系统角色**********************/	
function add(){
	 BootstrapDialog.show({
		 title:'添加系统角色',
         message: $('<div></div>').load('/sys/role?add&Ajax=true'),//加载远程地址
         buttons: [{
             label: '确定',
             icon: 'glyphicon glyphicon-ok',
             cssClass: 'btn-primary',
             action: function(dialog) {
                 if($('#roleForm').valid()){
                 	AjaxRequest.submitFormForModel("roleForm",dialog,searchSubmit);//提交数据表单
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
/***************更新系统角色**********************/	
function update(roleId){
	 BootstrapDialog.show({
		 title:'更新系统角色',
         message: $('<div></div>').load('/sys/role?update&Ajax=true&roleId='+roleId),//加载远程地址
         buttons: [{
             label: '确定',
             icon: 'glyphicon glyphicon-ok',
             cssClass: 'btn-primary',
             action: function(dialog) {
                 if($('#sysRoleForm').valid()){
                 	AjaxRequest.submitFormForModel("sysRoleForm",dialog,searchSubmit);//提交数据表单
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
/***************分配权限**********************/	
function permission(roleId){
	 BootstrapDialog.show({
		 title:'分配权限',
         message: $('<div></div>').load('/sys/role?permission&Ajax=true&roleId='+roleId),//加载远程地址
         buttons: [{
             label: '确定',
             icon: 'glyphicon glyphicon-ok',
             cssClass: 'btn-primary',
             action: function(dialog) {
               var json=zTree.getCheckedNodes(true);
                 var ids="";
                 for(var i=0; i<json.length; i++)  
				  {  
				    ids=ids+(json[i].id)+"-"  ;
				  }
				   $("#ids").val(ids);
                   //按钮事件，点击确定按钮之后，按钮变灰，不可再次操作
                   var $button = this; 
                   $button.disable();
				   var ajaxbg = $("#progressBar");	
				   ajaxbg.show();
                   AjaxRequest.submitFormForModel("permissionForm",dialog,function (){
                    ajaxbg.hide();
                   }) ;
                 
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
 	
/***************请求查询***************************/
function searchSubmit(type){
	   HJF.searchSubmit("/sys/role?gridView",type);
}	
/***************角色详情**********************/
function detail(roleId){
	 BootstrapDialog.show({
		 title:'角色详情',
         message: $("<div></div>").load("/sys/role?detail&Ajax=true&roleId="+roleId)//加载远程地址
     });
}	
</script>	
 
<div class="clearfix form-search" style="height: 80px;">
	<form  id="searchForm" >
		<div class="row">
			 
			<div class=" col-sm-5">
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
		 
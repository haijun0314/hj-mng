<!--更新用户页面-->
<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ include file="/jsp/common/taglibs.jsp"%>
<script type="text/javascript">
$(document).ready(function(){
	$('[data-rel=popover]').popover();
	$('[data-rel=tooltip]').tooltip();
	validate_Form();//初始化表单验证
	 
});
 
function checkNameExist(){
	 var username=$('#username').val();
	 var  url ="${contextPath}/sys/sysUser?checkUserName&username="+username;
	 AjaxRequest.urlRequestWithMsg(url);
}

/*********************角色类型选择改变事件**************/
function changeIssuperSelect(){
	  var type=$("#issuper").val();
	  if("0"==type){
		  $("#roleSelect").show();
		  $(":checkbox").addClass('required');
	  }else{
		   $("#roleSelect").hide();
		   $(":checkbox").removeClass('required');
	  }
}


/******************表单验证****************************/
function validate_Form(){
   var validateForm  = $('#userForm');
   validateForm.validate({ 
       
       rules:{
			userName:{required:true,minlength: 3},
			realName:{required:true},
			telePhone:{telePhone:true},
			email:{email:true}, 
      },
      
      messages:{
	   	   userName: {
	   		    required: "请输入登录名称"
	   	   },
	   	   realName: {
	  		    required: "请输入真实姓名"
	  	   },
	  	   telePhone: {
	  		    required: "请输入手机号码"
	  	   },
	  	   email: {
	  		    required: "请输入电子邮箱"
	  	   }
      }
   });		
}
</script>
<div class="row">
	<div class="col-xs-12">
		<form action="${contextPath}/sys/sysUser?mySet&ajax=true&reqType=2" class="form-horizontal" role="form"  id="userForm" name="userForm">
			<input type="hidden" id="userId"  name="userId"  value="${sysUser.userId}">
			<div class="form-group">
				<label for="userName" class="col-sm-3 control-label no-padding-right"> 登录名称</label>
				<div class="col-sm-9">
					<input type="text" class="col-xs-10 col-sm-7" placeholder="" id="userName" name="userName" value="${sysUser.userName }" disabled="disabled">
				</div>
			</div>
			<div class="form-group">
				<label for="realName" class="col-sm-3 control-label no-padding-right"> 真实姓名</label>
				<div class="col-sm-9">
					<input type="text" class="col-xs-10 col-sm-7" placeholder="" id="realName" name="realName" value="${sysUser.realName }">
				<span data-content="More details." data-placement="right" data-trigger="hover" data-rel="tooltip" class="help-button" data-original-title="请填写登录用户名，是用来登录系统的名称">?</span>
				</div>
			</div>
			 
			<div class="form-group">
				<label for="telePhone" class="col-sm-3 control-label no-padding-right">联系电话</label>
				<div class="col-sm-9">
					<input type="text" class=" required col-xs-10 col-sm-5" placeholder="" id="telePhone"  name="telePhone"  value="${sysUser.telePhone }">
				</div>
			</div>
			<div class="form-group">
				<label for="email" class="col-sm-3 control-label no-padding-right">电子邮件</label>
				<div class="col-sm-9">
					<input type="text" class=" required col-xs-10 col-sm-8" placeholder="" id="email"  name="email" value="${sysUser.email }">
				</div>
			</div>
			 
			<div class="form-group">
				<label for="remark" class="col-sm-3 control-label no-padding-right"> 备注</label>
				<div class="col-sm-7">
					<textarea class="form-control limited" id="remark" name="remark">${sysUser.remark }</textarea>
				</div>
			</div>
		</form>
	</div>
</div>
 
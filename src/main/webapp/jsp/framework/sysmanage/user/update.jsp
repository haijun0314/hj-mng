<!--更新用户页面-->
<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ include file="/jsp/common/taglibs.jsp"%>
<script type="text/javascript">
$(document).ready(function(){
	validate_Form();//初始化表单验证
});
/**
 * 初始化抽奖页面活动结束后是否可以继续兑奖 单选框
 */	
 
function checkNameExist(){
	 var username=$('#username').val();
	 var  url ="${contextPath}/sys/sysUser?checkUserName&username="+username;
	 AjaxRequest.urlRequestWithMsg(url);
}


/******************表单验证****************************/
function validate_Form(){
   var validateForm  = $('#userForm');
   validateForm.validate({
       rules:{
			userName:{required:true,minlength: 3},
			realName:{required:true,minlength: 3} ,
			telePhone:{telePhone:true} ,
			email:{email:true} 
      },
      messages:{
	   	   userName: {
	   		    required: "请输入登录名称"
	   	   },
	   	   realName: {
	  		    required: "请输入真实姓名"
	  	   },
	  	   telePhone: {
	  		    required: "请输入手机号"
	  	   } ,
	  	   email: {
	  		    required: "请输入邮箱"
	  	   }   
      }
   });		
}
</script>
<div class="row">
	<div class="col-xs-12">
		<form action="${contextPath}/sys/sysUser?update&ajax=true&reqType=2" class="form-horizontal" role="form"  id="userForm" name="userForm">
			<input type="hidden" id="userId"  name="userId"  value="${sysUser.userId}">
			<div class="form-group">
				<label for="username" class="col-sm-3 control-label no-padding-right"> 登录账号</label>
				<div class="col-sm-9">
					<input type="text" class="col-xs-10 col-sm-7" placeholder="" id="userName" name="userName" value="${sysUser.userName }" disabled="disabled">
				</div>
			</div>
			<div class="form-group">
				<label for="realname" class="col-sm-3 control-label no-padding-right"> 真实姓名</label>
				<div class="col-sm-9">
					<input type="text" class="col-xs-10 col-sm-7" placeholder="" id="realName" name="realName" value="${sysUser.realName }" >
				</div>
			</div>
			 
			<div class="form-group">
				<label for="telephone" class="col-sm-3 control-label no-padding-right"> <b class="star_red">*</b>联系电话</label>
				<div class="col-sm-9">
					<input type="text" class=" required col-xs-10 col-sm-5" placeholder="" id="telePhone"  name="telePhone"  value="${sysUser.telePhone }">
				</div>
			</div>
			 
			
			<div class="form-group">
				<label for="email" class="col-sm-3 control-label no-padding-right"> <b class="star_red">*</b>电子邮件</label>
				<div class="col-sm-9">
					<input type="text" class=" required col-xs-10 col-sm-8" placeholder="" id="email"  name="email" value="${sysUser.email }">
				</div>
			</div>
			 
			<div class="form-group">
				<label for="remark" class="col-sm-3 control-label no-padding-right"> 备注</label>
				<div class="col-sm-9">
					<textarea class="form-control limited" placeholder="" id="remark" name="remark" >${sysUser.remark }</textarea>
				</div>
			</div>
		</form>
	</div>
</div>
 
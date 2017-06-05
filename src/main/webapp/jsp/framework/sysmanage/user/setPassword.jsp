<!-- 修改密码页面-->
<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ include file="/jsp/common/taglibs.jsp"%>
<%	String basePath=request.getContextPath(); %>
<script type="text/javascript">
$(document).ready(function(){
	validate_Form();//初始化表单验证
});

/******************表单验证****************************/
function validate_Form(){
   var validateForm  = $('#changePwdForm');
   validateForm.validate({
      
       rules:{
			oldPassword:{required:true,minlength: 6},
			newPassword: {required:true,minlength: 6},  
            againPassword: {required:true,minlength: 6,equalTo: "#newPassword"},
            },  
      messages:{
	   	   oldPassword: {
	   		    required: "请输入原密码"},
	   	  newPassword: {    
                required: "请输入新密码"},  
            againPassword: {required: "请确认新密码",equalTo: "两次输入密码不一致"},
       }
   });		
}

</script>

<body>
	
	<div class="row">
		<div class="col-xs-12">
			<form
				action="${contextPath}/sys/sysUser?setPassword&ajax=true&reqType=2"class="form-horizontal" role="form" id="changePwdForm" name="changePwdForm">
				<div class="form-group">
					<label for="oldPassword"
						class="col-sm-3 control-label no-padding-right">原密码</label>
					<div class="col-sm-9">
						<input type="password" class="col-xs-10 col-sm-7" id="oldPassword" name="oldPassword">
					</div>
				</div>
				<div class="form-group">
					<label for="newPassword"
						class="col-sm-3 control-label no-padding-right">新密码</label>
					<div class="col-sm-9">
						<input type="password" class="col-xs-10 col-sm-7" id="newPassword" name="newPassword">
					</div>
				</div>
				<div class="form-group">
					<label for="againPassword"
						class="col-sm-3 control-label no-padding-right">确认密码</label>
					<div class="col-sm-9">
						<input type="password" class="col-xs-10 col-sm-7" id="againPassword" name="againPassword">
					</div>
				</div>
				
			</form>
		</div>
	</div>
				
	
</body>
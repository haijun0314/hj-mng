<!-- 添加用户页面-->
<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ include file="/jsp/common/taglibs.jsp"%>

<script type="text/javascript">
var data={
    roles      : [] ,
    isSuper:true,
    required:false
}
var app=new Vue({
  el: '#page',
  data:  data
})


$(document).ready(function(){
	$('[data-rel=popover]').popover();//Bootstrap 工具提示（popover）插件
	$('[data-rel=tooltip]').tooltip();//Bootstrap 工具提示（Tooltip）插件
	validate_Form();//初始化表单验证
});

$(document).ready(function(){
	 AjaxRequest.httpPost(
		"/sys/role?getRoles",
		{
			 resource:'1'
		},
		function(result) {
			 data.roles=result;
		});
});



/*********************角色类型选择改变事件**************/
function changeIssuperSelect(){
	  var type=$("#isSuper").val();
	  if("1"==type){
		 data.isSuper=false;
		 data.required=true;
	  }else{
		 data.isSuper=true;
		 data.required=false;;
	  }
}


/******************表单验证****************************/
function validate_Form(){
   var validateForm  = $('#userForm');
   validateForm.validate({
       rules:{
			userName:{required:true,minlength: 3},
			password:{required:true,minlength: 6},
			isSuper:{required:true},
			confirmPassword:{required:true,minlength: 6,equalTo: "#password"},
			email:{required:true,email:true},
			telePhone:{telePhone:true},
      },
      messages:{
	   	   userName: {
	   		    required: "请输入登录名称"
	   	   },
	   	   password: {
	  		    required: "请输入登录密码"
	  	   },
	  	   telePhone: {
	  		    required: "请输入正确的手机号"
	  	   },
	  	 confirmPassword:{ required: "请输入登录密码",equalTo: "两次输入密码不一致"  },
      }
   });		
}
</script>
<div class="row" id="page">
	<div class="col-xs-12">
		<form action="${contextPath}/sys/sysUser?add&ajax=true&reqType=2" class="form-horizontal" role="form"  id="userForm" name="userForm">
			<div class="form-group">
				<label for="userName" class="col-sm-3 control-label no-padding-right"> <b class="star_red">*</b>登录名称</label>
				<div class="col-sm-9">
					<input type="text" class="required col-xs-10 col-sm-7" placeholder="" id="userName" name="userName">
					<span data-content="More details." data-placement="right" data-trigger="hover" data-rel="tooltip" class="help-button" data-original-title="请填写登录用户名，是用来登录系统的名称">?</span>
					<span><a href="#" class="btn btn-xs btn-pink" onclick="UserUtil.checkName()">检查用户名</a></span>
				</div>
			</div>
			<div class="form-group">
				<label for="realname" class="col-sm-3 control-label no-padding-right"> 真实姓名</label>
				<div class="col-sm-9">
					<input type="text" class="col-xs-10 col-sm-7" placeholder="" id="realName" name="realName">
				<span data-content="More details." data-placement="right" data-trigger="hover" data-rel="tooltip" class="help-button" data-original-title="请填写登录用户名，是用来登录系统的名称">?</span>
				</div>
				
			</div>
			<div class="form-group">
				<label for="password" class="col-sm-3 control-label no-padding-right"> <b class="star_red">*</b>登录密码</label>
				<div class="col-sm-9">
					<input type="password" class=" required col-xs-10 col-sm-7" placeholder="" id="password" name="password">
				</div>
			</div>
			<div class="form-group">
				<label for="confirmPassword" class="col-sm-3 control-label no-padding-right"> <b class="star_red">*</b>确认密码</label>
				<div class="col-sm-9">
					<input type="password" class=" required col-xs-10 col-sm-5" placeholder="" id="confirmPassword" name="confirmPassword">
				</div>
			</div>
			
			<div class="form-group">
				<label for="telePhone" class="col-sm-3 control-label no-padding-right"> <b class="star_red">*</b>联系电话</label>
				<div class="col-sm-9">
					<input type="text" class=" required col-xs-10 col-sm-5" placeholder="" id="telePhone"  name="telePhone">
				</div>
			</div>
			<div class="form-group" >
				<label for="select_role" class="col-sm-3 control-label no-padding-right"> <b class="star_red">*</b>角色选择</label>
				<div class="col-sm-9" >
					 <select name="isSuper" id="isSuper" onchange="changeIssuperSelect()">
						<option value="">请选择</option> 
						<option value="0">超级理员</option> 
						<option value="1">普通管理员</option>
					 </select>
				</div> 
			</div>

			<div class="form-group"  id="roleSelect"  v-bind:class="{ 'hide': isSuper }">
				<label for="usertel" class="col-sm-3 control-label no-padding-right"> <b class="star_red">*</b>拥有角色</label>
				<div class="col-sm-9">
			        <div class="checkbox">
			        	<!-- 
				        <c:forEach var="data" items="${roleList}" >
				        	<label>
								<input type="checkbox" class="ace ace-checkbox-2 " name="roles" value="${data.roleId }" >
								<span class="lbl"> ${data.roleDesc }</span>
							</label>
				        </c:forEach>
				         -->
				         <div  v-for="role in  roles">  
				        	<label>
								<input type="checkbox" v-bind:value="role.roleId" class="ace ace-checkbox-2 " name="roles"   v-bind:class="{ 'required': required }"  >
								<span class="lbl"> {{role.roleDesc}}</span>
							</label>
				         </div>
				        
					</div>
				</div>
			</div>
			 
			<div class="form-group">
				<label for="email" class="col-sm-3 control-label no-padding-right"> <b class="star_red">*</b>电子邮件</label>
				<div class="col-sm-9">
					<input type="text" class=" required col-xs-10 col-sm-8" placeholder="" id="email"  name="email">
				</div>
			</div>
			 
			<div class="form-group">
				<label for="remark" class="col-sm-3 control-label no-padding-right"> 备注</label>
				<div class="col-sm-9">
					<textarea maxlength="50" id="form-field-9" class="form-control limited" placeholder="" id="remark" name="remark"></textarea>
				</div>
			</div>
		</form>
	</div>
</div>
 
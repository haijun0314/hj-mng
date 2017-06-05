<!-- 添加开放城市账号管理页面-->
<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ include file="/jsp/common/taglibs.jsp"%>
<script src="${contextPath}/static/logic/sys/agent.js" type="text/javascript"></script>
<script type="text/javascript">
$(document).ready(function(){
	validate_Form();//初始化表单验证
	$('[data-rel=popover]').popover();//Bootstrap 工具提示（popover）插件
	$('[data-rel=tooltip]').tooltip();//Bootstrap 工具提示（Tooltip）插件
});

$(document).ready(function(){
 $(":checkbox").addClass('required');
 $(":checkbox").removeClass('ace');
	AgentUtil.loadAgent();
});
 


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
			agentId:{required:true},
			telePhone:{required:true,minlength: 11},
      },
      messages:{
	   	   userName: {
	   		    required: "请输入登录名称"
	   	   },
	   	   password: {
	  		    required: "请输入登录密码"
	  	   },
	  	 	confirmPassword:{ required: "请输入登录密码",equalTo: "两次输入密码不一致"  },
	  	 	telePhone:{
	   		    required: "请输入电话号码"
	   	   },
      }
   });		
}
 
</script>
<div class="row">
	<div class="col-xs-12">
		<form action="${contextPath}/sys/sysUser?addAgent&ajax=true&reqType=2" class="form-horizontal" role="form"  id="userForm" name="userForm">
			<input type="hidden"   id="userType" name="userType" value="${userType}">
			<div class="form-group">
				<label for="userName" class="col-sm-3 control-label no-padding-right"> <b class="star_red">*</b>登录名称</label>
				<div class="col-sm-9">
					<input type="text" class="required col-xs-10 col-sm-7" placeholder="" id="userName" name="userName">
					<span data-content="More details." data-placement="right" data-trigger="hover" data-rel="tooltip" class="help-button" data-original-title="请填写登录用户名，是用来登录系统的名称">?</span>
					<span><a href="#" class="btn btn-xs btn-pink" onclick="checkNameExist()">检查用户名</a></span>
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
				<label for="telePhone" class="col-sm-3 control-label no-padding-right"> <b class="star_red">*</b>联系电话</label>
				<div class="col-sm-9">
					<input type="text" class=" required col-xs-10 col-sm-5" placeholder="" id="telePhone"  name="telePhone">
				</div>
			</div>
			<div class="form-group">
				<label for="email" class="col-sm-3 control-label no-padding-right"> <b class="star_red">*</b>电子邮件</label>
				<div class="col-sm-9">
					<input type="text" class=" required col-xs-10 col-sm-8" placeholder="" id="email"  name="email">
				</div>
			</div>
			<div class="form-group"  id="roleSelect"  >
				<label for="usertel" class="col-sm-3 control-label no-padding-right"> <b class="star_red">*</b>拥有角色</label>
				<div class="col-sm-9">
			        <div class="checkbox">
				        <c:forEach var="data" items="${roleList}" >
				        	<label>
								<input type="checkbox" class="ace ace-checkbox-2 " name="roles" value="${data.roleId }" >
								<span class="lbl"> ${data.roleDesc }</span>
							</label>
				        </c:forEach>
					</div>
				</div>
			</div>
			<c:if test="${userType==1}">
			<div class="form-group">
				<label for="cityCode_" class="col-sm-3 control-label no-padding-right"><b class="star_red">*</b>代&nbsp;&nbsp;理&nbsp;&nbsp;&nbsp;&nbsp;商</label>
				<div class="col-sm-9">
				<select id="agentId" class="col-xs-10 col-sm-7" name="agentId"  >
					<option value="">请选代理商</option>
				</select>
				</div>
			</div>
			</c:if>
			 
			<div class="form-group">
				<label for="remark" class="col-sm-3 control-label no-padding-right"> 备注</label>
				<div class="col-sm-9">
					<textarea maxlength="50" id="form-field-9" class="form-control limited" placeholder="" id="remark" id="remark"></textarea>
				</div>
			</div>
			<input type="hidden" id="userType" name="userType" value="${userType}">
		</form>
	</div>
</div>
 
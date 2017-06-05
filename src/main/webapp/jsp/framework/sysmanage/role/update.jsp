<!-- 编辑角色页面-->
<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ include file="/jsp/common/taglibs.jsp"%>
<%	String basePath=request.getContextPath(); %>
<script type="text/javascript">

$(document).ready(function(){
	$('[data-rel=popover]').popover();
	$('[data-rel=tooltip]').tooltip();
	validate_Form();//初始化表单验证
});

/******************表单验证****************************/
function validate_Form(){
   var validateForm  = $('#sysRoleForm');
   validateForm.validate({
       rules:{
			roleName:{required:true,minlength: 2},
			roleDesc:{required:true,minlength: 2},
      },
      messages:{
	   	   roleName: {
	   		    required: "请输入角色名称"
	   	   },
	   	   roleDesc: {
	   		    required: "请输入角色编码"
	   	   },
      }
   });		
}

</script>

	<div class="row">
		<div class="col-xs-12">
			<form
				action="${contextPath}/sys/role?update&ajax=true&reqType=2"
				class="form-horizontal" role="form" id="sysRoleForm"
				name="sysRoleForm">
				<input  type="hidden" name="roleId" value="${sr.roleId }"> 
				
				<div class="form-group">
					<label for="roleDesc"
						class="col-sm-3 control-label no-padding-right"> 角色名称</label>
					<div class="col-sm-9">
						<input type="text" class="col-xs-10 col-sm-7" placeholder=""
							id="roleDesc" name="roleDesc" value="${sr.roleDesc }">
					</div>
					</div>
					<div class="form-group">
					<label for="roleName"
						class="col-sm-3 control-label no-padding-right"> 角色说明</label>
					<div class="col-sm-9">
						<input type="text" class="col-xs-10 col-sm-7" placeholder=""
							id="roleName" name="roleName" value="${sr.roleName }">
					</div>
				</div>
					 
				
				<div class="form-group">
					<label for="remark"
						class="col-sm-3 control-label no-padding-right"> 备注</label>
					<div class="col-sm-9">
						<textarea class="form-control limited" placeholder="" id="remark" name="remark" >${sr.remark}</textarea>
					</div>
				</div>
				
			</form>
		</div>
	</div>
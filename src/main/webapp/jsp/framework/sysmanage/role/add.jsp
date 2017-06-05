<!-- 添加角色页面-->
<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ include file="/jsp/common/taglibs.jsp"%>
<script type="text/javascript">
$(document).ready(function(){
	validate_Form();//初始化表单验证
});
/******************检验角色名称****************************/
function checkExist(){
	 var roleDesc=$('#roleDesc').val();
	 var  url ="${contextPath}/sys/role?checkExist&roleDesc="+roleDesc;
	 AjaxRequest.urlRequestWithMsg(url);
}
/******************表单验证****************************/
function validate_Form(){
   var validateForm  = $('#roleForm');
   validateForm.validate({
       
       rules:{
			roleName:{required:true,minlength: 2},
			roleDesc:{required:true,minlength: 2}
      },
      messages:{
	   	   roleName: {
	   		    required: "请输入角色名称"
	   	   },
	   	   roleDesc: {
	   		    required: "请输入角色说明"
	   	   }
	   	    
      }
   });		
}
</script>
<div class="row">
	<div class="col-xs-12">
		<form action="${contextPath}/sys/role?add&ajax=true&reqType=2" class="form-horizontal" role="form"  id="roleForm" name="roleForm">
			
			<div class="form-group">
				<label for="roleDesc" class="col-sm-3 control-label no-padding-right"> <b class="star_red">*</b>角色名称</label>
				<div class="col-sm-9">
					<input type="text" class=" required col-xs-10 col-sm-7" placeholder="" id="roleDesc" name="roleDesc">
					<span><a href="#" class="btn btn-xs btn-pink" onclick="checkExist()">检查角色名称</a></span>
				</div>
			</div>
			<div class="form-group">
				<label for="roleName" class="col-sm-3 control-label no-padding-right"><b class="star_red">*</b> 角色说明</label>
				<div class="col-sm-9">
					<input type="text" class="col-xs-10 col-sm-7" placeholder="" id="roleName" name="roleName">
				</div>
				
			</div>
			<div class="form-group">
					<label for="resource"
						class="col-sm-3 control-label no-padding-right">角色来源</label>
					<div class="col-sm-9">
					<label>
						<input type="radio" class="ace" placeholder=""
							id="resource" name="resource" value="1" checked="checked">
						<span class="lbl">总部</span>
					</label>
						<label>
						<input type="radio" class="ace" placeholder=""
							id="resource" name="resource" value="2" >
						<span class="lbl">城市</span>
					</label>
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
 
<!-- 添加权限页面-->
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
   var validateForm  = $('#menuBarUpdateForm');
   validateForm.validate({
       
       rules:{
			menuName:{required:true,minlength: 2},
			title:{required:true,minlength: 2},
      },
      messages:{
	   	  menuName: {
	   		    required: "请输入权限名称 "
	   	   },
	   	    title: {
	   		    required: "请输入权限title "
	   	   },
      }
   });		
}	 
</script>
<div class="row">
		<div class="col-xs-12">
			<form action="${contextPath}/sys/security?update&ajax=true&reqType=2" class="form-horizontal" role="form" id="menuBarUpdateForm" name="menuBarUpdateForm">
				<input  type="hidden" name="menuId" value="${sysMenubar.menuId }"> 
				<div class="form-group">
					<label for="menuName"
						class="col-sm-3 control-label no-padding-right"> 权限名称</label>
					<div class="col-sm-9">
						<input type="text" class="col-xs-10 col-sm-7" placeholder=""
							id="menuName" name="menuName" value="${sysMenubar.menuName }">
					</div>
				</div>
				<div class="form-group">
					<label for="title"
						class="col-sm-3 control-label no-padding-right"> 权限title</label>
					<div class="col-sm-9">
						<input type="text" class="col-xs-10 col-sm-7" placeholder=""
							id="title" name="title" value="${sysMenubar.title }">
					</div>
				</div> 
				<c:if test="${sysMenubar.menuLevel==3}">
				<div class="form-group">
					<label for="location"
						class="col-sm-3 control-label no-padding-right"> URL</label>
					<div class="col-sm-9">
						<input type="text" class="col-xs-10 col-sm-7" placeholder=""
							id="location" name="location" value="${sysMenubar.location }">
					</div>
				</div> 
				</c:if>
				<div class="form-group">
					<label for="image"
						class="col-sm-3 control-label no-padding-right">权限图片</label>
					<div class="col-sm-9">
						<input type="text" class="col-xs-10 col-sm-7" placeholder=""
							id="image" name="image" value="${sysMenubar.image }">
					</div>
				</div> 
			</form>
		</div>
	</div>







 

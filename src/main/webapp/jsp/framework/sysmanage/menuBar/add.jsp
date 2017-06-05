<!-- 添加权限页面-->
<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ include file="/jsp/common/taglibs.jsp"%>
<script src="${contextPath}/static/logic/sys/menu.js" type="text/javascript"></script>
<script type="text/javascript">
$(document).ready(function(){
	validate_Form();//初始化表单验证
	MenuUtil.loadParent();
});
/*********************URL选择改变事件**************/
function changeUrl(){
	  var type=$("#son").val();
	  if(""==type){
		   $("#location").removeClass('required');
		   $("#error_").removeClass('has-error');
		   
	  }else{
		  $("#location").addClass('required');
	  }
}
/******************表单验证****************************/
function validate_Form(){
   var validateForm  = $('#menuBarForm');
   validateForm.validate({
       errorElement: 'span', 
       errorClass: 'help-inline',
       focusInvalid: true, 
       ignore: "",
       highlight: function (element) {
       		$(element).closest('.form-group').removeClass('has-info').addClass('has-error');
       },
       unhighlight: function (element) { 
			$(element).closest('.form-group').removeClass('has-error').addClass('has-info');
       },
       success: function (label) {
           label.addClass('valid').addClass('help-inline ok').closest('.control-group').removeClass('error').addClass('success');
       },
       
       submitHandler: function (form) {
       		 
       },
       rules:{
			menuName:{required:true,minlength: 2},
			
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

 
 <body>
	<div class="row">
		<div class="col-xs-12">
			<form action="${contextPath}/sys/security?add&ajax=true&reqType=2"class="form-horizontal" role="form" id="menuBarForm"name="menuBarForm">
				<div class="form-group">
					<label for="menuname"
						class="col-sm-3 control-label no-padding-right">上级菜单</label>
					<div class="col-sm-5">
						<select  name="parentIdS" class="form-control"  id="parent" onchange="MenuUtil.loadSon()">
						<option  value=""> 选择菜单</option>
					</select>
					</div>
				</div>
				<div class="form-group">
					<label for="menuname"
						class="col-sm-3 control-label no-padding-right"> 菜单</label>
					<div class="col-sm-5">
					<select  name="sonId" class="form-control"  id="son" onchange="changeUrl()">
						<option  value=""> 选择菜单</option>
					</select>
					</div>
				
				

				</div>
				<div class="form-group">
					<label for="menuname"
						class="col-sm-3 control-label no-padding-right"> <b class="star_red">*</b>菜单名称</label>
					<div class="col-sm-9">
						<input type="text" class="col-xs-10 col-sm-7" placeholder=""
							id="menuName" name="menuName">
					</div>
				</div>
				<div class="form-group" id="error_">
					<label for="location"
						class="col-sm-3 control-label no-padding-right"> URL</label>
					<div class="col-sm-9">
						<input type="text" class="col-xs-10 col-sm-7" placeholder=""
							id="location" name="location">
					</div>
				</div>
				<div class="form-group">
					<label for="image"
						class="col-sm-3 control-label no-padding-right">图标</label>
					<div class="col-sm-9">
						<input type="text" class="col-xs-10 col-sm-7" placeholder=""
							id="image" name="image">
					</div>
				</div>
			</form>
		</div>
	</div>
</body>

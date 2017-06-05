<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/jsp/common/cssandjs.jsp"%>
 <script type="text/javascript">
 $(document).ready(function(){
		
	 
 });
 
function checkNameExist(){
	 var username=$('#username').val();
	 var  url ="${contextPath}/sys/sysUserAction.do?checkUserName&username="+username;
	 AjaxRequest.urlRequestWithMsg(url);
}
 
 
 
 </script>

 
	 
	<link rel="stylesheet" href="${contextPath}/static/css/hjf.css" type="text/css"/>
			<script type="text/javascript">
			    $(document).ready(function() {
			       
			        $('#example2').multiselect();
					
			         
			    });
			</script>
	
	
	<body>
	<div class="row">
	<div class="col-xs-12">
		<form action="${contextPath}/sys/sysUserAction.do?add_sysUser&ajax=true&viewflag=0" class="form-horizontal" role="form"  id="userForm" name="userForm">
			<div class="form-group">
				<label for="username" class="col-sm-3 control-label no-padding-right"> <b class="star_red">*</b>登录名称</label>
				<div class="col-sm-9">
					<input type="text" class="required col-xs-10 col-sm-7" placeholder="" id="username" name="username">
					<span><a href="#" class="btn btn-xs btn-pink" onclick="checkNameExist()">检查用户名</a></span>
					<span data-content="More details." data-placement="right" data-trigger="hover" data-rel="tooltip" class="help-button" data-original-title="请填写登录用户名，是用来登录系统的名称">?</span>
				</div>
			</div>
			<div class="form-group">
				<label for="realname" class="col-sm-3 control-label no-padding-right"> 真实姓名</label>
				<div class="col-sm-9">
					<input type="text" class="col-xs-10 col-sm-7" placeholder="" id="realname" name="realname">
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
				<label for="usertel" class="col-sm-3 control-label no-padding-right"> <b class="star_red">*</b>联系电话</label>
				<div class="col-sm-9">
					<div class="radio">
						<label>
							<input type="radio" class="ace" name="sex">
							<span class="lbl"> 男</span>
						</label>
						<label>
							<input type="radio" class="ace" name="sex">
							<span class="lbl"> 女</span>
						</label>
					</div>
				</div>
			</div>
			<div class="form-group">
				<label for="usertel" class="col-sm-3 control-label no-padding-right"> <b class="star_red">*</b>联系电话</label>
				<div class="col-sm-9">
					<input type="text" class=" required col-xs-10 col-sm-5" placeholder="" id="usertel"  name="usertel">
				</div>
			</div>
			<div class="form-group">
				<label for="usertel" class="col-sm-3 control-label no-padding-right"> <b class="star_red">*</b>联系电话</label>
				<div class="col-sm-9">
			        <div class="checkbox">
			            <select id="example2" multiple="multiple">
			                <option value="cheese" selected>Cheese</option>
			                <option value="tomatoes" selected>Tomatoes</option>
			                <option value="mozarella" selected>Mozzarella</option>
			                <option value="mushrooms">Mushrooms</option>
			                <option value="pepperoni">Pepperoni</option>
			                <option value="onions">Onions</option>
			            </select>
			            
					</div>
				</div>
			</div>
			<div class="form-group">
				<label for="useremail" class="col-sm-3 control-label no-padding-right"> <b class="star_red">*</b>电子邮件</label>
				<div class="col-sm-9">
					<input type="text" class=" required col-xs-10 col-sm-5" placeholder="" id="useremail"  name="useremail">
				</div>
			</div>
			<div class="form-group">
				<label for="remark" class="col-sm-3 control-label no-padding-right"> 备注</label>
				<div class="col-sm-9">
					<textarea maxlength="50" id="form-field-9" class="form-control limited" placeholder="" id="remark" id="remark"></textarea>
				</div>
			</div>
		</form>
	</div>
</div>	 
        
			 
			

			 

			            

		 
	</body>
<!-- 后台登陆页面 -->
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<html class="login-bg">
<link rel="stylesheet" href="${contextPath}/static/ace/ace.min.css" />
<link rel="stylesheet" href="${contextPath}/static/bootstrap/css/bootstrap.css" type="text/css"/>
<script src="${contextPath}/static/js/jquery-1.3.2.min.js" type="text/javascript"></script>
<script src="${contextPath}/static/js/jquery.form.js" type="text/javascript"></script>
<link rel="stylesheet" href="${contextPath}/static/fontawesome/css/font-awesome.min.css" />
<script src="${contextPath}/static/js/vue.js" type="text/javascript"></script>	
<body style="overflow: hidden;">
<script type="text/javascript">


/********************新增按ENTER键时登陆******************************/
$(document).keyup(function(event){
  if(event.keyCode == 13){
    	$("#tijiao").trigger("click");
  }
});
getExplorer();
function getExplorer() {
var explorer = window.navigator.userAgent ;
	if (explorer.indexOf("Firefox") >= 0) {
		//alert("Firefox");
		 
	}else if(explorer.indexOf("Chrome") >= 0){
		//alert("Chrome");
	}else{
		//alert("Safari");
		alert("您浏览器不兼容，建议您使用火狐，谷歌，百度，搜狗等浏览器");
		var  url="${contextPath}/download.jsp";
	    window.location.href=url;
	}
}
</script>

<style>
	.login-bg {
		/*background: url("${contextPath}/static/image/login/login1.jpg") no-repeat fixed center center / cover rgba(0, 0, 0, 0);*/
   	 	background: url("${contextPath}/static/image/login/login_bg.jpg") no-repeat fixed center center / cover rgba(0, 0, 0, 0);
	}
	
	.login{
	    background-color: rgba(0, 25, 41, 0.7);
	    border-radius: 15px;
	    height: auto;
	    left: 35%;
	    padding: 30px;
	    position: absolute;
	    top: 20%;
	    width: 440px;
	    z-index: 5;
	}	
 
.prompt-error {
    background: url("${contextPath}/static/image/login/ico100.png") no-repeat scroll 0 0 rgba(0, 0, 0, 0);
    color: #ff8900;
    min-height: 30px;
    padding-left: 35px;
}
 
</style>

<body class="login-bg">
<div  id="supersized" class="row" style="margin-top:150px;margin-left: 200px ">
	<div class="col-sm-10 login" >
		<div class="login-container">
			<div class="space-6"></div>
			<div class="position-relative">
				<div id="login-box" class="login-box visible widget-box no-border">
					<div class="">
						<div class="widget-main">
							<h4 class="header blue lighter bigger">
								<i class="icon-coffee green"></i>
								管理后台
							</h4>
							<form name="loginForm" method="post"  class="form-vertical login-form "  id="loginForm">
							<div class="space-6"></div>

								<fieldset>
									<label class="block clearfix">
										<span class="block input-icon input-icon-right"  >
											<input id="j_username" name="j_username"  type="text" class="form-control" placeholder="账号" value="admin" />
											<i class="icon-user"></i>
										</span>
									</label>

									<label class="block clearfix">
										<span class="block input-icon input-icon-right">
											<input  name="j_password"  id="j_password" type="password" class="form-control" placeholder="密码" value="123456"/>
											<i class="icon-lock"></i>
										</span>
									</label>

									<div class="space"></div>
									    <div id="validate-error" class="text-warning bigger-110 orange prompt-error" style="display: none">
											<span>{{error_validate}}</span>
									    </div>
									    <div id="login-error" class="text-warning bigger-110 orange prompt-error" style="display: none">
											<span>{{error_login}}</span>
									    </div>
									 <div class="space"></div>
									<div class="clearfix">
										<button type="button"  style="height: 40px;width:215px;  font-size: 18px;left: 19%;" id="tijiao"   onclick="login()" class="btn btn-danger btn-block" >
											<i class="icon-key"></i>
											登录
										</button>
									</div>

								</fieldset>
						</form>
						</div><!-- /widget-main -->

					</div><!-- /widget-body -->
				</div><!-- /login-box -->

			</div><!-- /position-relative -->
		</div>
	</div><!-- /.col -->
</div><!-- /.row -->


<script>
	var  data={
	    error_login :'' ,
	    error_validate:''
	  };
	
	new Vue({
	  el: '#loginForm',
	  data:  data
	})
    var loginForm 	    = $('#loginForm');
    var error_validate  = $('#validate-error');
    var error_login 	= $('#login-error');
    
    /*****************执行登录方法*****************************/
	function login()  { 
		var j_username=$("#j_username").val();
		var j_password=$("#j_password").val();
		if(j_password==null||j_password==""||j_username==null||j_username==""){
			error_validate.show();
			error_login.hide();	
			data.error_validate="请输入用户名和密码";
			return;
		}
	    var options = {
			type: 'POST',   
			url: '${contextPath}/j_spring_security_check',
			success:  function(responseText, statusText){
				    if(responseText=="1105"){
				    	error_validate.hide();
				    	error_login.show();
				    	data.error_login="账户或密码错误！";
					}else if(responseText=="0000"){
						window.location.href="${contextPath}/forward?index";
					}
				} 
			};
		$('#loginForm').ajaxSubmit(options);
	}   
    </script>
</body></html>
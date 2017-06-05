<!--  没有系统权限 提示页面 -->

<%@ page language="java" pageEncoding="UTF-8"  isELIgnored="false"%>
<link rel="stylesheet" href="${contextPath}/static/bootstrap/css/bootstrap.css" type="text/css"/>
<script src="${contextPath}/static/js/jquery-2.0.3.min.js" type="text/javascript"></script>
<script src="${contextPath}/static/bootstrap/js/bootstrap.js" type="text/javascript"></script>
<link   type="text/css"   href="${contextPath}/static/bootstrap-model/css/bootstrap-dialog.css" rel="stylesheet"/>
<script  src="${contextPath}/static/js/bootbox.min.js" type="text/javascript" ></script>	
   <title>没有权限</title>
<script type="text/javascript">
	var msg="您没有操作此功能的权限！请找管理员索要权限！";
	$(document).ready(function(){
   		confirm();
	}); 
  	 function confirm(){
		bootbox.alert(msg);
	}
</script>

<%@ page language="java" pageEncoding="UTF-8"  isELIgnored="false"%>
	<%@ include file="/jsp/common/cssandjs.jsp"%>
<title>用户登录已超时</title>

<script type="text/javascript">
	 var msg="您长时间未操作系统，为确保您的资料及数据信息安全,系统自动超时退出，请重新登录系统！";
	$(document).ready(function(){
		bootbox.alert(msg,  function(){
			window.top.location ="/login.jsp";
		});
	}); 
</script>


<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/jsp/common/cssandjs.jsp"%>
<html>
  <head>
        <meta http-equiv="pragma" content="no-cache">
        <meta http-equiv="cache-control" content="no-cache">
        <meta http-equiv="expires" content="0">
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

	<script type="text/javascript">
	function alert(){
		bootbox.alert("您没有操作此功能的权限！请找管理员索要权限！");
	}
        </script>
  </head>
  
  <body>
  
  <a  class="btn" onclick="alert()">弹框测试</a>
  
<i class="fa fa-camera-retro fa-lg"></i> fa-lg
<i class="fa fa-camera-retro fa-2x"></i> fa-2x
<i class="fa-edit"></i> fa-3x
<i class="fa fa-camera-retro fa-4x"></i> fa-4x
<i class="fa fa-camera-retro fa-5x"></i> fa-5x
  
  
  
  </body>
</html>

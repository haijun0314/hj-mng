<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/jsp/common/taglibs.jsp"%>
<%@ include file="/jsp/common/cssandjs.jsp"%>
<script type="text/javascript">
$(document).ready(function(){
		$('[data-toggle=popover]').popover();
		$('[data-toggle=tooltip]').tooltip();
	});
</script>
  
  
  <body>
  		<button type="button" class="btn btn-lg btn-danger" data-toggle="popover" title="标题" data-content="很神奇吧!">点击</button>
  </body>
</html>

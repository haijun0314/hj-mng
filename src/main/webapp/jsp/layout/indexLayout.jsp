<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="d" uri="http://www.opensymphony.com/sitemesh/decorator" %>
<%@ include file="/jsp/common/cssandjs.jsp"%>
<head>
  <d:head />
  <title> 管理平台 </title>
</head>
<body>
	<%@ include file="/jsp/layout/inc/north.jsp"%>
	<div class="main-container-inner"> <d:body />
	</div>
 	<div>
	 	<%@ include file="/jsp/layout/inc/south.jsp"%>
	</div>
</body>
<script type="text/javascript"> 
	jQuery(function($) { 
		$(document).ready( function() { 
			$('.navbar-wrapper').stickUp(); 
		}); 
	});
</script>
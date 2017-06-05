<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="d" uri="http://www.opensymphony.com/sitemesh/decorator" %>
<%@ include file="/jsp/common/cssandjs.jsp"%>
<head>
   <d:head />
   <title> 管理平台 </title>
</head>
<meta name="keywords" content="管理平台" />
<meta name="description" content="管理平台" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />

 

<body>
	<%@ include file="/jsp/layout/inc/north.jsp"%>
	<div id="main-container" class="main-container">
		<div id="" class="main-container-inner">
		<%@ include file="/jsp/layout/inc/west.jsp"%>
		<div class="main-content">
  			 <div id="breadcrumbs" class="breadcrumbs">
				<ul class="breadcrumb">
					<li>
						<i class="icon-home home-icon"></i>
						<span id="menu_a"></span>
					</li>

					<li>
						<span id="menu_b" ></span>
					</li>
				</ul>
				
			</div>
			<div id="right"  class="page-content">
				<d:body></d:body>
			</div>
			
		</div>
	 	</div>
 	</div>
 	<%@ include file="/jsp/layout/inc/south.jsp"%>
	<div id="progressBar" class="progressBar" style="display: none; ">数据加载中，请稍等...</div> 
</body>

<script type="text/javascript"> 
	jQuery(function($) { 
		$(document).ready( function() { 
			$('.navbar-wrapper').stickUp(); 
		}); 
	});
</script>
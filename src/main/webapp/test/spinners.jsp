<!-- 加减框测试 -->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/jsp/common/cssandjs.jsp"%>

<script src="${contextPath}/static/js/fuelux.spinner.min.js"></script>

<script type="text/javascript">
	
/***************加减框***************************/
window.jQuery || document.write("<script src='${contextPath}/static/js/jquery-2.0.3.min.js'>"+"<"+"/script>");

jQuery(function($) {

	$('#spinner3').ace_spinner({value:0,min:-100,max:100,step:10, on_sides: true, icon_up:'icon-plus smaller-75', icon_down:'icon-minus smaller-75', btn_up_class:'btn-success' , btn_down_class:'btn-danger'});
			
});
	
</script>


<div class="widget-main">
		<input type="text" class="input-mini" id="spinner3" />
	</div>


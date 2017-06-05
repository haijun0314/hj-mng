<!-- bootstrap  时间插件测试 -->

<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/jsp/common/cssandjs.jsp"%>
<script type="text/javascript">
	jQuery(function($) {
		$('.date-picker').datepicker({autoclose:true}).next().on(ace.click_event, function(){
			$(this).prev().focus();
		});
	});
    $(function () {
        initdatepicker_cn();
        $('#mydate').datepicker({
            inline: true
        });
    });
</script>
   
<div class="input-group">
	<input id="id-date-picker-1" class="form-control date-picker" type="text" data-date-format="dd-mm-yyyy">
		<span class="input-group-addon">
			<i class="icon-calendar bigger-110"></i>
		</span>
</div>
<div class="input-group">
	<input type="text" name="mydate" id="mydate" />
</div>
 
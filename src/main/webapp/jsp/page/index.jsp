 <%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
 <%@ include file="/jsp/common/taglibs.jsp"%>
<style>
.styleLayout {
    line-height: 140px;
	font-size: 24px;
	color: #ffffff;
</style>
<script type="text/javascript">
$(document).ready(function(){
	});
function urlRequest( url){
	AjaxRequest.urlRequest(url+'&ajax=true' ,"right");
}


</script>
<div class="clearfix row-main">
<div id="shortcutBox" class="container">
 <div class="row" style="padding-top: 60px;padding-left: 60px">
 	<div class="col-md-3 col-sm-3 btn btn-primary  styleLayout" onclick="urlRequest('/orderinfo?gridView')">
 		<div class="">
 			查询订单
 		</div>
 	
 	</div>
 	<div class="col-md-3 col-sm-3 btn  btn-success styleLayout" style="margin-left: 20px;" onclick="urlRequest('/customer?customerGridView')">
 		<div class="">
 			查询用户
 		</div>
 	
 	</div>
 	<div class="col-md-3 col-sm-3  btn btn-warning styleLayout" style="margin-left: 20px;"onclick="urlRequest('/money/moneyChange?gridView')">
 		<div class="">
 			查询充值
 		</div>
 	
 	</div>
 
 
 	<div class="col-md-3 col-sm-3 btn btn-default styleLayout"  style="margin-top: 20px"onclick="urlRequest('/monery/moneyWithdraw?gridView')">
 		<div class="">
 			查询提现
 		</div>
 	
 	</div>
 	<div class="col-md-3 col-sm-3 btn  btn-info styleLayout" style="margin-left: 20px; margin-top: 20px" onclick="urlRequest('/orderinfo?commonlyGridView')" >
 		<div class="">
 			查询常用单
 		</div>
 	
 	</div>
 	<div class="col-md-3 col-sm-3  btn btn-danger styleLayout" style="margin-left: 20px;margin-top: 20px"onclick="urlRequest('/activity?gridView')">
 		<div class="">
 			查询活动
 		</div>
 	
 	</div>
 </div>
 </div>
 </div>

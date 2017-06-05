<!-- 开放区域查询页面 -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<script src="${contextPath}/static/logic/dict/dictArea.js" type="text/javascript"></script>
<script type="text/javascript">

$(document).ready(function(){
	DictAreaUtil.loadSheng();
	validate_Form();//初始化表单验证
});

/***************请求查询***************************/
function searchSubmit(){
	 AjaxRequest.urlRequest("/dict/dictArea?dicrOpenCityView&ajax=true&viewflag=0","tblist");
}
/***************启用，停用城市 **********************/
function updateServiceStatus(cityCode,operType){
	
	bootbox.confirm("确认要改变该城市状态吗?", function(result) {
		if(result) {
			var  url ="${contextPath}/dict/dictArea?startOrStop_city&cityCode="+cityCode+"&operType="+operType;
	 		AjaxRequest.urlRequestWithMsg(url,searchSubmit);
			}
		});
}
/***************开放区域添加**********************/	
function openCityAdd(){
	$("#cityName").val($("#shi").find("option:selected").text());
	$("#cityCode").val($("#shi").val());
	$("#shengName").val($("#sheng").find("option:selected").text());
	
if($("#openCityForm").valid()){
	AjaxRequest.submitFormForLocalModel("openCityForm","myModal",searchSubmit);//提交数据表单
  }
}
/******************表单验证****************************/
function validate_Form(){
   var validateForm  = $("#openCityForm");
   validateForm.validate({
     
       rules:{
			shengCode:{required:true},
			telPhone:{required:true,telePhone:true},
      },
      messages:{
      		shengCode:{
      			required:"请选择区域"
      		},
      		telPhone:{
      			required:"请填写手机号码"
      		},
      },
   });		
}
</script>

<div class="clearfix form-search" style="height: 80px;">
	<form id="searchForm" >
		<div class=" col-sm-5">
	     	<button class="btn btn-info" data-toggle="modal" data-target="#myModal" type="button"  >
			  		添加
		     		<i class="icon-plus icon-on-right"></i>
	   		</button>
	   	</div>
	</form> 
</div>
<div id="tblist">
	<%@ include file="dictOpenCityList.jsp"%>
</div>

<!-- 弹出Modal -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
        <h4 id="myModalLabel">开放区域添加</h4>
      </div>
      
      <div class="modal-body">
		<form action="${contextPath}/dict/dictArea?openCityAdd&ajax=true&viewflag=0" class="form-horizontal" role="form" id="openCityForm"name="openCityForm">
				<input type="hidden" name="cityName" id="cityName"/>
				<input type="hidden" name="cityCode" id="cityCode"/>
				<input type="hidden" name="shengName" id="shengName"/>
				<div class="form-group">
					<label for="sheng"
						class="col-sm-3 control-label no-padding-right"><b class="star_red">*</b>开放省份</label>
					<div class="col-sm-9">
						<select class="col-xs-10 col-sm-9" id="sheng" class="form-control"  name="shengCode" onchange="DictAreaUtil.loadShi()">
							<option value="">请选择区域</option>
						</select>
					</div>
				</div>
				<div class="form-group">
					<label for="shi"
						class="col-sm-3 control-label no-padding-right">开放区域</label>
					<div class="col-sm-9">
						<select class="col-xs-10 col-sm-7" id="shi" name="shiCode" >
							<option value="">请选择区域</option>
						</select>
					</div>
				</div>
				<div class="form-group">
					<label for="telPhone"
						class="col-sm-3 control-label no-padding-right"><b class="star_red">*</b>联系电话</label>
					<div class="col-sm-9">
						<input type="text" class="col-xs-10 col-sm-7" id="telPhone" name="telPhone">
					</div>
				</div>
				<div class="form-group">
					<label for="contact"
						class="col-sm-3 control-label no-padding-right">联系人</label>
					<div class="col-sm-9">
						<input type="text" class="col-xs-10 col-sm-7" id="contact" name="contact">
					</div>
				</div>
				<div class="form-group">
					<label for="address"
						class="col-sm-3 control-label no-padding-right">地址</label>
					<div class="col-sm-9">
						<input type="text" class="col-xs-10 col-sm-7" id="address" name="address">
					</div>
				</div>
				<div class="form-group">
					<label for="qq"
						class="col-sm-3 control-label no-padding-right">QQ</label>
					<div class="col-sm-9">
						<input type="text" class="col-xs-10 col-sm-7" id="qq" name="qq">
					</div>
				</div>
			</form>	
			
      </div>
      <div class="modal-footer">
      	<button type="button" class="btn btn-primary" onclick="openCityAdd()" ><i class="glyphicon glyphicon-ok"></i>确定</button>
        <button type="button" class="btn btn-default btn-danger" data-dismiss="modal"><i class="glyphicon glyphicon-remove"></i>取消</button>
      </div>
    </div>
  </div>
</div>

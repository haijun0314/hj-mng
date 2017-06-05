<!-- 品牌搜索框 -->
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<html>
  <head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
  </head>
  <script src="${contextPath}/static/logic/dict/dictArea.js" type="text/javascript"></script>
  <script type="text/javascript">
  
  $(document).ready(function(){
	DictAreaUtil.loadSheng();
	 
});


/***************请求查询***************************/
function searchSubmit(){
	 var conditionstr="&"+$('#searchForm').formSerialize();
	 var data=encodeURI(conditionstr); 
	 AjaxRequest.urlRequest("/dict/dictArea?gridView&ajax=true&viewflag=1"+data,"tblist");
}



  </script>
  <body>
    <div class="clearfix form-search" style="height: 80px;">
	<form  id="searchForm" >
		<div class="row">
			<div class="col-sm-4">
				<input type="text" placeholder="区域名" class="form-control" name="areaname">
			</div>
			<div class=" col-sm-3">
				<select  name="ShengCode" class="form-control"  id="sheng" onchange="DictAreaUtil.loadShi()">
					<option  value=""> 选择区域</option>
				</select>
			</div>
			<div class=" col-sm-3">
				<select  name="ShiCode" class="form-control"  id="shi">
					<option  value=""> 选择区域</option>
				</select>
			</div>
			<div class=" ">
					<button class="btn btn-purple " type="button" onclick="searchSubmit()">
						查询
						<i class="icon-search icon-on-right"></i>
					</button>
					
			</div>
		</div>
	</form> 	
</div>
<div id="tblist">
	<!-- 连接test2一起显示 -->
	<%@ include file="dictAreaList.jsp"%>
</div>
  </body>
</html>

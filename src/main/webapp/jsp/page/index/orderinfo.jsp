<!-- 最新5笔订单-->
<%@ page language="java" contentType="text/html; charset=UTF-8" %>
 <style>
.table {
  width: 100%;
  max-width: 100%;
}
</style>
 <script type="text/javascript">
$(document).ready(function() {
	 
	
});
function urlRequest( url){
	window.location=url;
}
/*********添加链接************/
function orderInfo(orderId){
	BootstrapDialog.show({
		 title:'订单详情',
        message: $("<div></div>").load("/orderinfo?orderinfoDetail&Ajax=true&orderId="+orderId)//加载远程地址
     });
}

</script>
	<div class="table-responsive  "  id="ttt">
	</div>
<script id="orderinfo" type="x-handlebars-template">
 
<div class="widget-main no-padding">
<table id="dataList" class="table table-striped table-bordered table-hover">
				<thead class="thin-border-bottom">
					<tr>
						<td class="hidden-480">发布人</td>
						<td class="hidden-480">发布时间</td>
						<td class="hidden-480">交易金额</td>
						<td class="hidden-480">类型</td>
					</tr>
				</thead>
				<tbody>
					{{#each orderinfo}}
      			 	<tr>
						<td>
						<a href="#" onclick="orderInfo('{{orderId}}')"><i ></i>{{telephone}}</a>
						</td>
						<td>{{createdTime}}</td>
          				<td>{{rewardLow}}--{{rewardUp}}</td>
						<td>
							<span class="badge badge-pink">{{serviceBigType}}</span> 
							<span class="badge badge-info">{{serviceName}}</span> 
						</td>
         			</tr> 
       				{{/each}}
				</tbody>
</table>
</div>
 
</script>	
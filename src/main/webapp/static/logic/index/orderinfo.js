var OrderinfoUtil = {
		/********************最新订单数据***********************************/
		loadOrderinfo : function() {
			var htmlStr = "<table class='table table-striped table-bordered table-hover table-condensed' style='table-layout:fixed'>";   
			htmlStr += "<tr>";
			htmlStr += "<th style='height: 50px'>";
			htmlStr += "交易金额";
			htmlStr += "</th>";
			htmlStr += "<th style='height: 50px'>";
			htmlStr += "类型";
			htmlStr += "</th>";
			htmlStr += "<th style='height: 50px'>";
			htmlStr += "状态";
			htmlStr += "</th>";
			htmlStr += "</tr>";
			htmlStr += "</table>";
			$("#ttt").html(htmlStr);
			AjaxRequest.httpPost(
					"/orderinfo?newOrderinfo",
					{
					},
					function(result) {
						 $.each(result,function(idx,item){
							 var newRow = "<tr><td style='height: 30px'>" + item.tradeMoney + "</td><td style='height: 30px'>"
								+ item.serviceBigType + "</td><td style='height: 30px'>"
								+ item.status + "</td>"+"</tr>";
							 $("#ttt tr:last").after(newRow);
						 });
					});
			}, 
			/********************最新订单数据***********************************/
			loadNewOrderInfo : function() {
				
				AjaxRequest.httpPost(
						"/orderinfo?newOrderinfo",
						{
							 
						},
						function(result) {
							 var  newOrderinfo = Handlebars.compile($("#orderinfo").html());
							 var  data=result;
							 alert(data)
							 $('#ttt').append(newOrderinfo(data));
						});
				}  ,
				
				
};

 
var StatUtil = {
			/********************获取总订单数和总金额***********************************/
			loadInfo : function() {
				var conditionstr="&"+$('#searchForm').formSerialize();
				 var data=encodeURI(conditionstr); 
				AjaxRequest.httpPost(
						"/orderinfo?getStat"+data,
						{
							 
						},
						function(result) {
							 var totalCount=$("#totalCount");
							 var totalMoney=$("#totalMoney");
							 
							 totalCount.append('<span > '+result.totalCount+'</span>');
							 totalMoney.append('<span > '+result.totalMoney+'</span>');
							 
						});
				}, 
 
				
};
var MsgUtil = {
			/********************未审核活动订单数***********************************/
			loadStat : function() {
				AjaxRequest.httpPost(
						"/activityStat?getActivityStat",
						{
							 
						},
						function(result) {
							 var activity=$("#activity");
							 var activityStat=$("#activityStat");
							 activity.append('<span > '+result.activityStat+'</span>');
							 activityStat.append('<span > '+result.activityStat+'</span>');
						});
				}, 
};
 
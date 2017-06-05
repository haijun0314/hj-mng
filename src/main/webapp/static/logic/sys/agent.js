var AgentUtil = {
		/********************省级加载下拉框数据***********************************/
		loadAgent : function() {
			AjaxRequest.httpPost(
					"/agent?loadAgent",
					{
						 
					},
					function(result) {
						 var agentId=$("#agentId");
						 $.each(result,function(idx,item){
							 agentId.append('<option value='+item.agentId+'> '+item.agentName+'</option>');
						 });
						
					});
			}
			 
};
var DictAreaUtil = {
		/********************省级加载下拉框数据***********************************/
		loadSheng : function() {
			 
			AjaxRequest.httpPost(
					"/dict/dictArea.do?getAreaList&pcode=000000",
					{
						 
					},
					function(result) {
						 var sheng=$("#sheng");
						 $.each(result,function(idx,item){
							 sheng.append('<option value='+item.areaCode+'> '+item.areaName+'</option>');
						 });
						
					});
			}, 
			/********************市级加载下拉框数据***********************************/	
		loadShi : function() {
			   var sheng = $("#sheng").val();
			   $("#shi").empty();
				 var shi=$("#shi");
				 shi.append("<option value=''>请选择</option>");
			   if(sheng==null||sheng==''){
				   return ;
			   }
			   AjaxRequest.httpPost(
						"/dict/dictArea.do?getAreaList&pcode="+sheng,
						{
							
						},
						function(result) {

							 $.each(result,function(idx,item){
								 shi.append('<option value='+item.areaCode+'> '+item.areaName+'</option>');
							 });
				});
					
		}, 
		/********************开放城市加载下拉框数据***********************************/
		loadOpenCity:function(url ,id){
			if(url==null){
				url="/dict/dictArea.do?getOpenCityList";
			}
			if(id==null){
				id="cityCode";
			}
			AjaxRequest.httpPost(
				url,
				{
					
				},
				function(result){
					var cityCode = $("#"+id);
					$.each(result,function(idx,item){
						 cityCode.append('<option value='+item.cityCode+'> '+item.cityName+'</option>');
					 });
				}
			);
		},
				
};
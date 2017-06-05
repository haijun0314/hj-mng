/***************个人订单数详情**********************/
function customerInfo(customerId){
	 BootstrapDialog.show({
		 title:'用户详情',
         message: $("<div></div>").load("/customer?customerInfo&Ajax=true&customerId="+customerId)//加载远程地址
     });
}

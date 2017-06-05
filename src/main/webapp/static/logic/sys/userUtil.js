
 
var UserUtil = {
		/********************加载登陆用户数据***********************************/
		loadLoginUser : function() {
			AjaxRequest.httpPost(
				"/sys/environment?loadUser",
				{
					 
				},
				function(result) {
					 var  user=result.data;
					 $(".login_user_name").text(user.userName);
					 $("#userType").val(user.userType)
				});
		} ,
		/******************检查用户名**********************************/
		checkName : function() {
			 var userName=$('#userName').val();
			 var  url ="/sys/sysUser?checkUserName&userName="+userName;
			 AjaxRequest.urlRequestWithMsg(url);
		},
		/***************删除用户***************************/
		deleteUser: function(userId){
			bootbox.confirm("确认要删除吗?", function(result) {
				if(result) {
					var  url ="/sys/sysUser?delete&userId="+userId;
					AjaxRequest.urlRequestWithMsg(url,searchSubmit) ;
					}
				});
		},
		/***************更新系统用户**********************/	
		 update :function(userId){
			 BootstrapDialog.show({
				 title:'更新系统用户',
		         message: $('<div></div>').load('/sys/sysUser?update&Ajax=true&userId='+userId),//加载远程地址
		         buttons: [{
		             label: '确定',
		             icon: 'glyphicon glyphicon-ok',
		             cssClass: 'btn-primary',
		             action: function(dialog) {
		                 if($('#userForm').valid()){
		                 	AjaxRequest.submitFormForModel("userForm",dialog);//提交数据表单
		                 	searchSubmit();//查询数据
		                 }
		             }
		         }, {
		             label: '取消',
		             icon: 'glyphicon glyphicon-remove',
		             cssClass: 'btn-danger',
		             action: function(dialog) {
		            	 dialog.close();
		             }
		         }]
		     });
		},
		/***************用户详情*********************/	
		 detail:function(userId){
			 BootstrapDialog.show({
				 title:'用户详情',
		         message: $('<div></div>').load('/sys/sysUser?detail&Ajax=true&userId='+userId)//加载远程地址
		     });
		},		
		 
		/***************重置密码**********************/	
		 resetPassword:function(userId){
			bootbox.confirm("确认要重置密码吗?", function(result) {
				if(result) {
					var  url ="/sys/sysUser?resetPassword&userId="+userId;
					AjaxRequest.urlRequestWithMsg(url,searchSubmit) ;
					}
				});
		},
		/***************启用，停用服务类型**********************/
		 startOrStop:function(userId,operType){
			bootbox.confirm("确认要改变该状态吗?", function(result) {
				if(result) {
					var  url ="/sys/sysUser?startOrStop&userId="+userId+"&operType="+operType;
					AjaxRequest.urlRequestWithMsg(url,searchSubmit) ;
					}
				});
		},	
		/*********修改密码**********/
		 setPassword :function(){
			BootstrapDialog.show({
				 title:'修改密码',
		         message: $('<div></div>').load("/sys/sysUser?setPassword&Ajax=true"),//加载远程地址
		         buttons: [{
		             label: '确定',
		             icon: 'glyphicon glyphicon-ok',
		             cssClass: 'btn-primary',
		             action: function(dialog) {
		                 if($('#changePwdForm').valid()){
		                 	AjaxRequest.submitFormForModel("changePwdForm",dialog,null);//提交数据表单
		                 }
		             }
		         }, {
		             label: '取消',
		             icon: 'glyphicon glyphicon-remove',
		             cssClass: 'btn-danger',
		             action: function(dialog) {
		            	 dialog.close();
		             }
		         }]
		     });
		},
		/***************退出登录*********************/
		logout:function(){
			var  url="${contextPath}/j_spring_security_logout";
			window.location.href=url;
		},	
		/*************个人资料********/
		userInfo:function(){
			BootstrapDialog.show({
				 title:'用户详情',
		         message: $('<div></div>').load("/sys/sysUser?myInfo&Ajax=true")//加载远程地址
		     });
		},	
		/************个人设置*******/
		mySet:function(){
			BootstrapDialog.show({
				 title:'用户设置',
		         message: $('<div></div>').load("/sys/sysUser?mySet&Ajax=true"),//加载远程地址
		         buttons: [{
		             label: '确定',
		             icon: 'glyphicon glyphicon-ok',
		             cssClass: 'btn-primary',
		             action: function(dialog) {
		                 if($('#userForm').valid()){
		                 	AjaxRequest.submitFormForModel("userForm",dialog,null);//提交数据表单
		                 }
		             }
		         }, {
		             label: '取消',
		             icon: 'glyphicon glyphicon-remove',
		             cssClass: 'btn-danger',
		             action: function(dialog) {
		            	 dialog.close();
		             }
		         }]
		     });
		},	
		 
};
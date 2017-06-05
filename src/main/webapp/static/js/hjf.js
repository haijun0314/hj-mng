

var HJF = {
	baseUrl:'localhost:8080',
	/**
	 * 列表分页
	 * curPage:当前页 totalPage：总页数 url：数据地址 pagerId  展示分页块儿的id listDivId:刷新块儿Id
	 */
		
	pageRequest : function(curPage,totalPage,url,formId ,pagerId,listDivId){
		if(pagerId==null){
			pagerId="pager";
		}
		if(listDivId==null){
			listDivId="tblist";
		}
		var data=""; 
		if(formId){
			var conditionstr="&"+$('#'+formId).formSerialize();
			data=encodeURI(conditionstr); 
		}
		
		var options = {
		        currentPage: curPage,
		        totalPages: totalPage,
		        alignment:'right',
		        onPageClicked: function(e,originalEvent,type,page){
		            AjaxRequest.urlRequest(url+"&page="+page+data,listDivId);
		        }
		    };
		 $('#'+pagerId).bootstrapPaginator(options);
	},
	// 获取指定名称的cookie的值
	getCookie : function(cookieName) {
		var cookies = this.getCookies();
		if (cookies == null) {
			return null;
		} else {
			for (var i = 0; i < cookies.length; i++) {
				if (cookies[i].cookieName == cookieName) {
					return cookies[i].cookieValue;
				}
			}
			return null;
		}
	},
	
	// 获取所有cookie
	getCookies : function() {
		var cookieStr = document.cookie;
		if (cookieStr == "") {
			return null;
		} else {
			var cookies = [];
			var cookieParts = cookieStr.split("; ");
			for (var i = 0; i < cookieParts.length; i++) {
				var cookiePart = cookieParts[i].split("=");
				var cookie = new Object();
				cookie.cookieName = cookiePart[0];
				cookie.cookieValue = unescape(cookiePart[1]);
				cookies.push(cookie);
			}
			return cookies;
		}
	},
	
	//开始日期，结束日期查询框
   initDate:function(){
		$('.date-picker').datepicker({autoclose:true}).next().on(ace.click_event, function(){
			$(this).prev().focus();
		}); 
		$('#id-date-picker').addClass("hjf"); 
   },
   /**
    * 复选框 多选，单选  
    * 列表之前的复选框  选中 取消事件  显示隐藏  功能按钮组
    * @param btns_id：按钮所属div  Id  
    */
   toggle_btns_checkBox:function(btns_id){
	 //判断btns_id，如果为空，则是默认值btns_oper(btns_id为成功失败按钮的id)
	   if(btns_id==null){                     
		   btns_id= "btns_oper";
	   }
	   //表头的复选框  操作  
	   $('table th input:checkbox').on('click' , function(){  
			var that = this;
			$(this).closest('table').find('tr > td:first-child input:checkbox')
			.each(function(){
				this.checked = that.checked;
				$(this).closest('tr').toggleClass('selected');
			});
		 	var ret=false;
			$("input[type=checkbox]").each(function(){
				if(this.checked){
					ret=true;
				}
			}); 
		 	if(ret){
		 	 	$("#"+btns_id).show();
		 	}else{
		 		$("#"+btns_id).hide();
		 	}
		});
	    ////列表的td 的复选框  操作  
		$('table td input:checkbox').on('click' , function(){  
		 	var ret=false;
			$("input[type=checkbox]").each(function(){    
				//遍历选中checkbox，如果选中返回true，如果没选中返回false
				if(this.checked){
					ret=true;
				}
			}); 
			//如果有选中的checkbox，则显示成功失败按钮，如果没选中的checkbox，则隐藏成功失败按钮
		 	if(ret){                      
		 		
		 	 	$("#"+btns_id).show();
		 	}else{
		 		$("#"+btns_id).hide();
		 	}
		});	 
   },
   /***************请求查询***************************/
   /**
    * 此方法为定页查询
    * 首先定义默认页数为第一页，传入一个变量type,判断type是否为空或者是否为undefined，如果为空或者undefined，页数为当前页  比如 更新  编辑操作   
    * 如果不为空或者undefined， 则 跳转到第一页，比如添加操作 查询
    *  
    */
    searchSubmit:function(url,type,listDivId){
    	var curPage=1;               //默认定义页数为第一页
    	if(listDivId==null){
    		listDivId="tblist";
    	}
    	if(type==null||type==undefined){              
    		//判断type，如果为空，页数为当前页  比如 更新  编辑操作   
    		//停留在操作页面   否则 跳转到第一页，比如添加操作  
    		curPage=$("#curPage_").val();
    	} 
   	 	AjaxRequest.urlRequest(url+"&ajax=true&reqType=1&page="+curPage,listDivId);  
   }	
	

};



/**
 * ajax 请求统一处理
 */
var AjaxRequest = {
		
	getJson : function(requestUrl ,callback){
		$.getJSON( requestUrl,callback);
	},	
	httpPost: function(url, data, callback) {
		$.ajax({
			type : 'post',
			url : url,
			cache : false,
			data : JSON.stringify(data),
			contentType : "application/json",
			dataType : "json",
			success : function(result) {
				callback(result);
			},
			error : function() {
				
			}
		});
	},	
	
	
	/**
	 * url请求
	 * @param requestUrl
	 * @param updatePanel
	 * @param callback
	 */
	urlRequest : function(requestUrl ,updatePanel,callback){
		var ajaxbg = $("#progressBar");
		$.ajax({
			url:requestUrl,
			success : function(responseText){
				if(updatePanel){
					$('#'+updatePanel).html(responseText);
				}
			},
			error : function(XMLHttpRequest, textStatus, errorThrown){
				AjaxRequest.onFailure(XMLHttpRequest);
			},
			complete : function(XMLHttpRequest,textStatus,responseText){
				AjaxRequest.onComplete(textStatus,callback,responseText);
				ajaxbg.hide();
			},
			beforeSend:function(){
				ajaxbg.show();
			}
		});
	},		
	/**
	 * url请求
	 * @param requestUrl
	 * @param updatePanel
	 * @param callback
	 */
	urlRequestWithMsg : function(requestUrl,callback){
		$.ajax({
			url:requestUrl,
			success : function(responseText){
				resultMsg('info',responseText);
				if(callback){
					callback(responseText);
				}
			},
			error : function(XMLHttpRequest, textStatus, errorThrown){
				AjaxRequest.onFailure(XMLHttpRequest);
			} 
		});
	},
	
	/**
	 * 打开子页面
	 * @param requestUrl
	 * @param width
	 * @param height
	 * @param title
	 */
	openUrl : function(requestUrl,width,height,title){
		$.ajax({
			url:requestUrl,
			
			success : function(responseText){
				ZMessage.Page(responseText,width,height,title);
			},
			
			error : function(XMLHttpRequest, textStatus, errorThrown){
				AjaxRequest.onFailure(XMLHttpRequest);
			}
			
		});
	},
	/**
	 * 表单请求【bootstrap 弹出框表单提交  远程URL】
	 * @param form
	 * @param callback
	 * @param reset
	 */
	submitFormForModel : function(form , dialog,callback){
		 var options = {
				type: 'POST', 
				success: function(responseText,textStatus){
					if(dialog){
						dialog.close();
					}
					
					if(callback){
						callback(responseText);
					}
					
					resultMsg('info',responseText);
					
				}
		 };
		 $('#'+form).ajaxSubmit(options);
	},	
	/**
	 * 表单请求【bootstrap 弹出框表单提交  本页面div弹框】
	 * @param form
	 * @param callback
	 * @param reset
	 */
	submitFormForLocalModel : function(form , modelId,callback){
		 var options = {
				type: 'POST', 
				success: function(responseText,textStatus){
					if(modelId){
						$('#'+modelId).modal('hide');
					}
					
					if(callback){
						callback(responseText);
					}
					
					resultMsg('info',responseText);
					
				}
		 };
		 $('#'+form).ajaxSubmit(options);
	},	
	/**
	 * 表单请求
	 * @param form
	 * @param updatePanel
	 * @param callback
	 * @param reset
	 */
	formRequest : function(form , updatePanel , callback, reset){
		var self = this;
		this.callback = callback;
		this.updatePanel = updatePanel;
		this.reset = reset;
		 var options = {
				type: 'POST', 
				success: function(responseText,textStatus){
					AjaxRequest.onSuccess(responseText,textStatus,self.updatePanel, self.callback);
				}
		 };
		 $('#'+form).ajaxSubmit(options);//ajax提交
	},
	
	
	/**
	 * 请求前操作
	 */
	beforeRequest : function(){
		
	},
	
	/**
	 * 请求后操作
	 * @param data
	 */
	afterRequest : function(data){
		 
	},

	
	/**
	 * form请求成功处理
	 * @param responseText
	 * @param textStatus
	 * @param updatePanel
	 * @param callback
	 */
	onSuccess : function(responseText,textStatus,updatePanel,callback){//成功
		if(responseText.success==false){//是否存在错误信息
			AjaxRequest.onComplete("error",callback);
			AjaxRequest.onFailure(responseText);
		}else{
			AjaxRequest.onComplete(textStatus,callback, responseText);
			resultMsg("success",responseText);
			if(updatePanel){
				$('#'+updatePanel).html(responseText);
			}
		}
	},
	
	/**
	 * 失败处理
	 * @param data
	 */
	onFailure : function(data){
		resultMsg("error",data);
		
	},

	
	/**
	 * 完成处理,主要用于操作回调函数
	 * @param textStatus
	 * @param callback
	 * @param responseText
	 */
	onComplete : function(textStatus,callback, responseText){
		if (textStatus == 'success') {
			flag = true;
		} else {
			flag = false;
		}
		if (callback) {
			callback(flag,responseText);//回调函数
		} 
	},

	/**
	 * 完成处理,主要用于操作回调函数
	 * @param type
	 */
	ajaxloading : function(type){
 		var loader = $("<div id='progressBar' class='progressBar'>数据加载中，请稍等...</div>"); 
 		loader.css("progressBar");
 		if(type==1){
 		loader.show();
 		}else{
 		loader.hide();
 		}
 		
	}
};

function resultMsg(type,responseText) {
    var opts = {
        title: "",
        text: responseText.msg,
        addclass: "stack-bar-top" 
    };
    switch (type) {
    case 'error':
        opts.title = "操作错误";
        opts.type = "error";
        break;
    case 'info':
        opts.title = "";
        opts.type = "info";
        break;
    case 'success':
        //opts.title = "操作成功";
        opts.type = "success";
        break;
    }
    $.pnotify(opts);
} 
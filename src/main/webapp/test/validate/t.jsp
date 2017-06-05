<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/jsp/common/cssandjs.jsp"%>
	
<script type="text/javascript">
$(document).ready(function(){
	 
	 
});

function addSysUser_open(){
	 BootstrapDialog.show({
		title:'添加用户',
		message: $('<div></div>').load('/sys/sysUser?add&ajax=true'),
        buttons: [{
            label: '确定',
            icon: 'glyphicon glyphicon-ok',
            cssClass: 'btn-primary',
            action: function(dialog) {
            if($('#userForm').valid()){
            	AjaxRequest.submitFormForModel  ("userForm",dialog);
            }
          
               
            }
        }, {
            label: '取消',
            icon:'glyphicon glyphicon-remove',
            cssClass: 'btn-danger',
            action: function(dialog) {
           	 	dialog.close();
            }
        }]
    });
}	

/******************表单提交     关闭model ****************************/
function  submitForm  (form,dialog){
	AjaxRequest.formRequest("userForm",null,function(flag){
		if(flag){
			dialog.close();
		}
	});
}

</script>


<body>

<a onclick="addSysUser_open()">Click me</a>
 
</body>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/jsp/common/cssandjs.jsp"%>
<script type="text/javascript">
$(document).ready(function(){
	 
});
 
function  model_local(){

$('#myModal').modal( );

}
 
function model_remote(roleId){
	 BootstrapDialog.show({
		 title:'更新系统角色',
         message: $('<div></div>').load('/sys/role?update&Ajax=true&roleId='+roleId),//加载远程地址
         buttons: [{
             label: '确定',
             icon: 'glyphicon glyphicon-ok',
             cssClass: 'btn-primary',
             action: function(dialog) {
                  var $button = this; 
                  $button.disable();
             
                 if($('#sysRoleForm').valid()){
                 	//AjaxRequest.submitFormForModel("sysRoleForm",dialog,searchSubmit);//提交数据表单
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
} 
 
 
</script> 

<!-- Button trigger modal -->
<button type="button" class="btn btn-primary btn-lg" data-toggle="modal"  onclick="model_local()">
  Local
</button>
<button type="button" class="btn btn-primary btn-lg" data-toggle="modal"  onclick="model_remote(1)">
  model_remote
</button>
<!-- Modal -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
        <h4 class="modal-title" id="myModalLabel">Modal title</h4>
      </div>
      <div class="modal-body">
        ...
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        <button type="button" class="btn btn-primary">Save changes</button>
      </div>
    </div>
  </div>
</div>

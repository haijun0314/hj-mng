 <!-- 系统角色权限分配管理页面 -->
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<head>
<link rel="stylesheet" href="${contextPath}/static/ztree/css/zTreeStyle/metro.css">
<script src="${contextPath}/static/ztree/js/jquery.ztree.all-3.5.min.js"></script>
</head>
<body>
<script>
    var zTree;
    var demoIframe;
    var setting = {
        check: {
            enable: true
        },
        
        data: {
            simpleData: {
                enable:true,
                idKey: "id",
                pIdKey: "pId",
                rootPId: ""
            }
        },
        callback: {
           
        }
    };
    var tree;
    $(document).ready(function(){
    	   var roleId=$("#roleId").val();
	       AjaxRequest.getJson("/sys/security?treeView&roleId="+roleId,function(data){
	       var t = $("#tree");
	        zTree = $.fn.zTree.init(t, setting, data);

	     });
    });
    /******************全选****************************/
   function checkAllNodes(){
        var treeObj = $.fn.zTree.getZTreeObj("tree");
        treeObj.checkAllNodes(true);
    }
    /******************全选****************************/
   function cancelAllNodes() {
        var treeObj = $.fn.zTree.getZTreeObj("tree");
        treeObj.checkAllNodes(false);
    }
</script>
<ul id="tree" class="ztree" style="width:560px; overflow:auto;"></ul>

<form action="${contextPath}/sys/role?permission&ajax=true&reqType=2" class="form-horizontal" role="form"  id="permissionForm" name="permissionForm">
<input  id="roleId" name="roleId" value="${roleId }" type="hidden">
<input id="ids" name="ids" value="" type="hidden">
<input type="button" value="全选" onclick="checkAllNodes()">
<input type="button" value="反选" onclick="cancelAllNodes()">
</form>

</body>
</html>
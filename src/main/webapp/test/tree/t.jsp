<!-- ztee  测试 -->
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<head>
<script src="${contextPath}/static/js/jquery-2.0.3.min.js" type="text/javascript"></script>
<link rel="stylesheet" href="${contextPath}/static/ztree/css/zTreeStyle/metro.css">
<script src="${contextPath}/static/ztree/js/jquery.ztree.all-3.5.min.js"></script>
<script src="${contextPath}/static/js/ajaxRequest.js" type="text/javascript"></script>
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

    $(document).ready(function(){
     AjaxRequest.getJson("/sys/security?treeView&roleId=1",function(data){
     alert(data)
        var t = $("#tree");
        t = $.fn.zTree.init(t, setting, data);
     });

    });
   
</script>
<ul id="tree" class="ztree" style="width:560px; overflow:auto;"></ul>
 

</body>
</html>
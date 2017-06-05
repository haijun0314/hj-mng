<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>  
<%   
String basePath = request.getContextPath();   
%>  
<html>  
  <head>  
    <meta http-equiv="pragma" content="no-cache">  
    <meta http-equiv="cache-control" content="no-cache">  
    <meta http-equiv="expires" content="0">       
<link rel="stylesheet" type="text/css" href="<%=basePath%>/theme/CSS/uploadify.css"/>  
<script type="text/javascript" src="<%=basePath%>/JS/jquery-1.7.1.js"></script> 
<script type="text/javascript" src="<%=basePath%>/JS/jquery.uploadify-3.1.js"></script>   
<script type="text/javascript" src="<%=basePath%>/JS/zDrag.js"></script>
<script type="text/javascript" src="<%=basePath%>/JS/zDialog.js"></script> 
       
    <script type="text/javascript">  
        $(document).ready(function() {   
            $("#fileUpload").uploadify({   
                /*注意前面需要书写path的代码*/   
                'swf'            : '<%=basePath%>/JS/flash/uploadify.swf',   
                'uploader'       : '<%=basePath%>/upload.up',   
                'cancelImg'      : '<%=basePath%>/theme/images/cancel.png',   
                'queueID'        : 'fileQueue', //和存放队列的DIV的id一致   
                'fileDataName'   : 'fileUpload', //和以下input的name属性一致  
                'formData':{'typeCode':'productPhotoUploadBean'}, 
                'auto'           : false, //是否自动开始   
                'multi'          : true, //是否支持多文件上传 
                'queueSizeLimit'  : 30,        
                'buttonText'     : '选择文件', //按钮上的文字   
                'buttonClass': 'browser',
                onQueueComplete: function (stats) { 
                 	//alert( '成功上传的文件数: ' + stats.uploadsSuccessful
				　　//+ ' - 上传出错的文件数: ' + stats.uploadsErrored
				　　//+ ' - 取消上传的文件数: ' + stats.filesCancelled
				　　//+ ' - 出错的文件数' + stats.filesErrored);
                }, 
				onUploadError : function(file,errorCode,errorMsg,errorString,swfuploadifyQueue) {//上传文件出错是触发（每个出错文件触发一次）
				　　alert( 'id: ' + file.id
				　　+ ' - 索引: ' + file.index
				　　+ ' - 文件名: ' + file.name
				　　+ ' - 文件大小: ' + file.size
				　　+ ' - 类型: ' + file.type
				　　+ ' - 创建日期: ' + file.creationdate
				　　+ ' - 修改日期: ' + file.modificationdate
				　　+ ' - 文件状态: ' + file.filestatus
				　　+ ' - 错误代码: ' + errorCode
				　　+ ' - 错误描述: ' + errorMsg
				　　+ ' - 简要错误描述: ' + errorString
				　　+ ' - 出错的文件数: ' + swfuploadifyQueue.filesErrored
				　　+ ' - 错误信息: ' + swfuploadifyQueue.errorMsg
				　　+ ' - 要添加至队列的数量: ' + swfuploadifyQueue.filesSelected
				　　+ ' - 添加至对立的数量: ' + swfuploadifyQueue.filesQueued
				　　+ ' - 队列长度: ' + swfuploadifyQueue.queueLength);
				},
				onUploadComplete : function(file,swfuploadifyQueue) {//队列中的每个文件上传完成时触发一次
				　　alert( 'id: ' + file.id
				　　+ ' - 索引: ' + file.index
				　　+ ' - 文件名: ' + file.name
				　　);
				}
            });   
        });   
           
        function uploadifyUpload(){   
            $('#fileUpload').uploadify('upload');   
        }   
    </script>  
  </head>  
     
  <body>  
    <table>  
        <tr>  
            <td colspan="3">  
                <div id="fileQueue"></div>  
                <input type="file" name="fileUpload" id="fileUpload" />  
                <input type="button" value="开始上传" class="sub" onclick="$('#fileUpload').uploadify('upload','*');"/>
                    <a href="javascript:;" onClick="javascript:uploadifyUpload()">开始上传</a>&nbsp;   
                    <a href="javascript:jQuery('#fileUpload').uploadifyClearQueue()">取消所有上传</a>  
                <ol class=files></ol>  
            </td>  
        </tr>  
    </table>  
  </body>  
</html>  

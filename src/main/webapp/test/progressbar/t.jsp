<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<html>
  <head>
<%@ include file="/jsp/common/taglibs.jsp"%>
<%@ include file="/jsp/common/cssandjs.jsp"%>  
<style type="text/css">
#center{
margin:50px auto;
width:400px;
}
#loading{
width:397px;
height:49px;
background:url(bak.png) no-repeat;
}
#loading div{
width:0px;
height:48px;
background:url(pro.png) no-repeat;
color:#fff;
text-align:center;
font-family:Tahoma;
font-size:18px;
line-height:48px;
}
#message{
width:200px;
height:35px;
font-family:Tahoma;
font-size:12px;
background-color:#d8e7f0;
border:1px solid #187CBE;
display:none;
line-height:35px;
text-align:center;
margin-bottom:10px;
margin-left:50px; 
</style>
<script type="text/javascript">
var progress_id = "loading";
function SetProgress(progress) {
if (progress) {
$("#" + progress_id + " > div").css("width", String(progress) + "%"); //控制#loading div宽度
$("#" + progress_id + " > div").html(String(progress) + "%"); //显示百分比
}
}
var i = 0;
function doProgress() {
if (i > 100) {
$("#message").html("加载完毕！").fadeIn("slow");//加载完毕提示
return;
}
if (i <= 100) {
setTimeout("doProgress()", 100);
SetProgress(i);
i++;
}
}
$(document).ready(function() {
doProgress();
}); 
</script>
  </head>
  
  <body>
   <div id="center">
	<div id="message"></div>
	<div id="loading"><div></div></div>
	</div> 
  </body>
</html>

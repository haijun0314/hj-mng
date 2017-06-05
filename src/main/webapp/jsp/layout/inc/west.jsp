<!--  左侧菜单页面   -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<script  src="${contextPath}/static/logic/sys/menu.js" type="text/javascript" ></script>
<style>
.nav-list li.open > a:after {
    display: block;
}

</style>
<script type="text/javascript">
/**
*左侧菜单跳转
*/
/********************获得父.子菜单名称以及选中变色****************************/
function menuRequest( menucode,url,menuName){
/********************菜单选中变色****************************/
	var selectMenu=$("#selectMenu").val();
	$("#"+selectMenu).removeClass("selected");
	$("#selectMenu").val(menucode);
	$("#"+menucode).addClass("selected");
	AjaxRequest.urlRequest(url+'&ajax=true' ,"right");
/********************获得父.子菜单名称 左上角导航****************************/	
	var menubrName=$("#"+menucode.substring(0,6)).html();
	document.getElementById("menu_b").innerHTML=menuName;
    document.getElementById("menu_a").innerHTML=menubrName;
}
$(document).ready(function(){
	/**
	* 加载左侧菜单   利用Handlebars模板
	*/
	MenuUtil.loadLeftMenus();
	  
});	
</script>
<!-- 左侧菜单开始  -->
<div id="sidebar" class="sidebar" >
	<div id="sidebar-shortcuts" class="sidebar-shortcuts">
		
		<div id="sidebar-shortcuts-large" class="sidebar-shortcuts-large">
			<button class="btn btn-success">
				<i class="icon-signal"></i>
			</button>
			<button class="btn btn-info">
				<i class="icon-pencil"></i>
			</button>
			<button class="btn btn-warning">
				<i class="icon-group"></i>
			</button>
			<button class="btn btn-danger">
				<i class="icon-cogs"></i>
			</button>
		</div>
		<div id="sidebar-shortcuts-mini" class="sidebar-shortcuts-mini">
			<span class="btn btn-success"></span>
			<span class="btn btn-info"></span>
			<span class="btn btn-warning"></span>
			<span class="btn btn-danger"></span>
		</div>
	</div>

	<ul class="nav nav-list" id="leftMenu_nav">
		 
	</ul> 
	<div id="sidebar-collapse" class="sidebar-collapse">
		<i data-icon2="icon-double-angle-right" data-icon1="icon-double-angle-left" class="icon-double-angle-left"></i>
	</div>
</div>
<input  type="hidden"   value=""  id="selectMenu">

 
<!-- 菜单模板 -->
<script id="leftMenu-template" type="x-handlebars-template">
{{#each this}}
<li class=" ">
		<a class="dropdown-toggle" href="#">
			<i class="{{smb.image}}"></i>
			<span class="menu-text" id="{{smb.menuCode}}"> {{smb.menuName}} </span>
			<b class="arrow icon-angle-down"></b>
		</a>
		<ul  class="submenu" id="{{menuCode}}">
		{{#each menuList}}
				<li id="{{menuCode}}">
					<a style="cursor:pointer" onclick="menuRequest('{{menuCode}}','{{location}}','{{menuName}}')">
						<font  class="menu-name">{{menuName}}</font> 
					</a>
				</li>
		{{/each}}
		</ul>
	</li>
{{/each}}
</script>
 
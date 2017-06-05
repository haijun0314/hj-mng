<html>
<!-- 订单详情页面-->
<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ include file="/jsp/common/taglibs.jsp"%>
<style>
.modal-dialog {
    margin: 60px auto;
    width: 600px;
}

</style>
	<div class="tabbable">
		<ul class="nav nav-tabs" id="myTab">
			<li class="active">
				<a data-toggle="tab" href="#home">
					<i class="green icon-home bigger-110"></i>
					基本信息
				</a>
			</li>

			<li>
				<a data-toggle="tab" href="#profile">
					拥有管理员
					<span class="badge badge-danger"></span>
				</a>
			</li>
		</ul>
		<div class="tab-content">
			<div id="home" class="tab-pane in active">
			<table class="table  table-bordered " >
				<tr>
					<td class="alert alert-danger">角色说明</td>
					<td>${sysRole.roleName}</td>
				</tr>
				<tr>	
					<td  class="alert alert-danger ">角色名称</td>
					<td  >${sysRole.roleDesc}</td>
				</tr>
				
					<td  class="alert alert-danger ">说明</td>
					<td >${sysRole.remark}</td>
				</tr>
				</table>	
			</div>
			<div id="profile" class="tab-pane">
					<table class="table table-bordered" >
					<thead>
				<tr>
					<td >管理员</td>
					<td >联系电话</td>
					<td >电子邮箱</td>
				</tr>
			</thead>
					<c:forEach var="userList" items="${userList}" varStatus="status">
					<tr>
						<td >${userList.userName}</td>
						<td >${userList.telePhone}</td>
						<td >${userList.email}</td>
					</tr>	 
				</c:forEach>
					 
					</table>
			</div>
		</div>
	</div>
 





 		
 



	 
 
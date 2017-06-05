<!-- 添加角色页面-->
<%@ page language="java" contentType="text/html; charset=UTF-8" %>
 <%@ include file="/jsp/common/taglibs.jsp"%>
 
<div class="pageContent">

	<table class="table" layoutH="118" targetType="dialog" width="100%">
		<thead>
			<tr>
				<th width="30"><input type="checkbox" class="checkboxCtrl" group="sysUser" /></th>
				<th width="100" >角色名称</th>
				<th width="100" >角色状态</th>
				<th width="80"  >删除状态</th>
				<th width="90" >建立时间</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="item" items="${selectRoleList}">
			<tr>
			    <td><input type="checkbox" name="sysUser" value="{roles:'${item.roleid}', roledesc:'${item.roledesc}'}"/></td>
				<td>${item.roledesc}</td>
				<td>${item.status}</td>
				<td>${item.delFlag}</td>
				<td><fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${item.inTime}"/></td>
			</tr>
			</c:forEach>
		</tbody>
		
 
	</table>
 
<div class="formBar">
			<ul>
				<li><div class="button"><div class="buttonContent">
				<button type="button" multLookup="sysUser" warn="请选择角色">确定</button></div></div></li>
				<li><div class="button"><div class="buttonContent"><button type="button" class="close">取消</button></div></div></li>
			</ul>
</div>	 
</div>
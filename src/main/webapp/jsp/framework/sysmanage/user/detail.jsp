<!-- 添加菜单页面-->
<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ include file="/jsp/common/taglibs.jsp"%>

<table class="table table-bordered table-hover table-condensed" >
<tbody>
		<tr>
			<td class="alert alert-danger col-sm-3">用户名称</td>
			<td>${sysUser.userName }</td>
		</tr>
		<tr>
			<td class="alert alert-danger ">真实名称 </td>
			<td>${sysUser.realName }</td>
		</tr>
		<tr>
			<td class="alert alert-danger">用户电话</td>
			<td>${sysUser.telePhone }</td>
		</tr>					
		<tr>
			<td class="alert alert-danger">登陆时间</td>
			<td><fmt:formatDate value="${sysUser.loginTime}" type="both" pattern="yyyy-MM-dd HH:mm:ss"/></td>
		</tr>					
		<tr>
			<td class="alert alert-danger">注册时间</td>
			<td><fmt:formatDate value="${sysUser.createdTime}" type="both" pattern="yyyy-MM-dd HH:mm:ss"/></td>
		</tr>
		<tr>
			<td class="alert alert-danger">状态</td>
			<td> 
				<c:if test="${sysUser.status==0}">
					<span class="editable editable-click">正常</span>
				</c:if>
				<c:if test="${sysUser.status==1}">
					<span class="editable editable-click"> 停用</span>
				</c:if>
			
			</td>
		</tr>					
		 
		<tr>
			<td class="alert alert-danger">电子邮件</td>
			<td>${sysUser.email }</td>
		</tr>					
		<tr>
			<td class="alert alert-danger">角色</td>
			<td>
				<c:if test="${sysUser.isSuper==0}">
					<span class="editable editable-click">超级管理员</span>
				</c:if>
				<c:if test="${sysUser.isSuper==1}">
					<span class="editable editable-click">${sysUser.roleDesc }</span>
				</c:if>
			</td>
		</tr>									
</tbody>
</table>


	 
 
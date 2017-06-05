<!-- 系统日志详情页面-->
<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ include file="/jsp/common/taglibs.jsp"%>

<style>
.modal-dialog {
	width: 900px;
}
</style>

<table class="table" >
		
		<tr>
			<td class="alert alert-danger ">用户名称</td>
			<td>${sysLog.userName }</td>
		</tr>
		<tr>
			<td class="alert alert-danger ">操作时间</td>
			<td><fmt:formatDate value="${sysLog.logTime }" type="both" pattern="yyyy-MM-dd HH:mm:ss"/></td>
		</tr>
		<tr>
			<td class="alert alert-danger ">操作内容</td>
			<td>${sysLog.logMessage }</td>
		</tr>
		<tr>
			<td class="alert alert-danger ">IP地址</td>
			<td>${sysLog.logIp }</td>
		</tr>
		<tr>
			<td class="alert alert-danger" style="width:80px;">存在结果</td>
			<td>
				<c:if test="${sysLog.operResult ==1 }">成功</c:if>
				<c:if test="${sysLog.operResult ==2 }">失败</c:if>
			</td>
		</tr>
		<tr>
			<td class="alert alert-danger ">操作类型</td>
			<td>${sysLog.logType.name }</td>
		</tr>
	</table>						




	 
 
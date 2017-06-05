<!--用户个人资料-->
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ include file="/jsp/common/taglibs.jsp"%>

 
<style>
.modal-dialog {
    margin: 60px auto;
    width: 900px;
}

</style>


<div class="row">
	<div class="col-xs-12">
		<form action="${contextPath}/sys/setAction.do?myInfo&ajax=true&reqType=2 class="form-horizontal" role="form" id="userForm" name="userForm">
			<input type="hidden" id="userId" name="userId" value="${sysUser.userId}">
				<div class="tabbable">
					<ul class="nav nav-tabs" id="myTab">
					<li class="active"><a data-toggle="tab" href="#home"> <i
							class="green icon-home bigger-110"></i> 基本信息 </a>
					</li>
					<li>
						<a data-toggle="tab" href="#profile">
								拥有权限
						</a>
					</li>
				</ul>
				<div class="tab-content">
					<div id="home" class="tab-pane in active">
						<table class="table">
							<tr>
								<td class="alert alert-danger ">登录名称</td>
								<td>${sysUser.userName }</td>
								<td class="alert alert-danger ">真实姓名</td>
								<td>${sysUser.realName }</td>
							</tr>
							<tr>
								<td class="alert alert-danger">联系电话</td>
								<td>${sysUser.telePhone }</td>
								<td class="alert alert-danger ">电子邮件</td>
								<td>${sysUser.email }</td>
							</tr>
							<tr>
								<td class="alert alert-danger ">注册时间</td>
								<td><fmt:formatDate value="${sysUser.loginTime }" type="both" pattern="yyyy-MM-dd HH:mm:ss"/></td>
								<td class="alert alert-danger">备&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;注</td>
								<td>${sysUser.remark }</td>
							</tr>
						</table>
				</div>		
					<div id="profile" class="tab-pane">
					<table class="table" >
						<c:forEach var="menu" items="${datas }" varStatus="status">
							<tr>
								<td>${menu.menuName0 }</td>
								<td>${menu.menuName1 }</td>
								<td>${menu.menuName2 }</td>
								<td>${menu.menuName3 }</td>
								<td>${menu.menuName4 }</td>
							</tr>
						</c:forEach>
					</table>
				</div>
			</div>
			</div>
		</form>
	</div>
</div>
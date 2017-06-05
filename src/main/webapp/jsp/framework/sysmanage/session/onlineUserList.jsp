<!-- 在线用户管理页面 -->
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/jsp/common/taglibs.jsp"%>
<% String basePath = request.getContextPath(); %>
<script type="text/javascript">
/***************踢出用户***************************/
function kickOut(userId){
	bootbox.confirm("确认要踢出吗?", function(flag) {
		if(flag) {
			var  url ="${contextPath}/sys/sysUser?kickOutUser&userId="+userId;
			AjaxRequest.urlRequestWithMsg(url,searchSubmit) ;
			}
		});
}
/***************请求查询***************************/
function searchSubmit(){
	AjaxRequest.urlRequest("/sys/sysUser?onlineUserList&ajax=true&reqType=1","dataList");
}
</script>

<div class="clearfix form-search" style="height: 10px;">
</div>
 
<div class="row ">
	<div class="col-xs-12">
		<div class="table-responsive">
			<table id="dataList" class="table table-striped table-bordered table-hover table-condensed">
				<thead>
					<tr>
						<td>序号</td>
						<td class="hidden-480">用户名</td>
						<td class="hidden-480">电话号码</td>
						<td class="hidden-480">真实姓名</td>
						<td class="hidden-480">登陆时间</td>
						<td class="hidden-480">操作</td>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="data" items="${pm.datas}" varStatus="status">
								<tr>
									<td>${status.index+1}</td>
									<td>${data.username}</td>
									<td>${data.telePhone}</td>
									<td>${data.realName}</td>
									<td class="hidden-480"><fmt:formatDate value="${data.loginTime}" type="both" pattern="yyyy-MM-dd HH:mm:ss"/></td>
									<td>
									<c:if test="${data.userid!=data.ownUserid}">
									<a href="#" class="btn btn-xs btn-success" onclick="kickOut(${data.userid})"><i class="glyphicon glyphicon-user"></i>踢出</a>
									</c:if>
									</td>
								</tr>
					</c:forEach>
				</tbody>
			</table>
			<jsp:include page="../../../common/pager.jsp"></jsp:include>
		</div>
	</div>
</div>
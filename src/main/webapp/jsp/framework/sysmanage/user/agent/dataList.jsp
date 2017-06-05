<!-- 城市账号管理页面 -->
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/jsp/common/taglibs.jsp"%>
<script>
			HJF.pageRequest("${pm.curPage}","${pm.totalPage}","/sys/sysUser?gridViewAgent&reqType=1&ajax=true","searchForm");
</script>

<div class="row">
	<div class="col-xs-12">
		<div class="table-responsive">
			<table id="dataList" class="table table-striped table-bordered table-hover table-condensed">
				<thead>
					<tr>
						<td>序号</td>
						<td >用户名称</td>
						<td class="hidden-480">状态</td>
						<td class="hidden-480">联系电话</td>
						<td class="hidden-480">电子邮件</td>
						<td class="hidden-480">操作</td>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="data" items="${pm.datas}" varStatus="status">
						<tr>
							<td>${status.index+1}</td>
							<td>${data.userName}</td>
							<c:if test="${data.status.value==0}">
							<td class="hidden-480"><span class="badge badge-success">${data.status.name}</span> </td>
							
							</c:if>
							<c:if test="${data.status.value==1}">
							<td class="hidden-480"><span class="badge badge-pink">${data.status.name}</span> </td>
							</c:if>
							<td class="hidden-480">${data.telePhone} </td>
							<td class="hidden-480">${data.email}</td>
							<td>
							<c:if test="${data.userType==2}">
								<a href="#" class="btn btn-xs btn-success" onclick="UserUtil.resetPassword(${data.userId})"><i class="icon-edit bigger-120"></i>重置密码</a>
								
								<a href="#" class="btn btn-xs btn-info"    onclick="UserUtil.update(${data.userId})"><i class="icon-edit bigger-120"></i>编辑</a> 
								<a href="#" class="btn btn-xs btn-danger"  onclick="UserUtil.deleteUser(${data.userId})"><i class="icon-trash bigger-120"></i>删除</a>
								<c:if test="${data.status.value==0}">
								<a  href="#"class="btn btn-xs " onclick="UserUtil.startOrStop(${data.userId},'1')"><i class="glyphicon glyphicon-pause"></i>停用</a>
								</c:if>
								<c:if test="${data.status.value==1}">
								<a  href="#"class="btn btn-xs  btn-warning" onclick="UserUtil.startOrStop(${data.userId},'0')"><i class="glyphicon glyphicon-play"></i>启用</a>
								</c:if>
							</c:if>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<jsp:include page="../../../../common/pager.jsp"></jsp:include>
		</div>
	</div>
</div>
 
	
	
	 
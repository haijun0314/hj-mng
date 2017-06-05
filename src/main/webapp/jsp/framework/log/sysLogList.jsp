<!-- 管理员管理页面 -->
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/jsp/common/taglibs.jsp"%>
<script>
	HJF.pageRequest("${pm.curPage}","${pm.totalPage}","/sys/sysLogAction.do?gridView&reqType=1&ajax=true");


</script>



<div class="row">
	<div class="col-xs-12">
		<div class="table-responsive">
			<table id="dataList" class="table table-striped table-bordered table-hover table-condensed">
				<thead>
					<tr>
						<th>序号</th>
						<th>用户名称</th>
						<th class="hidden-480">日志信息</th>
						<th class="hidden-480">操作结果</th>
						<th class="hidden-480">操作时间</th>
						<th class="hidden-480">操作</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="data" items="${pm.datas}" varStatus="status">
								<tr>
									<td>${status.index+1}</td>
									<td>${data.userName}</td>
									<td class="hidden-480">${data.logMessage}</td>
									<c:if test="${data.operResult==1}">
									<td class="hidden-480"><span class="badge badge-info">成功</span> </td>
									</c:if>
									<c:if test="${data.operResult==2}">
									<td class="hidden-480"><span class="badge badge-pink">失败</span> </td>
									</c:if>
									
									<td class="hidden-480"><fmt:formatDate value="${data.logTime}" type="both" pattern="yyyy-MM-dd HH:mm:ss"/></td>
<!-- 									<td > -->
<!-- 									<a href="#" class="btn btn-xs btn-success" onclick="detailSysUser_open(${data.userId})"><i class="glyphicon glyphicon-eye-open bigger-120"></i>查看</a> -->
<!-- 									</td> -->
									<td >
									<a href="#" class="btn btn-xs btn-success" onclick="detailSysLog(${data.logId})"><i class="glyphicon glyphicon-eye-open bigger-120"></i>查看</a>
									</td>
								</tr>
					</c:forEach>
				</tbody>
			</table>
			<jsp:include page="../../common/pager.jsp"></jsp:include>
		</div>
	</div>
</div>
 
	
	
	 
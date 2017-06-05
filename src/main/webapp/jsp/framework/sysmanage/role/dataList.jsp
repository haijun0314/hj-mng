<!-- 系统角色管理页面 -->
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/jsp/common/taglibs.jsp"%>

<script>
		 
HJF.pageRequest("${pm.curPage}","${pm.totalPage}","/sys/rolerole?gridView&reqType=1&ajax=true");
		
</script>
<div class="row">
	<div class="col-xs-12">
		<div class="table-responsive">
			<table class="table table-striped table-bordered table-hover table-condensed" id="dataList">
			<thead>
				<tr>
					<td>序号</td>
					<td>角色名称</td>
					<td class="hidden-480">添加时间</td>
					<td class="hidden-480">操作</td>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="data" items="${pm.datas}" varStatus="status">
					<tr>
						<td>${status.index+1}</td>
						<td>${data.roleDesc}</td>
						<td class="hidden-480"><fmt:formatDate value="${data.createdTime}" type="both" pattern="yyyy-MM-dd HH:mm:ss"/></td>
						<td >
						<a href="#" class="btn btn-xs btn-info" onclick="update(${data.roleId})"><i class="icon-edit bigger-120"></i>编辑</a> 
						<a href="#" class="btn btn-xs btn-danger" onclick="deleteRole(${data.roleId})"><i class="icon-trash bigger-120"></i>删除</a>
						<a href="#" class="btn btn-xs btn-success" onclick="permission(${data.roleId})"><i class="icon-edit bigger-120"></i>分配权限</a>
						<a href="#" class="btn btn-xs btn-success" onclick="detail(${data.roleId})"><i class="glyphicon glyphicon-eye-open bigger-120"></i>详情</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
			</table>
			<jsp:include page="../../../common/pager.jsp"></jsp:include>
		</div>
	</div>
</div>

<!-- 权限管理页面 -->
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/jsp/common/taglibs.jsp"%>
<script>
			HJF.pageRequest("${pm.curPage}","${pm.totalPage}","/sys/security?gridView&reqType=1&ajax=true");
</script>

<div class="row" >
	<div class="col-xs-12">
		<div class="table-responsive">
			<table  class="table table-striped table-bordered table-hover table-condensed" >
				<thead>
					<tr>
						<td>序号</td>
						<td class="hidden-480">菜单名称</td>
						<td class="hidden-480">上级菜单</td>
						<td class="hidden-480">菜单编码</td>
						<td class="hidden-480">URL</td>
						<td class="hidden-480">操作</td>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="data" items="${pm.datas}" varStatus="status" >
								<tr>
									<td>${status.index+1}</td>
									<td>${data.menuName}</td>
									<td>${data.parentName}</td>
									<td>${data.menuCode}</td>
									<td class="hidden-480">${data.location} </td>
									 
									<td >
									<a href="#" class="btn btn-xs btn-info"    onclick="update(${data.menuId})"><i class="icon-edit bigger-120"></i>编辑</a> 
									<a href="#" class="btn btn-xs btn-danger"  onclick="delete_(${data.menuId})"><i class="icon-trash bigger-120"></i>删除</a>
									<c:if test="${data.status==0}">
									<a  href="#"class="btn btn-xs " onclick="updateStatus(${data.menuCode},'1')"><i class="glyphicon glyphicon-pause"></i>停用</a>
									</c:if>
									<c:if test="${data.status==1}">
									<a  href="#"class="btn btn-xs  btn-warning" onclick="updateStatus(${data.menuCode},'0')"><i class="glyphicon glyphicon-play"></i>启用</a>
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
 
	
	
	 
<!-- 开放区域管理展示页面 -->
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/jsp/common/taglibs.jsp"%>

    <div class="row">
		<div class="col-xs-12">
			<div class="table-responsive" id="tblist">
					<table id="dataList" class="table table-striped table-bordered table-hover table-condensed">
						<thead>
						<tr>
							<td>序号</td>
							<td>开放区域</td>
							<td>开放区域编号</td>
							<td>开放时间</td>
							<td>联系电话</td>
							<td>联系人</td>
							<td>联系地址</td>
							<td>qq</td>
							<td>状态</td>
							<td>操作</td>
						</tr>
						</thead> 
						<c:forEach items="${openList }" var="dictOpenCity" varStatus="status">
							<tr>
								<td class="hidden-480">${status.index+1}</td>
								<td class="hidden-480">${dictOpenCity.cityName }</td>
								<td class="hidden-480">${dictOpenCity.cityCode }</td>
								<td class="hidden-480"><fmt:formatDate value="${dictOpenCity.openTime}" type="both" pattern="yyyy-MM-dd "/></td>
								<td class="hidden-480">${dictOpenCity.telPhone}</td>
								<td class="hidden-480">${dictOpenCity.contact}</td>
								<td class="hidden-480">${dictOpenCity.address}</td>
								<td class="hidden-480">${dictOpenCity.qq}</td>
								<c:if test="${dictOpenCity.status.value==0}">
									<td class="hidden-480"><span class="badge badge-success">${dictOpenCity.status.name}</span> </td>
									
									</c:if>
									<c:if test="${dictOpenCity.status.value==1}">
									<td class="hidden-480"><span class="badge badge-pink">${dictOpenCity.status.name}</span> </td>
								</c:if>
								<td>
								<c:if test="${dictOpenCity.status.value==0}">
									<a  href="#"class="btn btn-xs " onclick="updateServiceStatus('${dictOpenCity.cityCode}','1')"><i class="glyphicon glyphicon-pause"></i>停用</a>
									</c:if>
									<c:if test="${dictOpenCity.status.value==1}">
									<a  href="#"class="btn btn-xs  btn-warning" onclick="updateServiceStatus('${dictOpenCity.cityCode}','0')"><i class="glyphicon glyphicon-play"></i>启用</a>
								</c:if>
								</td>
							</tr>
						</c:forEach>
					</table>
			</div>
	</div>
</div>



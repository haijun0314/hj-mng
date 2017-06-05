<!-- 区域管理展示页面 -->
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/jsp/common/taglibs.jsp"%>
<script>
	HJF.pageRequest("${pm.curPage}", "${pm.totalPage}","/dict/dictArea?gridView&viewflag=1&ajax=true","searchForm");
</script>
<html>
  
  
  <body>
    <div class="row">
		<div class="col-xs-12">
			<div class="table-responsive" id="tblist">
					<table id="dataList"
						class="table table-striped table-bordered table-hover table-condensed">
						<thead>
						<tr>
							<td class="hidden-480">序号</td>
							<td class="hidden-480">区域编号</td>
							<td class="hidden-480">区域</td>
							<td class="hidden-480">省份</td>
						</tr>
						</thead> 
						<c:forEach items="${pm.datas }" var="dictArea" varStatus="status">
							<tr>
								<td>${status.index+1}</td>
								<td>${dictArea.areacode }</td>
								<td>${dictArea.areaname }</td>
								<td>${dictArea.pcode}</td>
							</tr>
						</c:forEach>
					</table>
					<jsp:include page="../../common/pager.jsp"></jsp:include>
			</div>
		</div>
	</div>
  </body>
</html>

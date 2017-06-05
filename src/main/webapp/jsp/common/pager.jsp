<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/xml" prefix="x" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
 


<div class="row">
	<div class="col-sm-6 infobox-data-number" > 
	<c:if test="${pm.curRow==0}">
	共计${pm.totalRows}条记录  
	</c:if>
	<c:if test="${pm.curRow>0}">
	共计${pm.totalRows}条记录 当前显示第${pm.startRow+1}条到第 ${pm.curRow}条
	</c:if>
	</div>
	<input type="hidden" id="curPage_"  value="${pm.curPage}">
	<div class="col-sm-6"><div id="pager" ></div>	</div>
</div>
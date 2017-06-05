<!-- 统计 昨日 本周 本月 数据页面-->
<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<style>
.table {
  width: 100%;
  max-width: 100%;
}
</style>
<div class="widget-main no-padding" >	 
	<table class="table  table-bordered"  >
		<tr>
			<td>
				<div class="infobox infobox-green  " style="text-align:center;">
					<div class="infobox-icon">
						<i class="glyphicon glyphicon-stats"></i>
					</div>
		
					<div class="infobox-data" style="text-align:center;">
						<div class="infobox-content">昨日统计</div>
					</div>
			   </div>
			</td>
			<td>
				<div class="infobox infobox-green  ">
				<div class="infobox-data " style="text-align:center;">
					<span class="infobox-data-number" id="successCount"></span>
					<div class="infobox-content">成功订单数</div>
				</div>
			    </div>
			</td>
			<td>
				<div class="infobox infobox-green  ">
				<div class="infobox-data" style="text-align:center;">
					<span class="infobox-data-number" id="failCount"></span>
					<div class="infobox-content" >失败订单数</div>
				</div>
			    </div>
			</td>
			<td>
				<div class="infobox infobox-green  ">
				<div class="infobox-data" style="text-align:center;">
					<span class="infobox-data-number" id="successMoney"></span>
					<div class="infobox-content">成功金额</div>
				</div>
			    </div>
			</td>
			<td>
			<div class="infobox infobox-green  ">
			<div class="infobox-data" style="text-align:center;">
				<span class="infobox-data-number" id="failMoney"></span>
				<div class="infobox-content">失败金额</div>
			</div>
		    </div>
			</td>
		</tr>
		<tr>
			<td>
				<div class="infobox infobox-blue  " style="text-align:center;">
				<div class="infobox-icon">
					<i class="glyphicon glyphicon-stats"></i>
				</div>
	
				<div class="infobox-data" style="text-align:center;">
					<div class="infobox-content">本周统计</div>
				</div>
			    </div>
			</td>
			<td>
				<div class="infobox infobox-blue  ">
				<div class="infobox-data" style="text-align:center;">
					<span class="infobox-data-number" id="wsuccessCount"></span>
					<div class="infobox-content">成功订单数</div>
				</div>
			    </div>
			</td>
			<td>
				<div class="infobox infobox-blue  ">
				<div class="infobox-data" style="text-align:center;">
					<span class="infobox-data-number" id="wfailCount"></span>
					<div class="infobox-content">失败订单数</div>
				</div>
			    </div>
			</td>
			<td>
				<div class="infobox infobox-blue  ">
				<div class="infobox-data" style="text-align:center;">
					<span class="infobox-data-number" id="weeksuccessMoney"></span>
					<div class="infobox-content">成功金额</div>
				</div>
			    </div>
			</td>
			<td>
				<div class="infobox infobox-blue  ">
				<div class="infobox-data" style="text-align:center;">
					<span class="infobox-data-number" id="weekfailMoney"></span>
					<div class="infobox-content">失败金额</div>
				</div>
			    </div>
			</td>
		</tr>
		<tr>
			<td>
				<div class="infobox infobox-pink  " style="text-align:center;">
				<div class="infobox-icon" >
					<i class="glyphicon glyphicon-stats"></i>
				</div>
				<div class="infobox-data" style="text-align:center;">
					<div class="infobox-content" >本月统计</div>
				</div>
			    </div>
			</td>
			<td>
				<div class="infobox infobox-pink  ">
				<div class="infobox-data" style="text-align:center;">
					<span class="infobox-data-number" id="monthsuccessCount"></span>
					<div class="infobox-content">成功订单数</div>
				</div>
			    </div>
			</td>
			<td>
				<div class="infobox infobox-pink  ">
				<div class="infobox-data" style="text-align:center;">
					<span class="infobox-data-number" id="monthfailCount"></span>
					<div class="infobox-content">失败订单数</div>
				</div>
			    </div>
			</td>
			<td>
				<div class="infobox infobox-pink  ">
				<div class="infobox-data" style="text-align:center;">
					<span class="infobox-data-number" id="monthsuccessMoney"></span>
					<div class="infobox-content">成功金额</div>
				</div>
			    </div>
			</td>
			<td>
				<div class="infobox infobox-pink  ">
				<div class="infobox-data" style="text-align:center;">
					<span class="infobox-data-number" id="monthfailMoney"></span>
					<div class="infobox-content">失败金额</div>
				</div>
			    </div>
			</td>
		</tr>
	
	</table>
 
 </div>
	 
		
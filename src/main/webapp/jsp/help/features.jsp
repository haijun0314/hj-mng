<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!-- 添加用户页面-->
<script type="text/javascript" charset="UTF-8">
	var url_dept = "/sys/deptAction.do?method=getDeptlist";
	$.getJSON(url_dept, function(json) {
		$('#deptid').combobox({
		   data : json,
		   width: 200,
           valueField:	'deptid',
           textField:	'deptname'
           });
    }); 
</script>
	<div data-options="region:'center',border:false" title="" style="overflow: hidden;">
		<form id="addSysUserForm" method="post" class="form-horizontal">
		<fieldset>
		
			<table class="table table-hover table-condensed">
				<tr>
					<th>机构名称：</th>
					<td><input name="orgid"  id="orgid"  class="easyui-combobox"  required="true" /></td>
				</tr>
				<tr>
					<th>登录名称：</th>
					<td><input name="username" type="text" class="easyui-validatebox" required="true"  validType="length[1,20]" style="width: 180px; height: 25px;"></input></td>
				</tr>
				<tr>
					<th>真实姓名：</th>
					<td><input name="realname" type="text" class="easyui-validatebox" required="true" validType="length[1,20]" style="width: 180px; height: 25px;"/></input></td>
				</tr>
				<tr>
					<th>登录密码：</th>
					<td><input name="password" id="password" type="password" class="easyui-validatebox" required="true" validType="length[4,10]" style="width: 180px; height: 25px;"/></td>
				</tr>
				<tr>
					<th>确认密码：</th>
					<td><input id="confirmPassword" name="confirmPassword" type="password" class="easyui-validatebox"   required="true" validType="eqPassword['#password']" validType="length[4,10]" invalidMessage="两次输入密码不匹配" style="width: 180px; height: 25px;"></input></td>
				</tr>
				<tr>
					<th>联系电话：</th>
					<td><input name="usertel" type="text" class="easyui-validatebox" required="true" validType="length[7,11]" style="width: 180px; height: 25px;"/></td>
				</tr>
<combobox:roleCombobox multiple="true" required="true"></combobox:roleCombobox>		
				<tr>
					<th>电子邮件：</th>
					<td><input name="useremail"  type="text"  class="easyui-validatebox"   validType="email" style="width: 180px; height: 25px;" />
					</td>
				</tr>
				<tr>
					<th>备注：</th>
					<td>
					<textarea name="remark" style="height:60px;"></textarea>
					 
					</td>
				</tr>
			</table>
			</fieldset>
		</form>
		</div>

	 

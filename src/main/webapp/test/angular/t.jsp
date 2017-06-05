<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>


<head>
  <meta charset="utf-8">
  <title>Google Phone Gallery</title>
  <script src="${contextPath}/static/js/angular.js" type="text/javascript"></script>
  <script src="${contextPath}/static/js/jquery-2.0.3.min.js" type="text/javascript"></script>
  <link rel="stylesheet" href="//apps.bdimg.com/libs/bootstrap/3.2.0/css/bootstrap.min.css"> 	
</head>
<body ng-app="">


<div  ng-controller="formController">
  <form novalidate>
    First Name:<br>
    <input type="text" ng-model="user.firstName"><br>
    Last Name:<br>
    <input type="text" ng-model="user.firstName">
    <br><br>
  </form>
</div>


<div class="container" ng-controller="userController">
	<h3>用户列表</h3>
	<table class="table table-striped">
	  <thead>
	    <tr>
	      <th>编辑</th>
	      <th>名</th>
	      <th>姓</th>
	    </tr>
	  </thead>
	  <tbody>
	    <tr ng-repeat="user in users">
	      <td>
	        <button class="btn" ng-click="editUser(user.userid)">
	          <span class="glyphicon glyphicon-pencil"></span>编辑
	        </button>
	      </td>
	      <td>{{ user.username }}</td>
	      <td>{{ user.telephone }}</td>
	    </tr>
	  </tbody>
	</table>
<hr>
<button class="btn btn-success" ng-click="editUser('new')"><span class="glyphicon glyphicon-user"></span>创建新用户</button>
<hr>
<h3 ng-show="edit">创建新用户:</h3>
<h3 ng-hide="edit">编辑用户:</h3>
<form class="form-horizontal">
  <div class="form-group">
    <label class="col-sm-2 control-label">名:</label>
    <div class="col-sm-10">
    <input type="text" ng-model="username" ng-disabled="!edit" placeholder="名">
    </div>
  </div> 
  <div class="form-group">
    <label class="col-sm-2 control-label">姓:</label>
    <div class="col-sm-10">
    <input type="text" ng-model="telephone" ng-disabled="!edit" placeholder="姓">
    </div>
  </div>
  <div class="form-group">
    <label class="col-sm-2 control-label">密码:</label>
    <div class="col-sm-10">
    <input type="password" ng-model="password" placeholder="密码">
    </div>
  </div>
  <div class="form-group">
    <label class="col-sm-2 control-label">重复密码:</label>
    <div class="col-sm-10">
    <input type="password" ng-model="password2" placeholder="重复密码">
    </div>
  </div>
</form>
<hr>
	<button class="btn btn-success" ng-disabled="error || incomplete"><span class="glyphicon glyphicon-save"></span>  保存修改</button>
</div>


<script>
 
function formController ($scope) {
    $scope.user = {firstName: "John", lastName: "Doe"};
};


</script>

<script src= "myUsers.js"></script>
</body>


 
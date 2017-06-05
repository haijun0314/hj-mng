<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>


<head>
  <meta charset="utf-8">
  <title>Google Phone Gallery</title>
  <script src="${contextPath}/static/js/angular.js" type="text/javascript"></script>
  <script src="${contextPath}/static/js/jquery-2.0.3.min.js" type="text/javascript"></script>
  <link rel="stylesheet" href="//apps.bdimg.com/libs/bootstrap/3.2.0/css/bootstrap.min.css"> 	
</head>
<body ng-app="">
 
<div class="container" ng-controller="userController">
<div ng-include="'list.html'"></div>
<div ng-include="'form.html'"></div>
</div>

<script>
 
function formController ($scope) {
    $scope.user = {firstName: "John", lastName: "Doe"};
};


</script>

<script src= "myUsers.js"></script>
</body>


 
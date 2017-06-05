<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>


<head>
  <meta charset="utf-8">
  <title>Google Phone Gallery</title>
  <script src="${contextPath}/static/js/angular.js" type="text/javascript"></script>
  <script src="${contextPath}/static/js/jquery-2.0.3.min.js" type="text/javascript"></script>
  <link rel="stylesheet" href="//apps.bdimg.com/libs/bootstrap/3.2.0/css/bootstrap.min.css"> 	
  <style type="text/css">
  .expander {
    border: 1px solid black;
    width: 250px;
}

.expander>.title {
    background-color: black;
    color: white;
    padding: .1em .3em;
    cursor: pointer;
}

.expander>.body {
    padding: .1em .3em;
}
  
  
  
  </style>
</head>
<body ng-app="expanderModule">

        <div ng-controller='SomeController'>
            <expander class='expander' expander-title='title'>
                {{text}}
            </expander>
        </div>

<script>
 
var expanderModule=angular.module('expanderModule', [])
expanderModule.directive('expander', function() {
    return {
        restrict : 'EA',
        replace : true,
        transclude : true,
        scope : {
            title : '=expanderTitle'
        },
        template : '<div>'
                 + '<div class="title" ng-click="toggle()">{{title}}</div>'
                 + '<div class="body" ng-show="showMe" ng-transclude></div>'
                 + '</div>',
        link : function(scope, element, attrs) {
            scope.showMe = false;
            scope.toggle = function toggle() {
                scope.showMe = !scope.showMe;
            }
        }
    }
});
expanderModule.controller('SomeController',function($scope) {
    $scope.title = '点击展开';
    $scope.text = '这里是内部的内容。';
});
</script>

 
</body>


 
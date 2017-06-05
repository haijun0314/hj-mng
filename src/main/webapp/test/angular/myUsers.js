function userController($scope,$http) {
$scope.username = '';
$scope.telephone = '';
$scope.password = '';
$scope.password2 = '';

 
$http.get("/angular.do?getListData")
	.success(function(response) {
	  $scope.users = response;
	  }
);

$scope.edit = true;
$scope.error = false;
$scope.incomplete = false;  

$scope.editUser = function(id) {
    if (id == 'new') {
        $scope.edit = true;
        $scope.incomplete = true;
        $scope.username = '';
        $scope.telephone = '';
    } else {
        $scope.edit = false;
        $scope.username = $scope.users[id-1].username;
        $scope.telephone = $scope.users[id-1].telephone;        
    }
};

$scope.$watch('password',function() {$scope.test();});
$scope.$watch('password2',function() {$scope.test();});
$scope.$watch('username', function() {$scope.test();});
$scope.$watch('telephone', function() {$scope.test();});
$scope.test = function() {
    if ($scope.password !== $scope.password2) {
        $scope.error = true;
    } else {
        $scope.error = false;
    }
    $scope.incomplete = false;
    if ($scope.edit && (!$scope.username.length || !$scope.telephone.length|| !$scope.password.length || !$scope.password2.length)) {
        $scope.incomplete = true;
    }
};

}

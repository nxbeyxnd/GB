angular.module('app', []).controller('indexController', function ($scope, $http) {
    const contextPath = 'http://localhost:8190/api/v1';

    $scope.fillTable = function () {
        $http({
            url: contextPath + '/products',
            method: 'GET',
            params: {
                min_price: $scope.filter ? $scope.filter.min_price : null,
                max_price: $scope.filter ? $scope.filter.max_price : null
            }
        }).then(function (response) {
            $scope.ProductsList = response.data;
        });
    };

    $scope.submitCreateNewUser = function (){
        $http.post(contextPath + '/user/add', $scope.newUser)
            .then(function (response){
                console.log($scope.newUser)
                $scope.newUser = null;
            });
    };

    $scope.findUserByLoginAndPass = function (){
        $http.post(contextPath + '/user/login', $scope.user)
            .then(function (response){
                console.log($scope.user);
                $scope.user = null;
            });
    };

    $scope.fillTable();
});
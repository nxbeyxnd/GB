angular.module('app', []).controller('indexController', function ($scope, $http) {
    const contextPath = 'http://localhost:8888/api/v1';

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

    $scope.submitCreateNewProduct = function (){
        $http.post(contextPath + '/products', $scope.newProduct)
        .then(function (response){
            $scope.fillTable();
            $scope.newProduct = null;
        })
    }

    $scope.submitDeleteProductById = function (id){
        $http.delete(contextPath + '/products/' + id)
            .then(function (response){
                $scope.fillTable();
            })
    }

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
                console.log(response);
                $scope.user = null;
                sessionStorage.setItem('user', response.data['email']);
            });
    };

    //Todo add function which loading user page (sessionStorage)

    $scope.fillTable();
});
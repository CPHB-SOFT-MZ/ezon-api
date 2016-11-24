'use strict';
angular.module('myApp.view1', ['ngRoute'])

    .config(['$routeProvider', function ($routeProvider) {
        $routeProvider.when('/view1', {
            templateUrl: 'app/view1/view1.html',
            controller: 'View1Ctrl',
        });
    }])

    .controller('View1Ctrl', ["InfoFactory", "InfoService", '$scope', '$http', function (InfoFactory, InfoService, $scope, $http) {

        $scope.msgFromFactory = InfoFactory.getInfo();
        $scope.msgFromService = InfoService.getInfo();
        $scope.category = "undefined";

        $scope.getResults = function (searchText, category) {
            console.log(searchText);
            console.log(category);

            if (angular.isUndefined(category) || category === "undefined") {
                category = "";
            } else {
                category = category + "/";
            }

            $http({
                url: 'http://localhost:8084/api/api/products/' + category + searchText,
                method: 'GET'
            })
                .success(function (data, status, headers, config) {
                    console.log(data);
                    $scope.data = data;
                    console.log($scope.data);
                })
                .error(function (data, status, headers, config) {
                    console.log("Error " + data);
                });

//                    productsFactory.getInfo().then(function (response) {
//                        $scope.data = response.data;
//                    });
        };

    }]);


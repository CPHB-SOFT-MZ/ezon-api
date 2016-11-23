'use strict';
angular.module('myApp.view1', ['ngRoute'])

        .config(['$routeProvider', function ($routeProvider) {
                $routeProvider.when('/view1', {
                    templateUrl: 'app/view1/view1.html',
                    controller: 'View1Ctrl',
                });
            }])

        .controller('View1Ctrl', ["InfoFactory", "InfoService", '$scope','$http', function (InfoFactory, InfoService, $scope, $http) {
                $scope.msgFromFactory = InfoFactory.getInfo();
                $scope.msgFromService = InfoService.getInfo();
                $scope.getInfo = function () {
                    $http({
                        url: 'http://localhost:8084/api/api/products/1/Mac',
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
                }

            }])

        .factory('productsFactory', ['$http', function ($http) {
                var getInfo = function () {
                    return $http({
                        url: 'http://localhost:8084/api/products',
                        method: 'GET'
                    })
                            .success(function (data, status, headers, config) {
                                console.log(data);
                                if (data.error) {
                                    alert("Error: " + data.message);
                                }
                                return data;
                            })
                            .error(function (data, status, headers, config) {
                                return console.log("Error " + data);
                            });
                };
                return {
                    getInfo: getInfo
                };
            }]);

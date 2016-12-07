'use strict';
angular.module('myApp.index', ['ngRoute'])

        .config(['$routeProvider', function ($routeProvider) {
                $routeProvider.when('/index', {
                    templateUrl: 'app/index/index.html',
                    controller: 'IndexCtrl'
                });
            }])
        .controller('IndexCtrl', ["ResultData", '$scope', '$http', function (ResultData, $window, $scope, $http) {

                $scope.category = "undefined";

                $scope.newUser = {
                    userEmail: '',
                    password: '',
                    retypePassword: ''
                };

                $scope.createUser = function () {
                    console.log($scope.newUser.userEmail);
                    console.log($scope.newUser.password);
                    console.log($scope.newUser.retypePassword);
                    if ($scope.newUser.password !== $scope.newUser.retypePassword) {
                        alert("Wrong password");
                    } else {
                        $http({
                            url: 'http://localhost:8084/api/api/Authenticate/' + $scope.newUser.userEmail + '/' + $scope.newUser.password,
                            method: 'POST'
                        })
                                .success(function (data, status, headers, config) {
                                    console.log("Works");
                                    console.log(data);
                                })
                                .error(function (data, status, headers, config) {
                                    console.log(status);
                                    console.log("Dosnt work");
                                });
                    }
                };

                $scope.getResults = function (searchText, category) {
                    console.log(searchText);
                    console.log(category);

                    if (angular.isUndefined(category) || category === "undefined") {
                        category = "";
                    } else {
                        category = category + "/";
                    }

                    $http({
                        url: 'http://localhost:8084/api/api/products/' + searchText,
                        method: 'GET'
                    })
                            .success(function (data, status, headers, config) {
                                console.log(data);
                                ResultData.setData(data);
                                console.log(ResultData.getData());
                                $window.location.href = "/result";
                            })
                            .error(function (data, status, headers, config) {
                                console.log("Error " + data);
                                $window.location.href = "#/result";
                            });
                };

            }]);




/*
 * Place your global Controllers in this file
 */

angular.module('myApp.controllers', [])
        .controller('AppCtrl', function () {

        })
        .controller('IndexCtrl', ["ResultData", '$window', '$scope', '$http', function (ResultData, $window, $scope, $http) {
                console.log("test3");
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
                            })
                            .error(function (data, status, headers, config) {
                                console.log(status);
                                alert("The services is currently down");
                            });
                        }
                };

                $scope.getResults = function (searchText, category) {

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
                                ResultData.setData(data);
                                $window.location.href = "#/result";
                                
                            })
                            .error(function (data, status, headers, config) {
                                console.log("Error " + data);
                        alert("The services is currently down");
                            });
                };

            }])
        
        .controller("ResultCtrl", ["ResultData", '$scope', '$http', function (ResultData, $scope, $http) {
                $scope.data = ResultData.getData();
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
                                ResultData.setData(data);
                                $scope.data = ResultData.getData();
                            })
                            .error(function (data, status, headers, config) {
                                console.log("Error " + data);
                                alert("The services is currently down");
                            });
                };
            }]);




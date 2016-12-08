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
                        url: 'http://localhost:8084/api/api/products/' + category + searchText,
                        method: 'GET'
                    })
                            .success(function (data, status, headers, config) {
                                ResultData.setData(data);
                                $window.location.href = "#/result";
                                $scope.category = "undefined";
                            })
                            .error(function (data, status, headers, config) {
                                console.log("Error " + data);
                                $window.location.href = "#/result";
//                                alert("The services is currently down");
                            });
                };

                $scope.getPopular = function () {
                    $http.get("http://localhost:8084/api/api/products/popular").then(function (data) {
                        $scope.popular = data.data;
                    }, function (error) {
                        console.log(error);
                    });
                };

                $scope.getPopular();

            }])

        .controller("ResultCtrl", ["ResultData", '$scope', '$http', function (ResultData, $scope, $http) {

                $scope.currentPage = 0;
                $scope.pageSize = 6;
                $scope.numberOfPages = function () {
                    return Math.ceil($scope.data.length / $scope.pageSize);
                };

                $scope.scrollTop = function (num) {
                    $scope.currentPage = $scope.currentPage + num;
                    window.scrollTo(0, 0);
                };

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
                        url: 'http://localhost:8084/api/api/products/' + category + searchText,
                        method: 'GET'
                    })
                            .success(function (data, status, headers, config) {
                                ResultData.setData(data);
                                $scope.data = ResultData.getData();
                                $scope.category = "undefined";
                                $scope.currentPage = 0;
                            })
                            .error(function (data, status, headers, config) {
                                console.log("Error " + data);
                                alert("The services is currently down");
                            });
                };
            }]);




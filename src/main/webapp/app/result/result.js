angular.module('myApp.result', ['ngRoute'])

        .config(['$routeProvider', function ($routeProvider) {
                $routeProvider.when('/result', {
                    templateUrl: 'app/result/result.html',
                    controller: 'ResultCtrl'
                });
            }])
        .controller("ResultCtrl", ["ResultData", '$scope', '$http', function (ResultData, $window, $scope, $http) {
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
                                console.log(data);
                                ResultData.setData(data);
                                $scope.data = ResultData.getData();
                                console.log(ResultData.getData());
                            })
                            .error(function (data, status, headers, config) {
                                console.log("Error " + data);
                            });
                };
            }])

'use strict';
angular.module('myApp.view1', ['ngRoute'])

        .config(['$routeProvider', function ($routeProvider) {
                $routeProvider.when('/view1', {
                    templateUrl: 'app/view1/view1.html',
                    controller: 'View1Ctrl',
                    controllerAs: 'ctrl'
                });
            }])

        .controller('View1Ctrl', ["InfoFactory", "InfoService", '$scope', 'productsFactory', function (InfoFactory, InfoService, $scope, productsFactory) {
                $scope.msgFromFactory = InfoFactory.getInfo();
                $scope.msgFromService = InfoService.getInfo();
                $scope.data;
                $scope.getInfo = function () {
                    productsFactory.getInfo().then(function (response) {
                        $scope.data = response.data;
                    });
                }


            }])

        .factory('productsFactory', ['$http', function ($http) {
                var getInfo = function (searchText, Country, Option) {
                    var first = searchText;
                    if (Option.selectedOption.value === "vat") {
                        first = searchText.substring(0, 4);
                        first += "%20" + searchText.substring(4);
                    }
                    return $http({
                        url: 'http://localhost/api/product',
                        skipAuthorization: true,
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

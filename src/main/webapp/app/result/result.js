angular.module('myApp.result', ['ngRoute'])

        .config(['$routeProvider', function ($routeProvider) {
                $routeProvider.when('/result', {
                    templateUrl: 'app/result/result.html',
                    controller: 'ResultCtrl'
                });
            }])
        

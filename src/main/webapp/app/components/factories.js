'use strict';

/* Place your global Factory-service in this file */

angular.module('myApp.factories', [])
        .factory("ResultData", function () {
            var data;
            var setData = function setData(data) {
                this.data = data;
            };
            var getData = function getData() {
                return this.data;
            };
            return {
                setData: setData,
                getData: getData
            };
        });
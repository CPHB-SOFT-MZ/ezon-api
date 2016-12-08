'use strict';

/* Place your Global Filters in this file */

angular.module('myApp.filters', []).filter('checkmark', function () {
    return function (input) {
        return input ? '\u2713' : '\u2718';
    };
});

angular.module('myApp').filter('product', function () {

    return function (input) {
        var out = [];

        angular.forEach(input, function (product) {

            if (product.title.length > 60) {
                product.title = product.title.substr(0, 60) + "...";
            }
            if (product.description.length > 300) {
                product.excerpt = product.description.substr(0, 300) + "...";
            } else {
                product.excerpt = product.description;
            }

            out.push(product);
        });

        return out;
    };
}).filter('startFrom', function () {
    return function (input, start) {
        start = +start; //parse to int
        return input.slice(start);
    };
});

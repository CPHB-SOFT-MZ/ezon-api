'use strict';

/* Place you Global Directives in this file */

angular.module('myApp.directives', []).
  directive('angularLinks', function () {
    return {
      restrict: 'AE',
      replace: 'true',
      template:  '<ul style="list-style-type: none">'
    };
  });

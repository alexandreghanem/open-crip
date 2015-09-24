'use strict';

/**
 * @ngdoc function
 * @name projectsApp.controller:AboutCtrl
 * @description
 * # AboutCtrl
 * Controller of the projectsApp
 */
app
  .controller('LoginCtrl', function ($scope, loginService, $location) {
      $scope.save = function (form, bean) {
            if (form.$valid) {
                loginService.connect(bean).then(function (data) {
                    $scope.results = data;
                    console.log($scope.results);
                });
                $location.path('/login');
            }
        };
  });
'use strict';

/**
 * @ngdoc function
 * @name projectsApp.controller:SearchCtrl
 * @description
 * # SearchCtrl
 * Controller of the projectsApp
 */
app
  .controller('SearchCtrl', function ($scope, searchService, $location) {
      $scope.save = function (form, bean) {
          if (form.$valid) {
              searchService.addBean(bean).then(function (data) {
                  $scope.results = data;
              });
              $location.path('/search');
          }
      };      
  });

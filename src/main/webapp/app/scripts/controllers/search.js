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
                  $scope.searchResult = true;
                  console.log($scope.results);
                  console.log($scope.searchResult);
              });
              console.log('SearchCtrl has been executed');
              $location.path('/search');
          }
      };      
  });

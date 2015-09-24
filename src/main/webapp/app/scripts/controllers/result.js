'use strict';

/**
 * @ngdoc function
 * @name projectsApp.controller:ResultCtrl
 * @description
 * # ResultCtrl
 * Controller of the projectsApp
 */
app
  .controller('ResultCtrl', function ($scope, resultService) {      
      resultService.getProducts().then(function (data) {
          $scope.defaultResults = data;
          $scope.searchResult = false;
          console.log($scope.defaultResults);
          console.log($scope.searchResult);
      });
      console.log('ResultCtrl has been executed');
//    this.awesomeThings = [
//      'HTML5 Boilerplate',
//      'AngularJS',
//      'Karma'
//    ];
  });
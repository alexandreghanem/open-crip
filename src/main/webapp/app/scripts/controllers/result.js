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
          $scope.products= data;
      });

      console.log('List Produits Controller has been executed');
//    this.awesomeThings = [
//      'HTML5 Boilerplate',
//      'AngularJS',
//      'Karma'
//    ];
  });
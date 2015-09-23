'use strict';

/**
 * @ngdoc function
 * @name projectsApp.controller:SearchMapCtrl
 * @description
 * # SearchMapCtrl
 * Controller of the projectsApp
 */



angular.module('projectsApp')
  .controller('SearchMapCtrl', function ($scope, $geolocation, $compile) {	
    this.awesomeThings = [
      'HTML5 Boilerplate',
      'AngularJS',
      'Karma'
    ];
    
    $scope.$geolocation = $geolocation;

    $geolocation.getCurrentPosition().then(function(location) {
      $scope.location = location
    });

    // regular updates
    $geolocation.watchPosition({ 
      timeout: 60000,
      maximumAge: 2,
      enableHighAccuracy: true
    });
    $scope.coords = $geolocation.position.coords; // this is regularly updated
    $scope.error = $geolocation.position.error; // this becomes truthy, and has 'code' and 'message' if an error occurs
  });



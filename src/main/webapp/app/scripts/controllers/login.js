'use strict';

/**
 * @ngdoc function
 * @name projectsApp.controller:AboutCtrl
 * @description
 * # AboutCtrl
 * Controller of the projectsApp
 */
angular.module('projectsApp')
  .controller('LoginCtrl', function ($scope, authentificationService, $location) {
	  $scope.save = function (form, bean) {
	        if (form.$valid) {
	        	authentificationService.addBean(bean);
	            $location.path('/login');
	        }
	    };
  });

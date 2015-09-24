'use strict';

/**
 * @ngdoc function
 * @name projectsApp.controller:AboutCtrl
 * @description
 * # AboutCtrl
 * Controller of the projectsApp
 */

app
  .controller('RegisterCtrl', function ($scope, registerService, $location) {
	  $scope.save = function (form, bean) {
	        if (form.$valid) {
	        	registerService.addBean(bean);
	            $location.path('/register');
	        }
	    };
//    this.awesomeThings = [
//      'HTML5 Boilerplate',
//      'AngularJS',
//      'Karma'
//    ];
  });

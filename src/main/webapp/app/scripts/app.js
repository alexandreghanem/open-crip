'use strict';

/**
 * @ngdoc overview
 * @name projectsApp
 * @description
 * # projectsApp
 *
 * Main module of the application.
 */
angular
  .module('projectsApp', [
    'ngCookies',
    'ngRoute',
    'ngSanitize'
  ])
  .config(function ($routeProvider) {
    $routeProvider
      .when('/', {
        templateUrl: 'app/views/main.html',
        controller: 'MainCtrl',
        controllerAs: 'main'
      })
      .when('/register', {
        templateUrl: 'app/views/register.html',
        controller: 'RegisterCtrl',
        controllerAs: 'register'
      })
      .when('/login', {
        templateUrl: 'app/views/login.html',
        controller: 'LoginCtrl',
        controllerAs: 'login'
      })
      .when('/login', {
        templateUrl: 'app/views/login.html',
        controller: 'LoginCtrl',
        controllerAs: 'login'
      })
      .otherwise({
        redirectTo: '/'
      });
  });

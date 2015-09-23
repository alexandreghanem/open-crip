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
    'ngSanitize',
    'angularLoad'
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
      .when('/search', {
        templateUrl: 'app/views/search.html',
        controller: 'SearchCtrl',
        controllerAs: 'search'
      })
      .when('/basket', {
        templateUrl: 'app/views/basket.html',
        controller: 'BasketCtrl',
        controllerAs: 'basket'
      })
      .when('/searchmap', {
        templateUrl: 'app/views/search_map.html',
        controller: 'SearchMapCtrl',
        controllerAs: 'searchmap'
      })
      .otherwise({
        redirectTo: '/'
      });
  });

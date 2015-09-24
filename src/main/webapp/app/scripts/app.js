'use strict';

/**
 * @ngdoc overview
 * @name projectsApp
 * @description
 * # projectsApp
 *
 * Main module of the application.
 */
var app = angular
  .module('projectsApp', [
    'ngCookies',
    'ngRoute',
    'ngSanitize',
    'ngGeolocation',
    'ngMap'
  ])
  
app
    .factory('$geolocation', ['$rootScope', '$window', '$q', function($rootScope, $window, $q) {
    
        function supported() {
            return 'geolocation' in $window.navigator;
        }
    
        var retVal = {
            getCurrentPosition: function(options) {
                var deferred = $q.defer();
                if(supported()) {
                    $window.navigator.geolocation.getCurrentPosition(
                        function(position) {
                            $rootScope.$apply(function() {
                                retVal.position.coords = position.coords;
                                retVal.position.timestamp = position.timestamp;
                                deferred.resolve(position);
                            });
                        },
                        function(error) {
                            $rootScope.$apply(function() {
                                deferred.reject({error: error});
                            });
                        }, options);
                } else {
                    deferred.reject({error: {
                        code: 2,
                        message: 'This web browser does not support HTML5 Geolocation'
                    }});
                }
                return deferred.promise;
            },
    
            watchPosition: function(options) {
                if(supported()) {
                    if(!this.watchId) {
                        this.watchId = $window.navigator.geolocation.watchPosition(
                            function(position) {
                                $rootScope.$apply(function() {
                                    retVal.position.coords = position.coords;
                                    retVal.position.timestamp = position.timestamp;
                                    delete retVal.position.error;
                                    $rootScope.$broadcast('$geolocation.position.changed', position);
                                });
                            },
                            function(error) {
                                $rootScope.$apply(function() {
                                    retVal.position.error = error;
                                    delete retVal.position.coords;
                                    delete retVal.position.timestamp;
                                    $rootScope.$broadcast('$geolocation.position.error', error);
                                });
                            }, options);
                    }
                } else {
                    retVal.position = {
                        error: {
                            code: 2,
                            message: 'This web browser does not support HTML5 Geolocation'
                        }
                    };
                }
            },
    
            clearWatch: function() {
                if(this.watchId) {
                    $window.navigator.geolocation.clearWatch(this.watchId);
                    delete this.watchId;
                }
            },
    
            position: {}
        };
    
        return retVal;
    }]);

app
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

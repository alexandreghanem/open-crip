'use strict';

/**
 * @ngdoc function
 * @name projectsApp.controller:SearchCtrl
 * @description
 * # SearchCtrl
 * Controller of the projectsApp
 */
app
    .controller('SearchCtrl', function ($scope, searchService, $location, $compile,$geolocation) {

        $scope.save = function (form, bean) {
            searchService.addBean(bean).then(function (data) {
                $scope.results = data;
                $scope.searchResult = true;
                console.log($scope.results);
                console.log($scope.searchResult);
            });
            
            console.log('SearchCtrl has been executed');
            $location.path('/search');
        }

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

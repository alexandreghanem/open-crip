'use strict'

app
    .factory('resultService', function ($http) {        
        return  {
            getProducts: function () {
                return $http.put('/open-crip/rest/search/all').then(
                    function (response) { //success
                        console.log(response.data);
                        return response.data;
                    },
                    function (response) {}, //error
                    function (response) {} // pending
                );
            }
        }
    });
'use strict';

app

.factory("searchService", function ($http) {
    return {
        addBean: function (bean) {
            return $http.post('/open-crip/rest/search/input', bean).then(
                function (response) { //success
                    return response.data;
                },
                function (response) {
                    
                }, //error
                function (response) {
                    
                } // pending
            );
        }
    };
});

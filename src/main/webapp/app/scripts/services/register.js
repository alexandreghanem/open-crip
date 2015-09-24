'use strict';

angular.module('projectsApp')
.factory("registerService", function ($http) {

    return {
        addBean: function (bean) {
            return $http.post('/open-crip/rest/register/client', bean);
        }
    }
});




'use strict';

angular.module('projectsApp')
.factory("loginService", function ($http) {

    return {
        addBean: function (bean) {
            return $http.post('/open-crip/rest/login/client', bean);
        }
    }
});
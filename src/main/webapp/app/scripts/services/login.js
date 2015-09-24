'use strict';

app
.factory("loginService", function ($http) {

    return {
        connect: function (bean) {
            return $http.post('/open-crip/rest/login/client', bean).then(
                    function (response) { //success
                        return response.data;
                    }
                );
        }
    }
});
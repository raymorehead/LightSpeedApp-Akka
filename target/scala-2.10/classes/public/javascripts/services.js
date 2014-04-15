'use strict';

var rootUrl = "http://localhost:9000";

angular.module('angular-client-side-auth')
.factory('Auth', function($http, $cookieStore){

    var accessLevels = routingConfig.accessLevels
        , userRoles = routingConfig.userRoles
        , currentUser = $cookieStore.get('user') || { username: '', role: userRoles.public };
    
    //$cookieStore.remove('user');

    function changeUser(user) {
        _.extend(currentUser, user);
    };

    return {
        check: function(next){
            $http.get(rootUrl + '/user/auth').success(function(res, status){
                next(status === 200)
            })
        },
        authorize: function(accessLevel, role) {
            if(role === undefined)
                role = currentUser.role;

            return accessLevel.bitMask & role.bitMask;
        },
        isLoggedIn: function(user) {
            if(user === undefined)
                user = currentUser;
            return user.role == userRoles.admin.title || user.role == userRoles.user.title;
        },
        register: function(user, success, error) {
            $http.post('/register', user).success(function(res) {
                changeUser(res);
                success();
            }).error(error);
        },
        login: function(user, success, error) {
            $http.post(rootUrl + '/user/login', user).success(function(user){
                var userTitle = user.role;
                user.role = {
                    bitMask: userRoles[userTitle].bitMask,
                    title: userTitle
                };
                changeUser(user);
                $cookieStore.put('user', user);
                success(user);
            }).error(error);
        },
        logout: function(success, error) {
            $http.post(rootUrl + '/user/logout').success(function(){
                changeUser({
                    username: '',
                    role: userRoles.public
                });
                $cookieStore.remove('user');
                success();
            }).error(error);
        },
        accessLevels: accessLevels,
        userRoles: userRoles,
        user: currentUser
    };
});

angular.module('angular-client-side-auth')
.factory('Users', function($resource) {
    return $resource(rootUrl + '/user/:uid', 
                     {
                         uid: '@uid'
                     });
});

angular.module('angular-client-side-auth')
.factory('Trainers', ['$resource', function($resource) {
    return $resource(rootUrl + '/trainer/:tid/:entity', {tid: '@tid', entity: '@entity'});
}]);

angular.module('angular-client-side-auth')
.factory('Admin', ['$http', '$resource', function($http, $resource) {
    return $resource(rootUrl + '/admin/:cid', 
                     {
                         cid: '@cid'
                     },
                     {
                         listClients: 
                         {
                             method: 'GET',
                             isArray: true,
                             url: rootUrl + '/admin/clients'
                         }
                     });
}]);

angular.module('angular-client-side-auth')
.factory('Clients', ['$http', '$resource', function($http, $resource) {
    return $resource(rootUrl + '/client/:cid/:entity', 
                     {
                         cid: '@cid',
                         entity: '@entity'
                     },
                     {
                         
                     });
}]);

angular.module('angular-client-side-auth')
.factory('Exercises', ['$http', '$resource', function($http, $resource) {
    return $resource(rootUrl + '/exercise/:eid/:entity', 
                     {
                         eid: '@eid',
                         entity: '@entity'
                     },
                     {
                         list: 
                         {
                             method: 'GET',
                             isArray: true,
                             url: rootUrl + '/exercises'
                         }
                     });
}]);

angular.module('angular-client-side-auth')
.factory('Workouts', ['$http', '$resource', function($http, $resource) {
    return $resource(rootUrl + '/workout/:wid/:entity', 
                     {
                         wid: '@wid',
                         entity: '@entity'
                     },
                     {
                         list: 
                         {
                             method: 'GET',
                             isArray: true,
                             url: rootUrl + '/workouts'
                         }
                     });
}]);

angular.module('angular-client-side-auth')
.factory('Affiliates', ['$http', '$resource', function($http, $resource) {
    return $resource(rootUrl + '/affiliate/:aid', 
                     {
                         aid: '@aid'
                     },
                     {
                         list: 
                         {
                             method: 'GET',
                             isArray: true,
                             url: rootUrl + '/affiliates'
                         }
                     });
}]);


angular.module('angular-client-side-auth')
.factory('Programs', ['$http', '$resource', function($http, $resource) {
    return $resource(rootUrl + '/program/:pid/:wid', 
                     {
                         pid: '@pid',
                         wid: '@wid'
                     },
                     {
                         list: 
                         {
                             method: 'GET',
                             isArray: true,
                             url: rootUrl + '/programs'
                         }
                     });
}]);

angular.module('angular-client-side-auth')
.factory('Promos', ['$http', '$resource', function($http, $resource) {
    return $resource(rootUrl + '/promo/:pid', 
                     {
                         pid: '@pid'
                     },
                     {
                         list: 
                         {
                             method: 'GET',
                             isArray: true,
                             url: rootUrl + '/promos'
                         }
                     });
}]);

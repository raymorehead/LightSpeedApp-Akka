'use strict';

/* Controllers */

angular.module('angular-client-side-auth')
.controller('NavCtrl', ['$rootScope', '$scope', '$location', 'Auth', function($rootScope, $scope, $location, Auth) {
    $scope.user = Auth.user;
    $scope.userRoles = Auth.userRoles;
    $scope.accessLevels = Auth.accessLevels;

    $scope.logout = function() {
        Auth.logout(function() {
            $location.path('/login');
        }, function() {
            $rootScope.error = "Failed to logout";
        });
    };
}]);

angular.module('angular-client-side-auth')
.controller('LoginCtrl',
['$rootScope', '$scope', '$location', '$window', 'Auth', function($rootScope, $scope, $location, $window, Auth) {

    $scope.rememberme = true;
    $scope.login = function() {
        Auth.login({
            email: $scope.email,
            password: $scope.password,
            rememberme: $scope.rememberme
        },
        function(res) {
            Auth.check(function(valid){
                if(valid)
                    $location.path('/');
                else
                    $rootScope.error = "Failed to login";
            })
        },
        function(err) {
            $rootScope.error = "Failed to login";
        });
    };

    $scope.loginOauth = function(provider) {
        $window.location.href = '/auth/' + provider;
    };
}]);

angular.module('angular-client-side-auth')
.controller('RegisterCtrl',
['$rootScope', 
 '$scope', 
 '$location', 
 'Auth', function($rootScope, $scope, $location, Auth) {
    $scope.role = Auth.userRoles.user;
    $scope.userRoles = Auth.userRoles;

    $scope.register = function() {
        Auth.register({
                username: $scope.username,
                password: $scope.password,
                role: $scope.role
            },
            function() {
                $location.path('/');
            },
            function(err) {
                $rootScope.error = err;
            });
    };
}]);

angular.module('angular-client-side-auth')
.controller('SettingsCtrl',
['$rootScope', 
 '$scope', 
 'Auth', function($rootScope, $scope, Auth) {

}]);

angular.module('angular-client-side-auth')
.controller('AffiliatesCtrl',
['$scope',
 '$state',
 'Affiliates',
 'Auth', function($scope, $state, Affiliates, Auth) {
    
    if(Auth.authorize(routingConfig.accessLevels.admin))
        $scope.affiliates = Affiliates.list();
    
    $scope.affiliate = new Affiliates();
    $scope.new = function() {
        $scope.affiliate.$save(function(affiliate, res) {
            $state.go('affiliates.detail', {affiliateId: affiliate._id}, {reload: true});
        });
    };
     
    $scope.cancel = function() {
        $state.go('affiliates', {}, {reload: true});
    };
     
    $scope.remove = function(eid) {
        $scope.affiliate.$delete({eid: eid}, function(res) {
            $state.go('affiliates', {}, {reload: true});
        });
    };
}]);
angular.module('angular-client-side-auth')
.controller('AffiliateDetailCtrl',
['$rootScope', 
 '$scope', 
 '$location', 
 '$window', 
 '$stateParams',
 'Affiliates', function($rootScope, $scope, $location, $window, $stateParams, Affiliates) {
     
    $scope.affiliate = Affiliates.get({aid: $stateParams.affiliateId});
    $scope.update = function() {
        $scope.affiliate.$save({eid: $scope.affiliate._id});
    };
     
 }]);

angular.module('angular-client-side-auth')
.controller('ExercisesCtrl',
['$scope',
 '$state',
 'Exercises',
 'Trainers',
 'Auth', function($scope, $state, Exercises, Trainers, Auth) {
     
    if(Auth.authorize(routingConfig.accessLevels.trainer))
        $scope.exercises = Trainers.query({tid: Auth.user._id, entity: 'exercises'});
    if(Auth.authorize(routingConfig.accessLevels.admin))
        $scope.exercises = Exercises.list();
    
    $scope.exercise = new Exercises();
    $scope.new = function() {
        $scope.exercise.$save(function(exercise, res) {
            $state.go('exercises.detail', {exerciseId: exercise._id}, {reload: true});
        });
    };
     
    $scope.cancel = function() {
        $state.go('exercises', {}, {reload: true});
    };
     
    $scope.remove = function(eid) {
        $scope.exercise.$delete({eid: eid}, function(res) {
            $state.go('exercises', {}, {reload: true});
        });
    };
}]);
angular.module('angular-client-side-auth')
.controller('ExerciseDetailCtrl',
['$rootScope', 
 '$scope', 
 '$location', 
 '$window', 
 '$stateParams',
 'Exercises', function($rootScope, $scope, $location, $window, $stateParams, Exercises) {
     
    $scope.exercise = Exercises.get({eid: $stateParams.exerciseId});
    $scope.update = function() {
        $scope.exercise.$save({eid: $scope.exercise._id});
    };
     
 }]);

angular.module('angular-client-side-auth')
.controller('WorkoutsCtrl',
['$scope',
 '$state',
 'Trainers',
 'Workouts',
 'Auth', function($scope, $state, Trainers, Workouts, Auth) {
     
    $scope.levels = [1,2,3,4,5,6,7,8,9,10];
     
    if(Auth.authorize(routingConfig.accessLevels.trainer))
        $scope.workouts = Trainers.query({tid: Auth.user._id, entity: 'workouts'});
    if(Auth.authorize(routingConfig.accessLevels.admin))
        $scope.workouts = Workouts.list();
     
    $scope.workout = new Workouts();
    $scope.new = function() {
        $scope.workout.$save(function(workout, res) {
            $state.go('workouts.detail', {workoutId: workout._id}, {reload: true});
        });
    };
     
    $scope.cancel = function() {
        $state.go('workouts', {}, {reload: true});
    };
     
    $scope.remove = function(wid) {
        $scope.workout.$delete({wid: wid}, function(res) {
            $state.go('workouts', {}, {reload: true});
        });
    };
     
}]);
angular.module('angular-client-side-auth')
.controller('WorkoutDetailCtrl',
['$rootScope', 
 '$scope', 
 '$location', 
 '$window', 
 '$stateParams',
 'Workouts', function($rootScope, $scope, $location, $window, $stateParams, Workouts) {
     
    $scope.workout = Workouts.get({wid: $stateParams.workoutId});
    $scope.update = function() {
        $scope.workout.$save({wid: $scope.workout._id});
    };
     
 }]);

angular.module('angular-client-side-auth')
.controller('AdminCtrl',
['$rootScope', 
 '$scope', 
 'Auth', function($rootScope, $scope, Auth) {

}]);

angular.module('angular-client-side-auth')
.controller('ClientsCtrl',
['$rootScope', 
 '$scope', 
 'Trainers',
 'Clients',
 'Admin',
 'Auth', function($rootScope, $scope, Trainers, Clients, Admin, Auth) {

    if(Auth.authorize(routingConfig.accessLevels.trainer))
        $scope.clients = Trainers.query({tid: Auth.user._id, entity: 'clients'});
    if(Auth.authorize(routingConfig.accessLevels.admin))
        $scope.clients = Admin.listClients();
    
}]);
angular.module('angular-client-side-auth')
.controller('ClientDetailCtrl',
['$rootScope', 
 '$scope', 
 'Users',
 '$stateParams', function($rootScope, $scope, Users, $stateParams) {

    $scope.client = Users.get({uid: $stateParams.clientId});
    
}]);

angular.module('angular-client-side-auth')
.controller('ProgramsCtrl',
['$rootScope', 
 '$scope', 
 'Trainers',
 'Programs',
 'Auth', function($rootScope, $scope, Trainers, Programs, Auth) {

    if(Auth.authorize(routingConfig.accessLevels.trainer))
        $scope.clients = Trainers.query({tid: Auth.user._id, entity: 'programs'});
    if(Auth.authorize(routingConfig.accessLevels.trainer))
        $scope.clients = Programs.list();
    
}]);
angular.module('angular-client-side-auth')
.controller('ProgramDetailCtrl',
['$rootScope', 
 '$scope', 
 'Users',
 '$stateParams', function($rootScope, $scope, Users, $stateParams) {

    $scope.client = Users.get({uid: $stateParams.clientId});
    
}]);

angular.module('angular-client-side-auth')
.controller('PromosCtrl',
['$rootScope', 
 '$scope', 
 'Promos',
 'Auth', function($rootScope, $scope, Promos, Auth) {
     
    if(Auth.authorize(routingConfig.accessLevels.admin))
        $scope.promos = Promos.list();
     
    $scope.promo = new Promos();
    $scope.new = function() {
        $scope.promo.$save(function(promo, res) {
            $state.go('promo.detail', {promoId: promo._id}, {reload: true});
        });
    };
     
    $scope.cancel = function() {
        $state.go('promos', {}, {reload: true});
    };
     
    $scope.remove = function(eid) {
        
        $scope.promo.$delete(
            (eid) ? {eid: eid} : null,
            function(res) {
            $state.go('promos', {}, {reload: true});
        });
    };
    
}]);
angular.module('angular-client-side-auth')
.controller('PromoDetailCtrl',
['$rootScope', 
 '$scope', 
 'Promos',
 '$stateParams', function($rootScope, $scope, Promos, $stateParams) {

   
    
}]);


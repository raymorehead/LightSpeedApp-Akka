'use strict';

angular.module('angular-client-side-auth', ['ngCookies', 'ngRoute', 'ui.router', 'ngResource'])

    .config(['$routeProvider', '$locationProvider', '$httpProvider', '$stateProvider', '$urlRouterProvider', function ($routeProvider, $locationProvider, $httpProvider, $stateProvider, $urlRouterProvider) {

    $httpProvider.defaults.withCredentials = true;  
    var access = routingConfig.accessLevels;

//    $routeProvider.when('/',
//        {
//            templateUrl:    '/views/admin.html',
//            controller:     'AdminCtrl',
//            access:         access.admin
//        });
//    $routeProvider.when('/login',
//        {
//            templateUrl:    '/views/login.html',
//            controller:     'LoginCtrl',
//            access:         access.anon
//        });
    $routeProvider.otherwise({redirectTo:'/'});
    $urlRouterProvider.otherwise('/');
        
    $stateProvider.state('welcome', {
        url: '/',
        templateUrl: '/assets/views/admin.html',
        controller: 'AdminCtrl',
        access: access.user
    }); 
    $stateProvider.state('login', {
        url: '/login',
        templateUrl: '/assets/views/login.html',
        controller: 'LoginCtrl',
        access: access.anon
    });
    $stateProvider.state('settings', {
        parent: 'welcome',
        url: 'settings',
        templateUrl: '/assets/views/settings.html',
        controller: 'SettingsCtrl',
        access: access.user
    });
    $stateProvider.state('clients', {
        parent: 'welcome',
        url: 'clients',
        templateUrl: '/views/clients/clients.html',
        controller: 'ClientsCtrl',
        access: access.user
    });
    $stateProvider.state('clients.detail', {
        url: '/:clientId',
        templateUrl: '/views/clients/detail.html',
        controller: 'ClientDetailCtrl',
        access: access.user
    });
    $stateProvider.state('exercises', {
        parent: 'welcome',
        url: 'exercises',
        templateUrl: '/views/exercises/exercises.html',
        controller: 'ExercisesCtrl',
        access: access.user
    });
    $stateProvider.state('exercises.new', {
        url: '/new',
        templateUrl: '/views/exercises/new.html',
        access: access.user
    });
    $stateProvider.state('exercises.detail', {
        url: '/:exerciseId',
        templateUrl: '/views/exercises/detail.html',
        controller: 'ExerciseDetailCtrl',
        access: access.user
    });
        
    $stateProvider.state('workouts', {
        parent: 'welcome',
        url: 'workouts',
        templateUrl: '/views/workouts/workouts.html',
        controller: 'WorkoutsCtrl',
        access: access.user
    });
    $stateProvider.state('workouts.new', {
        url: '/new',
        templateUrl: '/views/workouts/new.html',
        access: access.user
    });
    $stateProvider.state('workouts.detail', {
        url: '/:workoutId',
        templateUrl: '/views/workouts/detail.html',
        controller: 'WorkoutDetailCtrl',
        access: access.user
    });
        
    $stateProvider.state('affiliates', {
        parent: 'welcome',
        url: 'affiliates',
        templateUrl: '/views/affiliates/affiliates.html',
        controller: 'AffiliatesCtrl',
        access: access.user
    });
    $stateProvider.state('affiliates.new', {
        url: '/new',
        templateUrl: '/views/affiliates/new.html',
        access: access.user
    });
    $stateProvider.state('affiliates.detail', {
        url: '/:affiliateId',
        templateUrl: '/views/affiliates/detail.html',
        controller: 'AffiliateDetailCtrl',
        access: access.user
    });
        
    $stateProvider.state('programs', {
        parent: 'welcome',
        url: 'programs',
        templateUrl: '/views/programs/programs.html',
        controller: 'ProgramsCtrl',
        access: access.user
    });
    $stateProvider.state('programs.new', {
        url: '/new',
        templateUrl: '/views/programs/new.html',
        access: access.user
    });
    $stateProvider.state('programs.detail', {
        url: '/:programId',
        templateUrl: '/views/programs/detail.html',
        controller: 'ProgramDetailCtrl',
        access: access.user
    });
        
    $stateProvider.state('promos', {
        parent: 'welcome',
        url: 'promos',
        templateUrl: '/views/promos/promos.html',
        controller: 'PromosCtrl',
        access: access.user
    });
    $stateProvider.state('promos.new', {
        url: '/new',
        templateUrl: '/views/promos/new.html',
        access: access.user
    });
    $stateProvider.state('promos.detail', {
        url: '/:promoId',
        templateUrl: '/views/promos/detail.html',
        controller: 'PromoDetailCtrl',
        access: access.user
    });

    $locationProvider.html5Mode(true);

    $httpProvider.interceptors.push(function($q, $location) {
        return {
            'responseError': function(response) {
                if(response.status === 401 || response.status === 403) {
                    $location.path('/login');
                    return $q.reject(response);
                }
                else {
                    return $q.reject(response);
                }
            }
        }
    });
    //delete $httpProvider.defaults.headers.common["X-Requested-With"];

}])

    .run(['$rootScope', '$location', '$http', 'Auth', function ($rootScope, $location, $http, Auth) {

        $rootScope.$on("$stateChangeStart", function (event, toState, toParams, fromState, fromParams) {
            $rootScope.error = null;
            if (!Auth.authorize(toState.access)) {
                if(Auth.isLoggedIn()) $location.path('/');
                else                  $location.path('/login');
            }
        });

    }]);
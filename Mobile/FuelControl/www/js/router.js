angular.module('', []).config(function ($stateProvider, $urlRouterProvider) {
    
    // Ionic uses AngularUI Router which uses the concept of states
    // Learn more here: https://github.com/angular-ui/ui-router
    // Set up the various states which the app can be in.
    // Each state's controller can be found in controllers.js
    $stateProvider
    
    // Setup an simple state for the Login page
    .state('login', {
        url: '/login',
        templateUrl: 'templates/login.html',
        controller: 'LoginCtrl'
    })
    
    // Setup an abstract state for the tabs directive
    .state('tab', {
        url: '/tab',
        abstract: true,
        controller: 'TabsCtrl',
        templateUrl: 'templates/tabs.html'
    })
    
    // Each tab has its own nav history stack:
    .state('tab.form', {
        url: '/form',
        views: {
            'tab-form': {
                templateUrl: 'templates/tab-form.html',
                controller: 'FormCtrl'
            }
        }
    })
    
    .state('tab.histories', {
        url: '/histories',
        views: {
            'tab-histories': {
                templateUrl: 'templates/tab-history.html',
                controller: 'HistoryCtrl'
            }
        }
    })
    .state('tab.history-detail', {
        url: '/history/:historyId',
        templateUrl: 'templates/history-detail.html',
        controller: 'HistoryDetailCtrl'
    });
    
    // If none of the above states are matched, fallback to Login Page
    $urlRouterProvider.otherwise('/login');
    
});
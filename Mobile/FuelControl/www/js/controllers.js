angular.module('starter.controllers', [])

.controller('LoginCtrl', function($scope, $rootScope, $state, Login) {
  
  // Autentica o usuário
  $scope.login = function(user, pass){
    Login.login(user,pass).then(function(){
      $rootScope.userLogged = user;
      $state.go('tab.form');
    }).catch(function(err){
      alert ("Usuário ou senha inválidos.");
    });
  };
  
})

.controller('TabsCtrl', function($scope, $ionicHistory, $state, $rootScope) {
  
  $scope.logout = function(){
    Login.logout($rootScope.userLogged).catch(function(err){
      console.log('Falha ao executar login: ');
      console.log(err);
    }).finally(function(){
      $rootScope.userLogged = false;
      $state.go('login');
    });
  };
  
})

.controller('FormCtrl', function($scope) {
  
  $scope.data = {};
  
  $scope.send = function(){
    var kmI = $scope.data.kmInitial;
    var kmF = $scope.data.kmFinal;
    alert('Enviado! Km Inicial: '+kmI + ' Km Final: ' + kmF);
  };
  
})

.controller('HistoryCtrl', function($scope, Histories) {
  $scope.histories = Histories.all();
  $scope.remove = function(history) {
    Histories.remove(history);
  };
})

.controller('HistoryDetailCtrl', function($scope, $stateParams, Histories) {
  
  $scope.$on('$ionicView.beforeEnter', function(e) {
    console.log('historyDetail');
    $scope.history = Histories.get($stateParams.historyId);
  });
  
});

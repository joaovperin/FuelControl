angular.module('starter.services', [])

.service('Login', function($q) {
  return {
    login: function(user, pass) {
      var q = $q.defer();
      if (user === 'joao' && pass === '1234'){
        q.resolve(true);
      } else {
        q.reject("Usuário ou senha inválidos.");
      }
      return q.promise;
    },
    logout: function(user){
      return $q.resolve();
    }
  }
})

.factory('Histories', function() {
  // Might use a resource here that returns a JSON array
  
  // Some fake testing data
  var histories = [{
    id: 0,
    name: 'Ben Sparrow',
    lastText: 'You on your way?',
    face: 'img/ben.png'
  }, {
    id: 1,
    name: 'Max Lynx',
    lastText: 'Hey, it\'s me',
    face: 'img/max.png'
  }, {
    id: 2,
    name: 'Adam Bradleyson',
    lastText: 'I should buy a boat',
    face: 'img/adam.jpg'
  }, {
    id: 3,
    name: 'Perry Governor',
    lastText: 'Look at my mukluks!',
    face: 'img/perry.png'
  }, {
    id: 4,
    name: 'Mike Harrington',
    lastText: 'This is wicked good ice cream.',
    face: 'img/mike.png'
  }];
  
  return {
    all: function() {
      return histories;
    },
    remove: function(history) {
      histories.splice(histories.indexOf(history), 1);
    },
    get: function(historyId) {
      for (var i = 0; i < histories.length; i++) {
        if (histories[i].id === parseInt(historyId)) {
          return histories[i];
        }
      }
      return null;
    }
  };
});

angular.module('starter.services', [])

.service('Webservice', function($q, $http, $httpParamSerializer) {
  
  function getUrl(url){
    return "http://192.168.100.31:8080/" + url;
  }
  
  return {
    post: function(url, param) {
      return $http({
        url: getUrl(url),
        method: "POST",
        headers: {'Content-Type': 'application/x-www-form-urlencoded'},
        data: $httpParamSerializer(param)
      });
    },
    get: function(url, param) {
      return $http({
        url: getUrl(url),
        method: "GET",
        data: param
      });
    }
  }
})

.service('Login', function($q, Webservice) {
  return {
    login: function(user, pass) {
      var q = $q.defer();
      Webservice.post('login', {user:user, pass:pass}).then(function(r){
        // If return code is Okay, proceed
        if(r.data.httpCode === 200){
          q.resolve(true);
        } else {
          // Otherwise log data on console and reject with a message
          console.log(r.data);
          q.reject(r.data.message);
        }
      }).catch(function(err){
        console.log(err);
        q.reject("Problema na comunicação com o WebService!");
      });
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

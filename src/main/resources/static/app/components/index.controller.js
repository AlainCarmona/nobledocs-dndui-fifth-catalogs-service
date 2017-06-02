
var app = angular.module('dnduiApp', []);

app.controller('dnduiCtrl', function ($scope, $http) {

  $http.get("http://localhost:8080/spell/findAllNames").then(function (response) {
    console.log(response.data);
  });

});
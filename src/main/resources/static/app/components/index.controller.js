
var app = angular.module('dnduiApp', []);

app.controller('dnduiCtrl', function ($scope, $http, $sce) {
  $scope.findByName = findByName;

  $scope.initials = [
    'A', 'B', 'C', 'D', 'E',
    'F', 'G', 'H', 'I', 'J',
    'K', 'L', 'M', 'N', 'O',
    'P', 'Q', 'R', 'S', 'T',
    'U', 'V', 'W', 'X', 'Y',
    'Z'
  ];

  $http.get("/spell/findAllNames").then(function (response) {
    if (response.data.code === 200) {
      $scope.spells = response.data.body;
    }
  });

  function findByName(name) {
    $http.get("/spell/findByName?name=" + name).then(function (response) {
      if (response.data.code === 200) {
        $scope.modalSpell = {};
        $scope.modalSpell.name = response.data.body.name;
        $scope.modalSpell.descriptor = response.data.body.descriptor;
        $scope.modalSpell.castingTime = response.data.body.castingTime;
        $scope.modalSpell.range = response.data.body.range;
        $scope.modalSpell.components = response.data.body.components;
        $scope.modalSpell.duration = response.data.body.duration;
        $scope.modalSpell.description = $sce.trustAsHtml(response.data.body.description);
      }
    });
  }

});
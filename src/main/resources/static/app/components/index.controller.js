
var app = angular.module('dnduiApp', []);

app.controller('dnduiCtrl', function ($scope, $http, $sce) {
  $scope.findByName = findByName;
  $scope.findDndClassByName = findDndClassByName;

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

  $http.get("/dndClass/findAllNames").then(function (response) {
    if (response.data.code === 200) {
      $scope.dndClasses = response.data.body;
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

  function findDndClassByName(name) {
    $http.get("/dndClass/findByName?name=" + name).then(function (response) {
      if (response.data.code === 200) {
        var data = response.data.body;

        $scope.modalDndClass = {};
        $scope.modalDndClass.name = data.name;
        $scope.modalDndClass.featuresTable = $sce.trustAsHtml(data.featuresTable);
        $scope.modalDndClass.hitPoints = $sce.trustAsHtml(data.hitPoints);
        $scope.modalDndClass.proficiencies = $sce.trustAsHtml(data.proficiencies);
        $scope.modalDndClass.equipment = $sce.trustAsHtml(data.equipment);
        $scope.modalDndClass.generalFeatures = data.generalFeatures;

        for (var i = 0; i < $scope.modalDndClass.generalFeatures.length; i++) {
          $scope.modalDndClass.generalFeatures[i].description = $sce.trustAsHtml($scope.modalDndClass.generalFeatures[i].description);
        }
        
        $scope.modalDndClass.pathName = data.classPaths.name;
        $scope.modalDndClass.pathDescription = $sce.trustAsHtml(data.classPaths.description);
        $scope.modalDndClass.paths = data.classPaths.paths;
        
        for (var i = 0; i < $scope.modalDndClass.paths.length; i++) {
          $scope.modalDndClass.paths[i].description = $sce.trustAsHtml($scope.modalDndClass.paths[i].description);
        }
      }
    });
  }

});

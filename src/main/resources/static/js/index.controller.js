
(function () {
  'use sctrict';

  angular
          .module('dndui-fifth')
          .controller('homeController', homeController);

  homeController.$inject = ['$scope', '$http', '$sce'];

  function homeController($scope, $http, $sce) {
    $scope.findByName = findByName;
    $scope.findRaceByName = findRaceByName;
    $scope.findDndClassByName = findDndClassByName;
    $scope.findBackgroundByName = findBackgroundByName;

    $scope.initials = [
      'A', 'B', 'C', 'D', 'E',
      'F', 'G', 'H', 'I', 'J',
      'K', 'L', 'M', 'N', 'O',
      'P', 'Q', 'R', 'S', 'T',
      'U', 'V', 'W', 'X', 'Y',
      'Z'
    ];

    $http.get("/catalogs/spell/findAllNames").then(function (response) {
      if (response.data.code === 200) {
        $scope.spells = response.data.body;
      }
    });

    $http.get("/catalogs/dndClass/findAllNames").then(function (response) {
      if (response.data.code === 200) {
        $scope.dndClasses = response.data.body;
      }
    });

    $http.get("/catalogs/background/findAllNames").then(function (response) {
      if (response.data.code === 200) {
        $scope.backgrounds = response.data.body;
      }
    });

    $http.get("/catalogs/race/findAllNames").then(function (response) {
      if (response.data.code === 200) {
        $scope.races = response.data.body;
      }
    });

    $http.get("/catalogs/armor/findAll").then(function (response) {
      if (response.data.code === 200) {
        $scope.armors = response.data.body;
      }
    });

    $http.get("/catalogs/weapon/findAll").then(function (response) {
      if (response.data.code === 200) {
        $scope.weapons = response.data.body;
      }
    });

    $http.get("/catalogs/experience/findAll").then(function (response) {
      if (response.data.code === 200) {
        $scope.experience = response.data.body;
      }
    });

    $http.get("/catalogs/heightAndWeight/findAll").then(function (response) {
      if (response.data.code === 200) {
        $scope.heightAndWeight = response.data.body;
      }
    });

    $http.get("/catalogs/language/findAll").then(function (response) {
      if (response.data.code === 200) {
        $scope.languages = response.data.body;
      }
    });

    $http.get("/catalogs/dndClass/findAllSpells").then(function (response) {
      if (response.data.code === 200) {
        $scope.dndClassesSpellList = response.data.body;
      }
    });

    function findByName(name) {
      $http.get("/catalogs/spell/findByName?name=" + name).then(function (response) {
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
      $http.get("/catalogs/dndClass/findByName?name=" + name).then(function (response) {
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

          $scope.modalDndClass.spellList = data.spellList;
        }
      });
    }

    function findBackgroundByName(name) {
      $http.get("/catalogs/background/findByName?name=" + name).then(function (response) {
        if (response.data.code === 200) {
          var data = response.data.body;

          $scope.modalBackground = {};
          $scope.modalBackground.name = data.name;
          $scope.modalBackground.content = $sce.trustAsHtml(data.content);
          $scope.modalBackground.personalityTrait = $sce.trustAsHtml(data.personalityTrait);
          $scope.modalBackground.ideal = $sce.trustAsHtml(data.ideal);
          $scope.modalBackground.bond = $sce.trustAsHtml(data.bond);
          $scope.modalBackground.flaw = $sce.trustAsHtml(data.flaw);
          $scope.modalBackground.additionalContent = data.additionalContent !== 'null' ?
                  $sce.trustAsHtml(data.additionalContent) : null;
        }
      });
    }

    function findRaceByName(name) {
      $http.get("/catalogs/race/findByName?name=" + name).then(function (response) {
        if (response.data.code === 200) {
          var data = response.data.body;

          $scope.modalRace = {};
          $scope.modalRace.name = data.name;
          $scope.modalRace.traits = $sce.trustAsHtml(data.traits);
          $scope.modalRace.subraces = data.subraces !== '' ? $sce.trustAsHtml(data.subraces) : null;
        }
      });
    }

  }
})();
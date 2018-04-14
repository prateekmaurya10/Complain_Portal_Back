app.controller("loginCheck", function ($scope, $localStorage, $location) {

    $scope.user = $localStorage.CurrentUserName;

    if($scope.user === null){
        $location.path("/error")
    }
});

app.controller("AlreadyLoggedIn", function ($scope, $localStorage, $location){
   $scope.user = $localStorage.CurrentUserName;
   if($scope.user != null) {
       $location.path("/alreadyLogged")
   }
});
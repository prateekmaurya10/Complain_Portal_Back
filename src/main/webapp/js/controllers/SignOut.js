app.controller("SignOut", function ($scope, $localStorage, $location, $http) {

    $scope.user = $localStorage.CurrentUserName;

   $scope.signOutFunction = function () {

       //set local Storage for current User to null
       $localStorage.CurrentUserName = null;
       alert("You are successfully signed out.");
       $location.path("/");

   }

});
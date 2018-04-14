app.controller("MainController", function ($scope, $localStorage) {
   // $localStorage.usernew = "prateekdjj"
    $scope.user = $localStorage.CurrentUserName;
    $scope.addUser = function () {
     $scope.user = $localStorage.CurrentUserName;
    };
    function changeUser(userName) {
        console.log("newUser = new user")
        $scope.user = userName;
        return;
    }
});
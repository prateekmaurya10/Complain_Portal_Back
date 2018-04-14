app.controller("LoginValidate", function ($scope, $location, $http, $localStorage) {

    $scope.login = function () {
        $(document).ready(function () {
        });
        let UserName = document.getElementById("InputEmailID").value;
        let password = document.getElementById("GetInputPassword").value;

        console.log("I am in controller " + UserName + " " + password);
        let newLogin = new CreateLogin(UserName, password);

        const post_url = 'http://localhost:8080/webapi/login/';

        $http({
            method: 'POST',
            url: post_url,
            data: JSON.stringify(newLogin),
            headers: {'Content-Type': 'application/json'}
        })
            .then(function (response) {

                let UserDetails = response.data;

                console.log("response : " + UserDetails);
                $localStorage.CurrentOwnerId = UserDetails.id
                $localStorage.CurrentUserName = UserDetails.firstName + " " + UserDetails.lastName;
                $scope.user = "changed";

                console.log("id " + $localStorage.CurrentOwnerId + "  name " + $localStorage.CurrentUserName);
                //changeUser(CurrentUserName);
                $location.path("/complaint");


            }, function () {
                alert("INVALID USERNAME OR PASSWORD");
            })
    };


    $scope.signOut1 = function () {
        $localStorage.loginUserDetails = null;
        $localStorage.CurrentUser = null;
        $localStorage.FirstName = null;
        $scope.nameUser = "noNmae";
        console.log("made current user null");
        $location.path("/");
    };
});

function CreateLogin(emailAddress, password) {
    this.emailAddress = emailAddress;
    this.password = password;
}

app.controller("loginDetails", function ($scope, $http, $localStorage, $location) {

    $(document).ready(function () {
    });

    $scope.signOut = function () {/*
        $localStorage.loginUserDetails = null;
        $localStorage.CurrentUser = null;
        $localStorage.FirstName = null;*/
        $scope.nameUser = "noNmae";
        console.log("made current user null");
        $location.path("/");
    };

    $scope.showloginbutton = function () {
        $scope.nameUser = "LOGGED_IN";
        console.log("logginin");
    };

    $scope.showSignoutbutton = function () {
        $scope.showSignout = true;
        $scope.showLogin = false;
    };
});


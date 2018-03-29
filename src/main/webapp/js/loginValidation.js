app.controller("LoginValidate", function($scope, $location, $http) {

    $scope.login = function () {
        $(document).ready(function(){});
            let UserName = document.getElementById("InputEmailID").value;
            let password = document.getElementById("GetInputPassword").value;

        console.log("I am in controller "+UserName+" " + password);
        let newLogin = new CreateLogin(UserName, password);

        const post_url = 'http://localhost:8080/webapi/login/';

        $http({
            method: 'POST',
            url: post_url,
            data: JSON.stringify(newLogin),
            headers: {'Content-Type': 'application/json'}
        })
        .then(function(response) {
            
            console.log("response : " + JSON.stringify(response.data));
            $location.path("\complaint");

        }, function() {
            alert("INVALID USERNAME OR PASSWORD");
        })
    }
});

function  CreateLogin(emailAddress, password) {
    this.emailAddress= emailAddress;
    this.password = password;
}

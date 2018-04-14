app.controller("SignUp", function ($scope) {

    $(document).ready(function () {

    });

    $scope.signUpPost = function () {
        {
            let firstName = document.getElementById("firstName").value;
            let middleName = document.getElementById("middleName").value;
            let lastName = document.getElementById("lastName").value;
            let inputEmail = document.getElementById("inputEmail").value;
            let inputPassword = document.getElementById("inputPassword").value;
            let areaname = (document.getElementById("locality-dropdown")).value;
            let qtrId = (document.getElementById("QtrNo")).value;
            let rank = document.getElementById("rank").value;
            let newOwner = new CreateOwner(firstName, middleName, lastName, inputEmail, inputPassword, areaname, qtrId, rank);
            console.log(JSON.stringify(newOwner));
            if(areaname ===0) {
                alert("Please input a valid area")
            } else if(qtrId === 0) {
                alert("Please input a valid qtrId")
            } else {
                console.log(JSON.stringify(newOwner));
                const post_url = 'http://localhost:8080/webapi/signup/';
                const post_request = new XMLHttpRequest();
                post_request.open('POST',post_url, true);
                post_request.setRequestHeader("Content-type", "application/json");
                post_request.send(JSON.stringify(newOwner));
            }
        }
        function CreateOwner(firstName, middleName, lastName, inputEmail, inputPassword, areaname, qtrId, rank) {
            this.firstName = firstName;
            this.middleName = middleName;
            this.lastName = lastName;
            this.emailAddress = inputEmail;
            this.password = inputPassword;
            this.area = areaname;
            this.qtrNo = qtrId;
            this.rank = rank;
        }
    }

});
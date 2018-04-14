app.controller("postComplaint", function ($localStorage, $scope, $http, $location) {

    $scope.user = $localStorage.CurrentUserName;

    $scope.postResult = function () {
        let complaint_drop = document.getElementById("ComplaintType");
        let complaintType = complaint_drop.value;
        let summary = document.getElementById('Summary');
        summary = summary.value;
        //let ownerId = $localStorage.loginUserDetails.id;
        let ownerId = $localStorage.CurrentOwnerId;
        let newComplaint = new CreateComplaint(complaintType, summary, ownerId);

        const post_url = 'http://localhost:8080/webapi/complaintrecords/';
        $http({
            method: 'POST',
            url: post_url,
            data: JSON.stringify(newComplaint),
            headers: {'Content-Type': 'application/json'}
        })
            .then(function (response) {

                let newComp = response.data;
                console.log(newComp);
                $localStorage.newComplaintLocal  = newComp;
                $location.path("/complaintList");
            }, function () {
                alert("ERROR REGISTERING COMPLAINT");
            })
    };

    function  CreateComplaint(complaintType, summary, ownerId) {
        this.complaintId= complaintType;
        this.summary = summary;
        this.ownerId = ownerId;
    }
});

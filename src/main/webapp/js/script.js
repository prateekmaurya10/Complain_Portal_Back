/**
 * Created by dtanwani on 3/5/2018.
 */

$(document).ready(function() {
/*
    $("button").click(function () {
       alert("Your complaint has been registered.");
    });*/
});

let app1 = angular.module("ComplaintPortal", ['ngRoute', 'ngStorage']);
/*
app1.controller("postComplaint", function ($localStorage, $scope, $http) {

    function postResult() {
        let qtr_dropdown = document.getElementById('QtrNo');
        let dropdown= document.getElementById("locality-dropdown");
        let complaint_drop = document.getElementById("ComplaintType");
        let area = dropdown.value;
        let complaintType = complaint_drop.value;
        let qtr = qtr_dropdown.value;
        let summary = document.getElementById('Summary');
        summary = summary.value;
        let ownerId = $localStorage.loginUserDetails.id;
        console.log("qtr : " + qtr);
        let newComplaint = new CreateComplaint(complaintType, summary);

        const post_url = 'http://localhost:8080/webapi/complaintrecords/';

        const post_request = new XMLHttpRequest();
        post_request.open('POST',post_url, true);
        post_request.setRequestHeader("Content-type", "application/json");
        post_request.send(JSON.stringify(newComplaint));
    }

    function  CreateComplaint(complaintType, summary, ownerId) {
        this.complaintId= complaintType;
        this.summary = summary;
        this.ownerId = ownerId;
    }


    function signUpPost() {
        let firstName = document.getElementById("firstName").value;
        let middleName = document.getElementById("middleName").value;
        let lastName = document.getElementById("lastName").value;
        let inputEmail = document.getElementById("inputEmail").value;
        let inputPassword = document.getElementById("inputPassword").value;
        let areaname = (document.getElementById("locality-dropdown")).text;
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
            post_request.setRequestHeader("Content-type", "app1lication/json");
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
});
*/

/**
 * Created by dtanwani on 3/5/2018.
 */

$(document).ready(function() {
/*
    $("button").click(function () {
       alert("Your complaint has been registered.");
    });*/
});

function postResult() {
    let qtr_dropdown = document.getElementById('QtrNo');
    let dropdown= document.getElementById("locality-dropdown");
    let complaint_drop = document.getElementById("ComplaintType");
    let area = dropdown.value;
    let complaintType = complaint_drop.value;
    let qtr = qtr_dropdown.value;
    let summary = document.getElementById('Summary');
    summary = summary.value;
    console.log("qtr : " + qtr);
    let newComplaint = new CreateComplaint(complaintType, summary);

    const post_url = 'http://localhost:8080/webapi/complaintrecords/';

    const post_request = new XMLHttpRequest();
    post_request.open('POST',post_url, true);
    post_request.setRequestHeader("Content-type", "application/json");
    post_request.send(JSON.stringify(newComplaint));
}

function  CreateComplaint(complaintType, summary) {
    this.complaintId= complaintType;
    this.summary = summary;
    this.ownerId = 1;
}


function signUpPost() {
    let firstName = document.getElementById("firstName").value;
    let middleName = document.getElementById("middleName").value;
    let lastName = document.getElementById("lastName").value;
    let inputEmail = document.getElementById("inputEmail").value;
    let inputPassword = document.getElementById("inputPassword").value;
    let areaname = (document.getElementById("locality-dropdown")).value;
    let qtrId = (document.getElementById("QtrNo")).value;
    if(areaname ==0) {
        alert("Please input a valid area")
    } else if(qtrId == 0) {
        alert("Please input a valid qtrId")
    } else {
        let newOwner = new CreateOwner(firstName, middleName, lastName, inputEmail, inputPassword, areaname, qtrId);
        console.log(JSON.stringify(newOwner));
    }
}
function CreateOwner(firstName, middleName, lastName, inputEmail, inputPassword, areaname, qtrId) {
    this.firstName = firstName;
    this.middleName = middleName;
    this.lastName = lastName;
    this.inputEmail = inputEmail;
    this.inputPassword = inputPassword;
    this.areaname = areaname;
    this.qtrId = qtrId
}
function loginForm() {
    let email = document.getElementById("InputEmailID");
    let password = document.getElementById("GetInputPassword");
    let userLogin = new UserDetails(email, password);
    console.log(JSON.stringify(userLogin));
}


function UserDetails(username, password) {
    this.username = username;
    this.password = password;
}
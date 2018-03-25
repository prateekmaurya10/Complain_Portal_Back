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
    let area = dropdown.value;
    let complaintType = complaint_drop.value;
    let qtr = qtr_dropdown.value;
    let summary = document.getElementById('Summary');
    summary = summary.value;

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

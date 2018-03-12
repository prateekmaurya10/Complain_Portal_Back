/**
 * Created by dtanwani on 3/6/2018.
 */
let complaint_drop = document.getElementById('ComplaintType');
complaint_drop.length = 0;

let c_defaultOp = document.createElement('option');
c_defaultOp.text='Choose Complaint Type';

complaint_drop.add(c_defaultOp);
complaint_drop.selectedIndex=0;

const c_url = 'http://localhost:8080/webapi/complaintTypes';

const c_request = new XMLHttpRequest();
c_request.open('GET', c_url, true);

c_request.onload = function() {
    if(c_request.status===200) {
        console.log(c_request.response);
        const data = JSON.parse(c_request.responseText);
        console.log(data);
        let option;
        for(let i=0; i<data.length;i++) {
            option = document.createElement('option');
            option.text= data[i].complaintType;
            option.value = data[i].id;
            complaint_drop.add(option);
        }
    }else {
        console.log("Can't reach REST");
    }
};

c_request.onerror = function() {
    console.error('Error' + c_url);
};

c_request.send();
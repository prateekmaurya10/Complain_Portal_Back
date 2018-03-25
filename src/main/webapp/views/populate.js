function populateAllDropdown() {
populateAreas();
populateComplaintTypes();
}


function populateAreas() {

    let dropdown = document.getElementById('locality-dropdown');
    let qtr_dropdown = document.getElementById('QtrNo');

    dropdown.length = 0;

    let defaultOption = document.createElement('option');
    defaultOption.text = 'Choose Area';
    defaultOption.value = 0;
    dropdown.add(defaultOption);
    dropdown.selectedIndex = 0;

    const url = 'http://localhost:8080/webapi/areas';

    const request = new XMLHttpRequest();
    request.open('GET', url, true);

    request.onload = function () {
        if (request.status === 200) {
            const data = JSON.parse(request.response);
            let option;
            for (let i = 0; i < data.length; i++) {
                option = document.createElement('option');
                option.text = data[i].areaName;
                option.value = data[i].id;
                dropdown.add(option);
            }
        } else {
            console.log("Can't reach REST");
        }
    };

    request.onerror = function () {
        console.error('Error' + url);
    };

    request.send();

    //POPULATE QTRS
    dropdown.onchange = function () {

        qtr_dropdown.length = 0;
        let default_op = document.createElement('option');
        default_op.text = 'Choose Quarter Number';
        default_op.value = 0;
        qtr_dropdown.add(default_op);
        qtr_dropdown.selectedIndex = 0;
        let _val = dropdown.options[this.selectedIndex].value;
        console.log(_val);
        if (_val != 0) {
            console.log(_val);
            const q_url = 'http://localhost:8080/webapi/Qtrs/' + _val;
            const request_qtr = new XMLHttpRequest();
            request_qtr.open('GET', q_url, true);

            request_qtr.onload = function () {

                if (request_qtr.status === 200) {
                    const data = JSON.parse(request_qtr.responseText);
                    let op = document.createElement('option');
                    for (let i = 0; i < data.length; i++) {
                        option = document.createElement('option');
                        option.text = data[i].qtrNo;
                        option.value = data[i].id;
                        qtr_dropdown.add(option);
                    }
                } else {
                    console.log("Can't reach REST");
                }
            };
            request_qtr.onerror = function () {
                console.error('Error' + 'QTRS');
            };

            request_qtr.send();
        }
    }
}


function populateComplaintTypes() {


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
}

/**
 * Created by dtanwani on 3/6/2018.
 */
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

// ----------------------


dropdown.onchange = function () {

    qtr_dropdown.length = 0;
    let default_op = document.createElement('option');
    default_op.text = 'Choose Quarter Number';
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

            if (request_qtr.status === 200)  {
                const data = JSON.parse(request_qtr.responseText);
                let op = document.createElement('option');
                for (let i = 0; i < data.length; i++) {
                    option = document.createElement('option');
                    option.text = data[i];
                    option.value = i+1;
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
};


/*<!--- --------------------------



 // QTRS
 function GetSelectedItem(el)
 {
 var e = document.getElementById('locality-dropdown');
 var strSel = "The Value is: " + e.options[e.selectedIndex].value + " and text is: " + e.options[e.selectedIndex].text;
 alert(strSel);
 }
 if (strSel !== 0 ) {
 let dropdown_qtr = document.getElementById('QtrNo');
 dropdown_qtr.length = 0;

 let defaultOption = document.createElement('option');
 defaultOption.text = 'Choose Qtr';

 dropdown_qtr.add(defaultOption);
 dropdown_qtr.selectedIndex = 0;

 const url = 'http://localhost:8080/webapi/Qtrs/'+strUser;

 const request = new XMLHttpRequest();
 request.open('GET', url, true);

 request.onload = function () {
 if (request.status === 200) {
 console.log(request.responseText);
 const data = JSON.parse(request.responseText);
 let option;
 for (let i = 0; i < data.length; i++) {
 option = document.createElement('option');
 option.text = data[i];
 option.value = i;
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
 }
 */
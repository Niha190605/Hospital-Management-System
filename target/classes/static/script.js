const BASE_URL = "https://hospital-management-system-42po.onrender.com";

function login() {

    let username = document.getElementById("username").value;
    let password = document.getElementById("password").value;

    if(username === "admin" && password === "admin"){

        document.getElementById("loginPage").style.display = "none";
        document.getElementById("dashboard").style.display = "block";

    }
    else{
        alert("Invalid Login");
    }
}

async function addPatient() {

    let name = document.getElementById("name").value;
    let age = document.getElementById("age").value;

    let patient = {
        name: name,
        age: age
    };

    let response = await fetch(BASE_URL + "/patients", {

        method: "POST",

        headers: {
            "Content-Type": "application/json"
        },

        body: JSON.stringify(patient)
    });

    let data = await response.json();

    alert("Patient Added Successfully");

    console.log(data);
}

async function getPatients() {

    let response = await fetch(BASE_URL + "/patients");

    let patients = await response.json();

    let list = document.getElementById("patientList");

    list.innerHTML = "";

    patients.forEach(patient => {

        let li = document.createElement("li");

        li.innerText =
            patient.name + " - Age: " + patient.age;

        list.appendChild(li);
    });
}
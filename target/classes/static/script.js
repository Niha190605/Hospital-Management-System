const BASE_URL = "https://hospital-management-system-42po.onrender.com";


// LOGIN
function login() {

    const username = document.getElementById("username").value;
    const password = document.getElementById("password").value;

    if(username === "admin" && password === "admin123") {

        document.getElementById("mainApp").style.display = "block";
        document.getElementById("loginMessage").innerText = "Login Successful";

    } else {

        document.getElementById("loginMessage").innerText = "Invalid Credentials";
    }
}


// ADD PATIENT
async function addPatient() {

    const name = document.getElementById("patientName").value;
    const age = document.getElementById("patientAge").value;

    const response = await fetch(`${BASE_URL}/patients`, {

        method: "POST",

        headers: {
            "Content-Type": "application/json"
        },

        body: JSON.stringify({
            name,
            age
        })
    });

    if(response.ok) {
        alert("Patient Added Successfully");
        loadPatients();
    }
}


// LOAD PATIENTS
async function loadPatients() {

    const response = await fetch(`${BASE_URL}/patients`);
    const patients = await response.json();

    const list = document.getElementById("patientList");

    list.innerHTML = "";

    patients.forEach(patient => {

        const li = document.createElement("li");

        li.innerText =
            `ID: ${patient.id} | ${patient.name} | Age: ${patient.age}`;

        list.appendChild(li);
    });
}


// ADD DOCTOR
async function addDoctor() {

    const name = document.getElementById("doctorName").value;
    const specialization =
        document.getElementById("doctorSpecialization").value;

    const experience =
        document.getElementById("doctorExperience").value;

    const response = await fetch(`${BASE_URL}/doctors`, {

        method: "POST",

        headers: {
            "Content-Type": "application/json"
        },

        body: JSON.stringify({
            name,
            specialization,
            experience
        })
    });

    if(response.ok) {
        alert("Doctor Added Successfully");
        loadDoctors();
    }
}


// LOAD DOCTORS
async function loadDoctors() {

    const response = await fetch(`${BASE_URL}/doctors`);
    const doctors = await response.json();

    const list = document.getElementById("doctorList");

    list.innerHTML = "";

    doctors.forEach(doctor => {

        const li = document.createElement("li");

        li.innerText =
            `ID: ${doctor.id} | ${doctor.name} | ${doctor.specialization} | Experience: ${doctor.experience}`;

        list.appendChild(li);
    });
}


// ADD APPOINTMENT
async function addAppointment() {

    const appointmentDate =
        document.getElementById("appointmentDate").value;

    const patientId =
        document.getElementById("appointmentPatientId").value;

    const doctorId =
        document.getElementById("appointmentDoctorId").value;

    const response = await fetch(`${BASE_URL}/appointments`, {

        method: "POST",

        headers: {
            "Content-Type": "application/json"
        },

        body: JSON.stringify({

            appointmentDate,

            patient: {
                id: patientId
            },

            doctor: {
                id: doctorId
            }
        })
    });

    if(response.ok) {

        alert("Appointment Added Successfully");
        loadAppointments();
    }
}


// LOAD APPOINTMENTS
async function loadAppointments() {

    const response = await fetch(`${BASE_URL}/appointments`);
    const appointments = await response.json();

    const list = document.getElementById("appointmentList");

    list.innerHTML = "";

    appointments.forEach(appointment => {

        const li = document.createElement("li");

        li.innerText =
            `Appointment ID: ${appointment.id}
             | Date: ${appointment.appointmentDate}
             | Patient: ${appointment.patient?.name}
             | Doctor: ${appointment.doctor?.name}`;

        list.appendChild(li);
    });
}
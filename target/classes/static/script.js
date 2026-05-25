const BASE_URL = "https://hospital-management-system-42po.onrender.com";


// ================= PATIENT =================

async function addPatient() {

    const patient = {
        name: document.getElementById("patientName").value,
        age: document.getElementById("patientAge").value
    };

    await fetch(`${BASE_URL}/patients`, {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(patient)
    });

    alert("Patient Added");
}

async function loadPatients() {

    const response = await fetch(`${BASE_URL}/patients`);

    const patients = await response.json();

    const list = document.getElementById("patientList");

    list.innerHTML = "";

    patients.forEach(patient => {

        list.innerHTML += `
            <li>
                ID: ${patient.id} |
                ${patient.name} |
                Age: ${patient.age}
            </li>
        `;
    });
}



// ================= DOCTOR =================

async function addDoctor() {

    const doctor = {
        name: document.getElementById("doctorName").value,
        specialization: document.getElementById("doctorSpecialization").value,
        experience: document.getElementById("doctorExperience").value
    };

    await fetch(`${BASE_URL}/doctors`, {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(doctor)
    });

    alert("Doctor Added");
}

async function loadDoctors() {

    const response = await fetch(`${BASE_URL}/doctors`);

    const doctors = await response.json();

    const list = document.getElementById("doctorList");

    list.innerHTML = "";

    doctors.forEach(doctor => {

        list.innerHTML += `
            <li>
                ID: ${doctor.id} |
                ${doctor.name} |
                ${doctor.specialization} |
                Experience: ${doctor.experience} years
            </li>
        `;
    });
}



// ================= APPOINTMENT =================

async function addAppointment() {

    const appointment = {
        appointmentDate: document.getElementById("appointmentDate").value,
        patient: {
            id: document.getElementById("patientId").value
        },
        doctor: {
            id: document.getElementById("doctorId").value
        }
    };

    await fetch(`${BASE_URL}/appointments`, {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(appointment)
    });

    alert("Appointment Added");
}

async function loadAppointments() {

    const response = await fetch(`${BASE_URL}/appointments`);

    const appointments = await response.json();

    const list = document.getElementById("appointmentList");

    list.innerHTML = "";

    appointments.forEach(app => {

        list.innerHTML += `
            <li>
                Appointment ID: ${app.id} |
                Date: ${app.appointmentDate} |
                Patient ID: ${app.patient.id} |
                Doctor ID: ${app.doctor.id}
            </li>
        `;
    });
}
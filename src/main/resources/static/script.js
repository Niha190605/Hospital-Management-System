const BASE_URL =
"https://hospital-management-system-42po.onrender.com";



/* ================= PATIENT APIs ================= */

async function addPatient() {

    const patient = {

        name: document.getElementById("patientName").value,

        age: parseInt(
            document.getElementById("patientAge").value
        )
    };

    const response = await fetch(`${BASE_URL}/patients`, {

        method: "POST",

        headers: {
            "Content-Type": "application/json"
        },

        body: JSON.stringify(patient)
    });

    if(response.ok){

        alert("Patient Added Successfully");

        loadPatients();
    }
}



async function loadPatients() {

    const response =
        await fetch(`${BASE_URL}/patients`);

    const patients = await response.json();

    const patientList =
        document.getElementById("patientList");

    patientList.innerHTML = "";

    patients.forEach(patient => {

        patientList.innerHTML += `
            <li>
                ID: ${patient.id}
                |
                ${patient.name}
                |
                Age: ${patient.age}
            </li>
        `;
    });
}



/* ================= DOCTOR APIs ================= */

async function addDoctor() {

    const doctor = {

        name:
            document.getElementById("doctorName").value,

        specialization:
            document.getElementById(
                "doctorSpecialization"
            ).value,

        experience: parseInt(
            document.getElementById(
                "doctorExperience"
            ).value
        )
    };

    const response = await fetch(`${BASE_URL}/doctors`, {

        method: "POST",

        headers: {
            "Content-Type": "application/json"
        },

        body: JSON.stringify(doctor)
    });

    if(response.ok){

        alert("Doctor Added Successfully");

        loadDoctors();
    }
}



async function loadDoctors() {

    const response =
        await fetch(`${BASE_URL}/doctors`);

    const doctors = await response.json();

    const doctorList =
        document.getElementById("doctorList");

    doctorList.innerHTML = "";

    doctors.forEach(doctor => {

        doctorList.innerHTML += `
            <li>
                ID: ${doctor.id}
                |
                ${doctor.name}
                |
                ${doctor.specialization}
                |
                Experience: ${doctor.experience}
            </li>
        `;
    });
}



/* ================= APPOINTMENT APIs ================= */

async function addAppointment() {

    const appointment = {

        appointmentDate:
            document.getElementById(
                "appointmentDate"
            ).value,

        patient: {
            id: parseInt(
                document.getElementById(
                    "appointmentPatientId"
                ).value
            )
        },

        doctor: {
            id: parseInt(
                document.getElementById(
                    "appointmentDoctorId"
                ).value
            )
        }
    };

    const response = await fetch(
        `${BASE_URL}/appointments`,
        {

            method: "POST",

            headers: {
                "Content-Type": "application/json"
            },

            body: JSON.stringify(appointment)
        }
    );

    if(response.ok){

        alert("Appointment Added Successfully");

        loadAppointments();
    }
}



async function loadAppointments() {

    const response =
        await fetch(`${BASE_URL}/appointments`);

    const appointments = await response.json();

    const appointmentList =
        document.getElementById("appointmentList");

    appointmentList.innerHTML = "";

    appointments.forEach(app => {

        appointmentList.innerHTML += `
            <li>
                Appointment ID: ${app.id}
                |
                Date: ${app.appointmentDate}
                |
                Patient ID: ${app.patient.id}
                |
                Doctor ID: ${app.doctor.id}
            </li>
        `;
    });
}
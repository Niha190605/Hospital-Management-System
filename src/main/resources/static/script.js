const BASE_URL = "";


/* ================= PATIENT APIs ================= */

async function addPatient() {

    try {

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

        } else {

            alert("Failed to add patient");
        }

    } catch(error){

        console.error(error);

        alert("Server Error");
    }
}



async function loadPatients() {

    try {

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

    } catch(error){

        console.error(error);
    }
}



/* ================= DOCTOR APIs ================= */

async function addDoctor() {

    try {

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

        } else {

            alert("Failed to add doctor");
        }

    } catch(error){

        console.error(error);

        alert("Server Error");
    }
}



async function loadDoctors() {

    try {

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

    } catch(error){

        console.error(error);
    }
}



/* ================= APPOINTMENT APIs ================= */

async function addAppointment() {

    try {

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

        } else {

            alert("Failed to add appointment");
        }

    } catch(error){

        console.error(error);

        alert("Server Error");
    }
}



async function loadAppointments() {

    try {

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

    } catch(error){

        console.error(error);
    }
}
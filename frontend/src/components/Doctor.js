import React, { useEffect, useState } from "react";

const Doctor = () => {
    const [doctors, setDoctors] = useState([]);

    const apiUrl = "http://127.0.0.1:8081/e-health-app/rest/doctors/list";

    useEffect(() => {
        const username = "malise";
        const password = "123";
        const basicAuth = btoa(`${username}:${password}`);

        fetch(apiUrl, {
            method: "GET",
            headers: {
                Authorization: `Basic ${basicAuth}`,
                "Content-Type": "application/json",
                // Add other headers as needed
            },
        })
            .then((response) => response.json())
            .then((data) => setDoctors(data))
            .catch((error) => console.error("Error fetching doctors:", error));
    }, []);

    return (
        <div className="table-container">
            <h2>Doctors</h2>
            <table>
                <tbody>
                    {doctors.map((doctor) => (
                        <tr key={doctor.id}>
                            <td>{doctor.index}</td>
                            <td>{doctor.name}</td>
                            <td>{doctor.email}</td>
                            <td>{doctor.specialization}</td>
                        </tr>
                    ))}
                </tbody>
            </table>
        </div>
    );
};

export default Doctor;

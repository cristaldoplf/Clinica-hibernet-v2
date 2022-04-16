import React, { useEffect, useState } from 'react';
import Swal from "sweetalert2"


export default function FormCreateDentist(props) {

  const createDentist = (e) => {
    e.preventDefault()

    let capturedName = document.querySelector("#createNameDentist").value
    let capturedLastName = document.querySelector("#createLastNameDentist").value
    let capturedLicenseNumber = document.querySelector("#createLicenseDentist").value

    if (capturedName.trim().length <= 0 || capturedLastName.trim().length <= 0 || capturedLicenseNumber.trim().length <= 0) {
      Swal.fire({
        icon: 'error',
        title: 'Error',
        text: 'No es posible registrar un Dentista con campos vacios!',
      })
    } else {
      let data = {
        name: capturedName,
        lastName: capturedLastName,
        licenseNumber: capturedLicenseNumber,
      }

      let myHeaders = new Headers();
      myHeaders.append("Content-Type", "application/json");

      let requestOptions = {
        method: 'POST',
        headers: myHeaders,
        body: JSON.stringify(data),
        redirect: 'follow'
      };

      fetch("http://localhost:8080/api/dentist/", requestOptions)
        .then(response => response.text())
        .then(result => {
          console.log(result)
          props.update()
          document.querySelector("#createNameDentist").value = ""
          document.querySelector("#createLastNameDentist").value = ""
          document.querySelector("#createLicenseDentist").value = ""
        })
        .catch(error => console.log('error', error));
    }


  }



  return (

    <form className="formUpdate mx-auto" style={{ maxWidth: "400px", margin: "50px 0px" }}>
      <h2>Create Dentist</h2>
      <div className="mb-3">
        <label htmlFor="nameDentist" className="form-label">Name</label>
        <input type="text" className="form-control" id="createNameDentist" />
      </div>
      <div className="mb-3">
        <label htmlFor="lastNameDentist" className="form-label">Last Name</label>
        <input type="text" className="form-control" id="createLastNameDentist" />
      </div>
      <div className="mb-3">
        <label htmlFor="nameDentist" className="form-label">License</label>
        <input type="text" className="form-control" id="createLicenseDentist" />
      </div>
      <button onClick={props.cancelCreate} type="submit" className="btn btn-primary" style={{ margin: "10px" }}>Cancel</button>
      <button onClick={createDentist} type="submit" className="btn btn-primary" style={{ margin: "10px" }}>Create</button>
    </form>
  )
}
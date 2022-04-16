import React, { useEffect, useState } from 'react';
import Swal from "sweetalert2"

export default function FormUpdate(props) {
  const [targetToUpdate, setTargetToUpdate] = useState({});



  useEffect(() => {
    //funciona como componentDidMount
    searchTarget(props.target)
  }, [])

  useEffect(() => {
    //funciona como componentDidMount
    props.update()
  }, [targetToUpdate])

  const searchTarget = (idTargetToUpdate) => {
    let requestOptions = {
      method: 'GET',
      redirect: 'follow'
    };

    fetch("http://localhost:8080/api/dentist/" + idTargetToUpdate, requestOptions)
      .then(response => response.text())
      .then(result => {
        setTargetToUpdate(JSON.parse(result))
        return console.log(result)
      })
      .catch(error => console.log('error', error));
  }

  const updateDentist = (e) => {
    e.preventDefault()

    Swal.fire({
      title: 'Are you sure?',
      text: "You won't be able to revert this!",
      icon: 'warning',
      showCancelButton: true,
      confirmButtonColor: '#3085d6',
      cancelButtonColor: '#d33',
      confirmButtonText: 'Yes, update it!'
    }).then((result) => {
      if (result.isConfirmed) {
        Swal.fire(
          'Updated!',
          'Your file has been updated.',
          'success'
        )
        let data = {
          id: document.querySelector("#updateIdDentist").value,
          name: document.querySelector("#updateNameDentist").value,
          lastName: document.querySelector("#updateLastNameDentist").value,
          licenseNumber: document.querySelector("#updateLicenseDentist").value,
        }
    
        let myHeaders = new Headers();
        myHeaders.append("Content-Type", "application/json");
    
        let requestOptions = {
          method: 'PUT',
          headers: myHeaders,
          body: JSON.stringify(data),
          redirect: 'follow'
        };
    
        fetch("http://localhost:8080/api/dentist/update", requestOptions)
          .then(response => response.text())
          .then(result => {
            setTargetToUpdate(JSON.parse(result))
            console.log(result)
          })
          .catch(error => console.log('error', error));
      }
    })
    
  }

  return (

    <form className="formUpdate mx-auto" style={{ maxWidth: "400px", margin: "50px 0px" }}>
      <h2>Update Dentist</h2>
      <div className="mb-3">
        <label htmlFor="idDentist" className="form-label">ID</label>
        <input readOnly="readonly" defaultValue={targetToUpdate.id} type="email" className="form-control" id="updateIdDentist" aria-describedby="emailHelp" />
      </div>
      <div className="mb-3">
        <label htmlFor="nameDentist" className="form-label">Name</label>
        <input defaultValue={targetToUpdate.name} type="text" className="form-control" id="updateNameDentist" />
      </div>
      <div className="mb-3">
        <label htmlFor="lastNameDentist" className="form-label">Last Name</label>
        <input defaultValue={targetToUpdate.lastName} type="text" className="form-control" id="updateLastNameDentist" />
      </div>
      <div className="mb-3">
        <label htmlFor="nameDentist" className="form-label">License</label>
        <input defaultValue={targetToUpdate.licenseNumber} type="text" className="form-control" id="updateLicenseDentist" />
      </div>
      <button onClick={props.cancelUpdate} type="submit" className="btn btn-primary" style={{ margin: "10px" }}>Cancel</button>
      <button onClick={updateDentist} type="submit" className="btn btn-primary" style={{ margin: "10px" }}>Update</button>
    </form>
  )
}

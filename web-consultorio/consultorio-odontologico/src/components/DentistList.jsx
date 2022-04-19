import React, { useEffect, useState } from 'react';
import { Link } from 'react-router-dom';
import FormUpdateDentist from './FormUpdateDentist';
import FormCreateDentist from './FormCreateDentist';
import Swal from "sweetalert2"




export default function DentistList() {
  const [list, setList] = useState([]);
  const [updating, setUpdating] = useState([false, -1]);
  const [creating, setCreating] = useState(false);



  useEffect(() => {
    //funciona como componentDidMount
    updateList()
  }, [])



  const updateList = () => {
    let requestOptions = {
      method: 'GET',
      redirect: 'follow'
    };

    fetch("http://localhost:8080/api/dentist/list", requestOptions)
      .then(response => response.text())
      .then(result => {
        /* console.log(result) */
        setList(JSON.parse(result))
      })
      .catch(error => console.log('error', error));
  }

  const deleteDentist = (id) => {

    console.log(id)

    Swal.fire({
      title: 'Are you sure?',
      text: "You won't be able to revert this!",
      icon: 'warning',
      showCancelButton: true,
      confirmButtonColor: '#3085d6',
      cancelButtonColor: '#d33',
      confirmButtonText: 'Yes, delete it!'
    }).then((result) => {
      
      if (result.isConfirmed) {
        Swal.fire(
          'Deleted!',
          'El dentista fue borrado.',
          'success'
        )

        let requestOptions = {
          method: 'DELETE',
        };

        fetch("http://localhost:8080/api/dentist/" + id, requestOptions)
          .then(response => response.text())
          .then(result => {
            updateList()
            return console.log(result)
          })
          .catch(error => console.log('error', error));
      }
    })


  }

  const cancelCreate = () => {
    setCreating(false)
  }

  const cancelUpdate = () => {
    setUpdating([false, -1])
  }

  const createDentistDisplay = () => {
    setCreating(true)
  }

  const modifyDentistDiplay = (id) => {
    console.log(id)
    setUpdating([true, id])

  }


  return (
    <div className='main-size'>
      <table className="table mx-auto" style={{ maxWidth: "900px" }}>
        <thead>
          <tr>
            <th scope="col">ID</th>
            <th scope="col">Name</th>
            <th scope="col">Lastname</th>
          </tr>
        </thead>
        <tbody>
          {list.sort((a, b) => a.id - b.id).map((ele, i) => {
            return (
              <tr key={i} className="align-middle">
                <th scope="row">{ele.id}</th>
                <td key={"2" + ele.name}>{ele.name}</td>
                <td key={"3" + ele.lastName}>{ele.lastName}</td>
                <td onClick={() => modifyDentistDiplay(ele.id)} className='btn btn-outline-success'> Modify </td>
                <td onClick={() => deleteDentist(ele.id)} className='btn btn-outline-danger delete-button'> X </td>
              </tr>
            )
          })}
          <button onClick={() => createDentistDisplay()} className='btn btn-primary' style={{ margin: "20px 0px 20px 0%" , }}>Add Dentist</button>
        </tbody>
      </table>
      {creating ? <FormCreateDentist cancelCreate={cancelCreate} update={updateList} /> : ""}
      {updating[0] ? <FormUpdateDentist target={updating[1]} update={updateList} cancelUpdate={cancelUpdate} /> : ""}

    </div>
  )
}

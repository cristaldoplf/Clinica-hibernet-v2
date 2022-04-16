import React, { useEffect, useState } from 'react';
import { Link } from 'react-router-dom';




export default function DentistList() {
  const [list, setList] = useState([]);



  useEffect(() => {
    //funciona como componentDidMount
    updateList()
  }, [])

  const updateList = () => {
    var requestOptions = {
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

  const modifyDentist = (id) => {
    console.log(id)
  }


  return (
    <table className="table mx-auto" style={{ maxWidth: "80%" }}>
      <thead>
        <tr>
          <th scope="col">ID</th>
          <th scope="col">Nombre</th>
          <th scope="col">pellido</th>
        </tr>
      </thead>
      <tbody>
        {list.map((ele, i) => {
          return (
            <tr key={i} className="align-middle">
              <th scope="row">{ele.id}</th>
              <td key={"2" + ele.name}>{ele.name}</td>
              <td key={"3" + ele.lastName}>{ele.lastName}</td>
              <Link to={"/"} class="btn btn-outline-success"> Modify</Link>
              <td onClick={() => modifyDentist(ele.id)} className='btn btn-outline-success'> Modify </td>
              <td onClick={() => deleteDentist(ele.id)} className='btn btn-outline-danger delete-button'> X </td>
              
            </tr>
          )
        })}
      </tbody>
    </table>
  )
}
{/* <th scope="row">1</th>
          <td>Mark</td>
          <td>Otto</td>
          <td>@mdo</td> */}
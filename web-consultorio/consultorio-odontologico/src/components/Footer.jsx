import React, { useEffect, useState } from 'react';

export default function Footer() {

  return (
    <footer className="bg-light d-flex flex-wrap justify-content-between align-items-center py-3 my-4 border-top container-fluid mt-5 ">
      <p className="col-md-4 mb-0 text-muted">© 2022 Pablo Leonel Cristaldo - View of API REST</p>

      <a href="/" className="col-md-4 d-flex align-items-center justify-content-center mb-3 mb-md-0 me-md-auto link-dark text-decoration-none">
        <svg className="bi me-2" width="40" height="32"></svg>
      </a>

      <ul className="nav col-md-4 justify-content-end">
        <li className="nav-item"><a href="/" className="nav-link px-2 text-muted">Home</a></li>
        <li className="nav-item"><a href="#" className="nav-link px-2 text-muted">Patients</a></li>
        <li className="nav-item"><a href="#" className="nav-link px-2 text-muted">Dentists</a></li>
        <li className="nav-item"><a href="#" className="nav-link px-2 text-muted">Appointments</a></li>
      </ul>
    </footer>
  )
}
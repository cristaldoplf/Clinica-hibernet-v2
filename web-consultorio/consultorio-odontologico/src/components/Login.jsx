import React, { useEffect, useState } from 'react';

export default function Login() {

  return (
    <div className='main-size'>
      <div className='div-center '>
        <div style={{ maxWidth: "300px" }} className="mx-auto">
          <h1 className="h3 mb-3 font-weight-normal">Please sign in</h1>
          <label htmlFor="inputEmail" className="sr-only">Email address</label>
          <input type="email" id="inputEmail" className="form-control" placeholder="Email address" required="" autoFocus="" />
          <label htmlFor="inputPassword" className="sr-only">Password</label>
          <input type="password" id="inputPassword" className="form-control" placeholder="Password" required="" />
          <div className="checkbox mb-3">
          </div>
          <button className="btn btn-lg btn-primary btn-block" style={{ margin: "10px" }} type="submit">Sign in</button>
          <button className="btn btn-lg btn-primary btn-block" style={{ margin: "10px" }} type="submit">Sign up</button>
          <p className="mt-5 mb-3 text-muted">© 2022</p>
        </div>
      </div>
    </div>
  )

}
import React from 'react'
import { NavLink } from 'react-router-dom'
import Institucional from "./components/Institucional";
import './style.css';


function QuemSomos() {
  return (
    <>
        <NavLink className="nav-link" to="/"><h1>Teste</h1></NavLink>
        <Institucional></Institucional>
    </>
  )
}

export default QuemSomos;

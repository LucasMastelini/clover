import {React, useState} from 'react'
import Header from '../../Header'
import SideBar from '../Sidebar/SideBar';
import { BiUser } from 'react-icons/bi';
import './style.css';

function DadosPessoais() {

  const [countryName, setCountryName] = useState("lalalala");

  return (
    <>
      <Header />
      <div className="container-geral">
        <SideBar></SideBar>
        <div className="container-dados-pessoais">
          <div className="dados-pessoais">
            <div className="title">
              <BiUser className="icon-user" /><h1>Dados pessoais</h1>
            </div>

            <div className="container-informacoes">
            <input value={countryName} 
            onChange={event => {setCountryName(event.target.value)}} 
            variant="outlined" InputLabelProps={{shrink: true}} />
            </div>
          </div>
        </div>
      </div>
    </>
  )
}

export default DadosPessoais;

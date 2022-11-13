import { React, useState } from 'react'
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
        <form className="container-dados-pessoais">
          <div className="dados-pessoais">
            <div className="title">
              <BiUser className="icon-user" /><h1>Dados pessoais</h1>
            </div>

            <div className="container-informacoes">
              <label>
                Nome
                <input value={countryName}
                  onChange={event => { setCountryName(event.target.value) }}
                  InputLabelProps={{ shrink: true }} />
              </label>

              <label>
                Sobrenome
                <input value={countryName}
                  onChange={event => { setCountryName(event.target.value) }}
                  InputLabelProps={{ shrink: true }} />
              </label>

              <label className='email'>
                E-mail
                <input value={countryName}
                  onChange={event => { setCountryName(event.target.value) }}
                  InputLabelProps={{ shrink: true }} />
              </label>

              <label>
                CPF
                <input value={countryName}
                  onChange={event => { setCountryName(event.target.value) }}
                  InputLabelProps={{ shrink: true }} />
              </label>

              <label>
                Gênero
                <input value={countryName}
                  onChange={event => { setCountryName(event.target.value) }}
                  InputLabelProps={{ shrink: true }} />
              </label>

              <label>
                Data de nascimento
                <input value={countryName}
                  onChange={event => { setCountryName(event.target.value) }}
                  InputLabelProps={{ shrink: true }} />
              </label>

              <label>
                Celular
                <input value={countryName}
                  onChange={event => { setCountryName(event.target.value) }}
                  InputLabelProps={{ shrink: true }} />
              </label>

              <button>Salvar</button>
            </div>
          </div>
        </form>
      </div>
    </>
  )
}

export default DadosPessoais;

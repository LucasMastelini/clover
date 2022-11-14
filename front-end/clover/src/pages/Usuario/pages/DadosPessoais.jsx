import { React, useState } from 'react'
import Header from '../../Header'
import SideBar from '../Sidebar/SideBar';
import { BiUser } from 'react-icons/bi';
import './style.css';

function DadosPessoais() {

  const [nome, setNome] = useState("Alex");
  const [sobrenome, setSobrenome] = useState("Barreira");
  const [email, setEmail] = useState("alex.barreira@sptech.school.com");
  const [cpf, setCpf] = useState("386.118.288-28");
  const [genero, setGenero] = useState("Masculino");
  const [dataNascimento, setDataNascimento] = useState("28/12/1994");
  const [telCelular, setTelCelular] = useState("(11)964616681");

  const [disabled, setDisabled] = useState(true);
  const [isBlue, setIsBlue] = useState(false);
  const [buttonText, setButtonText] = useState(false);


  function handleGameClick() {
    setDisabled(!disabled);
    setIsBlue(!isBlue);
    setButtonText(!buttonText);
  }

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
                <input value={nome}
                  style={{ borderColor: isBlue ? '#35DAF0' : '#D02EE0' }}
                  onChange={event => { setNome(event.target.value) }}
                  disabled={disabled}
                />
              </label>

              <label>
                Sobrenome
                <input value={sobrenome}
                  style={{ borderColor: isBlue ? '#35DAF0' : '#D02EE0' }}
                  onChange={event => { setSobrenome(event.target.value) }}
                  disabled={disabled}
                />
              </label>

              <label className='email'>
                E-mail
                <input value={email}
                  style={{ borderColor: isBlue ? '#35DAF0' : '#D02EE0'}}
                  onChange={event => { setEmail(event.target.value) }}
                  disabled={disabled}
                />
              </label>

              <label>
                CPF
                <input value={cpf}
                  style={{ borderColor: isBlue ? '#35DAF0' : '#D02EE0' }}
                  onChange={event => { setCpf(event.target.value) }}
                  disabled={disabled}
                />
              </label>

              <label>
                Gênero
                <input value={genero}
                  style={{ borderColor: isBlue ? '#35DAF0' : '#D02EE0' }}
                  onChange={event => { setGenero(event.target.value) }}
                  disabled={disabled}
                />
              </label>

              <label>
                Data de nascimento
                <input value={dataNascimento}
                  style={{ borderColor: isBlue ? '#35DAF0' : '#D02EE0' }}
                  onChange={event => { setDataNascimento(event.target.value) }}
                  disabled={disabled}
                />
              </label>

              <label>
                Celular
                <input value={telCelular}
                  style={{ borderColor: isBlue ? '#35DAF0' : '#D02EE0' }}
                  onChange={event => { setTelCelular(event.target.value) }}
                  disabled={disabled}
                />
              </label>
              <div className='teste' onClick={handleGameClick}>{buttonText ? "Salvar" : "Editar"}</div>
            </div>
          </div>
        </form>
      </div>
    </>
  )
}

export default DadosPessoais;

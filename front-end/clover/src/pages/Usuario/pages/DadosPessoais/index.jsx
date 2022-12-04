import { React, useState, useEffect } from 'react'
import { BiUser } from 'react-icons/bi';
import './style.css';
import api from '../../../../Api/api';

function DadosPessoais() {


  const [dadosUsuario, setDadosUsuario] = useState('');
  const [nome, setNome] = useState('Vazio');
  const [sobrenome, setSobrenome] = useState('Vazio');
  const [email, setEmail] = useState('Vazio');
  const [cpf, setCpf] = useState('Vazio');
  const [genero, setGenero] = useState('Vazio');
  const [dataNascimento, setDataNascimento] = useState('Vazio');
  const [telCelular, setTelCelular] = useState('vazio');

  const [disabled, setDisabled] = useState(true);
  const [isBlue, setIsBlue] = useState(false);
  const [buttonText, setButtonText] = useState(false);
  
  
  useEffect(() => {
    //api.get('/clientes/${localStorage.getItem('id').then((resposta) => {
    api.get('/clientes/1').then((resposta) => {
        console.log(resposta.data);
        setDadosUsuario(resposta.data)
    })
}, [])


const handleEmail = (e) => {
  setEmail(e.target.value)
  console.log(e.target.value);
}


  function handleGameClick(event) {
    setDisabled(!disabled);
    setIsBlue(!isBlue);
    setButtonText(!buttonText);
    if(event.target.innerHTML == "Salvar"){
      let data = {
        nome: dadosUsuario.nome,
        email: dadosUsuario.email
      }
      api.put('/clientes/1', data).then((resposta) => {
        alert('Todos os dados alterados com sucesso!')
        // console.log(resposta.data);
        // setDadosUsuario(resposta.data)
    }).catch((erro) =>{
          console.log(erro);
    })
    }
      
  }

  function handleDadosUsuario(e){
    const newDadosUsuario = {...dadosUsuario};
    newDadosUsuario[e.target.id] = e.target.value;
    setDadosUsuario(newDadosUsuario);
}
  

  return (
    <>
      <div className="container-geral">
        <form className="container-dados-pessoais">
          <div className="dados-pessoais">
            <div className="title">
              <BiUser className="icon-user" /><h1>Dados pessoais</h1>
            </div>

            <div className="container-informacoes">

              <label className='email'>
                Nome Completo
                <input
                  className="input-dados-pessoais"
                  value={dadosUsuario?.nome}
                  style={{ borderColor: isBlue ? '#35DAF0' : '#D02EE0' }}
                  onChange={handleDadosUsuario}
                  disabled={disabled}
                  id = 'nome'
                />
              </label>

              <label className='email'>
                E-mail
                <input
                  className="input-dados-pessoais"
                  value={dadosUsuario?.email}
                  style={{ borderColor: isBlue ? '#35DAF0' : '#D02EE0' }}
                  onChange={handleDadosUsuario}
                  disabled={disabled}
                  id = 'email'
                />
              </label>

              <label>
                CPF
                <input
                  className="input-dados-pessoais"
                  value={dadosUsuario?.cpfOuCnpj}              
                  style={{ borderColor: isBlue ? '#35DAF0' : '#D02EE0' }}
                  onChange={handleDadosUsuario}
                  disabled={disabled}
                  id = 'cpfOuCnpj'
                />
              </label>

              <label>
                Gênero
                <input
                  className="input-dados-pessoais"
                  value={dadosUsuario?.genero}
                  style={{ borderColor: isBlue ? '#35DAF0' : '#D02EE0' }}
                  onChange={handleDadosUsuario}
                  disabled={disabled}
                  id = 'genero'
                />
              </label>

              <label>
                Data de nascimento
                <input
                  className="input-dados-pessoais"
                 value={dadosUsuario?.dataNascimento}
                  style={{ borderColor: isBlue ? '#35DAF0' : '#D02EE0' }}
                  onChange={handleDadosUsuario}
                  disabled={disabled}
                  id = 'dataNascimento'
                />
              </label>

              <label>
                Celular
                <input
                  className="input-dados-pessoais"
                  value={dadosUsuario?.telefone}
                  style={{ borderColor: isBlue ? '#35DAF0' : '#D02EE0' }}
                  onChange={handleDadosUsuario}
                  id = 'telefone'
                />
              </label>
              <div  className='teste' onClick={handleGameClick}>{buttonText ? "Salvar" : "Editar"}</div>
            </div>
          </div>
        </form>
      </div>
    </>
  )
}

export default DadosPessoais;

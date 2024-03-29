import { React, useState } from "react";
import { BiUser } from "react-icons/bi";
import "./style.css";
// import api from "../../../../Api/api";
import { useNavigate } from "react-router-dom";

function DadosPessoais() {
  const [dadosUsuario, setDadosUsuario] = useState("");
  // const [nome, setNome] = useState("Vazio");
  // const [sobrenome, setSobrenome] = useState("Vazio");
  // const [email, setEmail] = useState("Vazio");
  // const [cpf, setCpf] = useState("Vazio");
  // const [cpfOuCnpj] = useState("");
  // const [tipo] = useState("");
  // const [genero] = useState("");
  // const [dataNascimento] = useState("");
  // const [telCelular, setTelCelular] = useState("vazio");

  const [disabled, setDisabled] = useState(true);
  const [isBlue, setIsBlue] = useState(false);
  const [buttonText, setButtonText] = useState(false);

  const navegar = useNavigate();

  // const idCliente = 1;
  // let idCliente = localStorage.getItem('id');

  // useEffect(() => {
  //   api.get(`/clientes-cadastro/${idCliente}`).then((resposta) => {
  //     console.log(resposta.data);
  //     setDadosUsuario(resposta.data);
  //   });
  // });

  // const handleEmail = (e) => {
  //   setEmail(e.target.value);
  //   console.log(e.target.value);
  // };

  function telaTres() {
    navegar("/finalizar-compra-tres")
  }

  function handleGameClick(event) {

    setDisabled(!disabled);
    setIsBlue(!isBlue);
    setButtonText(!buttonText);

    telaTres()
    // const usuario = {
    //   id: idCliente,
    //   cpfOuCnpj: event.target.cpfOuCnpj.value,
    //   tipo: 1,
    //   genero: event.target.genero.value,
    //   dataNascimento: event.target.dataNascimento.value,
    //   // enderecos: [JSON.parse(localStorage.getItem("dados_usuario"))],
    // };

    // if (event.target.innerHTML === "Salvar") {
    //   api.put(`clientes/payment-info/${idCliente}`, usuario)
    //     .then((res) => {
    //       console.log(res);
    //         navegar("/finalizar-compra-tres")
    //   })
    //     .catch((err) => {
    //       console.log(err);
    //   });
    // }
    // localStorage.setItem("user", JSON.stringify(usuario))
  }

  function handleDadosUsuario(e) {
    const newDadosUsuario = { ...dadosUsuario };
    newDadosUsuario[e.target.id] = e.target.value;
    setDadosUsuario(newDadosUsuario);
  }

  return (
    <>
      <div className="container-geral">
        <form className="container-dados-pessoais">
          <div className="dados-pessoais">
            <div className="title">
              <BiUser className="icon-user" />
              <h1>Dados pessoais</h1>
            </div>

            <div className="container-informacoes">
              <label className="email">
                Nome Completo
                <input
                  className="input-dados-pessoais"
                  value={localStorage.getItem('nome')}
                  style={{ borderColor: isBlue ? "#35DAF0" : "#D02EE0" }}
                  onChange={handleDadosUsuario}
                  disabled={disabled}
                  id="nome"
                />
              </label>

              <label className="email">
                E-mail
                <input
                  className="input-dados-pessoais"
                  value={localStorage.getItem('email')}
                  style={{ borderColor: isBlue ? "#35DAF0" : "#D02EE0" }}
                  onChange={handleDadosUsuario}
                  disabled={disabled}
                  id="email"
                />
              </label>

              <label>
                CPF
                <input
                  className="input-dados-pessoais"
                  // value={dadosUsuario?.cpfOuCnpj}
                  style={{ borderColor: isBlue ? "#35DAF0" : "#D02EE0" }}
                  onChange={handleDadosUsuario}
                  disabled={disabled}
                  id="cpfOuCnpj"
                />
              </label>

              <label>
                Gênero
                <input
                  className="input-dados-pessoais"
                  // value={dadosUsuario?.genero}
                  style={{ borderColor: isBlue ? "#35DAF0" : "#D02EE0" }}
                  onChange={handleDadosUsuario}
                  disabled={disabled}
                  id="genero"
                />
              </label>

              <label>
                Data de nascimento
                <input
                  className="input-dados-pessoais"
                  // value={dadosUsuario?.dataNascimento}
                  style={{ borderColor: isBlue ? "#35DAF0" : "#D02EE0" }}
                  onChange={handleDadosUsuario}
                  disabled={disabled}
                  id="dataNascimento"
                />
              </label>

              <label>
                Celular
                <input
                  className="input-dados-pessoais"
                  value={localStorage.getItem('telefone')}
                  style={{ borderColor: isBlue ? "#35DAF0" : "#D02EE0" }}
                  onChange={handleDadosUsuario}
                  id="telefone"
                />
              </label>
              <div className="teste" onClick={handleGameClick}>
                {buttonText ? "Salvar" : "Editar"}
              </div>
            </div>
          </div>
        </form>
      </div>
    </>
  );
}

export default DadosPessoais;

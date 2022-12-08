import React from "react";
import { useState } from "react";
import { BsHouseDoor, BsHouseFill } from "react-icons/bs";
import { IMaskInput } from "react-imask";
import { useNavigate } from "react-router-dom";
import api from "../../../../Api/api";
import "./style.css";

export default function Enderecos() {
  // function enviarDados(passoAtual) {
  //     setarPassos(passoAtual + 1);
  // }

  const [cep, setCep] = useState("");
  const [tipoLogradouro, setTipoLogradouro] = useState("");
  const [logradouro, setLogradouro] = useState("");
  const [bairro, setBairro] = useState("");
  const [cidade, setCidade] = useState("");
  const [uf, setUf] = useState("");
  const [latitude, setLatitude] = useState("");
  const [longitude, setLongitude] = useState("");
  // const [numero, setNumero] = useState("");
  const [complemento, setComplemento] = useState("");
  // const [destinatario, setDestinatario] = useState("");

  const navegar = useNavigate();

  const handleCep = (e) => {
    let cepVar = e.target.value.replace("-", "");

    setCep(cepVar);

    if (cepVar.length === 8) {
      api
        .post(`/clientes/cep/${cepVar}`)
        .then((result) => {
          console.log(result);
          let cepInfo = result.data;
          document.getElementById("tipo_logradouro").value =
            cepInfo.tipoLogradouro +
            " " +
            cepInfo.logradouro +
            " - " +
            cepInfo.bairro;
          document.getElementById("cidade_endereco").value =
            cepInfo.cidade + " - " + cepInfo.uf;

          setTipoLogradouro(cepInfo.tipoLogradouro);
          setLogradouro(cepInfo.logradouro);
          setBairro(cepInfo.bairro);
          setCidade(cepInfo.cidade);
          setUf(cepInfo.uf);
          setLatitude(cepInfo.latitude);
          setLongitude(cepInfo.longitude);

          document.getElementById("complemento_endereco").value =
            cepInfo.complemento;
          setComplemento(cepInfo.complemento);

          if (complemento.length > 0) {
            document.getElementById("complemento_endereco").disabled = true;
          }

          document.getElementsByClassName("card-endereco")[0].style.display =
            "flex";
          document.getElementsByClassName(
            "dados-complementares"
          )[0].style.display = "flex";
        })
        .catch((error) => {
          alert("Error in get cep: ", error);
        });
    }
  };

  function cadastrar(evento) {
    // let idCliente = localStorage.getItem('id');

    const endereco = {
      enderecos:[
          {
            localidadeCep: {
            cep: cep,
            logradouro: logradouro,
            complemento: complemento,
            bairro: bairro,
            cidade: cidade,
            uf: uf,
            tipoLogradouro: tipoLogradouro,
            latitude: latitude,
            longitude: longitude,
          },
          numero: evento.target.numero_endereco.value,
          complemento: evento.target.complemento_endereco.value,
          destinatario: evento.target.destinatario_endereco.value,
        }
      ]
      
      
    };

    const handleSubmit = event => {
      // 👇️ prevent page refresh
      event.preventDefault();
      navegar("/finalizar-compra-dois");
    };

      // let idCliente = localStorage.getItem('id');
    const idCliente = 1;

    api.post(`clientes/${idCliente}/enderecos`, endereco)
      .then((res) => {
        console.log(res);
        handleSubmit()
    })
      .catch((err) => {
        console.log(err);
    });

    localStorage.setItem("dados_usuario", JSON.stringify(endereco));

    // if (enderecos !== null) {
    //   navegar("/finalizar-compra-dois");
    // }
  }

  // function navegarTela() {
  //   // let idCliente = localStorage.getItem('id');

  //   // const endereco = {
  //   //   enderecos:[
  //   //       {
  //   //         localidadeCep: {
  //   //         cep: cep,
  //   //         logradouro: logradouro,
  //   //         complemento: complemento,
  //   //         bairro: bairro,
  //   //         cidade: cidade,
  //   //         uf: uf,
  //   //         tipoLogradouro: tipoLogradouro,
  //   //         latitude: latitude,
  //   //         longitude: longitude,
  //   //       },
  //   //       numero: evento.target.numero_endereco.value,
  //   //       complemento: evento.target.complemento_endereco.value,
  //   //       destinatario: evento.target.destinatario_endereco.value,
  //   //     }
  //   //   ]
      
      
  //   // };

  //     // let idCliente = localStorage.getItem('id');
  //   const idCliente = 1;

  //   api.post(`clientes/${idCliente}/enderecos`)
  //     .then((res) => {
  //       console.log(res);
  //       navegar("/finalizar-compra-dois");
  //   })
  //     .catch((err) => {
  //       console.log(err);
  //   });

  //   // if (enderecos !== null) {
  //   //   navegar("/finalizar-compra-dois");
  //   // }
  // }

  return (
    <>
      <div className="container-endereco">
        <div className="titulo-endereco">
          <BsHouseDoor />
          <h3>Endereço</h3>
        </div>

        <div className="cep-endereco">
          <p>CEP</p>
          <IMaskInput
            className="input-endereco"
            onChange={handleCep}
            type="text"
            name=""
            id=""
            mask="00000-000"
            placeholder="Insira o CEP"
          />
          <a
            href="https://buscacepinter.correios.com.br/app/endereco/index.php"
            target="_blank"
            rel="noopener noreferrer"
            className="ajuda-cep"
          >
            Não sei meu CEP
          </a>
        </div>
        {/* 
            <h3>Formas de Entrega</h3>

            <OpcoesFrete/> */}

        <h3 id="titulo-sessao-entrega">Endereço de entrega</h3>

        {/* <OpcoesCadastradas 
                logradouro={"Avenida Rosa Fioravante"} 
                number={189} 
                cep={"CEP: 09862-305"}
                cidade={"São Bernardo do Campo"}
                uf={"SP"}
            /> */}

        <div className="card-endereco">
          <BsHouseFill />
          <div className="corpo-card-endereco">
            <input type="text" disabled={true} id="tipo_logradouro" />
            <input type="text" disabled={true} id="cidade_endereco" />
            <button>Alterar</button>
          </div>
        </div>

        <form action="" className="dados-complementares" onSubmit={cadastrar.preventDefault}>
          <div className="dados-residenciais">
            <div className="box">
              <h4>Número</h4>
              <input type="text" name="numero_endereco" id="numero_endereco" />
            </div>

            <div className="box">
              <h4>Complemento e referência</h4>
              <input
                type="text"
                name="complemento_endereco"
                id="complemento_endereco"
              />
            </div>
          </div>
          <div className="box">
            <h4>Destinatário</h4>
            <input
              type="text"
              name="destinatario_endereco"
              id="destinatario_endereco"
            />
          </div>
          <button type="submit" className="btn-salvar-dados">
            Salvar
          </button>
        </form>
      </div>
    </>
  );
}

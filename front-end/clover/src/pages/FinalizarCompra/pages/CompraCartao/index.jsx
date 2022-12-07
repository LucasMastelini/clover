import React, { useState } from "react";
import { FcSimCardChip } from "react-icons/fc";
import { FaCcVisa, FaCcMastercard} from "react-icons/fa";

import "./style.css";
import api from "../../../../Api/api";

export default function CompraCartao({ setarPassos, passoAtual }) {
  const [numberCard, setNumberCard] = useState("");
  const [nameCard, setNameCard] = useState("");
  const [mesVencimento, setMesVencimento] = useState("");
  const [anoVencimento, setAnoVencimento] = useState("");
  const [cvv, setCvv] = useState("");
  const [virarCartao, setVirarCartao] = useState(false);

  function rotate() {
    setVirarCartao(true);
  }

  function rotateLeave() {
    setVirarCartao(false);
  }

  function enviarDados() {
    setarPassos(passoAtual + 1);
  }

  function cadastrarCartao(evento) {
    // let idCliente = localStorage.getItem('id');
    let idCliente = 1;

    const values = {
      cartoes: [
        {
          numero: evento.target.number_card.value,
          nome: evento.target.name_card.value,
          mes: evento.target.mounth_card.value,
          ano: evento.target.year_card.value,
          cvv: evento.target.cvv_card.value,
        },
      ],
    };

    api.post(`/clientes/${idCliente}/cartoes`, values)
      .then((res) => {
        console.log(res);
      })
      .catch((err) => {
        console.log(err);
      });
  }

  return (
    <>
      <div className="container-compra">
        <div className="card-container">
          <div className="front">
            <div className="icones-cartao">
              <FcSimCardChip />
              {numberCard.substring(0, 2) === "55" ? (
                <FaCcMastercard />
              ) : (
                <FaCcVisa />
              )}
            </div>
            <input
              className="card-number-box"
              placeholder="#### #### #### ####"
              defaultValue={numberCard}
              onChange={(event) => {
                setNumberCard(event.target.value);
              }}
              disabled={true}
            />
            <div className="flexbox">
              <div className="box">
                <span>titular cartão</span>
                <input
                  defaultValue={nameCard}
                  onChange={(event) => {
                    setNameCard(event.target.value);
                  }}
                  className="card-holder-name"
                  placeholder="nome completo"
                  disabled={true}
                />
              </div>
              <div className="box">
                <span>expiração</span>
                <div className="card-holder-name">
                  <input
                    defaultValue={mesVencimento}
                    onChange={(event) => {
                      setMesVencimento(event.target.value);
                    }}
                    className="exp-month"
                    placeholder="mês"
                    disabled={true}
                  />
                  <input
                    defaultValue={anoVencimento}
                    onChange={(event) => {
                      setAnoVencimento(event.target.value);
                    }}
                    className="exp-year"
                    placeholder="ano"
                    disabled={true}
                  />
                </div>
              </div>
            </div>
          </div>

          <div className={virarCartao ? "back" : ""}>
            <div className="stripe"></div>
            <div className="box">
              <span>cvv</span>
              <input
                className="cvv-box"
                disabled={true}
                value={cvv}
                onChange={(event) => {
                  setCvv(event.target.value);
                }}
              />
              <FaCcVisa />
            </div>
          </div>
        </div>

        <form
          action=""
          method="post"
          className="formulario"
          onSubmit={cadastrarCartao}
        >
          <div className="input-box">
            <span>número do cartão</span>
            <input
              type="number"
              min={16}
              max={16}
              defaultValue={numberCard}
              onChange={(event) => {
                setNumberCard(event.target.value);
              }}
              name=""
              id="number_card"
              className="card-holder-input"
            />
          </div>
          <div className="input-box">
            <span>titular do cartão</span>
            <input
              type="text"
              defaultValue={nameCard}
              onChange={(event) => {
                setNameCard(event.target.value);
              }}
              name=""
              id="name_card"
              className="card-holder-input"
            />
          </div>
          <div className="flexbox">
            <div className="input-box">
              <span>mês expiração</span>
              <select
                name=""
                defaultValue={mesVencimento}
                onChange={(event) => {
                  setMesVencimento(event.target.value);
                }}
                id="mounth_card"
                className="month-input"
              >
                <option defaultValue="month">mês</option>
                <option defaultValue="01">janeiro</option>
                <option defaultValue="02">fevereiro</option>
                <option defaultValue="03">março</option>
                <option defaultValue="04">abril</option>
                <option defaultValue="05">maio</option>
                <option defaultValue="06">junho</option>
                <option defaultValue="07">julho</option>
                <option defaultValue="08">agosto</option>
                <option defaultValue="09">setembro</option>
                <option defaultValue="10">outubro</option>
                <option defaultValue="11">novembro</option>
                <option defaultValue="12">dezembro</option>
              </select>
            </div>
            <div className="input-box">
              <span>ano expiração</span>
              <select
                name=""
                defaultValue={anoVencimento}
                onChange={(event) => {
                  setAnoVencimento(event.target.value);
                }}
                id="year_card"
                className="year-input"
              >
                <option defaultValue="year">ano</option>
                <option defaultValue="2022">2022</option>
                <option defaultValue="2023">2023</option>
                <option defaultValue="2024">2024</option>
                <option defaultValue="2025">2025</option>
                <option defaultValue="2026">2026</option>
                <option defaultValue="2027">2027</option>
                <option defaultValue="2028">2028</option>
                <option defaultValue="2029">2029</option>
                <option defaultValue="2030">2030</option>
              </select>
            </div>
            <div className="input-box">
              <span>cvv</span>
              <input
                type="text"
                onMouseEnter={rotate}
                onMouseLeave={rotateLeave}
                defaultValue={cvv}
                onChange={(event) => {
                  setCvv(event.target.value);
                }}
                maxLength={4}
                className="cvv-input"
                name=""
                id="cvv_card"
              />
            </div>
          </div>
          <div className="input-box">
            <span>quantidade de parcelas</span>
            <input
              type="text"
              defaultValue=""
              name=""
              id="parcel_card"
              className="card-holder-input"
            />
          </div>
          <button type="submit" defaultValue="submit" className="submit-btn">
            Finalizar pedido
          </button>
        </form>
      </div>
    </>
  );
}

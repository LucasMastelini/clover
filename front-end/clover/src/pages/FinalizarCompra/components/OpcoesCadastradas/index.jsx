import React from "react";
import { BsHouseFill } from "react-icons/bs";
import { AiFillEdit } from "react-icons/ai";
import { FaTrash } from "react-icons/fa";

import "./style.css";

export default function OpcoesCadastradas(props) {
  return (
    <>
      <div className="card-opcoes-cadastradas">
        <BsHouseFill /*{props.icon}*//>
        <div className="corpo-card-opcoes-cadastradas">
          <p>{props.logradouro}, {props.number}</p>
          <p>{props.cep}</p>
          <p>{props.cidade} - {props.uf}</p>
        </div>
        <div className="icons-opcoes-cadastradas">
          <AiFillEdit />
          <FaTrash className="icon-lixeira" />
        </div>
      </div>
    </>
  );
}

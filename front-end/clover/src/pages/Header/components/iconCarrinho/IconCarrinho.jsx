import React, { useState } from "react";
import "../style.css";

function IconCarrinho(props) {
  const [listaProduto, setListaProduto] = useState([]);

  setListaProduto(props);

  return (
    <div key={listaProduto[0].id}>
      Nome produto: {listaProduto[0].nome}
      Valor R$ {listaProduto[0].preco}
    </div>
  );
}

export default IconCarrinho;

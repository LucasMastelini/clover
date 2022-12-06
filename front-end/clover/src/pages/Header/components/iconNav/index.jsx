import React, { useState } from "react";

import "./style.css";

function IconNav(props) {
  
  const [subCategoria, setSubCategoria] = useState(props);
  const [abrirLista, setAbrirLista] = useState(false);

  function carregarLista() {
    setAbrirLista(true);
  }

  // console.log(subCategoria.categoria);

  return (
    <div className="texto">
      {
      subCategoria.categoria?.map((colecao) => {
        return (
          <div className="container">
            <p>{colecao.nome}</p>
            <p className="item-sub-categoria">{colecao.subcategorias?.map((sub_cat) => {
              return(
                <li className="list" onMouseEnter={carregarLista}>
                    <a
                      href="/"
                      className="item-sub-categoria"
                      key={sub_cat.id}
                    >
                      {sub_cat.nome}
                    </a>
                  </li>
              )
            })}</p>
          </div>
        );
      })
      }
    </div>
  );
}

export default IconNav;

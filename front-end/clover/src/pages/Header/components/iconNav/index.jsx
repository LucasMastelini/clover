import React, { useState } from "react";

import "./style.css";

function IconNav(props) {
  
  const [subCategoria, setSubCategoria] = useState(props);
  const [abrirLista, setAbrirLista] = useState(false);

  function carregarLista() {
    setAbrirLista(true);
  }

  // function filtroSubCat(nome){
  //   localStorage.setItem('id_sub_cat', nome)
  //   navegar('/filtros');
  // }

  // function filtroCat(nome){
  //   localStorage.setItem('id_cat', nome)
  //   navegar('/filtros')
  // }
  // console.log(subCategoria.categoria);

  return (
    <div className="texto">
      {
      subCategoria.categoria?.map((colecao) => {
        return (
          <div className="container">
            <p
            // onClick={filtroCat(colecao.nome)}
            >{colecao.nome}</p>
            <p className="item-sub-categoria">{colecao.subcategorias?.map((sub_cat) => {
              return(
                <li className="list" onMouseEnter={carregarLista}>
                    <a
                      href="/"
                      className="item-sub-categoria"
                      key={sub_cat.id}
                      // onClick={filtroSubCat(sub_cat.nome)}
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

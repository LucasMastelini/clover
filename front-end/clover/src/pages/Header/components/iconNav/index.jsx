import React, { useState } from "react";

import "./style.css";

function IconNav(props) {
  const [categoria, setCategoria] = useState(props.categoria);

  console.log(categoria);

  return (
    <div className="texto">
      {categoria.map((item) => {
        return (
          <div className="container">
            <p>{item.nome_categoria}</p>
            <p className="item-sub-categoria">{item.sub_categoria.map((sub_cat) => {
              return(
                <p>
                  {
                  sub_cat
                  }
                </p>
              )
            })}</p>
          </div>
        );
      })}
    </div>
  );
}

export default IconNav;

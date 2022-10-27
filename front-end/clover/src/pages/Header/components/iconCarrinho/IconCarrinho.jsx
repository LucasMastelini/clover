import React, { useState } from "react";
import "../style.css"

function IconCarrinho(props) {

    const [listaProduto, setListaProduto] = useState([]);

    setListaProduto(props);

    return(
        {
            listaProduto.map(item => (
                <div key={props.id}>
                    Nome produto: {item.nome}
                    Valor R$ {item.preco}
                </div>
            ))
        }
    );
    
}

export default IconCarrinho;
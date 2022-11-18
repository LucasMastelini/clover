import React, { createContext, useState, useContext } from "react";

const CarrinhoContext = createContext({});

export function CarrinhoProvider({ children }) {
  const [item, setItem] = useState([]);

  function adicionarQuantidade(idProd, nomeProd, valorProd) {
    const listaItens = [...item];

    const itemBusca = listaItens.find((i) => i.id === idProd);

    if(!itemBusca){
      listaItens.push({ id: idProd, nome: nomeProd, valor: valorProd, quantidade: 1 }); 
    }else{
      itemBusca.quantidade += 1;
    }
    setItem(listaItens);

    console.table(item)
  }

  function aumentarQuantidade(idProd){

    console.log(idProd)
    const listaItens = [...item];
    console.log(listaItens)

    // const itemBusca = listaItens.find((i) => i.id === idProd);
    // itemBusca.quantidade += 1;
    
    // setItem(listaItens);
  }

  function removerQuantidade(idProd) {
    const listaItens = [...item];
    
    const itemBusca = listaItens.find((i) => i.id === idProd);

    if(itemBusca.quantidade > 1){
      itemBusca.quantidade -= 1;
      setItem(listaItens)
    }else{
      {deletarItem(idProd)}
    }
  }

  function deletarItem(idProd) {
    const listaItens = [...item];
    const novaLitaItens = listaItens.filter(prod => prod.id !== idProd);
    setItem(novaLitaItens);
  }
  
  return (
    <CarrinhoContext.Provider value={{ item, aumentarQuantidade, removerQuantidade }}>
      {children}
    </CarrinhoContext.Provider>
  );
}

export const useCarrinho = () => {
  const context = useContext(CarrinhoContext);

  if (!context) {
    throw new Error("useCarrinho deve ser usado em um carrinho provider");
  }

  return context;
};

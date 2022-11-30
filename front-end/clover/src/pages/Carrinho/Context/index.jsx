import React, { createContext, useState, useContext } from "react";
import { useEffect } from "react";

const CarrinhoContext = createContext({});

export function CarrinhoProvider({ children }) {
  const [item, setItem] = useState([
    {
      id: 0,
      nome: 'nomeProd',
      valor: 0.45,
      quantidade: 2, 
    },
    {
      id: 1,
      nome: 'nomeProd',
      valor: 0.45,
      quantidade: 2, 
    },
    {
      id: 2,
      nome: 'nomeProd',
      valor: 0.45,
      quantidade: 2, 
    },
    {
      id: 3,
      nome: 'nomeProd',
      valor: 0.45,
      quantidade: 2, 
    },
    {
      id: 4,
      nome: 'nomeProd',
      valor: 0.45,
      quantidade: 2, 
    }
  ]);

  function adicionarProduto(idProd, nomeProd, valorProd) {
    const listaProdutos = [...item];

    const itemInformado = listaProdutos.find((i) => i.id === idProd);

    if (!itemInformado) {
      listaProdutos.push({
        id: idProd,
        nome: nomeProd,
        valor: valorProd,
        quantidade: 1,
      });
    } else {
      itemInformado.quantidade += 1;
    }

    setItem(listaProdutos);
  }

  useEffect(() => {
    console.log(item);
  }, [item]);

  function aumentarQuantidade(idProd) {
    const listaProdutos = [...item];

    const itemInformado = listaProdutos.find((i) => i.id === idProd);

    if (itemInformado) {
      itemInformado.quantidade += 1;
    }

    setItem(listaProdutos);
  }

  function removerQuantidade(idProd) {
    const listaItens = [...item];

    const itemBusca = listaItens.find((i) => i.id === idProd);

    if (itemBusca.quantidade > 1) {
      itemBusca.quantidade -= 1;
      setItem(listaItens);
    } else {
      {
        removerProduto(idProd);
      }
    }
  }

  function removerProduto(idProd) {
    const listaItens = [...item];
    const novaLitaItens = listaItens.filter((prod) => prod.id !== idProd);
    setItem(novaLitaItens);
  }

  function valorSubTotalItens() {
    let valorSubtotal = 0;

    item.map((item_produto) => {
      valorSubtotal += item_produto.valor * item_produto.quantidade;
    });

    return valorSubtotal.toFixed(2);
  }

  return (
    <CarrinhoContext.Provider
      value={{
        item,
        adicionarProduto,
        aumentarQuantidade,
        removerQuantidade,
        removerProduto,
        valorSubTotalItens,
      }}
    >
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

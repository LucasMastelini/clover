import React from "react";
import "./style.css";

function CardCupom(){
    const cupons = [
        {
            id:1,
            nome:"esquenta10",
            valor: 10
        },
        {
            id:2,
            nome:"heynerd20",
            valor: 20
        },
        {
            id:3,
            nome: "batsempre30",
            valor: 30
        },
        {
            id:4,
            nome: "emcasa40tenou",
            valor: 40
        },
        {
            id:5,
            nome:"brend4linda",
            valor: 50
        }
   
        
    ]
    return(
        <>
        <div className="container-card-cupom">
            <div className="porcentagem-cupom">
                
            </div>
            <div className="container-nome-cupom">
               <p className="titulo-cupom">Cupom:</p>
               <p className="nome-cupom">
               </p>
            </div>
        </div>
        </>
    );
}

export default CardCupom;
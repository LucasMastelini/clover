import React from 'react'

import "../../style.css"

export default function EtapaFazendo(props) {
  return (
    <>
        <div className="conjunto-etapa">
            <button className="etapa">{props.propsNumero}</button>
            <span>{props.propsName}</span>
        </div>
    </>
  )
}
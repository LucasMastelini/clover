import React from 'react'

import "../../style.css"

export default function EtapaAFazer(props) {
  return (
    <>
        <div className="conjunto-etapa-a-fazer">
            <button className="a-fazer">{props.propsNumero}</button>
            <span>{props.propsName}</span>
        </div>
    </>
  )
}

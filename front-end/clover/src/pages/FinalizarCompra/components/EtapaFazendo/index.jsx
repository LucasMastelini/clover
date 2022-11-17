import React from 'react'

import "../../style.css"

export default function EtapaFazendo({children}) {
  return (
    <>
        <div className="conjunto-etapa">
            <button className="etapa">4</button>
            <span>{children}</span>
        </div>
    </>
  )
}
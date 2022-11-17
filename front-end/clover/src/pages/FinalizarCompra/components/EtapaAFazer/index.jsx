import React from 'react'

import "../../style.css"

export default function EtapaAFazer({children}) {
  return (
    <>
        <div className="conjunto-etapa-a-fazer">
            <button className="a-fazer">5</button>
            <span>{children}</span>
        </div>
    </>
  )
}

import React from 'react'

import { BsCheckLg } from 'react-icons/bs';

import "../../style.css"

export default function EtapaFinalizada({children}) {
  return (
    <>
        <div className="conjunto-etapa">
            <button className="finalizado"><BsCheckLg/></button>
            <span>{children}</span>
        </div>
    </>
  )
}
import React from 'react'

import { FiLink2 } from 'react-icons/fi'
import { BsFillCheckCircleFill } from 'react-icons/bs'

import "./style.css"

export default function ArquivoRegistrado() {
  return (
    <>
        <div className="container-arquivo">
            <div className="body-right-arquivo">
                <h3>icone-caixa.jpg</h3>
                <p>110.4 kB</p>
            </div>
            <div className="body-left-arquivo">
                <FiLink2/>
                <BsFillCheckCircleFill/>
            </div>
        </div>
    </>
  )
}

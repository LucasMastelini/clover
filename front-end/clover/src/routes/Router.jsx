import React from 'react'
import { Routes, Route } from 'react-router-dom'
import HomePage from '../pages/HomePage'
import QuemSomos from '../pages/QuemSomos'
import CadastroLogin from '../pages/CadastroLogin'

export default function Router() {
  return (
      <Routes>
        <Route path="/" element={<HomePage/>}/>
        <Route path="/quem-somos" element={<QuemSomos/>}/>
        <Route path="/cadastro-login" element={<CadastroLogin/>}/>
      </Routes>
  )
}

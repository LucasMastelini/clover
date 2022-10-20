import React, { useState, useEffect } from "react";
import api from "../../Api/api";
// import cadastro from "../../Api/cadastro";
// import listar from "../../Api/listarUsuarios";
import { Formik, Field, Form } from "formik";
import schema from "../../schema";

import "./style.css";
import userIcon from "../../assets/image/user.png";
import emailIcon from "../../assets/image/email.png";
import telefoneIcon from "../../assets/image/celular.png";
import passwordIcon from "../../assets/image/senha.png";
import FormCadastro from "./components/FormCadastro/FormCadastro";
import FormLogin from "./components/FormLogin/FormLogin";
import Header from "../Header";
import Footer from "../../components/Footer";
function CadastroLogin() {
  // const [switchers, setSwitchers] = useState();
  // const [isActive, setIsActive] = useState();
  // const [cadastroIsActive, setCadastroIsActive] = useState();
  // const [loginIsActive, setLoginIsActive] = useState();

  // function cadastroSwitcher() {
  //     setCadastroIsActive(isActive)
  //     setLoginIsActive('form-wrapper')
  // }

  // function loginSwitcher() {
  //     setLoginIsActive(isActive)
  //     setCadastroIsActive('form-wrapper')
  // }

  // useEffect(() => {
  //     setIsActive('form-wrapper is-active')
  //     setCadastroIsActive('form-wrapper is-active')

  // }, [])

  return (
    <>
      <Header />
      <section className="forms-section">
        <div className="forms">
          <FormCadastro />
          <FormLogin />
        </div>
      </section>
      <Footer />
    </>
  );
}

export default CadastroLogin;

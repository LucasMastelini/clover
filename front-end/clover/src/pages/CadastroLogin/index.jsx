import React, { useEffect } from "react";

import './style.css'
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

  useEffect(() => {

    const switchers = [...document.querySelectorAll('.switcher')]

    switchers.forEach(item => {
        item.addEventListener('click', function () {
            switchers.forEach(item => item.parentElement.classList.remove('is-active'))
            this.parentElement.classList.add('is-active')
        })
    })

}, [])



    return (

        <>
        <Header/>
            <section className="forms-section">
                <div className="forms">
                
                    <FormCadastro />
                    <FormLogin />
                    


                </div>
            </section>
            <Footer/>
        </>
    );

}

export default CadastroLogin;

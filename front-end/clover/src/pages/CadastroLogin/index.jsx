import React, { useState, useEffect } from "react";
import api from "../../Api/api";

import './style.css';
import userIcon from '../../assets/image/user.png'
import emailIcon from '../../assets/image/email.png'
import telefoneIcon from '../../assets/image/celular.png'
import passwordIcon from '../../assets/image/senha.png'

function CadastroLogin() {
    // const switchers = [...document.querySelectorAll(".switcher")];
    const [switchers, setswitchers] = useState([]);
    
    useEffect(() => {
        setswitchers([...document.querySelectorAll(".switcher")])
        
        switchers.forEach((item) => {
            item.addEventListener("click", function () {
                switchers.forEach((item) =>
                    item.parentElement.classList.remove("is-active")
                );
                this.parentElement.classList.add("is-active");
            });
        });
        
    }, [])
    
    return (
        
        <>
            <section className="forms-section">
                <div className="forms">
                    <div className="form-wrapper is-active">
                        <button type="button" className="switcher switcher-cadastro">
                            Cadastre-se
                            <span className="underline"></span>
                        </button>
                        <form className="form form-cadastro">
                            <fieldset>
                                <div className="input-block">
                                    {/* <!- <Label>Nome Completo</Label>  */}
                                    <i className="icon">
                                        <img src={userIcon} alt="" />
                                    </i>
                                    <input id="cadastro-nome" type="text" placeholder="Nome completo" required />
                                </div>
                                <div className="input-block">
                                    <i>
                                        <img src={emailIcon} alt="" />
                                    </i>
                                    <input id="cadastro-email" type="email" placeholder="E-mail" required />
                                </div>
                                <div className="input-block">
                                    <i>
                                        <img src={passwordIcon} alt="" />
                                    </i>
                                    <input id="cadastro-senha" type="password" placeholder="Senha" required />
                                </div>
                                <div className="input-block">
                                    <i>
                                        <img src={passwordIcon} alt="" />
                                    </i>
                                    <input id="cadastro-senha-confirm" type="password" placeholder="Confirme sua senha" required />
                                </div>
                                <div className="input-block">
                                    <i>
                                        <img  src={telefoneIcon} alt="" />
                                    </i>
                                    <input id="cadastro-telefone" type="tel" placeholder="Numero de celular" required />
                                </div>
                            </fieldset>
                            <button type="submit" className="btn-signup">Criar conta</button>
                        </form>
                    </div>
                    <div className="form-wrapper">
                        <button type="button" className="switcher switcher-signup">
                            Entrar
                            <span className="underline"></span>
                        </button>
                        <form className="form form-signup">
                            <fieldset>
                                <div className="input-block">
                                    <i>
                                        <img className="email" src={emailIcon} alt="" />
                                    </i>
                                    <input id="login-email" type="email" placeholder="E-mail" required />
                                </div>
                                <div className="input-block">
                                    <i>
                                        <img src={passwordIcon} alt="" />
                                    </i>
                                    <input id="login-senha" type="password" placeholder="Senha" required />
                                </div>
                                <button id="update-senha">Esqueceu sua senha?</button>
                            </fieldset>
                            <button type="submit" className="btn-cadastro">Acessar minha conta </button>
                        </form>
                    </div>
                </div>
            </section>
        </>

    );
}
{
    function listarUsuarios(){
        api.get()
        .then(res => {
            console.log(res.data)
        })
        .catch(err => {
            console.log(err)
        })
    }

    listarUsuarios()
}



export default CadastroLogin;
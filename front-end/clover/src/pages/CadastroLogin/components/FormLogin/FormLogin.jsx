import React, { useState, useEffect } from "react";
import api from "../../Api/api";
// import cadastro from "../../Api/cadastro";
// import listar from "../../Api/listarUsuarios";
import {Formik, Field, Form} from 'formik';
import schema from '../../schema';

import './style.css';
import userIcon from '../../assets/image/user.png'
import emailIcon from '../../assets/image/email.png'
import telefoneIcon from '../../assets/image/celular.png'
import passwordIcon from '../../assets/image/senha.png'

function FormLogin(){
    return (
        <>
         <div className={loginIsActive}>
                        <button on type="button" className="switcher switcher-signup"
                        onClick={loginSwitcher()}>
                            Entrar
                            <span className="underline"></span>
                        </button>
                        <Formik 
                        validationSchema={schema}
                        onSubmit={onSubmit} 
                        // validateOnMount
                        initialValues={{
                            email: '',
                            senha: '',
                        }} 
                        render = {({values}) =>(<Form className="form form-signup">
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
                        </Form>)}
                        />
                    </div>
        </>
    )
}


export default FormLogin
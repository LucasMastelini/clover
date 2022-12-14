import React, { useState } from "react";
import api from "../../../../Api/api";
import { Formik, Field, Form } from 'formik';

import emailIcon from '../../../../assets/image/email.png'
import passwordIcon from '../../../../assets/image/senha.png'
import schemaLogin from "../../../../schemaLogin";
import { useNavigate } from "react-router-dom";
import { useEffect } from "react";

function FormLogin() {

    const[validacao , setValidacao] = useState(true);
    const navegar = useNavigate();

    function onSubmit(values, actions) {

        api.post('/login',
            values
        )
            .then(res => {
                alert(`Bem Vindo ${res.data.nome}!`);
                localStorage.setItem('nome', res.data.nome);
                localStorage.setItem('email', res.data.email);
                localStorage.setItem('id', res.data.id);
                localStorage.setItem('isLogado', res.data.logado);
                res.data.perfis?.map((status) => {status === 1 ? localStorage.setItem('isAdmin', true): localStorage.setItem('isAdmin', false );})
                res.data.perfis?.map((status) => {status === 1 ? navegar("/admin") : navegar("/")})  
                actions.resetForm();
            }).catch(err => {
                // console.log(err)
                if(err.response.status === 500) alert(err.response.data.error);  
                if (err.response.status === 403) {
                    alert("Email ou Senha incorretos")
                }
            })
    }


    return (
        <>
            <div className="form-wrapper is-active">
                <button on type="button" className="switcher switcher-signup"
                >
                    Entrar
                    <span className="underline"></span>
                </button>
                <Formik
                    
                    validationSchema={schemaLogin}
                    onSubmit={onSubmit}
                    validateOnMount
                    initialValues={{
                        email: '',
                        senha: '',
                    }}
                    render={({ values, touched }) => (
                        <Form className="form form-signup">
                            <fieldset>
                                <div className="input-block">
                                    <i>
                                        <img className="email" src={emailIcon} alt="" />
                                    </i>
                                    <Field
                                        autoComplete="off"
                                        className="input-valida"
                                        name="email"
                                        id="login-email"
                                        type="email"
                                        placeholder="E-mail"
                                        required />
                                </div>
                                <div className="input-block">
                                    <i>
                                        <img src={passwordIcon} alt="" />
                                    </i>
                                    <Field
                                        className="input-valida"
                                        name="senha"
                                        id="login-senha"
                                        type="password"
                                        placeholder="Senha"
                                        required />
                                </div>
                                <button id="update-senha">Esqueceu sua senha?</button>
                            </fieldset>
                            <button type="submit" className="btn-cadastro" disabled={!validacao}>Acessar minha conta </button>
                        </Form>)}
                />
            </div>
        </>
    )
}


export default FormLogin
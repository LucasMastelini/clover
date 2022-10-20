import React, { useState, useEffect } from "react";
import api from "../../../../Api/api";
// import cadastro from "../../../../Api/cadastro";
// import listar from "../../../../Api/listarUsuarios";
import { Formik, Field, Form } from 'formik';
import schemaLogin from '../../../../schemaLogin';


import userIcon from '../../../../assets/image/user.png'
import emailIcon from '../../../../assets/image/email.png'
import telefoneIcon from '../../../../assets/image/celular.png'
import passwordIcon from '../../../../assets/image/senha.png'

function FormLogin(props) {

    
    //  const [json, setJson] = useState([]);
    
    // function login(){

    // }
    
    // useEffect(() => {
        
    //     setJson(
    //         props.email,
    //         props.senha
    //     )
    
    // }, [])
    
    function onSubmit(values, actions) {

        api.post('/login',
            values
        )
            .then(res => {
                actions.resetForm();
                console.log('SUBMIT', values)
                alert(`Bem vindo ${values.nome}`)
            }).catch(err => {
                console.log(err)
                console.log(values)
                if(err.response.status === 403){
                alert("Email ou Senha incorretos")}
                actions.resetForm();
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
                    // validationSchema={schemaLogin}
                    onSubmit={onSubmit}
                    // validateOnMount
                    initialValues={{
                        email: '',
                        senha: '',
                    }}
                    render={({ values }) => (
                        <Form className="form form-signup">
                            <fieldset>
                                <div className="input-block">
                                    <i>
                                        <img className="email" src={emailIcon} alt="" />
                                    </i>
                                    <Field name="email" id="login-email" type="email" placeholder="E-mail" required />
                                </div>
                                <div className="input-block">
                                    <i>
                                        <img src={passwordIcon} alt="" />
                                    </i>
                                    <Field name="senha" d="login-senha" type="password" placeholder="Senha" required />
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
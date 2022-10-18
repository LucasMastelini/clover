import React, { useState } from "react";
// import api from "../../Api/api";
import cadastro from "../../Api/cadastro";
import listar from "../../Api/listarUsuarios";
import {Formik, Field, Form, ErrorMessage} from 'formik';
import schema from '../../schema';

import './style.css';
import userIcon from '../../assets/image/user.png'
import emailIcon from '../../assets/image/email.png'
import telefoneIcon from '../../assets/image/celular.png'
import passwordIcon from '../../assets/image/senha.png'

function CadastroLogin() {
    // const [switchers, setswitchers] = useState([]);
    // setswitchers([...document.querySelectorAll(".switcher")])
    
    // function switcher(){
       
    // }

    // function listarUsuarios(){
    //     listar.get()
    //     .then(res => {
    //         console.log(res.data)
    //     })
    //     .catch(err => {
    //         console.log(err)
    //     })
    // }
    // listarUsuarios()

    


    // cadastro.post('/cadastro-usuario', 
    // {
        
    // })

    function onSubmit(values, actions){
        console.log('SUBMIT',values)
        
    }

    
    return (
        
        <>
            <section className="forms-section">
                <div className="forms">
                    <div className="form-wrapper is-active">
                        <button type="button" className="switcher switcher-cadastro">
                            Cadastre-se
                            <span className="underline"></span>
                        </button>
                        <Formik
                        validationSchema={schema}
                        onSubmit={onSubmit} 
                        validateOnMount
                        initialValues={{
                            nome: '',
                            email: '',
                            senha: '',
                            confirmacao: '',
                            celular: '',
                        }}
                        render = {({values, errors, touched}) => (
                            <Form className="form form-cadastro" >
                            <fieldset>
                                <div className="input-block">
                                    {/* <!- <Label>Nome Completo</Label>  */}
                                    <i className="icon">
                                        <img src={userIcon} alt="" />
                                    </i>
                                    <Field name="nome"  type="text" placeholder="Nome completo"  />
                                    <ErrorMessage name="nome"/>
                                </div>
                                <div className="input-block">
                                    <i>
                                        <img src={emailIcon} alt="" />
                                    </i>
                                    <Field name="email" value={values.email} type="email" placeholder="E-mail"  />
                                    <ErrorMessage name="email"/>
                                </div>
                                <div className="input-block">
                                    <i>
                                        <img src={passwordIcon} alt="" />
                                    </i>
                                    <Field name="senha" id="cadastro-senha" type="password" placeholder="Senha"  />
                                </div>
                                <div className="input-block">
                                    <i>
                                        <img src={passwordIcon} alt="" />
                                    </i>
                                    <Field name="confirmacao" id="cadastro-senha-confirm" type="password" placeholder="Confirme sua senha"  />
                                </div>
                                <div className="input-block">
                                    <i>
                                        <img  src={telefoneIcon} alt="" />
                                    </i>
                                    <Field name="celular" id="cadastro-telefone" type="text" placeholder="Numero de celular"  />
                                </div>
                            </fieldset>
                            <button type="submit" className="btn-signup">Criar conta</button>
                        </Form>
                        )}
                        />
                    </div>
                    <div className="form-wrapper">
                        <button  type="button" className="switcher switcher-signup">
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




export default CadastroLogin;
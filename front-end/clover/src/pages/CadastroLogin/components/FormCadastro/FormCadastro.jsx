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

function FormCadastro(){
    function onSubmit(values){
        
        api.post('cadastro-usuario',
            values
        )
        .then(res => {
            // actions.resetForm();
            console.log('SUBMIT',values)
        }).catch(err => {
            console.log(err)
            console.log(values)
            // actions.resetForm();
        })
    }
    return (
        <>
        <div className={cadastroIsActive}>
                        <button type="button" className="switcher switcher-cadastro"
                        onClick={cadastroSwitcher}>
                            Cadastre-se
                            <span className="underline"></span>
                        </button>
                        <Formik
                        validationSchema={schema}
                        onSubmit={onSubmit} 
                        // validateOnMount
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
                                   
                                </div>
                                <div className="input-block">
                                    <i>
                                        <img src={emailIcon} alt="" />
                                    </i>
                                    <Field name="email" value={values.email} type="email" placeholder="E-mail"  />
                                    
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
        </>
    )
}


export default FormCadastro
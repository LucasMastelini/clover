import React, { useState, useEffect } from "react";
import api from "../../../../Api/api";
// import cadastro from "../../../../Api/cadastro";
// import listar from "../../../../Api/listarUsuarios";
import { Formik, Field, Form } from 'formik';
import schema from '../../../../schema';

import userIcon from '../../../../assets/image/user.png'
import emailIcon from '../../../../assets/image/email.png'
import telefoneIcon from '../../../../assets/image/celular.png'
import passwordIcon from '../../../../assets/image/senha.png'


function FormCadastro() {
    function onSubmit(values, actions) {

        api.post('/clientes/cadastro',
            values)
            .then(res => {
                console.log('SUBMIT', values)
                console.log(res)
                alert(res.data.nome `Cadastrado efetuado com sucesso `)
                actions.resetForm();
            }).catch(err => {
                // console.log(err.response)
                alert(err.response.data.msg)
            })
    }

    
    return (
        <>
            <div className="form-wrapper is-active">
                <button type="button" className="switcher switcher-cadastro"
                >
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
                    render={({ values, errors, touched }) => (
                        <Form className="form form-cadastro" >
                            <fieldset>
                                <div className="input-block">
                                    {/* <!- <Label>Nome Completo</Label>  */}
                                    <i>
                                        <img src={userIcon} alt="" />
                                    </i>
                                    <Field name="nome" type="text" placeholder="Nome completo" required/>

                                </div>
                                <div className="input-block">
                                    <i>
                                        <img src={emailIcon} alt="" />
                                    </i>
                                    <Field name="email" type="email" placeholder="E-mail" required/>

                                </div>
                                <div className="input-block">
                                    <i>
                                        <img src={passwordIcon} alt="" />
                                    </i>
                                    <Field name="senha" id="cadastro-senha" type="password" placeholder="Senha" required/>
                                </div>
                                <div className="input-block">
                                    <i>
                                        <img src={passwordIcon} alt="" />
                                    </i>
                                    <Field name="confirmacao" id="cadastro-senha-confirm" type="password" placeholder="Confirme sua senha" required />
                                </div>
                                <div className="input-block">
                                    <i>
                                        <img src={telefoneIcon} alt="" />
                                    </i>
                                    <Field name="celular" id="cadastro-telefone" type="text" placeholder="Numero de celular" required/>
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
import React, { useState } from "react";
import api from "../../../../Api/api";
import { Formik, Field, Form } from 'formik';
import schema from '../../../../schema';
import { useNavigate } from "react-router-dom";

import userIcon from '../../../../assets/image/user.png'
import emailIcon from '../../../../assets/image/email.png'
import telefoneIcon from '../../../../assets/image/celular.png'
import passwordIcon from '../../../../assets/image/senha.png'
import FormLogin from "../FormLogin";

function FormCadastro() {
    const [validateConfirmacao, setValidateConfirmacao] = useState(true);
    const [validateEmail, setValidateEmail] = useState(true);
    const [validateSenha, setValidateSenha] = useState(true);
    const [validarCadastrado, setValidarCadastrado] = useState(false);
    const [inputValida, setInputValida] = useState("input-valida");
    const [inputInValida, setInputInValida] = useState("input-invalida");
    const navegar = useNavigate();



    function onSubmit(values, actions) {

        if (values.senha !== values.confirmacao) {
            setValidateConfirmacao(false)
            setValidateSenha(false)
            setValidateSenha(false)
            setValidateEmail(true)
            navegar("/cadastro-login")
            alert("Senhas não são compativeis")
            return;
        }

        api.post('/clientes/cadastro',
            values)
            .then(res => {
                setValidateConfirmacao(true)
                setValidateEmail(true)
                setValidateSenha(true)
                // console.log(res);
                alert(`${values.nome} seu cadastrado foi efetuado com sucesso `)
                actions.resetForm();
                navegar("/cadastro-login")
            }).catch(err => {
                console.log(err.response)
                if(err.response.status === 500) alert(err.response.data.msg) ;  
                err.response.data.errors?.map((erro) =>{
                    if(erro.fieldName === "email" )
                    {
                    setValidateEmail(false);
                    setValidateSenha(true);
                    setValidateConfirmacao(true);
                    alert(`${erro.message}`)
                    }
                    else if(erro.fieldName === "senha")
                    {
                    setValidateEmail(true);
                    setValidateSenha(false);
                    setValidateConfirmacao(true);
                    alert(`${erro.message} de validação (Pelo menos 8 caracteres, uma maiuscula, um "@,/,#,$..." e um numero)`)
                    }
                    else if(erro.status === 500)
                    {
                    alert(`${erro.data.error}`)    
                    }
                    
                });
                    
                
            })
    }

    return (
        <>
            <div className="form-wrapper">
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
                        telefone: '',
                    }}
                    render={({ values, touched, actions }) => (
                        <Form className="form form-cadastro" >
                            <fieldset>
                                <div className="input-block">
                                    {/* <!- <Label>Nome Completo</Label>  */}
                                    <i>
                                        <img src={userIcon} alt="" />
                                    </i>
                                    <Field
                                        autoComplete="off"
                                        className="input-valida"
                                        name="nome"
                                        type="text"
                                        placeholder="Nome completo" required />

                                </div>
                                <div className="input-block">
                                    <i>
                                        <img src={emailIcon} alt="" />
                                    </i>
                                    <Field
                                        autoComplete="off"
                                        className={validateEmail ? inputValida : inputInValida}
                                        name="email"
                                        type="email"
                                        placeholder="E-mail" required />

                                </div>
                                <div className="input-block">
                                    <i>
                                        <img src={passwordIcon} alt="" />
                                    </i>
                                    <Field
                                        autoComplete="off"
                                        className={validateSenha ? inputValida : inputInValida}
                                        name="senha"
                                        id="cadastro-senha"
                                        type="password"
                                        placeholder="Senha" required />

                                </div>
                                <div className="input-block">
                                    <i>
                                        <img src={passwordIcon} alt="" />
                                    </i>
                                    <Field
                                        autoComplete="off"
                                        className={validateConfirmacao ? inputValida : inputInValida}
                                        name="confirmacao"
                                        id="cadastro-senha-confirm"
                                        type="password"
                                        placeholder="Confirme sua senha" required />
                                </div>
                                <div className="input-block">
                                    <i>
                                        <img src={telefoneIcon} alt="" />
                                    </i>
                                    <Field
                                        autoComplete="off"
                                        className="input-valida"
                                        name="telefone" 
                                        id="cadastro-telefone"
                                        type="text"
                                        placeholder="Numero de celular" required />
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
import React, { useState } from "react";
import api from "../../../../Api/api";
import { Formik, Field, Form } from 'formik';
import schema from '../../../../schema';
import { useNavigate } from "react-router-dom";

import userIcon from '../../../../assets/image/user.png'
import emailIcon from '../../../../assets/image/email.png'
import telefoneIcon from '../../../../assets/image/celular.png'
import passwordIcon from '../../../../assets/image/senha.png'


function FormCadastro() {
    const [validateConfirmacao, setValidateConfirmacao] = useState(true);
    const [validateEmail, setValidateEmail] = useState(true);
    const [validateSenha, setValidateSenha] = useState(true);
    const [cadastrado, setCadastrado] = useState(false);

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
                setCadastrado(true)
                setValidateConfirmacao(true)
                setValidateEmail(true)
                setValidateSenha(true)
                alert(`${values.nome} seu cadastrado efetuado com sucesso `)
                console.log('SUBMIT', values)
                console.log(res)
                actions.resetForm();
                navegar("/cadastro-login")
            }).catch(err => {
                console.log(err.response)
                if(err.response.data.msg){
                    setValidateEmail(false);
                    setValidateSenha(false);
                    setValidateConfirmacao(true);
                    alert(`${err.response.data.msg}, Email ou Senha Já existem`)
                }
            })

    }

    return (
        <>
            <div className= "form-wrapper">
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
                    render={({ values, touched, actions }) => (
                        <Form className="form form-cadastro" >
                            <fieldset>
                                <div className="input-block">
                                    {/* <!- <Label>Nome Completo</Label>  */}
                                    <i>
                                        <img src={userIcon} alt="" />
                                    </i>
                                    <Field
                                        autocomplete="off"
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
                                        autocomplete="off"
                                        className={validateEmail? inputValida : inputInValida}
                                        name="email"
                                        type="email"
                                        placeholder="E-mail" required />

                                </div>
                                <div className="input-block">
                                    <i>
                                        <img src={passwordIcon} alt="" />
                                    </i>
                                    <Field
                                        autocomplete="off"
                                        className={validateSenha? inputValida : inputInValida}
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
                                        autocomplete="off"
                                        className={validateConfirmacao? inputValida : inputInValida}
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
                                        autocomplete="off"
                                        className="input-valida"
                                        name="celular" id="cadastro-telefone"
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
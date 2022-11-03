import React, {useState} from "react";
import api from "../../../../Api/api";
import { Formik, Field, Form } from 'formik';

import emailIcon from '../../../../assets/image/email.png'
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
    const [response, setResponse] = useState([]);
    
    function onSubmit(values, actions) {

        api.post('/login',
            values
        )
            .then(res => {
                // actions.resetForm();
                // console.log(res)
                // console.log('SUBMIT', values)
                setResponse(values);
                alert(`Bem Vindo ${res.data.nome}!`)
                localStorage.setItem('responseKey', JSON.stringify(response))
                var jsonResponse = localStorage.getItem('responseKey');
                console.log(JSON.parse(jsonResponse))
                actions.resetForm();
            }).catch(err => {
                console.log(err)
                // console.log(values)
                if(err.response.status === 403){
                alert("Email ou Senha incorretos")}
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
                    validateOnMount
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
                                    <Field name="senha" id="login-senha" type="password" placeholder="Senha" required />
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
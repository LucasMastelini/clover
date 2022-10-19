import * as Yup from 'yup';

export default Yup.object().shape({
    nome: Yup.string().max(45).required(),
    email: Yup.string().email().required(),
    senha: Yup.string().max(45).required(),
    confirmacao: Yup.string().max(45).required(),
});
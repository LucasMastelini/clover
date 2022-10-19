import * as Yup from 'yup';

export default Yup.object().shape({
    nome: Yup.string().min(45).required(),
    email: Yup.string().email().required(),
});
import * as Yup from 'yup';

export default Yup.object().shape({
    email: Yup.string().email().required(),
    senha: Yup.string().max(20).min(8).required(),
});
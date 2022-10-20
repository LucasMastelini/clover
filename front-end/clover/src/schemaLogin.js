import * as Yup from 'yup';

export default Yup.object().shape({
    emailLogin: Yup.string().email().required(),
    senhaLogin: Yup.string().max(20).min(8).required(),
});
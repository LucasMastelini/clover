import axios from 'axios';
import api from './api';

const cadastro = axios.create({
  baseURL: "http://localhost:8080/cadastro-usuario"
})

export default cadastro;
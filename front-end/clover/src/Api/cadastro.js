import axios from 'axios';
import api from './api';

const cadastro = axios.create({
  baseURL: api.baseURL
})

export default cadastro;
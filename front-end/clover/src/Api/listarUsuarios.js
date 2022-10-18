import axios from 'axios';


const listar = axios.create({
  baseURL: "http://localhost:8080/usuarios"
})

export default listar;
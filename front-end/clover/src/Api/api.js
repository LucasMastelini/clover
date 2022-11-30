import axios from 'axios';
axios.defaults.headers.common = {'Authorization': `Bearer ${localStorage.getItem('token')}`}

const api = axios.create({

  baseURL: "http://localhost:8080"

})

export default api;
import axios from 'axios'

const api = axios.create({
   baseURL: "https://drug-tcc-pablo.herokuapp.com",
   timeout: 5000,
});


export default api;
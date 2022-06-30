import axios from "axios"

class UsuariosService {
    async login(data) {
      return axios({
          url: "https://drug-tcc-pablo.herokuapp.com/login",
          method: "POST",
          timeout: 5000,
          data: data,
          headers: {
             Accept: 'application/json'
          }
      }).then((response)=>{
         return Promise.resolve(response)
      }).catch((error)=>{
        return Promise.reject(error)
      })
    }
  }
  
  const usuarioService = new UsuariosService()
  export default usuarioService
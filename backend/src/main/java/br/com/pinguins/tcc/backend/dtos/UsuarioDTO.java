package br.com.pinguins.tcc.backend.dtos;

import br.com.pinguins.tcc.backend.entities.Usuario;

public class UsuarioDTO {

    private Integer id;
    private String nome;
    private String login;
    private String senha;

    public UsuarioDTO(){}

    public UsuarioDTO(Usuario usuario) {
        id = usuario.getId();
        nome = usuario.getNome();
        login = usuario.getLogin();
        senha = usuario.getSenha();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}

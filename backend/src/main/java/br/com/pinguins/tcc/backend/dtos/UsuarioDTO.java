package br.com.pinguins.tcc.backend.dtos;

import br.com.pinguins.tcc.backend.entities.Remedio;
import br.com.pinguins.tcc.backend.entities.Usuario;

import javax.validation.constraints.Email;
import java.util.HashSet;
import java.util.Set;

public class UsuarioDTO {


    private Integer id;
    private String nome;

    @Email
    private String login;

    private String senha;

    private Set<Remedio> remedios = new HashSet<>();

    public UsuarioDTO(){}

    public UsuarioDTO(Usuario usuario) {
        nome = usuario.getNome();
        login = usuario.getLogin();
        senha = usuario.getSenha();
        remedios = usuario.getRemedios();
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

    public void setRemedios(Set<Remedio> remedios) {
        this.remedios = remedios;
    }

    public Set<Remedio> getRemedios() {
        return remedios;
    }
}
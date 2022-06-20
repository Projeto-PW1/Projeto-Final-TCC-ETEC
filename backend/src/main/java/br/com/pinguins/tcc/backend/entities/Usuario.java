<<<<<<< HEAD
package br.com.pinguins.tcc.backend.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ConstraintMode;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Email;

import java.util.*;

@Entity
public class Usuario implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Integer id;

    @Column(nullable = false, length = 70)
    private String nome;

    @Column(nullable = false, length = 50, unique = true)
    @Email
    private String login;

    @Column(nullable = false, length = 70)
    private String senha;

    @JsonIgnore
    private String token = "";

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonIgnore
    private Set<Remedio> remedios = new HashSet<>();

    public Usuario(){}

    public Usuario(Integer id, String nome, String email, String senha, String token, Set<Remedio> remedios) {
        this.id = id;
        this.nome = nome;
        this.senha = senha;
        this.login = email;
        this.token = token;
        this.remedios = remedios;
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

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public void setRemedios(Set<Remedio> remedios) {
        this.remedios = remedios;
    }

    public Set<Remedio> getRemedios() {
        return remedios;
    }

    public List<Role> getRoles() {
        return roles;
    }

    @OneToMany(fetch = FetchType.EAGER)
    @JsonIgnore
    @JoinTable(name = "usuarios_role",uniqueConstraints = @UniqueConstraint(
            columnNames = { "usuario_id", "role_id" },
            name = "unique_role_user"), joinColumns = { @JoinColumn(name = "usuario_id",
            referencedColumnName = "id",
            table = "usuario", foreignKey = @ForeignKey(name = "usuario_fk"))},

            inverseJoinColumns = { @JoinColumn(name = "role_id",
                    referencedColumnName = "id", updatable = false,
                    table = "role", foreignKey = @ForeignKey(name = "role_fk", value = ConstraintMode.CONSTRAINT)
            )})
    private List<Role> roles;

    @Override
    @JsonIgnore
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles;
    }

    @Override
    @JsonIgnore
    public String getPassword() {
        return this.senha;
    }

    @Override
    @JsonIgnore
    public String getUsername() {
        return this.login;
    }

    @Override
    @JsonIgnore
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    @JsonIgnore
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    @JsonIgnore
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    @JsonIgnore
    public boolean isEnabled() {
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return Objects.equals(id, usuario.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
=======
package br.com.pinguins.tcc.backend.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ConstraintMode;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Email;

import java.util.*;

@Entity
public class Usuario implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Integer id;

    @Column(nullable = false, length = 70)
    private String nome;

    @Column(nullable = false, length = 50, unique = true)
    @Email
    private String login;

    @Column(nullable = false, length = 70)
    private String senha;

    @JsonIgnore
    private String token = "";

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonIgnore
    private Set<Remedio> remedios = new HashSet<>();

    public Usuario(){}

    public Usuario(Integer id, String nome, String email, String senha, String token, Set<Remedio> remedios) {
        this.id = id;
        this.nome = nome;
        this.senha = senha;
        this.login = email;
        this.token = token;
        this.remedios = remedios;
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

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public void setRemedios(Set<Remedio> remedios) {
        this.remedios = remedios;
    }

    public Set<Remedio> getRemedios() {
        return remedios;
    }

    public List<Role> getRoles() {
        return roles;
    }

    @OneToMany(fetch = FetchType.EAGER)
    @JsonIgnore
    @JoinTable(name = "usuarios_role",uniqueConstraints = @UniqueConstraint(
            columnNames = { "usuario_id", "role_id" },
            name = "unique_role_user"), joinColumns = { @JoinColumn(name = "usuario_id",
            referencedColumnName = "id",
            table = "usuario", foreignKey = @ForeignKey(name = "usuario_fk"))},

            inverseJoinColumns = { @JoinColumn(name = "role_id",
                    referencedColumnName = "id", updatable = false,
                    table = "role", foreignKey = @ForeignKey(name = "role_fk", value = ConstraintMode.CONSTRAINT)
            )})
    private List<Role> roles;

    @Override
    @JsonIgnore
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles;
    }

    @Override
    @JsonIgnore
    public String getPassword() {
        return this.senha;
    }

    @Override
    @JsonIgnore
    public String getUsername() {
        return this.login;
    }

    @Override
    @JsonIgnore
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    @JsonIgnore
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    @JsonIgnore
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    @JsonIgnore
    public boolean isEnabled() {
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return Objects.equals(id, usuario.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
>>>>>>> 606904349d8119483c76590e5f98c9c5439da15d
}
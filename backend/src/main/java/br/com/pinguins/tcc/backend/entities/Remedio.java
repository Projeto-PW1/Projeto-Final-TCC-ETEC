<<<<<<< HEAD
package br.com.pinguins.tcc.backend.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

@Entity
public class Remedio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String titulo;

    @Column(length = 45, nullable = false)
    private Integer quantidadeMedicamento;

    @Column(nullable = false)
    private LocalDate dataLembreteRemedio;

    @Column(nullable = false)
    private LocalTime horarioLembreteRemedio;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_user"))
    private Usuario usuario;

    public Remedio(){}

    public Remedio(Integer id, String titulo, Integer quantidadeMedicamento, LocalDate dataLembreteRemedio, LocalTime horarioLembreteRemedio, Usuario usuario) {
        this.id = id;
        this.titulo = titulo;
        this.quantidadeMedicamento = quantidadeMedicamento;
        this.dataLembreteRemedio = dataLembreteRemedio;
        this.horarioLembreteRemedio = horarioLembreteRemedio;
        this.usuario = usuario;
    }

    public Remedio(int i, String remedii, int i1, String s, String s1) {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Integer getQuantidadeMedicamento() {
        return quantidadeMedicamento;
    }

    public void setQuantidadeMedicamento(Integer quantidadeMedicamento) {
        this.quantidadeMedicamento = quantidadeMedicamento;
    }

    public LocalDate getDataLembreteRemedio() {
        return dataLembreteRemedio;
    }

    public void setDataLembreteRemedio(LocalDate dataLembreteRemedio) {
        this.dataLembreteRemedio = dataLembreteRemedio;
    }

    public LocalTime getHorarioLembreteRemedio() {
        return horarioLembreteRemedio;
    }

    public void setHorarioLembreteRemedio(LocalTime horarioLembreteRemedio) {
        this.horarioLembreteRemedio = horarioLembreteRemedio;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Remedio remedio = (Remedio) o;
        return Objects.equals(id, remedio.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
=======
package br.com.pinguins.tcc.backend.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

@Entity
public class Remedio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String titulo;

    @Column(length = 45, nullable = false)
    private Integer quantidadeMedicamento;

    @Column(nullable = false)
    private LocalDate dataLembreteRemedio;

    @Column(nullable = false)
    private LocalTime horarioLembreteRemedio;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_user"))
    private Usuario usuario;

    public Remedio(){}

    public Remedio(Integer id, String titulo, Integer quantidadeMedicamento, LocalDate dataLembreteRemedio, LocalTime horarioLembreteRemedio, Usuario usuario) {
        this.id = id;
        this.titulo = titulo;
        this.quantidadeMedicamento = quantidadeMedicamento;
        this.dataLembreteRemedio = dataLembreteRemedio;
        this.horarioLembreteRemedio = horarioLembreteRemedio;
        this.usuario = usuario;
    }

    public Remedio(int i, String remedii, int i1, String s, String s1) {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Integer getQuantidadeMedicamento() {
        return quantidadeMedicamento;
    }

    public void setQuantidadeMedicamento(Integer quantidadeMedicamento) {
        this.quantidadeMedicamento = quantidadeMedicamento;
    }

    public LocalDate getDataLembreteRemedio() {
        return dataLembreteRemedio;
    }

    public void setDataLembreteRemedio(LocalDate dataLembreteRemedio) {
        this.dataLembreteRemedio = dataLembreteRemedio;
    }

    public LocalTime getHorarioLembreteRemedio() {
        return horarioLembreteRemedio;
    }

    public void setHorarioLembreteRemedio(LocalTime horarioLembreteRemedio) {
        this.horarioLembreteRemedio = horarioLembreteRemedio;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Remedio remedio = (Remedio) o;
        return Objects.equals(id, remedio.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
>>>>>>> 606904349d8119483c76590e5f98c9c5439da15d

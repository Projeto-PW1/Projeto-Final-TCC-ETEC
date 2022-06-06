package br.com.pinguins.tcc.backend.dtos;

import br.com.pinguins.tcc.backend.entities.Remedio;
import br.com.pinguins.tcc.backend.entities.Usuario;

import java.time.LocalDate;
import java.time.LocalTime;

public class RemedioDTO {

    private Integer id;
    private String titulo;
    private Integer quantidadeMedicamento;
    private LocalDate dataLembreteRemedio;
    private LocalTime horarioLembreteRemedio;
    private Usuario userId;

    public RemedioDTO(){}

    public RemedioDTO(Remedio remedio) {
        id = remedio.getId();
        titulo = remedio.getTitulo();
        quantidadeMedicamento = remedio.getQuantidadeMedicamento();
        dataLembreteRemedio = remedio.getDataLembreteRemedio();
        horarioLembreteRemedio = remedio.getHorarioLembreteRemedio();
        userId = remedio.getUsuario();
    }

    public RemedioDTO(Integer id, String titulo, Integer quantidadeMedicamento, LocalDate dataLembreteRemedio, LocalTime horarioLembreteRemedio, Usuario usuario){
        this.id = id;
        this.titulo = titulo;
        this.quantidadeMedicamento = quantidadeMedicamento;
        this.dataLembreteRemedio = dataLembreteRemedio;
        this.horarioLembreteRemedio = horarioLembreteRemedio;
        this.userId = usuario;
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

    public Usuario getUserId() {
        return userId;
    }

    public void setUserId(Usuario userId) {
        this.userId = userId;
    }
}

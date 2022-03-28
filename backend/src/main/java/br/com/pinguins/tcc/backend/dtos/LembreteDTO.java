package br.com.pinguins.tcc.backend.dtos;

import java.time.LocalDate;

public class LembreteDTO {

    private Integer id;
    private String titulo;
    private LocalDate dataLembrete;
    private String descricao;

    public LembreteDTO(){}

    public LembreteDTO(Integer id, String titulo, LocalDate dataLembrete, String descricao) {
        this.id = id;
        this.titulo = titulo;
        this.dataLembrete = dataLembrete;
        this.descricao = descricao;
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

    public LocalDate getDataLembrete() {
        return dataLembrete;
    }

    public void setDataLembrete(LocalDate dataLembrete) {
        this.dataLembrete = dataLembrete;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}

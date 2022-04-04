package br.com.pinguins.tcc.backend.dtos;

import br.com.pinguins.tcc.backend.entities.Remedio;

public class RemedioDTO {

    public Integer id;
    public String nome;
    public String descricao;

    public RemedioDTO(){}

    public RemedioDTO(Remedio remedio) {
        id = remedio.getId();
        nome = remedio.getNome();
        descricao = remedio.getDescricao();
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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}

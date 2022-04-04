package br.com.pinguins.tcc.backend.mappers;

import br.com.pinguins.tcc.backend.dtos.RemedioDTO;
import br.com.pinguins.tcc.backend.entities.Remedio;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class RemedioMapper {

    public Remedio toEntity(RemedioDTO dto) {
        Remedio remedio = new Remedio();

        remedio.setId(dto.getId());
        remedio.setId(dto.getId());
        remedio.setNome(dto.getNome());
        remedio.setDescricao(dto.getDescricao());

        return remedio;
    }

    public RemedioDTO toDto(Remedio remedio) {
        RemedioDTO dto = new RemedioDTO();

        dto.setId(remedio.getId());
        dto.setId(remedio.getId());
        dto.setNome(remedio.getNome());
        dto.setDescricao(remedio.getDescricao());
        return dto;
    }

    public List<RemedioDTO> dtoList(List<Remedio> listUser) {
        return listUser.stream().map(RemedioDTO::new).collect(Collectors.toList());
    }
}

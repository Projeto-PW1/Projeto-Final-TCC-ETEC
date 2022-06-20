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

        remedio.setTitulo(dto.getTitulo());
        remedio.setQuantidadeMedicamento(dto.getQuantidadeMedicamento());
        remedio.setDataLembreteRemedio(dto.getDataLembreteRemedio());
        remedio.setHorarioLembreteRemedio(dto.getHorarioLembreteRemedio());
        remedio.setUsuario(dto.getUserId());

        return remedio;
    }

    public RemedioDTO toDto(Remedio remedio) {
        RemedioDTO dto = new RemedioDTO();

        dto.setTitulo(dto.getTitulo());
        dto.setQuantidadeMedicamento(remedio.getQuantidadeMedicamento());
        dto.setDataLembreteRemedio(remedio.getDataLembreteRemedio());
        dto.setHorarioLembreteRemedio(remedio.getHorarioLembreteRemedio());
        dto.setUserId(dto.getUserId());

        return dto;
    }

    public List<RemedioDTO> dtoList(List<Remedio> listUser) {
        return listUser.stream().map(RemedioDTO::new).collect(Collectors.toList());
    }
}

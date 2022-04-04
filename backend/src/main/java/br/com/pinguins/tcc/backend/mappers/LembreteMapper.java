package br.com.pinguins.tcc.backend.mappers;

import br.com.pinguins.tcc.backend.dtos.LembreteDTO;
import br.com.pinguins.tcc.backend.entities.Lembrete;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class LembreteMapper {

    public Lembrete toEntity(LembreteDTO dto) {
        Lembrete lembrete = new Lembrete();

        lembrete.setId(dto.getId());
        lembrete.setTitulo(dto.getTitulo());
        lembrete.setDataLembrete(dto.getDataLembrete());
        lembrete.setDescricao(dto.getDescricao());

        return lembrete;
    }

    public LembreteDTO toDto(Lembrete lembrete) {
        LembreteDTO dto = new LembreteDTO();

        dto.setId(lembrete.getId());
        dto.setTitulo(lembrete.getTitulo());
        dto.setDataLembrete(lembrete.getDataLembrete());
        dto.setDescricao(lembrete.getDescricao());

        return dto;
    }

    public List<LembreteDTO> dtoList(List<Lembrete> listUser) {
        return listUser.stream().map(LembreteDTO::new).collect(Collectors.toList());
    }
}

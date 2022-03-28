package br.com.pinguins.tcc.backend.services;

import br.com.pinguins.tcc.backend.dtos.LembreteDTO;
import br.com.pinguins.tcc.backend.entities.Lembrete;
import br.com.pinguins.tcc.backend.exceptions.ResourceNotFoundException;
import br.com.pinguins.tcc.backend.mappers.LembreteMapper;
import br.com.pinguins.tcc.backend.repositories.LembreteRepository;
import br.com.pinguins.tcc.backend.utils.MessageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class LembreteService {

    @Autowired
    private LembreteRepository repository;

    private LembreteMapper mapper;


    @Transactional(readOnly = true)
    public List<LembreteDTO> findAll() {
        List<Lembrete> list = repository.findAll();

        return mapper.dtoList(list);
    }

    @Transactional
    public LembreteDTO findById(Integer id) {
        return repository
                .findById(id)
                .map(mapper::toDto)
                .orElseThrow(() -> new ResourceNotFoundException(MessageUtil.MESSAGE_USER_NOT_FOUND));
    }


    @Transactional
    public LembreteDTO save(LembreteDTO lembreteDTO) {

        Lembrete lembrete = mapper.toEntity(lembreteDTO);

        repository.save(lembrete);

        return mapper.toDto(lembrete);
    }

    @Transactional
    public void deleteById(Integer id) {
        repository.findById(id)
                .map(mapper::toDto).orElseThrow(() -> new ResourceNotFoundException(MessageUtil.MESSAGE_USER_NOT_FOUND));

        repository.deleteById(id);
    }

    @Transactional
    public LembreteDTO updateById(Integer id, LembreteDTO lembreteDTO) {
        Lembrete lembrete = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(MessageUtil.MESSAGE_USER_NOT_FOUND));

        lembrete.setTitulo(lembrete.getTitulo());
        lembrete.setDataLembrete(lembrete.getDataLembrete());
        lembrete.setDescricao(lembrete.getDescricao());

        repository.save(lembrete);

        return mapper.toDto(lembrete);
    }
}

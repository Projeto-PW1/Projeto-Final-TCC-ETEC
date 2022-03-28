package br.com.pinguins.tcc.backend.services;

import br.com.pinguins.tcc.backend.dtos.RemedioDTO;
import br.com.pinguins.tcc.backend.entities.Remedio;
import br.com.pinguins.tcc.backend.exceptions.BusinessException;
import br.com.pinguins.tcc.backend.exceptions.ResourceNotFoundException;
import br.com.pinguins.tcc.backend.mappers.RemedioMapper;
import br.com.pinguins.tcc.backend.repositories.RemedioRepository;
import br.com.pinguins.tcc.backend.utils.MessageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RemedioService {

    @Autowired
    private RemedioRepository repository;

    @Autowired
    private RemedioMapper mapper;

    @Transactional(readOnly = true)
    public List<RemedioDTO> findAll() {

        List<Remedio> remedioList = repository.findAll();

        return mapper.dtoList(remedioList);
    }

    @Transactional(readOnly = true)
    public List<RemedioDTO> findByNome(String nome) {

        List<RemedioDTO> remedioDTOS = mapper.dtoList(repository.findByNome(nome));
        if (remedioDTOS.stream().noneMatch(x -> x.equals(nome))){
            throw new BusinessException(MessageUtil.MESSAGE_USER_NOT_FOUND);
        }

        return remedioDTOS;
    }

    @Transactional
    public RemedioDTO save(RemedioDTO remedioDTO) {

        Remedio remedio = mapper.toEntity(remedioDTO);

        repository.save(remedio);

        return mapper.toDto(remedio);
    }

    @Transactional
    public void deleteById(Integer id) {
        repository.findById(id)
                .map(mapper::toDto)
                .orElseThrow(() -> new ResourceNotFoundException(MessageUtil.MESSAGE_USER_NOT_FOUND));
    }

    @Transactional
    public RemedioDTO updateById(Integer id, RemedioDTO dto) {
        Remedio remedio = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(MessageUtil.MESSAGE_USER_NOT_FOUND));

        remedio.setNome(dto.getNome());
        remedio.setDescricao(dto.getDescricao());

        return mapper.toDto(remedio);
    }
}

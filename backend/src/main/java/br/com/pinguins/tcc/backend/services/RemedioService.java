package br.com.pinguins.tcc.backend.services;

import br.com.pinguins.tcc.backend.dtos.RemedioDTO;
import br.com.pinguins.tcc.backend.entities.Remedio;
import br.com.pinguins.tcc.backend.entities.Usuario;
import br.com.pinguins.tcc.backend.exceptions.BusinessException;
import br.com.pinguins.tcc.backend.exceptions.ResourceNotFoundException;
import br.com.pinguins.tcc.backend.mappers.RemedioMapper;
import br.com.pinguins.tcc.backend.repositories.RemedioRepository;
import br.com.pinguins.tcc.backend.repositories.UsuarioRepository;
import br.com.pinguins.tcc.backend.utils.MessageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RemedioService {

    private final RemedioRepository repository;
    private final UsuarioRepository usuarioRepository;
    private final RemedioMapper mapper;

    @Autowired
    public RemedioService(RemedioRepository repository, RemedioMapper mapper, UsuarioRepository usuarioRepository) {
        this.repository = repository;
        this.mapper = mapper;
        this.usuarioRepository = usuarioRepository;

    }

    @Transactional(readOnly = true)
    public List<RemedioDTO> findAll() {
        List<Remedio> remedioList = repository.findAll();

        return mapper.dtoList(remedioList);
    }

    @Transactional(readOnly = true)
    public List<RemedioDTO> findByNome(String nome) {

        List<RemedioDTO> remedioDTOS = mapper.dtoList(repository.findByNome(nome));
        if (remedioDTOS.stream().noneMatch(x -> x.equals(nome))){
            return remedioDTOS;
        } else {
            throw new BusinessException(MessageUtil.MESSAGE_USER_NOT_FOUND);
        }
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

        remedio.setTitulo(dto.getTitulo());
        remedio.setQuantidadeMedicamento(dto.getQuantidadeMedicamento());
        remedio.setDataLembreteRemedio(dto.getDataLembreteRemedio());
        remedio.setHorarioLembreteRemedio(dto.getHorarioLembreteRemedio());

        return mapper.toDto(remedio);
    }

    public Remedio addRemedioUser(Remedio remedio, Integer id) {

        Usuario usuario = usuarioRepository.findById(id).get();
        remedio.setUsuario(usuario);
        repository.save(remedio);

        return remedio;
    }

}

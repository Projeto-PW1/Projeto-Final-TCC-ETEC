package br.com.pinguins.tcc.backend.services;


import br.com.pinguins.tcc.backend.dtos.UsuarioDTO;
import br.com.pinguins.tcc.backend.entities.Usuario;
import br.com.pinguins.tcc.backend.exceptions.ResourceNotFoundException;
import br.com.pinguins.tcc.backend.mappers.UsuarioMapper;
import br.com.pinguins.tcc.backend.repositories.UsuarioRepository;
import br.com.pinguins.tcc.backend.utils.MessageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final UsuarioMapper mapper;

    @Autowired
    public UsuarioService(UsuarioRepository usuarioRepository, UsuarioMapper mapper) {
        this.usuarioRepository = usuarioRepository;
        this.mapper = mapper;
    }

    @Transactional(readOnly = true)
    public List<UsuarioDTO> findAll() {
        List<Usuario> userList = usuarioRepository.findAll();

        return mapper.dtoList(userList);
    }

    @Transactional
    public UsuarioDTO findById(Integer id) {
        return usuarioRepository
                .findById(id)
                .map(mapper::toDto)
                .orElseThrow(() -> new ResourceNotFoundException(MessageUtil.MESSAGE_USER_NOT_FOUND));
    }


    @Transactional
    public UsuarioDTO save(UsuarioDTO usuarioDTO) {

        Usuario usuario = mapper.toEntity(usuarioDTO);

        usuarioRepository.save(usuario);

        return mapper.toDto(usuario);
    }

    @Transactional
    public void deleteById(Integer id) {
        usuarioRepository.findById(id)
                .map(mapper::toDto).orElseThrow(() -> new ResourceNotFoundException(MessageUtil.MESSAGE_USER_NOT_FOUND));

        usuarioRepository.deleteById(id);
    }

    @Transactional
    public UsuarioDTO updateById(Integer id, UsuarioDTO usuarioDTO) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(MessageUtil.MESSAGE_USER_NOT_FOUND));

        usuario.setNome(usuarioDTO.getNome());
        usuario.setEmail(usuarioDTO.getEmail());
        usuario.setSenha(usuarioDTO.getSenha());

        usuarioRepository.save(usuario);

        return mapper.toDto(usuario);
    }
}

package br.com.pinguins.tcc.backend.mappers;

import br.com.pinguins.tcc.backend.dtos.UsuarioDTO;
import br.com.pinguins.tcc.backend.entities.Usuario;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UsuarioMapper {

    public Usuario toEntity(UsuarioDTO dto) {
        Usuario usuario = new Usuario();

        usuario.setNome(dto.getNome());
        usuario.setLogin(dto.getLogin());
        usuario.setSenha(dto.getSenha());
        return usuario;
    }

    public UsuarioDTO toDto(Usuario usuario) {
        UsuarioDTO dto = new UsuarioDTO();

        dto.setNome(usuario.getNome());
        dto.setLogin(usuario.getLogin());
        dto.setSenha(usuario.getSenha());
        return dto;
    }

    public List<UsuarioDTO> dtoList(List<Usuario> listUser) {
        return listUser.stream().map(UsuarioDTO::new).collect(Collectors.toList());
    }
}

package br.com.pinguins.tcc.backend.repositories;

import br.com.pinguins.tcc.backend.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    @Query("SELECT u from Usuario u where u.login = ?1")
    Usuario findUsuarioByLogin(String login);

}

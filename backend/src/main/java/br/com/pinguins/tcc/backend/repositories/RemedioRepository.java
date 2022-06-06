package br.com.pinguins.tcc.backend.repositories;

import br.com.pinguins.tcc.backend.entities.Remedio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RemedioRepository extends JpaRepository<Remedio, Integer> {

    @Query("SELECT n FROM Remedio as n WHERE n.titulo LIKE %?1")
    List<Remedio> findByNome(String nome);
}

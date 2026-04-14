package br.com.trabalho.faculdade.backend.Backend.repository;

import br.com.trabalho.faculdade.backend.Backend.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    Optional<Cliente> findByNome (String nome);
}

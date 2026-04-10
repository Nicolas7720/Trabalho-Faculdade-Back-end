package br.com.trabalho.faculdade.backend.Backend.repository;

import br.com.trabalho.faculdade.backend.Backend.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {
}

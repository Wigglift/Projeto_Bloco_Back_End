package br.com.infnet.ProjetoInfnet.model.repository;

import br.com.infnet.ProjetoInfnet.model.domain.entities.PedidoItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoItemRepository extends JpaRepository<PedidoItem,Integer> {
}

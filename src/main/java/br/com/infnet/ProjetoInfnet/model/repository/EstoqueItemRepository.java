package br.com.infnet.ProjetoInfnet.model.repository;

import br.com.infnet.ProjetoInfnet.model.domain.entities.EstoqueItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstoqueItemRepository extends JpaRepository<EstoqueItem,Integer> {
}

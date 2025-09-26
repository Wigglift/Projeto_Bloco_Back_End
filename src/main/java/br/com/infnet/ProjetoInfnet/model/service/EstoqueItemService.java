package br.com.infnet.ProjetoInfnet.model.service;

import br.com.infnet.ProjetoInfnet.model.domain.entities.EstoqueItem;
import br.com.infnet.ProjetoInfnet.model.repository.EstoqueItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstoqueItemService {

    @Autowired
    EstoqueItemRepository estoqueItemRepository;

    public List<EstoqueItem> getEstoque(){
        return estoqueItemRepository.findAll();
    }

    public EstoqueItem adicionarItem(EstoqueItem estoqueItem){
        return estoqueItemRepository.save(estoqueItem);
    }

}

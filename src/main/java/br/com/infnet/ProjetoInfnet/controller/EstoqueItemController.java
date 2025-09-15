package br.com.infnet.ProjetoInfnet.controller;

import br.com.infnet.ProjetoInfnet.model.domain.entities.EstoqueItem;
import br.com.infnet.ProjetoInfnet.model.service.EstoqueItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EstoqueItemController {

    @Autowired
    EstoqueItemService estoqueItemService;

    public void mostrarEstoque(){
        List<EstoqueItem> estoqueItem = estoqueItemService.getEstoque();

        for(EstoqueItem item : estoqueItem){
            System.out.println(item);
        }
    }

    public void adicionarItem(EstoqueItem item){
        EstoqueItem itemAdicionado = estoqueItemService.adicionarItem(item);

        System.out.println(itemAdicionado);
    }
}

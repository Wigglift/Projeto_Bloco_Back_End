package br.com.infnet.ProjetoInfnet.controller;

import br.com.infnet.ProjetoInfnet.model.domain.entities.EstoqueItem;
import br.com.infnet.ProjetoInfnet.model.service.EstoqueItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EstoqueItemController {

    @Autowired
    EstoqueItemService estoqueItemService;

    public ResponseEntity<List<EstoqueItem>> pegarEstoque(){
        List<EstoqueItem> estoqueItem = estoqueItemService.getEstoque();

        return new ResponseEntity<List<EstoqueItem>>(estoqueItem, HttpStatus.OK);
    }

    public ResponseEntity<EstoqueItem> adicionarItem(EstoqueItem item){
        EstoqueItem itemAdicionado = estoqueItemService.adicionarItem(item);

        return new ResponseEntity<>(itemAdicionado,HttpStatus.CREATED);
    }
}

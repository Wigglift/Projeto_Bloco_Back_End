package br.com.infnet.ProjetoInfnet.controller;

import br.com.infnet.ProjetoInfnet.model.domain.CarrinhoDeCompras;
import br.com.infnet.ProjetoInfnet.model.domain.entities.PedidoItem;
import br.com.infnet.ProjetoInfnet.model.service.CarrinhoDeComprasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Scanner;

@RestController
public class CarrinhoDeComprasController {

    @Autowired
    private CarrinhoDeComprasService carrinhoDeComprasService;

    public ResponseEntity<PedidoItem> adicionarItem(int escolha, int quantidade){

        try {
            PedidoItem itemAdicionado = carrinhoDeComprasService.adicionarItem(escolha, quantidade);

            if (itemAdicionado == null) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

            return new ResponseEntity<PedidoItem>(itemAdicionado, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<List<PedidoItem>> mostrarCarrinho(){
        return new ResponseEntity<>(CarrinhoDeCompras.getItens(), HttpStatus.OK);
    }

    public ResponseEntity<Void> renovarCarrinho(){

        carrinhoDeComprasService.renovarCarrinho();

        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

}

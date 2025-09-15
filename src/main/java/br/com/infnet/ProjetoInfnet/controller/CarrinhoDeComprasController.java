package br.com.infnet.ProjetoInfnet.controller;

import br.com.infnet.ProjetoInfnet.model.domain.entities.PedidoItem;
import br.com.infnet.ProjetoInfnet.model.service.CarrinhoDeComprasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Scanner;

@RestController
public class CarrinhoDeComprasController {

    @Autowired
    private CarrinhoDeComprasService carrinhoDeComprasService;

    public void adicionarItem(Scanner scanner){
        System.out.println("Digite o número do item que quer adicionar no carrinho");
        int escolha = scanner.nextInt();

        System.out.println("Digite a quantidade");
        int quantidade = scanner.nextInt();

        List<PedidoItem> carrinho = carrinhoDeComprasService.adicionarItem(escolha, quantidade);
    }

    public void mostrarCarrinho(){
        carrinhoDeComprasService.mostrarCarrinho();
    }

    public void renovarCarrinho(){

        carrinhoDeComprasService.renovarCarrinho();

    }

}

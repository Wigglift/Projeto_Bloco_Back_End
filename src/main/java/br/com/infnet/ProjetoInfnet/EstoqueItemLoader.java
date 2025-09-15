package br.com.infnet.ProjetoInfnet;

import br.com.infnet.ProjetoInfnet.controller.EstoqueItemController;
import br.com.infnet.ProjetoInfnet.model.domain.entities.EstoqueItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(1)
public class EstoqueItemLoader implements ApplicationRunner {

    @Autowired
    EstoqueItemController estoqueItemController;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        estoqueItemController.adicionarItem(new EstoqueItem("Notebook Dell Inspiron", 3500.00, 5));
        estoqueItemController.adicionarItem(new EstoqueItem("Mouse Gamer Logitech", 120.50, 20));
        estoqueItemController.adicionarItem(new EstoqueItem("Teclado Mecânico Redragon", 250.00, 15));
        estoqueItemController.adicionarItem(new EstoqueItem("Monitor LG 24'' Full HD", 899.90, 8));
        estoqueItemController.adicionarItem(new EstoqueItem("Headset HyperX Cloud II", 450.00, 12));
        estoqueItemController.adicionarItem(new EstoqueItem("SSD Kingston 480GB", 280.00, 25));
        estoqueItemController.adicionarItem(new EstoqueItem("Placa de Vídeo RTX 3060", 2200.00, 4));
        estoqueItemController.adicionarItem(new EstoqueItem("Cadeira Gamer DT3", 1350.00, 3));
        estoqueItemController.adicionarItem(new EstoqueItem("Smartphone Samsung Galaxy S23", 3999.99, 6));
        estoqueItemController.adicionarItem(new EstoqueItem("Roteador TP-Link Archer AX50", 650.00, 10));
    }
}

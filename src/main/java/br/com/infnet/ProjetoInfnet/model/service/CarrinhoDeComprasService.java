package br.com.infnet.ProjetoInfnet.model.service;

import br.com.infnet.ProjetoInfnet.model.domain.CarrinhoDeCompras;
import br.com.infnet.ProjetoInfnet.model.domain.entities.EstoqueItem;
import br.com.infnet.ProjetoInfnet.model.domain.entities.PedidoItem;
import br.com.infnet.ProjetoInfnet.model.repository.EstoqueItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarrinhoDeComprasService {

    @Autowired
    EstoqueItemRepository estoqueItemRepository;

    public List<PedidoItem> adicionarItem(int escolha, int quantidade){

        EstoqueItem itemEstoque = estoqueItemRepository.findById(escolha).orElseThrow(RuntimeException::new);

        PedidoItem itemPedido = new PedidoItem(itemEstoque.getNome(),itemEstoque.getPreco(),quantidade);

        CarrinhoDeCompras.adicionarItem(itemPedido);

        return CarrinhoDeCompras.getItens();
    }

    public void mostrarCarrinho(){
        System.out.println("Carrinho de compras:");
        for(PedidoItem item : CarrinhoDeCompras.getItens()){
            System.out.println(item);
        }
    }

    public void renovarCarrinho(){
        CarrinhoDeCompras.renovarCarrinho();
    }
}

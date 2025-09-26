package br.com.infnet.ProjetoInfnet.model.domain;

import br.com.infnet.ProjetoInfnet.model.domain.entities.Pedido;
import br.com.infnet.ProjetoInfnet.model.domain.entities.PedidoItem;
import br.com.infnet.ProjetoInfnet.model.domain.enumerator.StatusPedido;

public class CadastroPedido {


    public static Pedido criarPedido(Pedido pedido){

        pedido.setConteudo(CarrinhoDeCompras.getItens());

        pedido.setPreco(CarrinhoDeCompras.valorTotal());

        for(PedidoItem itens : pedido.getConteudo()){
            itens.setPedido(pedido);
        }

        pedido.setUsuario(LoginUsuario.getUsuarioAtual());

        pedido.setStatus(StatusPedido.EMPREPARO);

        return pedido;
    }
}

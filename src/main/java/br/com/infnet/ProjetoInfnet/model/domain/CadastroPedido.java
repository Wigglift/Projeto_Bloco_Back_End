package br.com.infnet.ProjetoInfnet.model.domain;

import br.com.infnet.ProjetoInfnet.model.domain.entities.Pedido;
import br.com.infnet.ProjetoInfnet.model.domain.entities.PedidoItem;
import br.com.infnet.ProjetoInfnet.model.domain.enumerator.StatusPedido;

public class CadastroPedido {
    private Pedido pedido;
    private String email;


    public Pedido criarPedido(Pedido pedido){

        for(PedidoItem itens : pedido.getConteudo()){
            itens.setPedido(pedido);
        }

        pedido.setUsuario(LoginUsuario.getUsuarioAtual());

        pedido.setStatus(StatusPedido.EMPREPARO);

        return pedido;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

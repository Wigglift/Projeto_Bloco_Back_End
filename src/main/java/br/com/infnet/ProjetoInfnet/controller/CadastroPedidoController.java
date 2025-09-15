package br.com.infnet.ProjetoInfnet.controller;

import br.com.infnet.ProjetoInfnet.model.domain.CarrinhoDeCompras;
import br.com.infnet.ProjetoInfnet.model.domain.LoginUsuario;
import br.com.infnet.ProjetoInfnet.model.domain.entities.Pedido;
import br.com.infnet.ProjetoInfnet.model.domain.enumerator.StatusPedido;
import br.com.infnet.ProjetoInfnet.model.domain.enumerator.TipoPagamentoPedido;
import br.com.infnet.ProjetoInfnet.model.service.CadastroPedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CadastroPedidoController {

    @Autowired
    CadastroPedidoService cadastroPedidoService;

    public void criarPedido(){

        Pedido pedido = new Pedido(CarrinhoDeCompras.valorTotal(),"rua 0",TipoPagamentoPedido.PIX,CarrinhoDeCompras.getItens());

        cadastroPedidoService.criarPedido(pedido);
    }

    public void pegarConteudo(){
        var teste = cadastroPedidoService.teste();

        for(var testes : teste){
            System.out.println(testes);
        }
    }

}

package br.com.infnet.ProjetoInfnet.model.service;

import br.com.infnet.ProjetoInfnet.model.domain.CadastroPedido;
import br.com.infnet.ProjetoInfnet.model.domain.entities.Pedido;
import br.com.infnet.ProjetoInfnet.model.domain.entities.PedidoItem;
import br.com.infnet.ProjetoInfnet.model.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CadastroPedidoService {

    @Autowired
    PedidoRepository pedidoRepository;

    public Pedido criarPedido(Pedido pedido){

        CadastroPedido cadastroPedido = new CadastroPedido();
        Pedido novoPedido = cadastroPedido.criarPedido(pedido);

        return pedidoRepository.save(novoPedido);
    }

    public List<PedidoItem> teste(){
        return pedidoRepository.findById(1).orElseThrow(RuntimeException :: new).getConteudo();
    }
}

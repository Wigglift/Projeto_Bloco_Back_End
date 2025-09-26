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

        Pedido novoPedido = CadastroPedido.criarPedido(pedido);



        return pedidoRepository.save(novoPedido);
    }
}

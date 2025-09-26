package br.com.infnet.ProjetoInfnet.model.service;

import br.com.infnet.ProjetoInfnet.model.domain.entities.Pedido;
import br.com.infnet.ProjetoInfnet.model.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlterarPedidoService {

    @Autowired
    PedidoRepository pedidoRepository;

    public Pedido alterarEndereco(int id,String endereco){
        Pedido pedidoAtual = pedidoRepository.findById(id).orElseThrow(RuntimeException :: new);

        pedidoAtual.setEndereco(endereco);

        return pedidoRepository.save(pedidoAtual);
    }
}

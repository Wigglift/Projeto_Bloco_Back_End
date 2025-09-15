package br.com.infnet.ProjetoInfnet.model.service;

import br.com.infnet.ProjetoInfnet.model.domain.entities.Pedido;
import br.com.infnet.ProjetoInfnet.model.repository.PedidoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CancelarPedidoService {

    @Autowired
    PedidoRepository pedidoRepository;

    @Transactional
    public void cancelarPedido(int id){
        Pedido pedido = pedidoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pedido não encontrado"));
        pedidoRepository.delete(pedido);
    }

}

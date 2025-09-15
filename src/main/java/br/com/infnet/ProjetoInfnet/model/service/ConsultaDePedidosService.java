package br.com.infnet.ProjetoInfnet.model.service;

import br.com.infnet.ProjetoInfnet.model.domain.LoginUsuario;
import br.com.infnet.ProjetoInfnet.model.domain.entities.Pedido;
import br.com.infnet.ProjetoInfnet.model.domain.entities.Usuario;
import br.com.infnet.ProjetoInfnet.model.repository.PedidoRepository;
import br.com.infnet.ProjetoInfnet.model.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConsultaDePedidosService {

    @Autowired
    UsuarioRepository usuarioRepository;

    public List<Pedido> pegarPedidos(){
        return usuarioRepository.findById(LoginUsuario.getUsuarioAtual().getEmail()).orElseThrow(RuntimeException::new).getPedidos();
    }

}

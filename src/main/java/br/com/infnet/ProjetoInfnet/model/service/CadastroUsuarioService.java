package br.com.infnet.ProjetoInfnet.model.service;

import br.com.infnet.ProjetoInfnet.model.domain.CadastroUsuario;
import br.com.infnet.ProjetoInfnet.model.domain.entities.Usuario;
import br.com.infnet.ProjetoInfnet.model.repository.UsuarioRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CadastroUsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    //cadastrar
    public Usuario cadastrar(CadastroUsuario novoCadastro){

        if(cadastroExistente(novoCadastro.getEmail())) return null;

        Usuario novoUsuario = novoCadastro.criarUsuario();

        return usuarioRepository.save(novoUsuario);
    }

    //email ja existe
    public boolean cadastroExistente(String email){
        return usuarioRepository.existsById(email);
    }
}

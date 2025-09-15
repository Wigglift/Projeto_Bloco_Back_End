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
    public String cadastrar(String email, String senha){

        if(cadastroExistente(email)) return "Usuário já existente";

        CadastroUsuario novoCadastro = new CadastroUsuario(email,senha);

        Usuario novoUsuario = novoCadastro.criarUsuario();

        Usuario usuarioCdastrado = usuarioRepository.save(novoUsuario);

        return "Usuario " + usuarioCdastrado.getEmail()+ " cadastrado com sucesso";
    }

    //email ja existe
    public boolean cadastroExistente(String email){
        return usuarioRepository.existsById(email);
    }
}

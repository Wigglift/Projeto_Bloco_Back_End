package br.com.infnet.ProjetoInfnet.model.service;

import br.com.infnet.ProjetoInfnet.model.domain.LoginUsuario;
import br.com.infnet.ProjetoInfnet.model.domain.entities.Usuario;
import br.com.infnet.ProjetoInfnet.model.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginUsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

    public Usuario logar(String email, String senha){

        try{
            Usuario tentativaLogin = usuarioRepository.findById(email).orElseThrow(RuntimeException::new);
            if(!tentativaLogin.getSenha().equals(senha)){
                Usuario usuarioFalho = new Usuario();
                usuarioFalho.setEmail(email);
                usuarioFalho.setSenha(null);
                return usuarioFalho;
            }

            LoginUsuario.setLogado(true);
            LoginUsuario.setUsuarioAtual(tentativaLogin);
            return LoginUsuario.getUsuarioAtual();

        } catch (RuntimeException e){
            return null;
        }
    }

}

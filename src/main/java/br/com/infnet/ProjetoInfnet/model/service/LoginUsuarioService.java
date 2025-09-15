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

    public String logar(String email, String senha){

        try{
            Usuario tentativaLogin = usuarioRepository.findById(email).orElseThrow(RuntimeException::new);
            if(!tentativaLogin.getSenha().equals(senha)) return "Senha errada, login falho";

            LoginUsuario.setLogado(true);
            LoginUsuario.setUsuarioAtual(usuarioRepository.getReferenceById(email));
            return "Usuario "+LoginUsuario.getUsuarioAtual().getEmail()+" Logado : "+LoginUsuario.isLogado();

        } catch (RuntimeException e){
            return "Usuário não registrado, por favor faça o cadastro";
        }
    }

}

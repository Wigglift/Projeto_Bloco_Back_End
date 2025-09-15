package br.com.infnet.ProjetoInfnet.model.domain;

import br.com.infnet.ProjetoInfnet.model.domain.entities.Usuario;

public class CadastroUsuario {

    private String email;
    private String senha;

    public CadastroUsuario(String email, String senha){
        this.email = email;
        this.senha = senha;
    }

    public Usuario criarUsuario(){
        Usuario novoUsuario = new Usuario();

        novoUsuario.setEmail(this.email);
        novoUsuario.setSenha(this.senha);

        return novoUsuario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}

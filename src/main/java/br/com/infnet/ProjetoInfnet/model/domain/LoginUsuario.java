package br.com.infnet.ProjetoInfnet.model.domain;

import br.com.infnet.ProjetoInfnet.model.domain.entities.Usuario;

public class LoginUsuario {
    private static boolean logado;
    private static Usuario usuarioAtual;


    public static boolean isLogado() {
        return logado;
    }

    public static void setLogado(boolean logado) {
        LoginUsuario.logado = logado;
    }

    public static Usuario getUsuarioAtual() {
        return usuarioAtual;
    }

    public static void setUsuarioAtual(Usuario usuarioAtual) {
        LoginUsuario.usuarioAtual = usuarioAtual;
    }
}
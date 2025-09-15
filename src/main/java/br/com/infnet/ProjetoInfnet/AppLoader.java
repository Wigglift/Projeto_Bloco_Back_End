package br.com.infnet.ProjetoInfnet;

import br.com.infnet.ProjetoInfnet.controller.*;
import br.com.infnet.ProjetoInfnet.view.LinhaDeComandoApp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
@Order(2)
public class AppLoader  implements ApplicationRunner {

    @Autowired
    CadastroUsuarioController cadastroController;

    @Autowired
    LoginUsuarioController loginController;

    @Autowired
    EstoqueItemController estoqueItemController;

    @Autowired
    CarrinhoDeComprasController carrinhoDeComprasController;

    @Autowired
    CadastroPedidoController cadastroPedidoController;

    @Autowired
    ConsultaDePedidosController consultaDePedidosController;

    @Autowired
    CancelarPedidoController cancelarPedidoController;


    @Override
    public void run(ApplicationArguments args) throws Exception {

        LinhaDeComandoApp.Hello();

        Scanner scanner = new Scanner(System.in);

        //Cadastro e login
        cadastroController.cadastrar(scanner);

        loginController.logar(scanner);

        //estoque disponivel
        estoqueItemController.mostrarEstoque();

        //criar 2 pedidos
        carrinhoDeComprasController.adicionarItem(scanner);

        carrinhoDeComprasController.adicionarItem(scanner);

        cadastroPedidoController.criarPedido();

        //iniciar novo pedido
        carrinhoDeComprasController.renovarCarrinho();

        carrinhoDeComprasController.adicionarItem(scanner);

        carrinhoDeComprasController.adicionarItem(scanner);

        cadastroPedidoController.criarPedido();

        //ver pedidos

        consultaDePedidosController.verPedidos();

        //cancelar pedido

        cancelarPedidoController.cancelarPedido(scanner);

        consultaDePedidosController.verPedidos();
    }
}

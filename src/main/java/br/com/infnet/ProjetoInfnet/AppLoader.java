package br.com.infnet.ProjetoInfnet;

import br.com.infnet.ProjetoInfnet.controller.*;
import br.com.infnet.ProjetoInfnet.model.domain.CadastroUsuario;
import br.com.infnet.ProjetoInfnet.model.domain.CarrinhoDeCompras;
import br.com.infnet.ProjetoInfnet.model.domain.LoginUsuario;
import br.com.infnet.ProjetoInfnet.model.domain.entities.Pedido;
import br.com.infnet.ProjetoInfnet.model.domain.enumerator.StatusPedido;
import br.com.infnet.ProjetoInfnet.model.domain.enumerator.TipoPagamentoPedido;
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

    @Autowired
    AlterarPedidoController alterarPedidoController;


    @Override
    public void run(ApplicationArguments args) throws Exception {


        Scanner scanner = new Scanner(System.in);
        int escolha;

        System.out.println("\uD83D\uDCC4\u200B Sistema de Cadastro de Pedidos \uD83D\uDCC4\u200B");

        //Login e cadastro
        while (!LoginUsuario.isLogado()) {

            Thread.sleep(1000);

            LinhaDeComandoApp.mostrarOpcoes("Cadastrar", "Fazer Login", "Itens");
            System.out.print("Digite a opção ->");
            escolha = scanner.nextInt();
            scanner.nextLine();

            switch (escolha) {
                case 1:
                    CadastroUsuario novoCadastro = LinhaDeComandoApp.requisitarInfoCadastro(scanner);

                    LinhaDeComandoApp.validarCadastro(cadastroController.cadastrar(novoCadastro));
                    break;

                case 2:
                    String[] infoLogin = LinhaDeComandoApp.requisitarInfoLogin(scanner);

                    LinhaDeComandoApp.validarLogin(loginController.logar(infoLogin[0], infoLogin[1]));
                    break;

                case 3:
                    LinhaDeComandoApp.mostrarEstoque(estoqueItemController.pegarEstoque());
                    break;

                default:
                    System.out.println("Opção Indisponível");
            }
        }

        //sistema
        while (true) {
            Thread.sleep(1000);

            LinhaDeComandoApp.mostrarEstoque(estoqueItemController.pegarEstoque());
            System.out.println();
            LinhaDeComandoApp.mostrarCarrinho(carrinhoDeComprasController.mostrarCarrinho());
            System.out.println();
            LinhaDeComandoApp.mostrarOpcoes("Adicionar Item no Carrinho", "Finalizar Compra","Ver Pedidos","Alterar endereço","Cancelar Pedido","sair");
            System.out.print("Digite a opção ->");
            escolha = scanner.nextInt();
            scanner.nextLine();

            switch (escolha) {
                case 1:
                    int[] infoItem = LinhaDeComandoApp.requisitarInfoItem(scanner);

                    LinhaDeComandoApp.validarItemAdicionadoCarrinho(carrinhoDeComprasController.adicionarItem(infoItem[0], infoItem[1]));
                    break;

                case 2:
                    Pedido pedido = LinhaDeComandoApp.requisitarInfoPedido(scanner);

                    LinhaDeComandoApp.validarPedido(cadastroPedidoController.criarPedido(pedido));

                    LinhaDeComandoApp.esvaziarCarrinho(carrinhoDeComprasController.renovarCarrinho());
                    break;

                case 3:
                    LinhaDeComandoApp.mostrarPedidos(consultaDePedidosController.verPedidos());
                    break;

                case 4:
                    String[] infoAlterar = LinhaDeComandoApp.requisitarIdAlterarPedido(consultaDePedidosController.verPedidos(),scanner);

                    alterarPedidoController.alterarEndereco(infoAlterar);
                    break;

                case 5:
                    //não está funcionando
                    cancelarPedidoController.cancelarPedido(scanner);
                    break;

                case 6:
                    System.out.println("Obrigado por usar o sistema");
                    System.exit(0);

                default:
                    escolha = 0;
                    System.out.println("Opção inválida");

            }

        }
    }
}

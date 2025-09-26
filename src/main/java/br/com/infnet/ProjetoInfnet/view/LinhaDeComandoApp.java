package br.com.infnet.ProjetoInfnet.view;

import br.com.infnet.ProjetoInfnet.model.domain.CadastroUsuario;
import br.com.infnet.ProjetoInfnet.model.domain.CarrinhoDeCompras;
import br.com.infnet.ProjetoInfnet.model.domain.entities.EstoqueItem;
import br.com.infnet.ProjetoInfnet.model.domain.entities.Pedido;
import br.com.infnet.ProjetoInfnet.model.domain.entities.PedidoItem;
import br.com.infnet.ProjetoInfnet.model.domain.entities.Usuario;
import br.com.infnet.ProjetoInfnet.model.domain.enumerator.TipoPagamentoPedido;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Scanner;

public class LinhaDeComandoApp {

    public static void mostrarOpcoes(String... opcoes){

        int i = 1;

        System.out.println();
        for(String opcao : opcoes){
            System.out.println(i +" - "+ opcao);
            i += 1;
        }

    }

    public static Pedido requisitarInfoPedido(Scanner scanner){
        TipoPagamentoPedido tipoPagamento = null;
        boolean erro = false;

        System.out.println("Digite o endereço do pedido");
        String endereco = scanner.nextLine();

        System.out.println("Selecione o tipo de pagamento");
        do{
            LinhaDeComandoApp.mostrarOpcoes("Pix", "Cartão de crédito", "Cartão de débito", "Boleto");
            int pagamento = scanner.nextInt();
            scanner.nextLine();

            switch (pagamento) {
                case 1:
                    erro = false;
                    tipoPagamento = TipoPagamentoPedido.PIX;
                    break;
                case 2:
                    erro = false;
                    tipoPagamento = TipoPagamentoPedido.CARTAOCREDITO;
                    break;
                case 3:
                    erro = false;
                    tipoPagamento = TipoPagamentoPedido.CARTAODEBITO;
                    break;
                case 4:
                    erro = false;
                    tipoPagamento = TipoPagamentoPedido.BOLETO;
                    break;
                default:
                    erro = true;
                    System.out.println("Opção indisponível");
            }
        } while (erro);

        return new Pedido(endereco,tipoPagamento);
    }

    public static int[] requisitarInfoItem(Scanner scanner){
        int[] infoItem = new int[2];

        System.out.println("Digite o número do item que quer adicionar no carrinho");
        infoItem[0] = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Digite a quantidade");
        infoItem[1]  = scanner.nextInt();
        scanner.nextLine();

        return infoItem;
    }

    public static CadastroUsuario requisitarInfoCadastro(Scanner scanner){

        String email;
        String senha;

        boolean erro = false;

        do {
            System.out.println("Digite o email da conta:");
            email = scanner.next();
            scanner.nextLine();

            System.out.println("Digite a senha da conta");
            senha = scanner.next();
            scanner.nextLine();

            if(email.length()<3 || senha.length()<3) erro = true;

            if(erro){
                System.out.println("\n‼\uFE0F\u200BO email e a senha tem que ter pelo menos 3 caracteres‼\uFE0F\u200B\n");
            }
        }while (erro);

        return new CadastroUsuario(email,senha);
    }

    public static String[] requisitarInfoLogin(Scanner scanner){
        String[] infoLogin = new String[2];
        boolean erro = false;

        do {
            System.out.println("Digite o email da conta:");
            infoLogin[0] = scanner.next();
            scanner.nextLine();

            System.out.println("Digite a senha da conta");
            infoLogin[1] = scanner.next();
            scanner.nextLine();

            if(infoLogin[0].length()<3 || infoLogin[1].length()<3) erro = true;

            if(erro){
                System.out.println("\n‼\uFE0F\u200BO email e a senha tem que ter pelo menos 3 caracteres‼\uFE0F\u200B\n");
            }
        }while (erro);

        return infoLogin;
    }

    public static void mostrarEstoque(ResponseEntity<List<EstoqueItem>> estoqueItemResponseEntity){

        if(estoqueItemResponseEntity.getStatusCode() == HttpStatus.OK) {

            List<EstoqueItem> estoqueItem = estoqueItemResponseEntity.getBody();

            System.out.println("\uD83D\uDD36\u200B\uD83D\uDD36\u200B\uD83D\uDD36\u200BLISTA DE ITENS\uD83D\uDD36\u200B\uD83D\uDD36\u200B\uD83D\uDD36\u200B");
            for (EstoqueItem item : estoqueItem) {
                System.out.println(item);
            }
        }

    }

    public static void mostrarCarrinho(ResponseEntity<List<PedidoItem>> pedidoItemResponseEntity){

        if(pedidoItemResponseEntity.getStatusCode() == HttpStatus.OK) {

            double total = 0;

            List<PedidoItem> pedidoItens = pedidoItemResponseEntity.getBody();

            System.out.println("\uD83D\uDD37\u200B\uD83D\uDD37\u200B\uD83D\uDD37\u200BCARRINHO DE COMPRAS\uD83D\uDD37\u200B\uD83D\uDD37\u200B\uD83D\uDD37\u200B");
            if (pedidoItens == null || pedidoItens.isEmpty()){
                System.out.println("Carrinho Vazio");
            }else{
            for (PedidoItem item : pedidoItens) {
                System.out.println(item);

                total += item.getPreco();

            }
            }
            System.out.printf("TOTAL = R$%.2f", total);
        }

    }

    public static void mostrarPedidos(ResponseEntity<List<Pedido>> pedidoResponseEntity){

        if(pedidoResponseEntity.getStatusCode() == HttpStatus.OK) {

            List<Pedido> pedidos = pedidoResponseEntity.getBody();

            System.out.println("\n\uD83D\uDFEA\uD83D\uDFEA\uD83D\uDFEAPEDIDOS CADASTRADOS\uD83D\uDFEA\uD83D\uDFEA\uD83D\uDFEA\n");

            for (Pedido pedido : pedidos) {
                System.out.println(pedido);
            }
            System.out.println();
        }
        if(pedidoResponseEntity.getBody().isEmpty())System.out.println("\n\u200B⚠\uFE0F\u200BUsuário não tem pedidos cadastrados\u200B⚠\uFE0F\u200B\n");
    }

    public static void esvaziarCarrinho(ResponseEntity<Void> carrinhoVazioResponseEntity){
        if(carrinhoVazioResponseEntity.getStatusCode() == HttpStatus.NO_CONTENT);
    }

    public static String[] requisitarIdAlterarPedido(ResponseEntity<List<Pedido>> pedidoResponseEntity, Scanner scanner){
        System.out.println("Digite o Id do pedido parar alterar o endereço\n");

        if(pedidoResponseEntity.getStatusCode() == HttpStatus.OK) {

            List<Pedido> pedidos = pedidoResponseEntity.getBody();

            for (Pedido pedido : pedidos) {
                System.out.println(pedido);
            }
        }

        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Qual será o novo endereço?");
        String novoEndereco = scanner.nextLine();

        return new String[]{String.valueOf(id), novoEndereco};

    }

    public static void validarItemAdicionadoCarrinho(ResponseEntity<PedidoItem> responseEntity){
        if(responseEntity.getStatusCode() == HttpStatus.NOT_FOUND) System.out.println("\n❗Não existe esse item no estoque❗\n");

        if (responseEntity.getStatusCode() == HttpStatus.BAD_REQUEST) System.out.println("\n❗Quantidade maior do que a disponível em estoque❗\n");

        if(responseEntity.getStatusCode() == HttpStatus.OK) {
            System.out.println("\n✅\u200BItem adicionado no carrinho✅\u200B\n");
        }
    }

    public static void validarCadastro(ResponseEntity<Usuario> responseEntity){
        if (responseEntity.getStatusCode() == HttpStatus.BAD_REQUEST) System.out.println("\n❗Usuário já cadastrado, faça o login❗\n");

        if(responseEntity.getStatusCode() == HttpStatus.CREATED) {
            System.out.println("\n✅\u200BCadastro realizado✅\u200B\n");
        }
    }

    public static void validarLogin(ResponseEntity<Usuario> responseEntity){

        if (responseEntity.getStatusCode() == HttpStatus.BAD_REQUEST)System.out.println("\n❗Senha incorreta ❗\n");

        if(responseEntity.getStatusCode() == HttpStatus.NOT_FOUND) System.out.println("\n❗Usuário não cadastrado, faça o cadastro❗\n");


        if(responseEntity.getStatusCode() == HttpStatus.OK) System.out.println("\n✅\u200BLogin realizado✅\u200B\n");

    }

    public static void validarPedido(ResponseEntity<Pedido> responseEntity){
        if(responseEntity.getStatusCode() == HttpStatus.CREATED) System.out.println("\n✅\u200BPedido cadastrado com sucesso✅\u200B\n");
    }



}
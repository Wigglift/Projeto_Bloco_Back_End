package br.com.infnet.ProjetoInfnet.model.domain;


import br.com.infnet.ProjetoInfnet.model.domain.entities.PedidoItem;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CarrinhoDeCompras {
    private static List<PedidoItem> itens = new ArrayList<>();

    public static List<PedidoItem> getItens() {
        return itens;
    }

    public static void adicionarItem(PedidoItem item){
        itens.add(item);
    }

    public static Double valorTotal(){
        double total = 0;
        for(PedidoItem item : itens){
            total += item.getPreco();
        }

        return total;
    }

    public static void renovarCarrinho(){
        itens = new ArrayList<>();
    }
}

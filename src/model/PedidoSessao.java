package model;

import java.util.ArrayList;
import java.util.List;

public class PedidoSessao {

    public static class ItemPedido {
        public String produto;
        public String status;

        public ItemPedido(String produto, String status) {
            this.produto = produto;
            this.status = status;
        }
    }

    private static List<ItemPedido> itens = new ArrayList<>();

    public static void limpar() {
        itens.clear();
    }

    public static void adicionarItem(String produto, String status) {
        itens.add(new ItemPedido(produto, status));
    }

    public static List<ItemPedido> getItens() {
        return itens;
    }

    public static boolean temPedido() {
        return !itens.isEmpty();
    }
}

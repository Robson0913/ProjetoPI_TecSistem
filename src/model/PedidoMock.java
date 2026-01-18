package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PedidoMock {

    private static final List<Pedido> pedidos = new ArrayList<>();

    static {
        pedidos.add(new Pedido(1, "Cliente A", Arrays.asList("Hambúrguer", "Refrigerante"), "Pendente", 25.0));
        pedidos.add(new Pedido(2, "Cliente B", Arrays.asList("Pizza"), "Em preparo", 50.0));
        pedidos.add(new Pedido(3, "Cliente C", Arrays.asList("Hambúrguer", "Pizza"), "Pronto", 70.0));
    }

    public static List<Pedido> listarPedidos() { return pedidos; }

    public static void adicionarPedido(Pedido p) { pedidos.add(p); }
}

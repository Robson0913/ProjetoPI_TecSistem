package model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Pedido {

    private int id;
    private String cliente;
    private List<String> produtos;
    private int quantidade;
    private String status;
    private double valor;

    public Pedido(int id, String cliente, List<String> produtos, String status, double valor) {
        this.id = id;
        this.cliente = cliente;
        this.produtos = produtos;
        this.status = status;
        this.valor = valor;
        this.quantidade = produtos.size();
    }

    public int getId() { return id; }
    public String getCliente() { return cliente; }
    public List<String> getProdutos() { return produtos; }
    public int getQuantidade() { return quantidade; }
    public String getStatus() { return status; }
    public double getValor() { return valor; }

    public void setStatus(String status) {
        this.status = status;
    }

    public void atualizarStatus() {
        String sql = "UPDATE pedidos SET status = ? WHERE id = ?";
        try (Connection con = Conexao.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setString(1, this.status);
            stmt.setInt(2, this.id);
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static List<Pedido> listarPedidos() {
        List<Pedido> lista = new ArrayList<>();
        String sql = "SELECT p.id, c.nome AS cliente, pr.nome AS produto, pr.preco, p.quantidade, p.status " +
                     "FROM pedidos p " +
                     "JOIN clientes c ON p.cliente_id = c.id " +
                     "JOIN produtos pr ON p.produto_id = pr.id";

        try (Connection con = Conexao.getConnection();
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                List<String> produtos = new ArrayList<>();
                produtos.add(rs.getString("produto"));

                double valor = rs.getDouble("preco") * rs.getInt("quantidade"); // calcula valor total do item

                lista.add(new Pedido(
                        rs.getInt("id"),
                        rs.getString("cliente"),
                        produtos,
                        rs.getString("status"),
                        valor
                ));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }
}

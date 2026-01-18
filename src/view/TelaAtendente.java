package view;

import model.Pedido;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class TelaAtendente extends TelaBase {

    private JTable tabelaPedidos;
    private DefaultTableModel model;

    public TelaAtendente() {
        super("Área do Atendente");

        painelPrincipal.setLayout(new BorderLayout(10, 10));
        painelPrincipal.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JLabel titulo = criarLabel("Pedidos dos Clientes");
        titulo.setFont(new Font("Arial", Font.BOLD, 18));
        titulo.setHorizontalAlignment(SwingConstants.CENTER);

        String[] colunas = {"Mesa", "Produtos", "Status"};
        model = new DefaultTableModel(colunas, 0);

        tabelaPedidos = new JTable(model);
        tabelaPedidos.setFont(new Font("Arial", Font.PLAIN, 14));
        tabelaPedidos.setRowHeight(24);
        tabelaPedidos.setEnabled(false);

        JScrollPane scroll = new JScrollPane(tabelaPedidos);

        JButton btnAtualizar = new JButton("Atualizar");
        btnAtualizar.addActionListener(e -> atualizarPedidos());

        JButton btnFinanceiro = new JButton("Financeiro");
        btnFinanceiro.addActionListener(e -> {

            JFrame frame = new JFrame("Relatório de Vendas");
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

            TelaFinanceiro grafico = new TelaFinanceiro(50, 150, 200);
            frame.add(grafico);

            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });

        JPanel painelInferior = new JPanel(new FlowLayout());
        painelInferior.add(btnAtualizar);
        painelInferior.add(btnFinanceiro);

        painelPrincipal.add(titulo, BorderLayout.NORTH);
        painelPrincipal.add(scroll, BorderLayout.CENTER);
        painelPrincipal.add(painelInferior, BorderLayout.SOUTH);

        atualizarPedidos();
        setVisible(true);
    }

    private void atualizarPedidos() {
        model.setRowCount(0);
        List<Pedido> pedidos = Pedido.listarPedidos();
        for (Pedido p : pedidos) {
            String mesa = "Mesa " + p.getId();
            String produtosStr = String.join(", ", p.getProdutos());
            model.addRow(new Object[]{mesa, produtosStr, p.getStatus()});
        }
    }
}

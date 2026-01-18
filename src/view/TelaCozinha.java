package view;

import model.Pedido;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class TelaCozinha extends TelaBase {

    private JTable tabelaPedidos;
    private DefaultTableModel model;
    private JComboBox<String> comboStatus;

    public TelaCozinha() {
        super("Cozinha");

        painelPrincipal.setLayout(new BorderLayout(10, 10));
        painelPrincipal.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JLabel titulo = criarLabel("Pedidos na Cozinha");
        titulo.setFont(new Font("Arial", Font.BOLD, 18));
        titulo.setHorizontalAlignment(SwingConstants.CENTER);
        painelPrincipal.add(titulo, BorderLayout.NORTH);

        String[] colunas = {"Mesa", "Produtos", "Status"};
        model = new DefaultTableModel(colunas, 0);

        tabelaPedidos = new JTable(model);
        tabelaPedidos.setFont(new Font("Arial", Font.PLAIN, 14));
        tabelaPedidos.setRowHeight(24);
        tabelaPedidos.setBackground(Color.BLACK);
        tabelaPedidos.setForeground(Color.WHITE);
        tabelaPedidos.getTableHeader().setBackground(Color.WHITE);
        tabelaPedidos.getTableHeader().setForeground(Color.BLACK);

        JScrollPane scroll = new JScrollPane(tabelaPedidos);
        painelPrincipal.add(scroll, BorderLayout.CENTER);

        JPanel painelInferior = new JPanel(new FlowLayout());
        comboStatus = new JComboBox<>(new String[]{"Pendente", "Em preparo", "Pronto"});
        JButton btnAlterarStatus = new JButton("Alterar Status");
        btnAlterarStatus.setBackground(Color.WHITE);
        btnAlterarStatus.setForeground(Color.BLACK);

        painelInferior.add(comboStatus);
        painelInferior.add(btnAlterarStatus);
        painelPrincipal.add(painelInferior, BorderLayout.SOUTH);

        atualizarPedidos();

        Timer timer = new Timer(3000, e -> atualizarPedidos());
        timer.start();

        btnAlterarStatus.addActionListener(e -> {
            int linhaSelecionada = tabelaPedidos.getSelectedRow();
            if (linhaSelecionada != -1) {
                Pedido pedido = Pedido.listarPedidos().get(linhaSelecionada);
                pedido.setStatus((String) comboStatus.getSelectedItem());
                pedido.atualizarStatus();
                atualizarPedidos();
            } else {
                JOptionPane.showMessageDialog(null, "Selecione um pedido para alterar o status!");
            }
        });

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

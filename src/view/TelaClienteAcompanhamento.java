package view;

import model.PedidoSessao;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class TelaClienteAcompanhamento extends TelaBase {

    public TelaClienteAcompanhamento() {
        super("Acompanhamento do Pedido");

        painelPrincipal.setLayout(new BorderLayout(10,10));
        painelPrincipal.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));

        JLabel titulo = criarLabel("Status do Pedido");
        titulo.setFont(new Font("Arial", Font.BOLD, 18));
        titulo.setHorizontalAlignment(SwingConstants.CENTER);

        String[] colunas = {"Produto", "Status"};
        DefaultTableModel model = new DefaultTableModel(colunas, 0);

        for (PedidoSessao.ItemPedido item : PedidoSessao.getItens()) {
            model.addRow(new Object[]{item.produto, item.status});
        }

        JTable tabela = new JTable(model);
        tabela.setEnabled(false);
        tabela.setRowHeight(24);

        JScrollPane scroll = new JScrollPane(tabela);

        JButton btnVoltar = criarBotao("Voltar ao menu");
        btnVoltar.addActionListener(e -> {
            new TelaCliente();
            dispose();
        });

        JPanel painelInferior = new JPanel();
        painelInferior.setBackground(Color.BLACK);
        painelInferior.add(btnVoltar);

        painelPrincipal.add(titulo, BorderLayout.NORTH);
        painelPrincipal.add(scroll, BorderLayout.CENTER);
        painelPrincipal.add(painelInferior, BorderLayout.SOUTH);

        setVisible(true);
    }
}

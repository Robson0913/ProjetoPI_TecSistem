package view;

import model.PedidoSessao;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class TelaConfirmacaoPedido extends TelaBase {

    public TelaConfirmacaoPedido(boolean hamb, boolean pizza, boolean refri) {
        super("Confirmação do Pedido");

        painelPrincipal.setLayout(new BorderLayout(10, 10));
        painelPrincipal.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        PedidoSessao.limpar();

        JLabel titulo = criarLabel("Pedido confirmado com sucesso!");
        titulo.setFont(new Font("Arial", Font.BOLD, 18));
        titulo.setHorizontalAlignment(SwingConstants.CENTER);

        String[] colunas = {"Produto", "Valor (R$)"};
        DefaultTableModel model = new DefaultTableModel(colunas, 0);

        double total = 0;

        if (hamb) {
            model.addRow(new Object[]{"Hambúrguer", "25,00"});
            PedidoSessao.adicionarItem("Hambúrguer", "Pendente");
            total += 25;
        }

        if (pizza) {
            model.addRow(new Object[]{"Pizza", "40,00"});
            PedidoSessao.adicionarItem("Pizza", "Pendente");
            total += 40;
        }

        if (refri) {
            model.addRow(new Object[]{"Refrigerante", "8,00"});
            PedidoSessao.adicionarItem("Refrigerante", "Pendente");
            total += 8;
        }

        JTable tabela = new JTable(model);
        tabela.setEnabled(false);
        tabela.setFont(fontePadrao);
        tabela.setRowHeight(24);

        JScrollPane scroll = new JScrollPane(tabela);

        JLabel lblTotal = criarLabel("Total: R$ " + total);
        lblTotal.setFont(new Font("Arial", Font.BOLD, 16));
        lblTotal.setHorizontalAlignment(SwingConstants.RIGHT);

        JButton btnAcompanhar = criarBotao("Acompanhar status do pedido");
        btnAcompanhar.addActionListener(e -> {
            new TelaClienteAcompanhamento();
            dispose();
        });

        JPanel painelInferior = new JPanel(new BorderLayout());
        painelInferior.setBackground(Color.BLACK);
        painelInferior.add(lblTotal, BorderLayout.CENTER);
        painelInferior.add(btnAcompanhar, BorderLayout.SOUTH);

        painelPrincipal.add(titulo, BorderLayout.NORTH);
        painelPrincipal.add(scroll, BorderLayout.CENTER);
        painelPrincipal.add(painelInferior, BorderLayout.SOUTH);

        setVisible(true);
    }
}

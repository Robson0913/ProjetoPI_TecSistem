package view;

import model.PedidoSessao;
import javax.swing.*;
import java.awt.*;

public class TelaCliente extends TelaBase {

    public TelaCliente() {
        super("Área do Cliente");

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10,10,10,10);

        JButton btnCardapio = criarBotao("Cardápio");
        JButton btnAcompanhar = criarBotao("Acompanhar Pedido");
        JButton btnSair = criarBotao("Sair");

        btnCardapio.addActionListener(e -> {
            new TelaClienteCardapio();
            dispose();
        });

        // ✅ ACOMPANHAR PEDIDO FUNCIONAL
        btnAcompanhar.addActionListener(e -> {
            if (PedidoSessao.temPedido()) {
                new TelaClienteAcompanhamento();
                dispose();
            } else {
                JOptionPane.showMessageDialog(
                    this,
                    "Nenhum pedido encontrado.",
                    "Aviso",
                    JOptionPane.INFORMATION_MESSAGE
                );
            }
        });

        gbc.gridy = 0;
        painelPrincipal.add(btnCardapio, gbc);

        gbc.gridy = 1;
        painelPrincipal.add(btnAcompanhar, gbc);

        gbc.gridy = 2;
        painelPrincipal.add(btnSair, gbc);

        setVisible(true);
    }
}

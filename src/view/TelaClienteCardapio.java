package view;

import javax.swing.*;
import java.awt.*;

public class TelaClienteCardapio extends TelaBase {

    public TelaClienteCardapio() {
        super("Cardápio");

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5,5,5,5);
        gbc.anchor = GridBagConstraints.WEST;

        JCheckBox cb1 = new JCheckBox("Hambúrguer - R$ 25,00");
        JCheckBox cb2 = new JCheckBox("Pizza - R$ 40,00");
        JCheckBox cb3 = new JCheckBox("Refrigerante - R$ 8,00");

        JButton btnConfirmar = criarBotao("Confirmar Pedido");

        // padrão visual
        JCheckBox[] checks = {cb1, cb2, cb3};
        for (JCheckBox cb : checks) {
            cb.setBackground(Color.BLACK);
            cb.setForeground(Color.WHITE);
            cb.setFont(fontePadrao);
        }

        btnConfirmar.addActionListener(e -> {
            new TelaConfirmacaoPedido(cb1.isSelected(), cb2.isSelected(), cb3.isSelected());
            dispose();
        });

        gbc.gridy = 0;
        painelPrincipal.add(cb1, gbc);
        gbc.gridy = 1;
        painelPrincipal.add(cb2, gbc);
        gbc.gridy = 2;
        painelPrincipal.add(cb3, gbc);
        gbc.gridy = 3;
        painelPrincipal.add(btnConfirmar, gbc);

        setVisible(true);
    }
}

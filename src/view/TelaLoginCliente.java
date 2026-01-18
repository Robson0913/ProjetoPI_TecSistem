package view;

import javax.swing.*;
import java.awt.*;

public class TelaLoginCliente extends TelaBase {

    public TelaLoginCliente() {
        super("Login Cliente");

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8, 8, 8, 8);

        JTextField campoCpf = criarCampoTexto();
        JPasswordField campoSenha = new JPasswordField(15);

        JButton btnEntrar = criarBotao("Entrar");

        // 🔗 AÇÃO DO BOTÃO ENTRAR
        btnEntrar.addActionListener(e -> {
            new TelaCliente(); // vai para menu do cliente
            dispose();
        });

        gbc.gridx = 0; gbc.gridy = 0;
        painelPrincipal.add(criarLabel("CPF:"), gbc);

        gbc.gridx = 1;
        painelPrincipal.add(campoCpf, gbc);

        gbc.gridx = 0; gbc.gridy = 1;
        painelPrincipal.add(criarLabel("Senha:"), gbc);

        gbc.gridx = 1;
        painelPrincipal.add(campoSenha, gbc);

        gbc.gridx = 1; gbc.gridy = 2;
        painelPrincipal.add(btnEntrar, gbc);

        setVisible(true);
    }
}

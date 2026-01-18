package view;

import javax.swing.*;
import java.awt.*;

public class TelaLoginInicial extends TelaBase {

    public TelaLoginInicial() {
        super("Sistema - Login Inicial");

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        JLabel titulo = criarLabel("Escolha o tipo de acesso");
        titulo.setFont(new Font("Arial", Font.BOLD, 16));

        JButton btnCliente = criarBotao("Cliente");
        JButton btnFuncionario = criarBotao("Funcionário");

        // 🔗 AÇÃO DO BOTÃO CLIENTE
        btnCliente.addActionListener(e -> {
            new TelaLoginCliente();
            dispose(); // fecha a tela atual
        });

        // 🔗 AÇÃO DO BOTÃO FUNCIONÁRIO
        btnFuncionario.addActionListener(e -> {
            new TelaLoginFuncionario();
            dispose();
        });

        gbc.gridy = 0;
        painelPrincipal.add(titulo, gbc);

        gbc.gridy = 1;
        painelPrincipal.add(btnCliente, gbc);

        gbc.gridy = 2;
        painelPrincipal.add(btnFuncionario, gbc);

        setVisible(true);
    }
}

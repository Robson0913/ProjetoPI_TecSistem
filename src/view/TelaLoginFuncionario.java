package view;

import javax.swing.*;
import java.awt.*;

public class TelaLoginFuncionario extends TelaBase {

    public TelaLoginFuncionario() {
        super("Login Funcionário");

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8,8,8,8);

        JTextField campoUsuario = criarCampoTexto();
        JPasswordField campoSenha = new JPasswordField(15);

        JButton btnEntrar = criarBotao("Entrar");

       btnEntrar.addActionListener(e -> {
       new TelaEscolhaFuncionario();
        dispose();
    });

        gbc.gridx = 0; gbc.gridy = 0;
        painelPrincipal.add(criarLabel("Usuário:"), gbc);

        gbc.gridx = 1;
        painelPrincipal.add(campoUsuario, gbc);

        gbc.gridx = 0; gbc.gridy = 1;
        painelPrincipal.add(criarLabel("Senha:"), gbc);

        gbc.gridx = 1;
        painelPrincipal.add(campoSenha, gbc);

        gbc.gridx = 1; gbc.gridy = 2;
        painelPrincipal.add(btnEntrar, gbc);

        setVisible(true);
    }
}

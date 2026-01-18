package view;

import java.awt.*;

public class TelaEscolhaFuncionario extends TelaBase {

    public TelaEscolhaFuncionario() {
        super("Escolha de Função");

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(15,15,15,15);

        var lbl = criarLabel("Selecione sua função");
        lbl.setFont(new Font("Arial", Font.BOLD, 18));

        var btnAtendente = criarBotao("Atendente");
        var btnCozinha = criarBotao("Cozinha");

        btnAtendente.addActionListener(e -> {
            new TelaAtendente();
            dispose();
        });

        btnCozinha.addActionListener(e -> {
            new TelaCozinha();
            dispose();
        });

        gbc.gridy = 0;
        painelPrincipal.add(lbl, gbc);

        gbc.gridy = 1;
        painelPrincipal.add(btnAtendente, gbc);

        gbc.gridy = 2;
        painelPrincipal.add(btnCozinha, gbc);

        setVisible(true);
    }
}

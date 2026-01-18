package view;

import java.awt.*;

public class TelaGerente extends TelaBase {

    public TelaGerente() {
        super("Gerente");

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10,10,10,10);

        painelPrincipal.add(criarBotao("Relatórios"), gbc);

        gbc.gridy = 1;
        painelPrincipal.add(criarBotao("Funcionários"), gbc);

        gbc.gridy = 2;
        painelPrincipal.add(criarBotao("Financeiro"), gbc);

        setVisible(true);
    }
}

package view;

import javax.swing.*;
import java.awt.*;

public abstract class TelaBase extends JFrame {

    protected JPanel painelPrincipal;
    protected Font fontePadrao = new Font("Arial", Font.PLAIN, 14);

    public TelaBase(String titulo) {
        setTitle(titulo);
        setSize(500, 350);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        painelPrincipal = new JPanel();
        painelPrincipal.setBackground(Color.BLACK);
        painelPrincipal.setLayout(new GridBagLayout());

        add(painelPrincipal);
    }

    protected JLabel criarLabel(String texto) {
        JLabel label = new JLabel(texto);
        label.setForeground(Color.WHITE);
        label.setFont(fontePadrao);
        return label;
    }

    protected JTextField criarCampoTexto() {
        JTextField campo = new JTextField(15);
        campo.setFont(fontePadrao);
        campo.setBackground(Color.WHITE);
        campo.setForeground(Color.BLACK);
        return campo;
    }

    protected JButton criarBotao(String texto) {
        JButton botao = new JButton(texto);
        botao.setFont(fontePadrao);
        botao.setBackground(Color.WHITE);
        botao.setForeground(Color.BLACK);
        return botao;
    }
}

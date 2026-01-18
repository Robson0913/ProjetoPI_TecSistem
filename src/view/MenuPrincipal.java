package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuPrincipal extends JFrame {

    public MenuPrincipal() {
        setTitle("Sistema Restaurante - Menu Principal");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel painel = new JPanel();
        painel.setLayout(new GridLayout(3, 1, 10, 10));
        painel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JButton btnAtendente = new JButton("Área do Atendente");
        JButton btnCozinha = new JButton("Cozinha");
        JButton btnCaixa = new JButton("Caixa");

        btnAtendente.setBackground(Color.BLACK);
        btnAtendente.setForeground(Color.WHITE);
        btnCozinha.setBackground(Color.BLACK);
        btnCozinha.setForeground(Color.WHITE);
        btnCaixa.setBackground(Color.BLACK);
        btnCaixa.setForeground(Color.WHITE);

        painel.add(btnAtendente);
        painel.add(btnCozinha);
        painel.add(btnCaixa);

        add(painel);

        btnAtendente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new TelaAtendente();
            }
        });

        btnCozinha.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new TelaCozinha();
            }
        });

        btnCaixa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new TelaCaixa();
            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MenuPrincipal());
    }
}

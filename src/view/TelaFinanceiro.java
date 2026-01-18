package view;

import javax.swing.*;
import java.awt.*;

public class TelaFinanceiro extends JPanel {

    private int diario, semanal, mensal;

    public TelaFinanceiro(int diario, int semanal, int mensal) {
        this.diario = diario;
        this.semanal = semanal;
        this.mensal = mensal;
        setPreferredSize(new Dimension(500, 350));
        setBackground(Color.WHITE);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        int margem = 50;
        int larguraBarra = 50;
        int alturaMax = 200; 

        int maxValor = Math.max(diario, Math.max(semanal, mensal));
        double escala = (double) alturaMax / maxValor;

        int alturaDiario = (int) (diario * escala);
        int alturaSemanal = (int) (semanal * escala);
        int alturaMensal = (int) (mensal * escala);

        g.setFont(new Font("Arial", Font.BOLD, 14));

        g.setColor(Color.BLUE);
        g.fillRect(margem, 250 - alturaDiario, larguraBarra, alturaDiario);

        g.setColor(Color.RED);
        g.fillRect(margem + 100, 250 - alturaSemanal, larguraBarra, alturaSemanal);

        g.setColor(Color.GREEN.darker());
        g.fillRect(margem + 200, 250 - alturaMensal, larguraBarra, alturaMensal);

        g.setColor(Color.BLACK);
        g.drawRect(margem, 50, 300, 200); 

        g.drawString("Diário", margem, 270);
        g.drawString("Semanal", margem + 100, 270);
        g.drawString("Mensal", margem + 200, 270);

        g.drawString(String.valueOf(diario), margem, 250 - alturaDiario - 5);
        g.drawString(String.valueOf(semanal), margem + 100, 250 - alturaSemanal - 5);
        g.drawString(String.valueOf(mensal), margem + 200, 250 - alturaMensal - 5);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Relatório Financeiro");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        TelaFinanceiro grafico = new TelaFinanceiro(120, 350, 250); // exemplo de valores reais
        frame.add(grafico);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}

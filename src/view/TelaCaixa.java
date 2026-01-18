package view;

import model.Pedido;
import model.PedidoMock;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class TelaCaixa extends TelaBase {

    private JComboBox<String> comboMesas;
    private JTextArea areaItens;
    private JLabel lblTotal;
    private JComboBox<String> comboPagamento;
    private JButton btnConfirmar;

    public TelaCaixa() {
        super("Caixa");

        painelPrincipal.setLayout(new BorderLayout(10, 10));
        painelPrincipal.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JLabel titulo = criarLabel("Caixa");
        titulo.setFont(new Font("Arial", Font.BOLD, 18));
        titulo.setHorizontalAlignment(SwingConstants.CENTER);
        painelPrincipal.add(titulo, BorderLayout.NORTH);

        JPanel painelCentral = new JPanel(new BorderLayout(5, 5));
        areaItens = new JTextArea(10, 30);
        areaItens.setEditable(false);
        areaItens.setBackground(Color.BLACK);
        areaItens.setForeground(Color.WHITE);
        areaItens.setFont(new Font("Arial", Font.PLAIN, 14));
        JScrollPane scroll = new JScrollPane(areaItens);

        lblTotal = criarLabel("Total: R$ 0.00");
        lblTotal.setFont(new Font("Arial", Font.BOLD, 16));

        painelCentral.add(scroll, BorderLayout.CENTER);
        painelCentral.add(lblTotal, BorderLayout.SOUTH);
        painelPrincipal.add(painelCentral, BorderLayout.CENTER);

        JPanel painelInferior = new JPanel(new FlowLayout());

        comboMesas = new JComboBox<>();
        atualizarMesas(); 
        comboMesas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                atualizarPedidoSelecionado();
            }
        });

        comboPagamento = new JComboBox<>(new String[]{"Dinheiro", "Cartão", "PIX", "Vale Alimentação"});
        btnConfirmar = new JButton("Confirmar Pagamento");

        btnConfirmar.setBackground(Color.WHITE);
        btnConfirmar.setForeground(Color.BLACK);

        painelInferior.add(new JLabel("Mesa:"));
        painelInferior.add(comboMesas);
        painelInferior.add(new JLabel("Pagamento:"));
        painelInferior.add(comboPagamento);
        painelInferior.add(btnConfirmar);

        painelPrincipal.add(painelInferior, BorderLayout.SOUTH);

        btnConfirmar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int index = comboMesas.getSelectedIndex();
                if (index != -1) {
                    Pedido pedido = PedidoMock.listarPedidos().get(index);
                    pedido.setStatus("Pago");
                    JOptionPane.showMessageDialog(null, "Pagamento confirmado para a mesa " + pedido.getId() + "!");
                    atualizarPedidoSelecionado();
                }
            }
        });

        atualizarPedidoSelecionado();
        setVisible(true);
    }

    private void atualizarMesas() {
        comboMesas.removeAllItems();
        for (Pedido p : PedidoMock.listarPedidos()) {
            comboMesas.addItem("Mesa " + p.getId());
        }
    }

    private void atualizarPedidoSelecionado() {
        int index = comboMesas.getSelectedIndex();
        if (index != -1) {
            Pedido pedido = PedidoMock.listarPedidos().get(index);
            String itens = String.join(", ", pedido.getProdutos());
            areaItens.setText(itens);
            lblTotal.setText(String.format("Total: R$ %.2f", pedido.getValor()));
        }
    }
}

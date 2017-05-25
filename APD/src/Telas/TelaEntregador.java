package Telas;

import Modelo.EnumEntregador;
import Modelo.Pedido;
import Modelo.StatusPedido;
import java.awt.GridLayout;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TelaEntregador {

    public static EnumEntregador showMenu() {

        String[] op = {"Ver Info Entrega", "Alterar Status", "Sair"};
        int i = JOptionPane.showOptionDialog(null, "O QUE ESCOLHER", "42'foods", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, op, op[0]);
        if (i == 0) {
            return EnumEntregador.verInfoEntrega;
        }
        if (i == 1) {
            return EnumEntregador.alterarStatusPedido;
        }
        if (i == 2) {
            return EnumEntregador.sair;
        }
        return null;

    }

    public static Pedido escolhePedido(Pedido[] pedidos) {
        Pedido p = null;
        String[] pedidosString = new String[pedidos.length];
        for (int i = 0; i < pedidos.length; i++) {
            pedidosString[i] = pedidos[i].toString();
        }
        JPanel panel = new JPanel();
        GridLayout gd = new GridLayout(2, 2);
        panel.setLayout(gd);
        panel.add(new JLabel("Escolha um pedido:"));
        JComboBox JCBproduto = new JComboBox(pedidosString);
        JTextField JTFquantia = new JTextField();
        panel.add(JTFquantia);
        JOptionPane.showMessageDialog(null, panel);
        return p;
    }

    public static StatusPedido escolheNovoStatus() {
        String[] op = {"Finalizado", "Sair"};

        int i = JOptionPane.showOptionDialog(null, "O QUE ESCOLHER", "42'foods", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, op, op[0]);
        if (i == 0) {
            return StatusPedido.finalizado;
        }
        if (i == 1) {
            return StatusPedido.enviado;
        }
        return null;

    }
    public static void mostraPedido(Pedido p){
       JOptionPane.showMessageDialog(null,p.toString());
    }

}

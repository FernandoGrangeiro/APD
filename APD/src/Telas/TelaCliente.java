package Telas;

import Modelo.EnumMenuPedido;
import Modelo.EnumMenuUsuario;
import static Modelo.EnumMenuUsuario.*;
import Modelo.FormaDePagamento;
import static Modelo.FormaDePagamento.*;
import Modelo.Item;
import Modelo.Pedido;
import Modelo.Produto;
import java.awt.GridLayout;
import java.io.IOException;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TelaCliente {

    public static EnumMenuUsuario menu() {
        String[] op = {"Novo Pedido", "Meus Pedidos", "Sair"};
        int i = JOptionPane.showOptionDialog(null, "Escolha uma opção:", "42'foods", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, op, op[0]);
        switch (i) {
            case 0:
                return fazerPedido;
            case 1:
                return meusPedidos;
            case 2:
                return sair;
            default:
                return null;
        }
    }

    public static Pedido montaPedido(Produto[] produtos,int idCliente) throws IOException {
        String[] nomesProdutos = new String[produtos.length];
        for (int i = 0; i < produtos.length; i++) {
            nomesProdutos[i] = produtos[i].getNome();
        }
        ArrayList<Item> itens = new ArrayList<Item>();
        FormaDePagamento formaDePagamento;
        boolean pedidoCompleto = false;
        {
            JPanel panel = new JPanel();
            GridLayout gd = new GridLayout(2, 2);
            panel.setLayout(gd);
            panel.add(new JLabel("Escolha um produto:"));
            JComboBox JCBproduto = new JComboBox(nomesProdutos);
            panel.add(JCBproduto);
            panel.add(new JLabel("Digite a quantia desejada:"));
            JTextField JTFquantia = new JTextField();
            panel.add(JTFquantia);
            JOptionPane.showMessageDialog(null, panel);
            Item i = new Item(Integer.parseInt(JTFquantia.getText()), Modelo.Modelo.getProduto(nomesProdutos[JCBproduto.getSelectedIndex()]));
        }
        Pedido p = new Pedido(idCliente,itens,formaDePagamento);
        while (!pedidoCompleto);
        return null;
    }

    public static boolean pagarOnline() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public static Pedido escolhePedido(Pedido[] pedidos) {
        String[] 
    }

    public static void mostraPedidoSemOpcoes(Pedido p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public static EnumMenuPedido mostraPedidoComOpcoes(Pedido p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public static String[] incluirItem() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public static Item escolheItemDoPedido(Pedido p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public static int novaQuantidade() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public static boolean confirmarCancelamento() {
        String[] op = {"Sim", "Nao"};
        int i = JOptionPane.showOptionDialog(null, "Confirma cancelamento ?", "42'foods", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, op, op[0]);

        if (i == 0) {
            return true;
        } else {
            return false;
        }
    }

}

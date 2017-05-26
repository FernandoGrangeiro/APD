package Telas;

import static Modelo.EnumMenuPedido.*;
import Modelo.EnumMenuPedido;
import static Modelo.EnumMenuPedido.voltar;
import Modelo.EnumMenuUsuario;
import static Modelo.EnumMenuUsuario.*;
import Modelo.FormaDePagamento;
import static Modelo.FormaDePagamento.*;
import Modelo.Item;
import Modelo.Modelo;
import Modelo.Pedido;
import Modelo.Produto;
import java.awt.GridLayout;
import java.io.IOException;
import java.util.ArrayList;
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
                return EnumMenuUsuario.sair;
            default:
                return null;
        }
    }

    public static Pedido montaPedido(Produto[] produtos, int idCliente) throws IOException {
        String[] nomesProdutos = new String[produtos.length];
        for (int i = 0; i < produtos.length; i++) {
            nomesProdutos[i] = produtos[i].getNome();
        }
        ArrayList<Item> itens = new ArrayList<>();
        FormaDePagamento formaDePagamento = null;
        boolean pedidoCompleto = false;
        do {
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
            System.out.println(nomesProdutos[JCBproduto.getSelectedIndex()]);
            System.out.println(Modelo.getProduto(nomesProdutos[JCBproduto.getSelectedIndex()]).getNome());
            itens.add(new Item(Integer.parseInt(JTFquantia.getText()), Modelo.getProduto(nomesProdutos[JCBproduto.getSelectedIndex()])));

            String[] op = {"Adiconar mais itens", "Fechar pedido"};
            int i = JOptionPane.showOptionDialog(null, "O que deseja fazer?", "42'foods", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, op, op[0]);
            if (i == 1) {
                pedidoCompleto = true;
            }
        } while (!pedidoCompleto);
        String[] op = {"Online", "Em Dinheiro", "Cartão (Débito ou Crédito)"};
        int i = JOptionPane.showOptionDialog(null, "Escolha uma forma de pagamento:", "42'foods", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, op, op[0]);
        switch (i) {
            case 0:
                formaDePagamento = online;
                break;
            case 1:
                formaDePagamento = dinheiro;
                break;
            case 2:
                formaDePagamento = cartao;
        }
        Pedido p = new Pedido(idCliente, itens, formaDePagamento);
        return p;
    }

    public static boolean pagarOnline() {
        JOptionPane.showMessageDialog(null, "Pagamento realizado com sucesso!");
        return true;
    }

    public static Pedido escolhePedido(Pedido[] pedidos) {
        Pedido p = null;
        if (pedidos == null) {
            JOptionPane.showMessageDialog(null, "Você não possui pedidos!");
        } else {
            String[] pedidosString = new String[pedidos.length];
            for (int i = 0; i < pedidos.length; i++) {
                pedidosString[i] = pedidos[i].toStringSimples();
            }
            JPanel panel = new JPanel();
            GridLayout gd = new GridLayout(2, 2);
            panel.setLayout(gd);
            panel.add(new JLabel("Escolha um pedido:"));
            JComboBox JCBpedido = new JComboBox(pedidosString);
            panel.add(JCBpedido);
            JOptionPane.showMessageDialog(null, panel);
            p = pedidos[JCBpedido.getSelectedIndex()];
        }
        return p;
    }

    public static void mostraPedidoSemOpcoes(Pedido p) {
        JOptionPane.showMessageDialog(null, p.toString());
    }

    public static EnumMenuPedido mostraPedidoComOpcoes(Pedido p) {
        String[] op = {"Voltar"};
        int i = JOptionPane.showOptionDialog(null, "Confirma cancelamento ?", "42'foods", JOptionPane.NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, op, op[0]);
        return voltar;
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

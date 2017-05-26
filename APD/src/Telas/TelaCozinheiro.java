package Telas;

import Modelo.StatusPedido;
import Modelo.EnumMenuCozinheiro;
import Modelo.Pedido;
import java.awt.GridLayout;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TelaCozinheiro {

    public static EnumMenuCozinheiro showMenu() {
        String[] op = {"Alterar Status", "Sair"};
        int i = JOptionPane.showOptionDialog(null, "O QUE ESCOLHER", "42'foods", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, op, op[0]);
        
        if (i ==0) {
            return EnumMenuCozinheiro.alterarStatusPedido;
        }
        if (i == 1) {
            return EnumMenuCozinheiro.sair;
        }
        return null;

    }
    

    public static Pedido escolhePedido(Pedido [] pedidos) {
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
        panel.add(JCBproduto);
        
        JOptionPane.showMessageDialog(null, panel);
        return pedidos[JCBproduto.getSelectedIndex()];
    }

    public static StatusPedido escolheNovoStatus() {
        String [] op={"Em preparo","Enviado","Sair"};
        int i = JOptionPane.showOptionDialog(null, "O QUE ESCOLHER", "42'foods", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, op, op[0]);
        if(i==0){
            return StatusPedido.emPreparo;
        }
        
        if(i==1){
            return  StatusPedido.enviado;
        }
        if(i==2){
            return null;
        }
        return null;
        
    }
    
      
    
    
}
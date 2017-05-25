package Telas;

import Modelo.EnumEntregador;
import Modelo.StatusPedido;
import javax.swing.JOptionPane;

public class TelaEntregador {

    public static EnumEntregador showMenu() {
        
        String[] op = {"Ver Info Entrega", "Alterar Status", "Sair"};
        int i = JOptionPane.showOptionDialog(null, "O QUE ESCOLHER", "42'foods", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, op, op[0]);
        if (i ==0) {
            return EnumEntregador.verInfoEntrega;
        }
        if (i==1){
            return EnumEntregador.alterarStatusPedido;
        }
        if(i==2){
            return EnumEntregador.sair;
        }
        return null;

    }

    public static int escolhePedido() {
        JOptionPane.showMessageDialog(null,"f");
        
    }

    public static StatusPedido escolheNovoStatus() {
        
      int i = JOptionPane.showOptionDialog(null, "O QUE ESCOLHER", "42'foods", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, op, op[0]);

    }

}

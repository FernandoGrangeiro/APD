package Telas;

import Modelo.EnumEntregador;
import Modelo.EnumStatusPedido;
import javax.swing.JOptionPane;

public class TelaEntregador {

    public static EnumEntregador showMenu() {
      int result=JOptionPane.showOptionDialog(null,panel,"Menu",JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.PLAIN_MESSAGE,null,opcoes,nul);
    }

    public static int escolhePedido() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public static EnumStatusPedido escolheNovoStatus() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}

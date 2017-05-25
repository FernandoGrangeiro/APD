package Telas;


import Modelo.StatusPedido;
import Modelo.EnumMenuCozinheiro;
import javax.swing.JOptionPane;

public class TelaCozinheiro {

    public static EnumMenuCozinheiro showMenu() {
        String[] op = {"Alterar Status", "Sair"};
        int i = JOptionPane.showOptionDialog(null, "O QUE ESCOLHER", "42'foods", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, op, op[0]);
        
        if (i == 1) {
            return EnumMenuCozinheiro.alterarStatusPedido;
        }
        if (i == 2) {
            return EnumMenuCozinheiro.sair;
        }
        return null;

    }
    

    public static int escolhePedido() {
            JOptionPane.showMessageDialog(null,"Pedido foi escolhido");
return 1;
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
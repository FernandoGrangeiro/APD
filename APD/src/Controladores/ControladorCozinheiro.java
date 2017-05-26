package Controladores;

import Telas.TelaCozinheiro;
import Modelo.StatusPedido;
import Modelo.Modelo;
import Modelo.EnumMenuCozinheiro;
import Modelo.Pedido;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ControladorCozinheiro {

    public static void rodar() {
        
        EnumMenuCozinheiro opcMenu;
        Pedido p=null;
        Pedido[] pedidos=null;
        try {
            pedidos = Modelo.getPedidos();
        } catch (IOException ex) {
            Logger.getLogger(ControladorCozinheiro.class.getName()).log(Level.SEVERE, null, ex);
        }
        do {
            opcMenu = TelaCozinheiro.showMenu();
            if(opcMenu == EnumMenuCozinheiro.alterarStatusPedido){
                p = TelaCozinheiro.escolhePedido(pedidos);
                StatusPedido statusPedido = TelaCozinheiro.escolheNovoStatus();
                Modelo.alteraStatusPedido(p,statusPedido);
            } 
        } while (opcMenu != EnumMenuCozinheiro.sair);
        
    }

}

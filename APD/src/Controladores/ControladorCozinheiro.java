package Controladores;

import Telas.TelaCozinheiro;
import Modelo.EnumStatusPedido;
import Modelo.Modelo;
import Modelo.EnumMenuCozinheiro;

public class ControladorCozinheiro {

    public static void rodar() {
        
        EnumMenuCozinheiro opcMenu;
        
        do {
            opcMenu = TelaCozinheiro.showMenu();
            if(opcMenu == EnumMenuCozinheiro.alterarStatusPedido){
                int indexPedido = TelaCozinheiro.escolhePedido();
                EnumStatusPedido statusPedido = TelaCozinheiro.escolheNovoStatus();
                Modelo.alteraStatusPedido(indexPedido,statusPedido);
            } 
        } while (opcMenu != EnumMenuCozinheiro.sair);

    }

}

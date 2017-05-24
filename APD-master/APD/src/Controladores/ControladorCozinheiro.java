package Controladores;

import Telas.TelaCozinheiro;
import Modelo.StatusPedido;
import Modelo.Modelo;
import Modelo.EnumMenuCozinheiro;

public class ControladorCozinheiro {

    public static void rodar() {
        
        EnumMenuCozinheiro opcMenu;
        
        do {
            opcMenu = TelaCozinheiro.showMenu();
            if(opcMenu == EnumMenuCozinheiro.alterarStatusPedido){
                int indexPedido = TelaCozinheiro.escolhePedido();
                StatusPedido statusPedido = TelaCozinheiro.escolheNovoStatus();
                Modelo.alteraStatusPedido(indexPedido,statusPedido);
            } 
        } while (opcMenu != EnumMenuCozinheiro.sair);
        
    }

}

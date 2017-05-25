package Controladores;

import Telas.TelaCozinheiro;
import Modelo.StatusPedido;
import Modelo.Modelo;
import Modelo.EnumMenuCozinheiro;
import Modelo.Pedido;

public class ControladorCozinheiro {

    public static void rodar() {
        
        EnumMenuCozinheiro opcMenu;
        Pedido p;
        Pedido[] pedidos = Modelo.getPedidos();
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

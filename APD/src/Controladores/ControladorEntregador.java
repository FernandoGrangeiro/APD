package Controladores;

import Modelo.EnumEntregador;
import Modelo.StatusPedido;
import Telas.TelaEntregador;
import Modelo.Modelo;
import Modelo.Pedido;

public class ControladorEntregador {
    
    public static void rodar(){
        EnumEntregador opcMenu;
         do {
            opcMenu = TelaEntregador.showMenu();
            if(opcMenu == EnumEntregador.alterarStatusPedido){
                int indexPedido = TelaEntregador.escolhePedido();
                StatusPedido statusPedido = TelaEntregador.escolheNovoStatus();
                Modelo.alteraStatusPedido(indexPedido,statusPedido);
            }
            if(opcMenu == EnumEntregador.verInfoEntrega){
                int indexPedido = TelaEntregador.escolhePedido();
                Modelo.getPedidos(indexPedido);
                
                
            }
         }while(opcMenu!=EnumEntregador.sair);
        
    }
}


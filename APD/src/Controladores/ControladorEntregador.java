package Controladores;

import Modelo.EnumEntregador;
import Modelo.EnumStatusPedido;
import Telas.TelaEntregador;
import Modelo.Modelo;

public class ControladorEntregador {
    
    public static void rodar(){
        EnumEntregador opcMenu;
         do {
            opcMenu = TelaEntregador.showMenu();
            if(opcMenu == EnumEntregador.alterarStatusPedido){
                int indexPedido = TelaEntregador.escolhePedido();
                EnumStatusPedido statusPedido = TelaEntregador.escolheNovoStatus();
                Modelo.alteraStatusPedido(indexPedido,statusPedido);
            }
         }while(opcMenu!=EnumEntregador.sair);
        
    }
}


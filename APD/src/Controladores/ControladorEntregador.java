package Controladores;

import Modelo.Envio;
import Modelo.EnumEntregador;
import Modelo.Fatura;
import Modelo.StatusPedido;
import Telas.TelaEntregador;
import Modelo.Modelo;
import Modelo.Pedido;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ControladorEntregador {
    
    public static void rodar(){
        EnumEntregador opcMenu;
        Pedido p=null;
        Envio e=null;
        Pedido[] pedidos=null;
        
        try {
            pedidos = Modelo.getPedidos();
        } catch (IOException ex) {
            Logger.getLogger(ControladorEntregador.class.getName()).log(Level.SEVERE, null, ex);
        }
         do {
            opcMenu = TelaEntregador.showMenu();
            
            if(opcMenu==EnumEntregador.pegarPedido){
             p = TelaEntregador.escolhePedido(pedidos);
             e=new Envio();
             e.setHoraSaida();
             p.setEnvio(e);
             
                    
            }
            if(opcMenu == EnumEntregador.alterarStatusPedido){
                
                p = TelaEntregador.escolhePedido(pedidos);
                StatusPedido statusPedido = TelaEntregador.escolheNovoStatus();
                Modelo.alteraStatusPedido(p,statusPedido);
                 if(statusPedido.equals(StatusPedido.finalizado)){
                     
                     if(p.pago==true){
                     p.setaEntrega();
                     Fatura f= new Fatura();
                     f.calcularTaxaEntrega(p);
                     f.cacularTotal(p);
                     f.setDataFatura();
                     f.emitirFatura();
                   }
                     
                     
                }
            }
            if(opcMenu == EnumEntregador.verInfoEntrega){
                p = TelaEntregador.escolhePedido(pedidos);
                 TelaEntregador.mostraPedido(p);
                
                
            }
         }while(opcMenu!=EnumEntregador.sair);
        
    }
}

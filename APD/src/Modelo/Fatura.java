package Modelo;

import java.util.Calendar;
import javax.swing.JOptionPane;


public class Fatura {
    
    public Calendar dataFatura;
    public double taxaEntrega;
    public boolean pagamento;
    public double total;
    
    public Fatura(){
        
    }
    
    
    public void cacularTotal(Pedido p){
        total=taxaEntrega+p.custoTotal;
        
    }
    
    public void calcularTaxaEntrega(Pedido p){ 
        taxaEntrega=p.custoTotal*0.1;
    }
    
    
    public void setDataFatura(){
    
        dataFatura=Calendar.getInstance();
    }
    
    public String emitirFatura(){
        return "Data:"+dataFatura+"\nTotal:"+total+"\ntaxaEntrega"+taxaEntrega;
    }
    
}

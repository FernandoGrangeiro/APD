package pacote;

import java.util.Calendar;


public class Fatura {
    
    public Calendar dataFatura;
    public double taxaEntrega;
    public boolean pagamento;
    public double total;
    
    public Fatura(){
        
    }
    
    
    public void cacularTotal(double valor){
        total=taxaEntrega+valor;
        
    }
    
    public void calcularTaxaEntrega(double valor){
        
        taxaEntrega=valor*0.1;
    }
    
    public boolean efetuarPagamento(){
                
        
        
        return true;
    }
    
    public void setDataFatura(){
    
        dataFatura=Calendar.getInstance();
    }
    
}
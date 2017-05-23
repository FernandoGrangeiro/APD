package pacote;

import java.util.Calendar;
import javax.swing.JOptionPane;

public class Pedido {

    public Calendar dataPedido;
    public String cod;
    public StatusPedido statusPedido;
    public double custoTotal;
    private Item item;
    public Envio env;

    public Pedido(String cod, int quant) {
        dataPedido = Calendar.getInstance();
        item = new Item(quant);
        this.cod = cod;
        env = new Envio();
    }
    
    public StatusPedido getStatusPedido(){
        return statusPedido;
    }

    public double calcularCustoTotal() {
        double x = 0;
        custoTotal = x * item.getQuantidade();
        return custoTotal;

    }

    public void cancelar() {
            if (statusPedido.equals(StatusPedido.espera) || statusPedido.equals(StatusPedido.preparo)){
            int x=JOptionPane.showConfirmDialog(null, "Gostaria de cancelar o produto", "Cancelar", JOptionPane.YES_NO_OPTION);
            if(x==1){
                JOptionPane.showMessageDialog(null,"Produto cancelado");
            }else{
                JOptionPane.showMessageDialog(null,"Obrigado");
            }
        }else{
            JOptionPane.showMessageDialog(null,"Produto nao pode ser alterado");
        }
    }

    public void alterar() {
        if (statusPedido.equals(StatusPedido.espera)){
            JOptionPane.showMessageDialog(null, "O que gostaria de alterar do Produto");
            
        }else{
            JOptionPane.showMessageDialog(null,"Produto nao pode ser alterado");
        }
    }

    public StatusPedido alterarStatus(StatusPedido sp) {
        
        return null;
    }

}

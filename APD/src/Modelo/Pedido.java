package Modelo;

import static Modelo.StatusPedido.*;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.JOptionPane;

public class Pedido {

    private Calendar dataPedido;
    private int cod;
    private StatusPedido statusPedido;
    private double custoTotal;
    private ArrayList <Item> item;
    private Envio env;
    private FormaDePagamento formaDePagamento;
    private boolean pago;
    private int idCliente;
    
    
    public Pedido(int idCliente, ArrayList<Item> item,FormaDePagamento formaDePagamento){
            
        this.idCliente=idCliente;
        this.item=item;
        this.formaDePagamento=formaDePagamento;
        dataPedido = Calendar.getInstance();
        statusPedido=StatusPedido.emEspera;
    
}

    public boolean estaPago() {
        return pago;
    }
    
    public void setStatusPedido(StatusPedido st){
        statusPedido=st;
    }
    
    public void setPago(boolean pago) {
        this.pago = pago;
    }

   

    public StatusPedido getStatusPedido() {
        return statusPedido;
    }

    public double calcularCustoTotal() {
        double x = 0;
        custoTotal = x * item.getQuantidade();
        return custoTotal;

    }

    public void cancelar() {
        if (statusPedido == emEspera) {
            int x = JOptionPane.showConfirmDialog(null, "Gostaria de cancelar o produto", "Cancelar", JOptionPane.YES_NO_OPTION);
            if (x == 1) {
                JOptionPane.showMessageDialog(null, "Produto cancelado");
                this.alterarStatus(cancelado);
            } else {
                JOptionPane.showMessageDialog(null, "Obrigado");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Produto nao pode ser alterado");
        }
    }

    public void alterar() {
        if (statusPedido == emEspera) {
            JOptionPane.showMessageDialog(null, "O que gostaria de alterar do Produto");

        } else {
            JOptionPane.showMessageDialog(null, "Produto nao pode ser alterado");
        }
    }

    public StatusPedido alterarStatus(StatusPedido sp) {

        return null;
    }

    public FormaDePagamento getFormaPagamento() {
        return this.formaDePagamento;
    }

    public void add(Item i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void removeItem(Item i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}

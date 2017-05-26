package Modelo;

import static Modelo.StatusPedido.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.JOptionPane;

public class Pedido implements Serializable{

    private Calendar dataPedido;
    private int cod;
    public StatusPedido statusPedido;
    public double custoTotal;
    private ArrayList<Item> item;
    private Envio env;
    private FormaDePagamento formaDePagamento;
    public boolean pago;
    private int idCliente;

    public Pedido(int idCliente, ArrayList<Item> item, FormaDePagamento formaDePagamento) {

        this.idCliente = idCliente;
        this.item = item;
        this.formaDePagamento = formaDePagamento;
        dataPedido = Calendar.getInstance();
        statusPedido = StatusPedido.emEspera;

    }
    
    public Pedido(Calendar dataPedido, int cod, StatusPedido statusPedido, double custoTotal, ArrayList<Item> item, Envio env, FormaDePagamento formaDePagamento, boolean pago, int idCliente) {
        this.dataPedido = dataPedido;
        this.cod = cod;
        this.statusPedido = statusPedido;
        this.custoTotal = custoTotal;
        this.item = item;
        this.env = env;
        this.formaDePagamento = formaDePagamento;
        this.pago = pago;
        this.idCliente = idCliente;
    }

    public boolean estaPago() {
        return pago;
    }

    public void setStatusPedido(StatusPedido st) {
        statusPedido = st;
    }

    public void setPago(boolean pago) {
        this.pago = pago;
    }

    public void setaEntrega() {
        env.setHoraEntrega();
    }

    public StatusPedido getStatusPedido() {
        return statusPedido;
    }

    public double calcularCustoTotal() {
        double x = 0, y = 0;
        for (int i = 0; i < item.size(); i++) {
            y += item.get(i).getQuantidade();
        }
        custoTotal = x * y;
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

    public void setEnvio(Envio env) {
        this.env = env;
    }

    public void alterar() {
        if (statusPedido == emEspera) {
            JOptionPane.showMessageDialog(null, "O que gostaria de alterar do Produto");

        } else {
            JOptionPane.showMessageDialog(null, "Produto nao pode ser alterado");
        }
    }

    public StatusPedido alterarStatus(StatusPedido sp) {
                return this.statusPedido=sp;
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

    public int getIdCliente() {
        return this.idCliente;
    }
    
    public String toStringSimples(){
        
        int y=dataPedido.get(Calendar.DATE);
        
        return "Data Pedido:"+y+"Cod:"+cod;
    }
    
    public String toString(){
        String x="";
        for(int i =0; i<item.size();i++){
            x+=item.get(i).getProduto();
            x+=": "+item.get(i).getQuantidade();
            x+="\n";
            
        }
        int y=dataPedido.get(Calendar.DATE);
        return "Cod: "+cod+"\nStatusPedido: "+statusPedido+"\nDataPedido: "+y+"\nItens "+x;
        
    }

}

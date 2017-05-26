package Modelo;

import java.io.Serializable;

public class Item implements Serializable{    
    public int quantidade;
    private Produto produto;
    
    public Item(int i,Produto produto){
        quantidade=i;
        this.produto = produto;
    }

    public Item(String string, String string0) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public int getQuantidade(){
        return quantidade;
    }

    public void quantidade(Item i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

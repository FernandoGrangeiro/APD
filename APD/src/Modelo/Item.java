package Modelo;


public class Item {
    
    private int quantidade;
    private Produto_Concreto produto;
    private DecoratorProduto decoratorProduto;
    
    public Item(int i,Produto_Concreto produto,DecoratorProduto decorator){
        quantidade=i;
        this.produto = produto;
        decoratorProduto = decorator;
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

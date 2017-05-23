package PessoaEClassesFilhas;

import pacote.Pedido;

public class Cozinheiro extends Funcionario{
    
    public Cozinheiro(String nome, String endereco, String telefone, String usuario, String senha) {
        super(nome, endereco, telefone, usuario, senha);
    }

    @Override
    void alteraStatusPedido(Pedido p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

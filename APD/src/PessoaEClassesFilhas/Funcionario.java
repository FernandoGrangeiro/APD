package PessoaEClassesFilhas;

import pacote.Pedido;

public abstract class Funcionario extends Pessoa{
    
    public Funcionario(String nome, String endereco, String telefone, String usuario, String senha) {
        super(nome, endereco, telefone, usuario, senha);
    }
    
    abstract void alteraStatusPedido(Pedido p);
}

package Modelo;

import Telas.TelaEntregador;

public class Entregador extends Funcionario{
    
    public Entregador(String nome, String endereco, String telefone, String usuario, String senha) {
        super(nome, endereco, telefone, usuario, senha);
    }

    @Override
    void alteraStatusPedido(Pedido p) {
        if(p.getStatusPedido().equals(StatusPedido.enviado)){
            p.setStatusPedido(StatusPedido.finalizado);
        }
    }
    
    
}

package Modelo;

import Telas.TelaEntregador;

public class Entregador extends Funcionario{
    
    public Entregador(String nome, String endereco, String telefone, String usuario, String senha) {
        super(nome, endereco, telefone, usuario, senha);
    }

    @Override
    void alteraStatusPedido(Pedido p) {
        if(p.statusPedido.equals(StatusPedido.enviado)){
            p.statusPedido=StatusPedido.finalizado;
        }else{
            TelaEntregador.pedidoInalteravel();
        }
    }
    
    
}

package PessoaEClassesFilhas;

import pacote.TelaEntregador;
import pacote.Pedido;
import pacote.EnumStatusPedido;

public class Entregador extends Funcionario{
    
    public Entregador(String nome, String endereco, String telefone, String usuario, String senha) {
        super(nome, endereco, telefone, usuario, senha);
    }

    @Override
    void alteraStatusPedido(Pedido p) {
        if(p.statusPedido.equals(EnumStatusPedido.enviado)){
            p.statusPedido=EnumStatusPedido.finalizado;
        }else{
            TelaEntregador.pedidoInalteravel();
        }
    }
    
    
}

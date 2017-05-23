package PessoaEClassesFilhas;

import pacote.Pedido;
import pacote.EnumStatusPedido;

public class Cozinheiro extends Funcionario {

    public Cozinheiro(String nome, String endereco, String telefone, String usuario, String senha) {
        super(nome, endereco, telefone, usuario, senha);
    }

    @Override
    void alteraStatusPedido(Pedido p) {
        if (p.getStatusPedido().equals(EnumStatusPedido.espera)) {
            p.statusPedido = EnumStatusPedido.preparo;
        }
        if (p.getStatusPedido().equals(EnumStatusPedido.preparo)) {
            p.statusPedido = EnumStatusPedido.enviado;
        }
    }
}

package PessoaEClassesFilhas;

import pacote.Pedido;
import pacote.StatusPedido;

public class Cozinheiro extends Funcionario {

    public Cozinheiro(String nome, String endereco, String telefone, String usuario, String senha) {
        super(nome, endereco, telefone, usuario, senha);
    }

    @Override
    void alteraStatusPedido(Pedido p) {
        if (p.getStatusPedido().equals(StatusPedido.espera)) {
            p.statusPedido = StatusPedido.preparo;
        }
        if (p.getStatusPedido().equals(StatusPedido.preparo)) {
            p.statusPedido = StatusPedido.enviado;
        }
    }
}

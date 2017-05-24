package Modelo;

public class Cozinheiro extends Funcionario {

    public Cozinheiro(String nome, String endereco, String telefone, String usuario, String senha) {
        super(nome, endereco, telefone, usuario, senha);
    }

    @Override
    void alteraStatusPedido(Pedido p) {
        if (p.getStatusPedido().equals(StatusPedido.emEspera)) {
            p.statusPedido = StatusPedido.emPreparo;
        }
        if (p.getStatusPedido().equals(StatusPedido.emPreparo)) {
            p.statusPedido = StatusPedido.enviado;
        }
    }
}

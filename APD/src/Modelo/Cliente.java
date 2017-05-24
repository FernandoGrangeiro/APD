package Modelo;

public class Cliente extends Pessoa {

    private String numCartao;
    private int id;

    public Cliente(String nome, String tel, String endereco, String numCartao, String usuario, String senha, int id) {
        super(nome, endereco, tel, usuario, senha);
        this.numCartao = numCartao;
        this.id = id;
    }

    @Override
    public String toString() {
        return "Nome" + nome + "\nEndereco" + endereco + "\nTelefone" + telefone;
    }

    public int getId(){
        return this.id;
    }
}

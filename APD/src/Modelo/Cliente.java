package Modelo;

public class Cliente extends Pessoa {

    public String numCartao;

    public Cliente(String nome, String tel, String endereco, String numCartao, String usuario, String senha) {
        super(nome, endereco, tel, usuario, senha);
        this.numCartao = numCartao;
    }

    public String toString() {
        return "Nome" + nome + "\nEndereco" + endereco + "\nTelefone" + telefone;
    }

}

package PessoaEClassesFilhas;

public class Pessoa {

    String nome;
    String endereco;
    String telefone;
    String usuario;
    String senha;

    public Pessoa(String nome, String endereco, String telefone, String usuario, String senha) {
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
        this.usuario = usuario;
        this.senha = senha;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getSenha() {
        return senha;
    }

    public String getNome() {
        return nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getTelefone() {
        return telefone;
    }

}

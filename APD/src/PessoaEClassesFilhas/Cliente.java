package PessoaEClassesFilhas;
public class Cliente extends Pessoa{
                         
    public String numCartao;
    
    public Cliente(String nome, String tel, String endereco, String numCartao,String usuario, String senha){
        super(nome,endereco,tel,usuario,senha);
        this.numCartao=numCartao;
    
    }
    
    
    
   
}

package pacote;

import PessoaEClassesFilhas.*;

public class Controlador {

    public static void main(String[] args) {
        Pessoa[] usuarios = instanciaUsuarios();

        Pessoa usuario = null;

        do {
            String[] login = Tela.login();
            for (Pessoa p : usuarios) {
                if (p.getUsuario().equals(login[0]) && p.getSenha().equals(login[1])) {
                    usuario = p;
                }
            }
        } while (usuario == null);
        
        if(usuario instanceof Cliente){
            ControladorUsuario controlUser = new ControladorUsuario();
            controlUser.rodar();
        }
    }

    private static Pessoa[] instanciaUsuarios() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
   /* public void lerPessoa(String nomearq, String separa ){
        FileReader fr=new FileReader(nomearq);
        BufferedReader br= new BufferedReader(fr);
        String linha;
        while((linha=br.readLine())=null){
            String[] info=linha.split(separa);
            String tipo=info[0];
            String nome=info[2];
            String enderco=info[3];
            String usuario=info[4];
            String senha = info [5];
            
            
        }

        
    }*/

}

package Controladores;

import Telas.Tela;
import Modelo.Pessoa;
import Modelo.Cozinheiro;
import Modelo.Cliente;
import Modelo.Entregador;
import java.io.*;

public class Controlador {

    public static void main(String[] args) throws IOException {
        Pessoa[] usuarios = instanciaUsuarios();

        Pessoa usuario;

        boolean sair = false;
        while (!sair) {
            //Apresenta login
            do {
                usuario = null;
                String[] login = Tela.login();
                if (login == null) {
                    sair = true;
                    break;
                }
                for (Pessoa p : usuarios) {
                    if (p.getUsuario().equals(login[0]) && p.getSenha().equals(login[1])) {
                        usuario = p;
                    }
                }
            } while (usuario == null);

            if (!sair) {
                //Invoca controladores
                if (usuario instanceof Cliente) {
                    ControladorUsuario.rodar((Cliente) usuario);
                } else if (usuario instanceof Cozinheiro) {
                    ControladorCozinheiro.rodar();
                } else if (usuario instanceof Entregador) {
                    ControladorEntregador.rodar();
                }
            }
        }
    }

    private static Pessoa[] instanciaUsuarios() throws FileNotFoundException, IOException {
        FileReader fr = new FileReader("Usuarios.txt");
        BufferedReader br = new BufferedReader(fr);
        String linha;   
            
        int numLinhas = Integer.parseInt( br.readLine());
          
        Pessoa[] p = new Pessoa[numLinhas];
        int i = 0;
        while (i < numLinhas) {
            linha = br.readLine();
            String[] info = linha.split(";");
            String tipo = info[0];
            String nome = info[1];
            String tel = info[2];
            String endereco = info[3];
            String usuario = info[4];
            String senha = info[5];
            String numCartao = info[6];
            int id = Integer.parseInt(info[7]);
            if (tipo.equals("Cozinheiro")) {
                Cozinheiro co = new Cozinheiro(nome, tel, endereco, usuario, senha);
                p[i] = co;
            }
            if (tipo.equals("Cliente")) {
                Cliente cl = new Cliente(nome, tel, endereco, numCartao, usuario, senha, id);
                p[i] = cl;
            }

            if (tipo.equals("Entregador")) {
               Entregador cl = new Entregador(nome, tel, endereco, usuario, senha);
                p[i] = cl;
            }
            i++;
        }
        fr.close();
        return p;
    }
}

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

        Pessoa usuario = null;

        do {
            String[] login = Tela.login();
            for (Pessoa p : usuarios) {
                if (p.getUsuario().equals(login[0]) && p.getSenha().equals(login[1])) {
                    usuario = p;
                }
            }
        } while (usuario == null);

        if (usuario instanceof Cliente) {
            ControladorUsuario controlUser = new ControladorUsuario();
            controlUser.rodar();
        }
    }

    private static Pessoa[] instanciaUsuarios() throws FileNotFoundException, IOException {
        FileReader fr = new FileReader("Usuarios.txt");
        BufferedReader br = new BufferedReader(fr);
        String linha;

        int numLinhas = 0;
        while ((linha = br.readLine()) != null) {
            numLinhas++;
        }
        fr.close();
        Pessoa[] p = new Pessoa[numLinhas];
        int i = 0;
        while ((linha = br.readLine()) == null) {
            String[] info = linha.split(";");
            String tipo = info[0];
            String nome = info[1];
            String tel = info[2];
            String endereco = info[3];
            String usuario = info[4];
            String senha = info[5];
            String numCartao = info[6];
            if (tipo.equals("Cozinheiro")) {
                Cozinheiro co = new Cozinheiro(nome, tel, endereco, usuario, senha);
                p[i] = co;
                i++;

            }
            if (tipo.equals("Cliente")) {
                Cliente cl = new Cliente(nome, tel, endereco, numCartao, usuario, senha);
                p[i] = cl;
                i++;
            }

            if (tipo.equals("Entregador")) {
                Entregador en = new Entregador(nome, tel, endereco, usuario, senha);
                p[i] = en;
                i++;
            }
            
            return  p;

        }

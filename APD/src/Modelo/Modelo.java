/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author osniellopesteixeira
 */
public class Modelo {
    
    public static void alteraStatusPedido(int indexPedido, StatusPedido statusPedido) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public static void add(Pedido p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public static Pedido[] getPedidos(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public static Pedido[] getPedido(int cod){
        return null;
    }

    public static Produto[] getProdutos() throws FileNotFoundException, IOException {
        FileReader fr = new FileReader("Produtos.txt");
        BufferedReader br = new BufferedReader(fr);
        String linha;   
            
        int numLinhas = Integer.parseInt( br.readLine());
          
        Produto[] ps = new Produto[numLinhas];
        int i = 0;
        while (i < numLinhas) {
            linha = br.readLine();
            System.out.println(linha);
            String[] info = linha.split(";");
            String nome = info[0];
            String preco = info[1];
            ps[i] = new Produto(nome,Double.parseDouble(preco));
            i++;
        }
        fr.close();
        return ps;
    }

    public static Produto getProduto(String nomeProduto) throws IOException {
        Produto[] produtos = getProdutos();
        for(Produto p: produtos){
            if(p.getNome().equals(nomeProduto));
            return p;
        }
        return null;
    }

}

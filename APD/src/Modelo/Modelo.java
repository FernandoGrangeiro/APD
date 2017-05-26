package Modelo;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import static Modelo.StatusPedido.*;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Modelo implements Serializable{

    public static void alteraStatusPedido(Pedido p, StatusPedido statusPedido) {
        p.statusPedido = statusPedido;
    }

    public static void add(Pedido p) throws FileNotFoundException, IOException {
        Pedido[] pedidos = getPedidos();
        ArrayList<Pedido> arrayPedidos = new ArrayList<>();
                
        //Gera o arquivo para armazenar o objeto
        FileOutputStream arquivoGrav = new FileOutputStream("Pedidos.txt");

        //Classe responsavel por inserir os objetos
        ObjectOutputStream objGravar = new ObjectOutputStream(arquivoGrav);

        //Grava o objeto cliente no arquivo
        if (pedidos != null) {
            if (pedidos.length != 0) {
                for (Pedido umPedido : pedidos) {
                    arrayPedidos.add(umPedido);
                }
            }
        }
        
        arrayPedidos.add(p);
        
        objGravar.writeObject(arrayPedidos);
        objGravar.flush();

        objGravar.close();

        arquivoGrav.flush();

        arquivoGrav.close();
    }

    public static Pedido[] getPedidos(int id) throws IOException {
        Pedido[] pedidos = getPedidos();
        if (pedidos != null) {
            if (pedidos.length != 0) {
                ArrayList<Pedido> pedidosCliente = new ArrayList<>();
                for (Pedido p : pedidos) {
                    if (p.getIdCliente() == id) {
                        pedidosCliente.add(p);
                    }
                }
                Pedido[] pedidosClienteVetor = pedidosCliente.toArray(new Pedido[pedidosCliente.size()]);
                return pedidosClienteVetor;
            }
        }
        return null;

    }

    public static Pedido[] getPedidos() throws FileNotFoundException, IOException {
        ObjectInputStream in = null;
        boolean oef = false;
        ArrayList<Pedido> pedidos = new ArrayList<>();
        try {
            in = new ObjectInputStream(new FileInputStream("Pedidos.txt"));
            while (oef == false) {
                try {
                    pedidos = (ArrayList<Pedido>) in.readObject();
                } catch (IOException | ClassNotFoundException e) {
                    System.out.println("erro durante a leitura");
                    in.close();
                    break;
                }
                in.close();
            }
        } catch (EOFException e) {
            System.out.println("erro durante a leitura EOFException");
        }

        Pedido[] pedidosArray = pedidos.toArray(new Pedido[pedidos.size()]);
        return pedidosArray;
    }

    public static Produto[] getProdutos() throws FileNotFoundException, IOException {
        FileReader fr = new FileReader("Produtos.txt");
        BufferedReader br = new BufferedReader(fr);
        String linha;

        int numLinhas = Integer.parseInt(br.readLine());

        Produto[] ps = new Produto[numLinhas];
        int i = 0;
        while (i < numLinhas) {
            linha = br.readLine();
            String[] info = linha.split(";");
            String nome = info[0];
            String preco = info[1];
            ps[i] = new Produto(nome, Double.parseDouble(preco));
            i++;
        }
        fr.close();
        return ps;
    }

    public static Produto getProduto(String nomeProduto) throws IOException {
        Produto[] produtos = getProdutos();
        for (Produto p : produtos) {
            if (p.getNome().equals(nomeProduto));
            return p;
        }
        return null;
    }

}

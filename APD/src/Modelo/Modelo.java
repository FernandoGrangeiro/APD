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
import java.io.ObjectInputStream;

public class Modelo {

    public static void alteraStatusPedido(Pedido p, StatusPedido statusPedido) {
        p.statusPedido = statusPedido;
    }

    public static void add(Pedido p, Pedido[] pedidos) {
        for (int i = 0; i < pedidos.length; i++) {
            if (pedidos[i] == null) {
                pedidos[i] = p;
            }
        }
    }

    public static Pedido[] getPedidos(int id) throws IOException {
        Pedido[] pedidos = getPedidos();
        if (pedidos != null && pedidos.length != 0) {
            ArrayList<Pedido> pedidosCliente = new ArrayList<>();
            for (Pedido p : pedidos) {
                if (p.getIdCliente() == id) {
                    pedidosCliente.add(p);
                }
            }
            Pedido[] pedidosClienteVetor = pedidosCliente.toArray(new Pedido[pedidosCliente.size()]);
            return pedidosClienteVetor;
        }
        return null;

    }

    public static Pedido[] getPedidos() throws FileNotFoundException, IOException {
        ObjectInputStream in = null;
        boolean oef = false;
        ArrayList<Pedido> pedidos = new ArrayList<>();
        Pedido p = null;
        try {
            in = new ObjectInputStream(new FileInputStream("Pedidos.txt"));
            while (oef == false) {
                try {
                    p = (Pedido) in.readObject();
                    pedidos.add(p);
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
        ObjectInputStream in = null;
        boolean oef = false;
        ArrayList<Produto> produtos = new ArrayList<>();
        Produto p = null;
        try {
            in = new ObjectInputStream(new FileInputStream("Pedidos.txt"));
            while (oef == false) {
                try {
                    p = (Produto) in.readObject();
                    produtos.add(p);
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
        Produto[] produtosArray = produtos.toArray(new Produto[produtos.size()]);
        return produtosArray;
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

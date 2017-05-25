package Controladores;

import Modelo.Cliente;
import Modelo.EnumMenuPedido;
import Modelo.EnumMenuUsuario;
import static Modelo.FormaDePagamento.online;
import Modelo.Modelo;
import Modelo.Pedido;
import static Modelo.StatusPedido.*;
import static Modelo.EnumMenuPedido.*;
import Modelo.Item;
import Modelo.Produto;
import Telas.TelaCliente;
import java.io.IOException;

public class ControladorCliente {

    static void rodar(Cliente c) throws IOException {
        EnumMenuUsuario opcMenu;
        do {
            opcMenu = TelaCliente.menu();
            Pedido p;
            Pedido[] pedidos=null;
            switch (opcMenu) {
                case fazerPedido:
                    p = TelaCliente.montaPedido(Modelo.getProdutos(),c.getId());
                    Modelo.add(p,pedidos);
                    if (p.getFormaPagamento() == online) {
                        boolean pago = TelaCliente.pagarOnline();
                        if (pago) {
                            p.setPago(true);
                        }
                    }
                    break;
                case meusPedidos:
                    pedidos = Modelo.getPedidos(c.getId());
                    p = TelaCliente.escolhePedido(pedidos);
                    if (p.getStatusPedido() != emEspera) {
                        TelaCliente.mostraPedidoSemOpcoes(p);
                    } else {
                        EnumMenuPedido opcPedido;
                        do {
                            opcPedido = TelaCliente.mostraPedidoComOpcoes(p);
                            Item i;
                            switch (opcPedido) {
                                case incluirItem:
                                    Object[] itemDetalhes = TelaCliente.incluirItem();
                                    i = new Item(Integer.parseInt((String) itemDetalhes[0]), (Produto) itemDetalhes[1]);
                                    p.add(i);
                                    break;

                                case alterarQuantidadeItem:
                                    i = TelaCliente.escolheItemDoPedido(p);
                                    int qtd = TelaCliente.novaQuantidade();
                                    i.quantidade(i);
                                    break;

                                case removerItem:
                                    i = TelaCliente.escolheItemDoPedido(p);
                                    p.removeItem(i);
                                    break;

                                case cancelarPedido:
                                    p.cancelar();
                            }
                        } while (opcPedido != voltar);
                    }
            }

        } while (opcMenu != EnumMenuUsuario.sair);

    }

}

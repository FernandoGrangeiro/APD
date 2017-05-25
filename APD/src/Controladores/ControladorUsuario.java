package Controladores;

import Modelo.Cliente;
import Modelo.DecoratorProduto;
import Modelo.EnumMenuPedido;
import Modelo.EnumMenuUsuario;
import static Modelo.FormaDePagamento.online;
import Modelo.Modelo;
import Modelo.Pedido;
import static Modelo.StatusPedido.*;
import static Modelo.EnumMenuPedido.*;
import Modelo.Item;
import Modelo.Produto_Concreto;
import Telas.TelaUsuario;

public class ControladorUsuario {

    static void rodar(Cliente c) {
        EnumMenuUsuario opcMenu;
        do {
            opcMenu = TelaUsuario.menu();
            Pedido p;
            switch (opcMenu) {
                case fazerPedido:
                    p = TelaUsuario.montaPedido(Modelo.getProdutos());
                    Modelo.add(p);
                    if (p.getFormaPagamento() == online) {
                        boolean pago = TelaUsuario.pagarOnline();
                        if (pago) {
                            p.setPago(true);
                        }
                    }
                    break;
                case meusPedidos:
                    Pedido[] pedidos = Modelo.getPedidos(c.getId());
                    p = TelaUsuario.escolhePedido(pedidos);
                    if (p.getStatusPedido() != emEspera) {
                        TelaUsuario.mostraPedidoSemOpcoes(p);
                    } else {
                        EnumMenuPedido opcPedido;
                        do {
                            opcPedido = TelaUsuario.mostraPedidoComOpcoes(p);
                            Item i;
                            switch (opcPedido) {
                                case incluirItem:
                                    Object[] itemDetalhes = TelaUsuario.incluirItem();
                                    i = new Item(Integer.parseInt((String) itemDetalhes[0]), (Produto_Concreto) itemDetalhes[1], (DecoratorProduto) itemDetalhes[2]);
                                    p.add(i);
                                    break;

                                case alterarQuantidadeItem:
                                    i = TelaUsuario.escolheItemDoPedido(p);
                                    int qtd = TelaUsuario.novaQuantidade();
                                    i.quantidade(i);
                                    break;

                                case removerItem:
                                    i = TelaUsuario.escolheItemDoPedido(p);
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

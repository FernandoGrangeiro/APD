package pacote;

public class ControladorCozinheiro {

    public static void rodar() {
        
        EnumMenuCozinheiro opcMenu;
        
        do {
            opcMenu = TelaCozinheiro.showMenu();
            if(opcMenu == EnumMenuCozinheiro.alterarStatusPedido){
                int indexPedido = TelaCozinheiro.escolhePedido();
                EnumStatusPedio statusPedido = TelaCozinheiro.escolheNovoStatus();
            } 
        } while (opcMenu != EnumMenuCozinheiro.sair);

    }

}

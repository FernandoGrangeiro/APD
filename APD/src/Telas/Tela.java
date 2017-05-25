package Telas;

import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Tela {

     public static String[] login() {
        JPanel panel = new JPanel();
        GridLayout gd = new GridLayout(2,2);
        panel.setLayout(gd);
        panel.add(new JLabel("Usuário"));
        JTextField textFieldUsuario = new JTextField();
        panel.add(textFieldUsuario);
        panel.add(new JLabel("Senha"));
        JTextField textFieldSenha = new JTextField();
        panel.add(textFieldSenha);
        
        do{
            JOptionPane.showMessageDialog(null,panel);
        }while(textFieldUsuario.getText().equals("") || textFieldUsuario.getText().equals(" ") ||
                textFieldSenha.getText().equals("") || textFieldSenha.getText().equals(" ") ||
                textFieldSenha.getText() == null || textFieldUsuario.getText() == null);
        
        String[] retorno = {textFieldUsuario.getText(),textFieldSenha.getText()};
               
        return retorno;
        
    }
    
}

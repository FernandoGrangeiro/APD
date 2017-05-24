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
        panel.add(new JTextField());
        panel.add(new JLabel("Senha"));
        panel.add(new JTextField());
        
        JOptionPane.showMessageDialog(null,panel);
        
        return null;
        
    }
    
}

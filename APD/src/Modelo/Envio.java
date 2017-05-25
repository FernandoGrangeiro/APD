package Modelo;

import java.util.Calendar;
import javax.swing.JOptionPane;

public class Envio {

    public Calendar horaSaida;
    public Calendar horaEntrega;

    public Envio() {
    }

    public void setHoraSaida() {
        horaSaida = Calendar.getInstance();
    }

    public void setHoraEntrega() {
        horaEntrega = Calendar.getInstance();
    }

    public void verificarInfo(Cliente c, Pedido p) {
        JOptionPane.showMessageDialog(null, c);
        JOptionPane.showMessageDialog(null, p);

    }
}

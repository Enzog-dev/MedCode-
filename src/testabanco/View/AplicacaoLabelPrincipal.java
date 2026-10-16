package testabanco.View;

import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class AplicacaoLabelPrincipal extends JFrame {

    public AplicacaoLabelPrincipal() {
       ImageIcon icon = new ImageIcon("C:\\Users\\User\\Desktop\\Entregar no grupo\\TestaBanco Todos\\TestaBanco Todos\\TestaBanco Paciente\\TestaBanco (1)\\TestaBancoPaciente\\src\\testabanco\\imagens\\consulta.jpg");
        JLabel label = new JLabel(icon);
        label.setBounds(80, 120, 100, 40);
    }

    public static void main(String[] args) {
        new AplicacaoLabelPrincipal().setVisible(true);
    }
}

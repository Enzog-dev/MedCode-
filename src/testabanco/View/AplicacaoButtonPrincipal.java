package testabanco.View;

import java.awt.event.KeyEvent;
import javax.swing.JButton;

public class AplicacaoButtonPrincipal extends NFramePrincipal {
    JButton B1, B2, B3, B4, B5;
    
    {
        setLayout(null); 

        B1 = new JButton("Consultar Pacientes");
        B1.setSize(300, 50);
        B1.setLocation(100, 40);
        B1.setMnemonic(KeyEvent.VK_P);

        B2 = new JButton("Consultar Enfermeiros");
        B2.setSize(300, 50);
        B2.setLocation(100, 100); 
        B2.setMnemonic(KeyEvent.VK_A);

        B3 = new JButton("Consultar Médicos");
        B3.setSize(300, 50);
        B3.setLocation(100, 160); 
        B3.setMnemonic(KeyEvent.VK_C);

        B4 = new JButton("Triagens");
        B4.setSize(300, 50);
        B4.setLocation(100, 220); 
        B4.setMnemonic(KeyEvent.VK_C);
        
        B5 = new JButton("Consultas");
        B5.setSize(300, 50);
        B5.setLocation(100, 280); 
        B5.setMnemonic(KeyEvent.VK_C);
        
        getContentPane().add(B1);
        getContentPane().add(B2);
        getContentPane().add(B3);
        getContentPane().add(B4);
        getContentPane().add(B5);

        setSize(500, 400);
        setTitle("Clínica MedCode");
        setLocationRelativeTo(null); 
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new AplicacaoButtonPrincipal().setVisible(true);
    }
}

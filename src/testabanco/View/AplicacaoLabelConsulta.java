
package testabanco.View;

import java.awt.Color;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class AplicacaoLabelConsulta extends NFrameConsulta {

    JLabel L1, L2, L3, L4, L5, L6, L7, L8;
    Color cor1 = new Color(105, 105, 105);
    Color cor2 = new Color(128, 128, 128);
    


    public AplicacaoLabelConsulta() {

        L1 = new JLabel("Cadastro de Consulta", JLabel.CENTER);
        L1.setFont(new Font("Arial", Font.BOLD, 14));
        L1.setBorder(BorderFactory.createLineBorder(cor1, 4));
        L1.setForeground(cor1);
        L1.setBounds(130, 60, 300, 30);

        L2 = new JLabel("CPF Paciente:", JLabel.RIGHT);
        L2.setFont(new Font("Arial", Font.BOLD, 14));
        L2.setBounds(80, 120, 120, 25);
        L2.setForeground(cor1);

        L3 = new JLabel("ID Consulta:", JLabel.RIGHT);
        L3.setFont(new Font("Arial", Font.BOLD, 14));
        L3.setBounds(80, 160, 120, 25);
        L3.setForeground(cor1);

        L4 = new JLabel("Hora:", JLabel.RIGHT);
        L4.setFont(new Font("Arial", Font.BOLD, 14));
        L4.setBounds(80, 200, 120, 25);
        L4.setForeground(cor1);

        L5 = new JLabel("Tipo Consulta:", JLabel.RIGHT);
        L5.setFont(new Font("Arial", Font.BOLD, 14));
        L5.setBounds(80, 240, 120, 25);
        L5.setForeground(cor1);

        L6 = new JLabel("ID Triagem:", JLabel.RIGHT);
        L6.setFont(new Font("Arial", Font.BOLD, 14));
        L6.setBounds(80, 280, 120, 25);
        L6.setForeground(cor1);

        L7 = new JLabel("Diagnóstico:", JLabel.RIGHT);
        L7.setFont(new Font("Arial", Font.BOLD, 14));
        L7.setBounds(80, 320, 120, 25);
        L7.setForeground(cor1);

        L8 = new JLabel("CRM Médico:", JLabel.RIGHT);
        L8.setFont(new Font("Arial", Font.BOLD, 14));
        L8.setBounds(80, 360, 120, 25);
        L8.setForeground(cor1);
        
        ImageIcon icon = new ImageIcon("C:\\Users\\User\\Desktop\\Entregar no grupo\\TestaBanco Todos\\TestaBanco Todos\\TestaBanco Paciente\\TestaBanco (1)\\TestaBancoPaciente\\src\\testabanco\\imagens\\consulta.jpg");
        JLabel label = new JLabel(icon);
        label.setBounds(500, 50, 200, 200);

        getContentPane().setLayout(null);
        getContentPane().add(L1);
        getContentPane().add(L2);
        getContentPane().add(L3);
        getContentPane().add(L4);
        getContentPane().add(L5);
        getContentPane().add(L6);
        getContentPane().add(L7);
        getContentPane().add(L8);
        
        getContentPane().add(label);
    
    }
    
public static void main(String[] args) {
        new AplicacaoLabelConsulta().show();
    }

}

    

    
    
    


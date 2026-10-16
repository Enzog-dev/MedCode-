
package testabanco.View;

import java.awt.Color;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class AplicacaoLabelPaciente extends NFramePaciente {

    JLabel L1, L2, L3, L4;
    Color cor1 = new Color(105, 105, 105);
    Color cor2 = new Color(128, 128, 128);

    public AplicacaoLabelPaciente() {

        L1 = new JLabel("Cadastro de Paciente", JLabel.CENTER);
        L1.setFont(new Font("Arial", Font.BOLD, 14));
        L1.setBorder(BorderFactory.createLineBorder(cor1, 4));
        L1.setForeground(cor1);
        L1.setBounds(130, 60, 300, 30);

        L2 = new JLabel("CPF :", JLabel.RIGHT);
        L2.setFont(new Font("Arial", Font.BOLD, 14));
        L2.setBounds(80, 120, 100, 40);
        L2.setForeground(cor1);

        L3 = new JLabel("Nome :", JLabel.RIGHT);
        L3.setFont(new Font("Arial", Font.BOLD, 14));
        L3.setBounds(80, 160, 100, 40);
        L3.setForeground(cor1);

        L4 = new JLabel("Telefone:   ", JLabel.RIGHT);
        L4.setFont(new Font("Arial", Font.BOLD, 14));
        L4.setBounds(80, 190, 120, 40);
        L4.setForeground(cor1);

        ImageIcon icon = new ImageIcon("C:\\Users\\User\\Desktop\\Entregar no grupo\\TestaBanco Todos\\TestaBanco Todos\\TestaBanco Paciente\\TestaBanco (1)\\TestaBancoPaciente\\src\\testabanco\\imagens\\paciente.jpg");
        JLabel label = new JLabel(icon);
        label.setBounds(500, 50, 200, 200);

        getContentPane().setLayout(null);
        getContentPane().add(L1);
        getContentPane().add(L2);
        getContentPane().add(L3);
        getContentPane().add(L4);
        getContentPane().add(label);
    }

    public static void main(String[] args) {
        new AplicacaoLabelPaciente().show();
    }
}
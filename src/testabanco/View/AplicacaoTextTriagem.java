package testabanco.View;

import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JScrollPane;

public class AplicacaoTextTriagem extends AplicacaoLabelTriagem {
    public JTextField Tx0, Tx1, Tx2, Tx3, Tx4, Tx5;
    public JTextArea Tx6;

    public AplicacaoTextTriagem() {
        // ID da triagem (Tx0)
        Tx0 = new JTextField();
        Tx0.setBounds(205, 83, 100, 25); // abaixo de "ID Triagem"

        Tx1 = new JTextField(); // CPF Paciente
        Tx1.setBounds(205, 123, 100, 25);

        Tx2 = new JTextField(); // ID Enfermeiro
        Tx2.setBounds(205, 163, 100, 25);

        Tx3 = new JTextField(); // Pressão
        Tx3.setBounds(205, 203, 100, 25);

        Tx4 = new JTextField(); // Temperatura
        Tx4.setBounds(205, 243, 100, 25);

        Tx5 = new JTextField(); // Batimentos
        Tx5.setBounds(205, 286, 100, 25);

        Tx6 = new JTextArea();  // Sintomas
        Tx6.setLineWrap(true);
        Tx6.setWrapStyleWord(true);
        JScrollPane scroll = new JScrollPane(Tx6);
        scroll.setBounds(205, 330, 200, 60);

        getContentPane().add(Tx0);
        getContentPane().add(Tx1);
        getContentPane().add(Tx2);
        getContentPane().add(Tx3);
        getContentPane().add(Tx4);
        getContentPane().add(Tx5);
        getContentPane().add(scroll); // adiciona JScrollPane, não diretamente o JTextArea
    }

    public static void main(String[] args) {
        new AplicacaoTextTriagem().show();
    }
}

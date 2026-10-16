package testabanco.View;

import testabanco.Model.Triagem;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ListaTriagem extends NFrameTriagem {

    JLabel L2;
    DefaultListModel<String> lista;
    JList<String> itens;
    JPanel P1;

    public ListaTriagem(ArrayList<Triagem> dados) {
        setTitle("Lista de Triagens");
        L2 = new JLabel("Lista de Triagens");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        setVisible(true);
        setResizable(false);
        setSize(500, 500);

        L2.setSize(400, 20);
        L2.setLocation(10, 20);
        L2.setForeground(new Color(105, 105, 105));  // cor ajustada para combinar

        lista = new DefaultListModel<>();

        for (Triagem triagem : dados) {
            String cpfPaciente = triagem.getPaciente().getCpf();
            String idEnfermeiro = triagem.getEnfermeiro().getId(); // id é String
            int pressao = triagem.getPressao();
            double temperatura = triagem.getTemperatura();

            lista.addElement("CPF: " + cpfPaciente +
                             " | Enfermeiro: " + idEnfermeiro +
                             " | Pressão: " + pressao +
                             " | Temp: " + temperatura);
        }

        itens = new JList<>(lista);
        itens.setSize(430, 300);
        itens.setLocation(10, 10);
        itens.setBackground(new Color(192, 192, 192));

        P1 = new JPanel();
        P1.setBounds(20, 50, 460, 350);
        P1.setBackground(new Color(211, 211, 211));
        P1.setBorder(BorderFactory.createLineBorder(Color.black, 2));
        P1.setLayout(null);
        P1.add(itens);

        getContentPane().setBackground(Color.yellow);
        getContentPane().setLayout(null);
        getContentPane().add(L2);
        getContentPane().add(P1);
    }
}

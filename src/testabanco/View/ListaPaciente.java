package testabanco.View;
import testabanco.*;
import testabanco.Model.Paciente;
import testabanco.View.NFramePaciente;
import java.awt.Color;
import java.util.ArrayList;

import javax.swing.*;

public class ListaPaciente extends NFramePaciente {
    
    JLabel L2;
    DefaultListModel<String> lista;
    JList<String> itens;
    JPanel P1;
    
    public ListaPaciente(ArrayList<Paciente> dados) {
        
        setTitle("Lista");
        L2 = new JLabel("Lista de Pacientes");
        setDefaultCloseOperation(ListaPaciente.DISPOSE_ON_CLOSE);

        setVisible(true);
        setResizable(false);
        setSize(500, 500);
        
        L2.setSize(400, 20);
        L2.setLocation(10, 20);
        L2.setForeground(new Color(211, 211, 211));
        
        
        lista = new DefaultListModel<>();
        
        for (int i = 0; i < dados.size(); i++) {
            String cpf = dados.get(i).getCpf();
            String nome = dados.get(i).getNome();
            lista.addElement(cpf + " - " + nome);
        }
        
        itens = new JList<>(lista);
        itens.setSize(430, 200);
        itens.setLocation(10, 10);
        itens.setBackground(new Color(192, 192, 192));
        
        P1 = new JPanel();
        P1.setBounds(20, 50, 450, 330);
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
package testabanco.View;
import testabanco.*;
import testabanco.Model.Consulta;
import testabanco.View.NFrameConsulta;
import java.awt.Color;
import java.util.ArrayList;

import javax.swing.*;

public class ListaConsulta extends NFrameConsulta {
    
    JLabel L2;
    DefaultListModel<String> lista;
    JList<String> itens;
    JPanel P1;
    
    public ListaConsulta(ArrayList<Consulta> dados) {
        // Altera o título da página
        setTitle("Lista");
        L2 = new JLabel("Lista de Consulta");
        setDefaultCloseOperation(ListaConsulta.DISPOSE_ON_CLOSE);

        setVisible(true);
        setResizable(false);
        setSize(500, 500);
        
        L2.setSize(400, 20);
        L2.setLocation(10, 20);
        L2.setForeground(new Color(211, 211, 211));
        
        // Acrescenta o objeto lista de seleção
        lista = new DefaultListModel<>();
        
        for (int i = 0; i < dados.size(); i++) {
            String cpf = dados.get(i).getCpf();
            String hora = dados.get(i).getHora();
            String tipo_consulta = dados.get(i).getTipo_consulta();
            String id_consulta = dados.get(i).getId_consulta();
            String Diagnostico = dados.get(i).getDiagnostico();
            String id_Triagem = dados.get(i).getId_triagem();
            String Crm_medico = dados.get(i).getCrm_medico();
            
            lista.addElement(cpf + " - " + hora);
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


package testabanco.View;

import testabanco.Model.Enfermeiro;
import testabanco.DAO.enfermeiroDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class AplicacaoEventoEnfermeiro extends AplicacaoButtonEnfermeiro implements ActionListener {
    Enfermeiro enfermeiro = new Enfermeiro();
    enfermeiroDAO enfermeiroBD;

    public AplicacaoEventoEnfermeiro() {
        B1.addActionListener(this); // Incluir
        B2.addActionListener(this); // Alterar
        B3.addActionListener(this); // Consultar
        B4.addActionListener(this); // Excluir
        B5.addActionListener(this); // Sair
        B6.addActionListener(this); // Listar
    }

    public void actionPerformed(ActionEvent e) {
        // Incluir enfermeiro
        if (e.getSource() == B1) {
            enfermeiro.setCoren(Tx1.getText());
            enfermeiro.setNome(Tx2.getText());
            enfermeiro.setId(Tx3.getText());

            enfermeiroBD = new enfermeiroDAO();
            enfermeiroBD.insert(enfermeiro);

            Tx1.setText("");
            Tx2.setText("");
            Tx3.setText("");
        }

        // Alterar enfermeiro
        if (e.getSource() == B2) {
            if ((enfermeiro.getCoren() == null) || Tx1.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Primeiro insira o coren e consulte");
            } else {
                enfermeiroBD = new enfermeiroDAO();
                enfermeiro.setCoren(Tx1.getText());
                enfermeiro.setNome(Tx2.getText());
                enfermeiro.setId(Tx3.getText());

                enfermeiroBD.update(enfermeiro);

                enfermeiro.setCoren(null);
                Tx1.setText("");
                Tx2.setText("");
                Tx3.setText("");
            }
        }

        // Consultar enfermeiro
        if (e.getSource() == B3) {
            enfermeiro.setCoren(null);
            enfermeiro.setNome("");
            enfermeiro.setId("");
            enfermeiroBD = new enfermeiroDAO();
            enfermeiro.setCoren(Tx1.getText());
            enfermeiroBD.consulta(enfermeiro);

            Tx2.setText(enfermeiro.getNome());
            Tx3.setText(enfermeiro.getId());
        }

        // Excluir enfermeiro
        if (e.getSource() == B4) {
            if ((Tx2.getText().equals("")) || (enfermeiro.getCoren() == null)) {
                JOptionPane.showMessageDialog(null, "Primeiro consulte o Enfermeiro");
            } else {
                enfermeiro.setCoren(Tx1.getText());
                enfermeiroBD = new enfermeiroDAO();
                enfermeiroBD.delete(enfermeiro);

                Tx1.setText("");
                Tx2.setText("");
                Tx3.setText("");
            }
        }

        // Sair da aplicação
        if (e.getSource() == B5) {
            this.dispose();
        }

        // Listar todos os enfermeiros
        if (e.getSource() == B6) {
            enfermeiroBD = new enfermeiroDAO();
            ArrayList<Enfermeiro> dados = enfermeiroBD.listaEnfermeiro();
            NFrameEnfermeiro Fx = new ListaEnfermeiro(dados);
            Fx.show();
        }
    }

    public static void main(String[] args) {
        new AplicacaoEventoEnfermeiro().show();
    }
}
    
    


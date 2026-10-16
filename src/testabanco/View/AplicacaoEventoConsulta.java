package testabanco.View;

import testabanco.Model.Consulta;
import testabanco.DAO.consultaDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class AplicacaoEventoConsulta extends AplicacaoButtonConsulta implements ActionListener {

    Consulta consulta;
    consultaDAO consultaBD;

    public AplicacaoEventoConsulta() {
        B1.addActionListener(this); // Incluir
        B2.addActionListener(this); // Alterar
        B3.addActionListener(this); // Consultar
        B4.addActionListener(this); // Excluir
        B5.addActionListener(this); // Sair
        B6.addActionListener(this); // Listar
    }

    public void actionPerformed(ActionEvent e) {
        // Incluir consulta
        if (e.getSource() == B1) {
            consulta = new Consulta();
            consulta.setCpf(Tx1.getText());
            consulta.setId_consulta(Tx2.getText());
            consulta.setHora(Tx3.getText());
            consulta.setTipo_consulta(Tx4.getText());
            consulta.setDiagnostico(Tx5.getText());
            consulta.setId_triagem(Tx6.getText());
            consulta.setCrm_medico(Tx7.getText());

            consultaBD = new consultaDAO();
            consultaBD.insert(consulta);

            limparCampos();
        }

        // Alterar consulta
        if (e.getSource() == B2) {
            if (Tx1.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Primeiro insira um CPF e consulte.");
            } else {
                consulta = new Consulta();
                consulta.setCpf(Tx1.getText());
                consulta.setId_consulta(Tx2.getText());
                consulta.setHora(Tx3.getText());
                consulta.setTipo_consulta(Tx4.getText());
                consulta.setDiagnostico(Tx5.getText());
                consulta.setId_triagem(Tx6.getText());
                consulta.setCrm_medico(Tx7.getText());

                consultaBD = new consultaDAO();
                consultaBD.update(consulta);

                limparCampos();
            }
        }

        // Consultar consulta
        if (e.getSource() == B3) {
            consulta = new Consulta();
            consulta.setCpf(Tx1.getText());

            consultaBD = new consultaDAO();
            consultaBD.consulta(consulta);

            Tx1.setText(consulta.getCpf());
            Tx2.setText(consulta.getId_consulta());
            Tx3.setText(consulta.getHora());
            Tx4.setText(consulta.getTipo_consulta());
            Tx5.setText(consulta.getDiagnostico());
            Tx6.setText(consulta.getId_triagem());
            Tx7.setText(consulta.getCrm_medico());
        }

        // Excluir consulta
        if (e.getSource() == B4) {
            if (Tx2.getText().equals("") || Tx1.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Primeiro consulte a consulta antes de excluir.");
            } else {
                consulta = new Consulta();
                consulta.setCpf(Tx1.getText());
                consulta.setId_consulta(Tx2.getText());

                consultaBD = new consultaDAO();
                consultaBD.delete(consulta);

                limparCampos();
            }
        }

        // Sair
        if (e.getSource() == B5) {
            this.dispose();
        }

        // Listar consultas (apenas chamado, resultado ainda não tratado)
        if (e.getSource() == B6) {
            consultaBD = new consultaDAO();
            ArrayList<Consulta> dados = consultaBD.listaConsulta();
            // Aqui você pode tratar os dados ou mostrar em tabela se quiser.
        }
    }

    // Método auxiliar para limpar os campos
    private void limparCampos() {
        Tx1.setText("");
        Tx2.setText("");
        Tx3.setText("");
        Tx4.setText("");
        Tx5.setText("");
        Tx6.setText("");
        Tx7.setText("");
    }

    public static void main(String[] args) {
        new AplicacaoEventoConsulta().show();
    }
}

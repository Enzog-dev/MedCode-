
package testabanco.View;

import testabanco.Model.Paciente;
import testabanco.DAO.pacienteDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class AplicacaoEventoPaciente extends AplicacaoButtonPaciente implements ActionListener {

    Paciente paciente = new Paciente();
    pacienteDAO pacienteBD;

    public AplicacaoEventoPaciente() {
        B1.addActionListener(this); // Incluir
        B2.addActionListener(this); // Alterar
        B3.addActionListener(this); // Consultar
        B4.addActionListener(this); // Excluir
        B5.addActionListener(this); // Sair
        B6.addActionListener(this); // Listar
    }

    public void actionPerformed(ActionEvent e) {
        // Incluir paciente
        if (e.getSource() == B1) {
            paciente.setCpf(Tx1.getText());
            paciente.setNome(Tx2.getText());
            paciente.setTelefone(Tx3.getText());

            pacienteBD = new pacienteDAO();
            pacienteBD.insert(paciente);

            Tx1.setText("");
            Tx2.setText("");
            Tx3.setText("");
        }

        // Alterar paciente
        if (e.getSource() == B2) {
            if ((paciente.getCpf() == null) || Tx1.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Primeiro insira um CPF e consulte");
            } else {
                pacienteBD = new pacienteDAO();
                paciente.setCpf(Tx1.getText());
                paciente.setNome(Tx2.getText());
                paciente.setTelefone(Tx3.getText());

                pacienteBD.update(paciente);

                paciente.setCpf(null);
                Tx1.setText("");
                Tx2.setText("");
                Tx3.setText("");
            }
        }

        // Consultar paciente
        if (e.getSource() == B3) {
            paciente.setCpf(null);
            paciente.setNome("");
            paciente.setTelefone("");
            pacienteBD = new pacienteDAO();
            paciente.setCpf(Tx1.getText());
            pacienteBD.consulta(paciente);

            Tx2.setText(paciente.getNome());
            Tx3.setText(paciente.getTelefone());
        }

        // Excluir paciente
        if (e.getSource() == B4) {
            if ((Tx2.getText().equals("")) || (paciente.getCpf() == null)) {
                JOptionPane.showMessageDialog(null, "Primeiro consulte o Paciente");
            } else {
                paciente.setCpf(Tx1.getText());
                pacienteBD = new pacienteDAO();
                pacienteBD.delete(paciente);

                Tx1.setText("");
                Tx2.setText("");
                Tx3.setText("");
            }
        }

        // Sair da aplicação
        if (e.getSource() == B5) {
            this.dispose();
        }

        // Listar todos os pacientes
        if (e.getSource() == B6) {
            pacienteBD = new pacienteDAO();
            ArrayList<Paciente> dados = pacienteBD.listaPacientes();
            NFramePaciente Fx = new ListaPaciente(dados);
            Fx.show();
        }
    }

    public static void main(String[] args) {
        new AplicacaoEventoPaciente().show();
    }
}

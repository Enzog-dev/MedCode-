package testabanco.View;

import testabanco.Model.Triagem;
import testabanco.DAO.triagemDAO;
import testabanco.Model.Paciente;
import testabanco.Model.Enfermeiro;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class AplicacaoEventoTriagem extends AplicacaoButtonTriagem implements ActionListener {

    Triagem triagem = new Triagem();
    triagemDAO triagemBD;

    public AplicacaoEventoTriagem() {
        B1.addActionListener(this); // Incluir
        B2.addActionListener(this); // Alterar
        B3.addActionListener(this); // Consultar
        B4.addActionListener(this); // Excluir
        B5.addActionListener(this); // Sair
        B6.addActionListener(this); // Listar
    }

    public void actionPerformed(ActionEvent e) {
        // Incluir triagem
        if (e.getSource() == B1) {
            Paciente paciente = new Paciente();
            Enfermeiro enfermeiro = new Enfermeiro();

            paciente.setCpf(Tx1.getText());
            enfermeiro.setId(Tx2.getText());

            triagem.setPaciente(paciente);
            triagem.setEnfermeiro(enfermeiro);
            triagem.setPressao(Integer.parseInt(Tx3.getText()));
            triagem.setTemperatura(Double.parseDouble(Tx4.getText()));
            triagem.setBatimentos(Integer.parseInt(Tx5.getText()));
            triagem.setSintomas(Tx6.getText());

            triagemBD = new triagemDAO();
            triagemBD.insert(triagem);

            limparCampos();
        }

        // Alterar triagem
        if (e.getSource() == B2) {
            if (Tx1.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Primeiro insira o CPF do Paciente e consulte");
            } else {
                Paciente paciente = new Paciente();
                Enfermeiro enfermeiro = new Enfermeiro();

                paciente.setCpf(Tx1.getText());
                enfermeiro.setId(Tx2.getText());

                triagem.setPaciente(paciente);
                triagem.setEnfermeiro(enfermeiro);
                triagem.setPressao(Integer.parseInt(Tx3.getText()));
                triagem.setTemperatura(Double.parseDouble(Tx4.getText()));
                triagem.setBatimentos(Integer.parseInt(Tx5.getText()));
                triagem.setSintomas(Tx6.getText());

                triagemBD = new triagemDAO();
                triagemBD.update(triagem);

                limparCampos();
            }
        }

        // Consultar triagem (consultar por id)
        if (e.getSource() == B3) {
            try {
                int idTriagem = Integer.parseInt(Tx1.getText()); // aqui assumo que consulta pelo id da triagem

                triagem.setId(idTriagem);
                triagemBD = new triagemDAO();
                triagemBD.consulta(triagem);

                Enfermeiro enfermeiro = triagem.getEnfermeiro();
                Paciente paciente = triagem.getPaciente();

                Tx1.setText(String.valueOf(triagem.getId()));          // mostra o id da triagem
                Tx2.setText(String.valueOf(enfermeiro.getId()));
                Tx3.setText(String.valueOf(triagem.getPressao()));
                Tx4.setText(String.valueOf(triagem.getTemperatura()));
                Tx5.setText(String.valueOf(triagem.getBatimentos()));
                Tx6.setText(triagem.getSintomas());

                // Se desejar, pode ter um campo extra para CPF do paciente para mostrar:
                // Exemplo: Tx7.setText(paciente.getCpf());

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Insira um ID válido para consultar");
            }
        }

        // Excluir triagem (excluir por id)
        if (e.getSource() == B4) {
            try {
                int idTriagem = Integer.parseInt(Tx1.getText());

                triagem.setId(idTriagem);
                triagemBD = new triagemDAO();
                triagemBD.delete(triagem);

                limparCampos();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Insira um ID válido para excluir");
            }
        }

        // Sair da aplicação
        if (e.getSource() == B5) {
            this.dispose();
        }

        // Listar todas as triagens
        if (e.getSource() == B6) {
            triagemBD = new triagemDAO();
            ArrayList<Triagem> dados = triagemBD.listaTriagens();
            NFrameTriagem Fx = new ListaTriagem(dados);
            Fx.show();
        }
    }

    private void limparCampos() {
        Tx1.setText("");
        Tx2.setText("");
        Tx3.setText("");
        Tx4.setText("");
        Tx5.setText("");
        Tx6.setText("");
    }

    public static void main(String[] args) {
        new AplicacaoEventoTriagem().show();
    }
}

package testabanco.View;
import testabanco.Model.Medico;
import testabanco.*;
import testabanco.DAO.medicoDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
public class AplicacaoEventoMedico extends AplicacaoButtonMedico implements ActionListener
{
    Medico medico = new Medico();
    medicoDAO medicoBD;
    
    public AplicacaoEventoMedico()
    {
        B1.addActionListener(this);// Adiciona ações ao botão
        B2.addActionListener(this);
        B3.addActionListener(this);
        B4.addActionListener(this);
        B5.addActionListener(this);
        B6.addActionListener(this);
    }
    
    public void actionPerformed(ActionEvent e)
    {
        // Incluir médico
        if(e.getSource() == B1)
        {   
            medico.setCrm(Tx1.getText());
            medico.setNome(Tx2.getText());
            medico.setEspecialidade(Tx3.getText());
            
            medicoBD = new medicoDAO();
            medicoBD.insert(medico);
            
            // limpar campos
            Tx1.setText("");
            Tx2.setText("");
            Tx3.setText("");
        }
        
        // Alterar médico
        if(e.getSource() == B2)
        {
            if ((medico.getCrm() == null) || Tx1.getText().equals("") || Tx1.getText().equals(""))
            {
                JOptionPane.showMessageDialog(null, "Primeiro insira um CRM e consulte");
            }
            else
            {
                medicoBD = new medicoDAO();
                medico.setCrm(Tx1.getText());
                medico.setNome(Tx2.getText());
                medico.setEspecialidade(Tx3.getText());
                
                medicoBD.update(medico);
                
                // limpar campos
                medico.setCrm(null);
                Tx1.setText("");
                Tx2.setText("");
                Tx3.setText("");
            }
        }
        
        // Consultar médico
        if (e.getSource() == B3)
        {                                                        
            medico.setCrm(null);
            medico.setNome("");
            medico.setEspecialidade("");
            medicoBD = new medicoDAO();
            medico.setCrm(Tx1.getText());
            medicoBD.consulta(medico);
            
            Tx2.setText(medico.getNome());
            Tx3.setText(medico.getEspecialidade());
        }
        
        // Excluir médico
        if(e.getSource() == B4)
        {
            if ((Tx2.getText().equals("")) || (medico.getCrm() == null))
            {
                JOptionPane.showMessageDialog(null, "Primeiro consulte o Médico");
            }
            else
            {
                medico.setCrm(Tx1.getText());
                medicoBD = new medicoDAO();
                medicoBD.delete(medico);
                
                // limpar campos
                Tx1.setText("");
                Tx2.setText("");
                Tx3.setText("");
            }
        }				
        
        // Sair da aplicação
        if (e.getSource() == B5)
        {				
            this.dispose();
        }
        
        // ListaMedico todos os médicos
        if (e.getSource() == B6)
        { 
            medicoBD = new medicoDAO();
            ArrayList dados = medicoBD.listaMedicos();
            NFrameMedico Fx = new ListaMedico(dados);
            Fx.show();
        }                        
    }
    
    public static void main(String arg[])
    {
        new AplicacaoEventoMedico().show();
    }  
}
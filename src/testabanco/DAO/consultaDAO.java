
package testabanco.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import testabanco.ConexaoDB;
import testabanco.Model.Consulta;
import testabanco.Model.Medico;

public class consultaDAO {

    public void insert(Consulta consulta) {
       
       String sql = "INSERT INTO consulta (cpf, id_consulta, Hora, Tipo_consulta, Diagnostico, ID_triagem, Crm_medico) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try {
            Connection c = ConexaoDB.obtemConexao();
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(1, consulta.getCpf());
            ps.setString(2, consulta.getId_consulta());
            ps.setString(3, consulta.getHora());
            ps.setString(4, consulta.getTipo_consulta());
            ps.setString(5, consulta.getDiagnostico());
            ps.setString(6, consulta.getId_triagem());
            ps.setString(7, consulta.getCrm_medico());
            ps.execute();
            JOptionPane.showMessageDialog(null, "Consulta realizado com sucesso");
            ps.close();
            c.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao acessar a consulta");
            e.printStackTrace();
        }
    }

   public void update(Consulta consulta) {
    String sql = "UPDATE consulta SET id_consulta=?, hora=?, tipo_consulta=?, diagnostico=?, id_triagem=?, crm_medico=? WHERE cpf=?";
    try {
        Connection c = ConexaoDB.obtemConexao();
        PreparedStatement ps = c.prepareStatement(sql);
        ps.setString(1, consulta.getId_consulta()); 
        ps.setString(2, consulta.getHora()); 
        ps.setString(3, consulta.getTipo_consulta()); 
        ps.setString(4, consulta.getDiagnostico()); 
        ps.setString(5, consulta.getId_triagem()); 
        ps.setString(6, consulta.getCrm_medico()); 
        ps.setString(7, consulta.getCpf()); // o "WHERE" pra saber qual quer atualizar
        ps.executeUpdate();

        JOptionPane.showMessageDialog(null, "Dados da consulta atualizados com sucesso.");
        ps.close();
        c.close();

    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Erro ao atualizar a consulta.");
        e.printStackTrace();
    }
}


    public void delete(Consulta consulta) {
        String sql = "DELETE FROM consulta WHERE cpf=?";
        try {
            Connection c = ConexaoDB.obtemConexao();
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(1, consulta.getCpf());
            ps.execute();
            JOptionPane.showMessageDialog(null, "Consulta excluída com sucesso");
            ps.close();
            c.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir consulta");
            e.printStackTrace();
        }
    }

    public void consulta(Consulta consulta) {
        String sql = "SELECT * FROM consulta WHERE cpf=?";
        try {
            Connection c = ConexaoDB.obtemConexao();
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(1, consulta.getCpf());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                consulta.setCpf(rs.getString("cpf"));
                consulta.setId_consulta(rs.getString("id_consulta"));
                consulta.setHora(rs.getString("hora"));
                consulta.setTipo_consulta(rs.getString("tipo_consulta"));
                consulta.setDiagnostico(rs.getString("diagnostico"));
                consulta.setId_triagem(rs.getString("id_triagem"));
                consulta.setCrm_medico(rs.getString("crm_medico"));

                
                Medico medico = new Medico();
                medico.setCrm(rs.getString("crm_medico"));
                medico.setNome("");
                medico.setEspecialidade("");
                
            }
            rs.close();
            ps.close();
            c.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Consulta> listaConsulta() {
        ArrayList<Consulta> dados = new ArrayList<>();
        String sql = "SELECT * FROM consulta";
        try {
            Connection c = ConexaoDB.obtemConexao();
            PreparedStatement ps = c.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Consulta consulta = new Consulta();
                consulta.setCpf(rs.getString("cpf"));
                consulta.setId_consulta(rs.getString("id_consulta"));
                consulta.setHora(rs.getString ("hora"));
                consulta.setTipo_consulta(rs.getString ("tipo_consulta"));
                consulta.setDiagnostico(rs.getString ("diagnostico"));
                consulta.setId_triagem(rs.getString ("id_triagem"));
                consulta.setCrm_medico(rs.getString ("crm_medico"));
                dados.add(consulta);
            }
            rs.close();
            ps.close();
            c.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao listar consultas");
            e.printStackTrace();
        }
        return dados;
    }
    
    


   
    
    
    
    
    
    
}



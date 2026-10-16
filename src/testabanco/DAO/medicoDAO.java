package testabanco.DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import testabanco.ConexaoDB;
import testabanco.Model.Medico;

public class medicoDAO {
    
    public void insert(Medico medico) {
        String sql = "INSERT INTO medico (crm, nome, especialidade) VALUES (?, ?, ?)";
        try {
            Connection c = ConexaoDB.obtemConexao();
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(1, medico.getCrm());
            ps.setString(2, medico.getNome());
            ps.setString(3, medico.getEspecialidade());
            ps.execute();
            JOptionPane.showMessageDialog(null, "Cadastro do médico realizado com sucesso");
            ps.close();
            c.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar médico");
            e.printStackTrace();
        }
    }

    public void update(Medico medico) {
        String sql = "UPDATE medico SET nome=?, especialidade=? WHERE crm=?";
        try {
            Connection c = ConexaoDB.obtemConexao();
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(1, medico.getNome());
            ps.setString(2, medico.getEspecialidade());
            ps.setString(3, medico.getCrm());
            ps.execute();
            JOptionPane.showMessageDialog(null, "Alteração do médico realizada com sucesso");
            ps.close();
            c.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar médico");
            e.printStackTrace();
        }
    }

    public void delete(Medico medico) {
        String sql = "DELETE FROM medico WHERE crm=?";
        try {
            Connection c = ConexaoDB.obtemConexao();
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(1, medico.getCrm());
            ps.execute();
            JOptionPane.showMessageDialog(null, "Médico excluído com sucesso");
            ps.close();
            c.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir médico");
            e.printStackTrace();
        }
    }

    public void consulta(Medico medico) {
        String sql = "SELECT * FROM medico WHERE crm=?";
        try {
            Connection c = ConexaoDB.obtemConexao();
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(1, medico.getCrm());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                medico.setNome(rs.getString("nome"));
                medico.setEspecialidade(rs.getString("especialidade"));
            }
            rs.close();
            ps.close();
            c.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Medico> listaMedicos() {
        ArrayList<Medico> dados = new ArrayList<>();
        String sql = "SELECT * FROM medico";
        try {
            Connection c = ConexaoDB.obtemConexao();
            PreparedStatement ps = c.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Medico medico = new Medico();
                medico.setCrm(rs.getString("crm"));
                medico.setNome(rs.getString("nome"));
                medico.setEspecialidade(rs.getString("especialidade"));
                dados.add(medico);
            }
            rs.close();
            ps.close();
            c.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao listar médicos");
            e.printStackTrace();
        }
        return dados;
    }
}

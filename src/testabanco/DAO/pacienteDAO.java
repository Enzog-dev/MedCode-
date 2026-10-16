
package testabanco.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import testabanco.ConexaoDB;
import testabanco.Model.Paciente;

public class pacienteDAO {

    public void insert(Paciente paciente) {
        String sql = "INSERT INTO paciente (cpf, nome, telefone) VALUES (?, ?, ?)";
        try {
            Connection c = ConexaoDB.obtemConexao();
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(1, paciente.getCpf());
            ps.setString(2, paciente.getNome());
            ps.setString(3, paciente.getTelefone());
            ps.execute();
            JOptionPane.showMessageDialog(null, "Cadastro do paciente realizado com sucesso");
            ps.close();
            c.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar paciente");
            e.printStackTrace();
        }
    }

    public void update(Paciente paciente) {
        String sql = "UPDATE paciente SET nome=?, telefone=? WHERE cpf=?";
        try {
            Connection c = ConexaoDB.obtemConexao();
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(1, paciente.getNome());
            ps.setString(2, paciente.getTelefone());
            ps.setString(3, paciente.getCpf());
            ps.execute();
            JOptionPane.showMessageDialog(null, "Alteração do paciente realizada com sucesso");
            ps.close();
            c.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar paciente");
            e.printStackTrace();
        }
    }

    public void delete(Paciente paciente) {
        String sql = "DELETE FROM paciente WHERE cpf=?";
        try {
            Connection c = ConexaoDB.obtemConexao();
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(1, paciente.getCpf());
            ps.execute();
            JOptionPane.showMessageDialog(null, "Paciente excluído com sucesso");
            ps.close();
            c.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir paciente");
            e.printStackTrace();
        }
    }

    public void consulta(Paciente paciente) {
        String sql = "SELECT * FROM paciente WHERE cpf=?";
        try {
            Connection c = ConexaoDB.obtemConexao();
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(1, paciente.getCpf());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                paciente.setNome(rs.getString("nome"));
                paciente.setTelefone(rs.getString("telefone"));
            }
            rs.close();
            ps.close();
            c.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Paciente> listaPacientes() {
        ArrayList<Paciente> dados = new ArrayList<>();
        String sql = "SELECT * FROM paciente";
        try {
            Connection c = ConexaoDB.obtemConexao();
            PreparedStatement ps = c.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Paciente paciente = new Paciente();
                paciente.setCpf(rs.getString("cpf"));
                paciente.setNome(rs.getString("nome"));
                paciente.setTelefone(rs.getString("telefone"));
                dados.add(paciente);
            }
            rs.close();
            ps.close();
            c.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao listar pacientes");
            e.printStackTrace();
        }
        return dados;
    }
}

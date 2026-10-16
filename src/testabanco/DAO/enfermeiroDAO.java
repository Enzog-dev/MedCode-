
package testabanco.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import testabanco.ConexaoDB;
import testabanco.Model.Enfermeiro;

public class enfermeiroDAO {
    public void insert(Enfermeiro enfermeiro) {
        String sql = "INSERT INTO enfermeiro (coren, nome, id) VALUES (?, ?, ?)";
        try {
            Connection c = ConexaoDB.obtemConexao();
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(1, enfermeiro.getCoren());
            ps.setString(2, enfermeiro.getNome());
            ps.setString(3, enfermeiro.getId());
            ps.execute();
            JOptionPane.showMessageDialog(null, "Cadastro do enfermeiro realizado com sucesso");
            ps.close();
            c.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar enfermeiro");
            e.printStackTrace();
        }
    }

    public void update(Enfermeiro enfermeiro) {
        String sql = "UPDATE enfermeiro SET coren=?, nome=? WHERE id=?";
        try {
            Connection c = ConexaoDB.obtemConexao();
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(1, enfermeiro.getCoren());
            ps.setString(2, enfermeiro.getNome());
            ps.setString(3, enfermeiro.getId());
            ps.execute();
            JOptionPane.showMessageDialog(null, "Alteração do enfermeiro realizada com sucesso");
            ps.close();
            c.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar enfermeiro");
            e.printStackTrace();
        }
    }

    public void delete(Enfermeiro enfermeiro) {
        String sql = "DELETE FROM enfermeiro WHERE coren=?";
        try {
            Connection c = ConexaoDB.obtemConexao();
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(1, enfermeiro.getCoren());
            ps.execute();
            JOptionPane.showMessageDialog(null, "Enfermeiro excluído com sucesso");
            ps.close();
            c.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir enfermeiro");
            e.printStackTrace();
        }
    }

    public void consulta(Enfermeiro enfermeiro) {
        String sql = "SELECT * FROM enfermeiro WHERE coren=?";
        try {
            Connection c = ConexaoDB.obtemConexao();
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(1, enfermeiro.getCoren());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                enfermeiro.setNome(rs.getString("nome"));
                enfermeiro.setId(rs.getString("id"));
            }
            rs.close();
            ps.close();
            c.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Enfermeiro> listaEnfermeiro() {
        ArrayList<Enfermeiro> dados = new ArrayList<>();
        String sql = "SELECT * FROM enfermeiro";
        try {
            Connection c = ConexaoDB.obtemConexao();
            PreparedStatement ps = c.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Enfermeiro enfermeiro = new Enfermeiro();
                enfermeiro.setCoren(rs.getString("coren"));
                enfermeiro.setNome(rs.getString("nome"));
                enfermeiro.setId(rs.getString("id"));
                dados.add(enfermeiro);
            }
            rs.close();
            ps.close();
            c.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao listar enfermeiro");
            e.printStackTrace();
        }
        return dados;
    }
}

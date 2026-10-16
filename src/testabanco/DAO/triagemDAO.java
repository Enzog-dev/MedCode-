package testabanco.DAO;

import testabanco.ConexaoDB;
import testabanco.Model.Triagem;
import testabanco.Model.Paciente;
import testabanco.Model.Enfermeiro;

import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class triagemDAO {

    public void insert(Triagem triagem) {
        String sql = "INSERT INTO triagem (pressao, temperatura, sintomas, cpf_paciente, id, batimentos, datahora) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection c = ConexaoDB.obtemConexao();
             PreparedStatement ps = c.prepareStatement(sql)) {

            ps.setInt(1, triagem.getPressao());
            ps.setDouble(2, triagem.getTemperatura());
            ps.setString(3, triagem.getSintomas());
            ps.setString(4, triagem.getPaciente().getCpf());
            ps.setInt(5, Integer.parseInt(triagem.getEnfermeiro().getId()));
            ps.setInt(6, triagem.getBatimentos());
            ps.setTimestamp(7, Timestamp.valueOf(triagem.getDataHora()));

            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Triagem cadastrada com sucesso");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar triagem");
            e.printStackTrace();
        }
    }

    public void update(Triagem triagem) {
        String sql = "UPDATE triagem SET pressao=?, temperatura=?, sintomas=?, cpf_paciente=?, id=?, batimentos=?, datahora=? WHERE id_triagem=?";
        try (Connection c = ConexaoDB.obtemConexao();
             PreparedStatement ps = c.prepareStatement(sql)) {

            ps.setInt(1, triagem.getPressao());
            ps.setDouble(2, triagem.getTemperatura());
            ps.setString(3, triagem.getSintomas());
            ps.setString(4, triagem.getPaciente().getCpf());
            ps.setInt(5, Integer.parseInt(triagem.getEnfermeiro().getId()));
            ps.setInt(6, triagem.getBatimentos());
            ps.setTimestamp(7, Timestamp.valueOf(triagem.getDataHora()));
            ps.setInt(8, triagem.getId());

            int linhas = ps.executeUpdate();
            if (linhas > 0) {
                JOptionPane.showMessageDialog(null, "Triagem atualizada com sucesso");
            } else {
                JOptionPane.showMessageDialog(null, "Triagem não encontrada para atualização");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar triagem");
            e.printStackTrace();
        }
    }

    public void delete(Triagem triagem) {
        String sql = "DELETE FROM triagem WHERE id_triagem=?";
        try (Connection c = ConexaoDB.obtemConexao();
             PreparedStatement ps = c.prepareStatement(sql)) {

            ps.setInt(1, triagem.getId());
            int linhas = ps.executeUpdate();
            if (linhas > 0) {
                JOptionPane.showMessageDialog(null, "Triagem excluída com sucesso");
            } else {
                JOptionPane.showMessageDialog(null, "Triagem não encontrada para exclusão");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir triagem");
            e.printStackTrace();
        }
    }

    public void consulta(Triagem triagem) {
        String sql = "SELECT * FROM triagem WHERE id_triagem=?";
        try (Connection c = ConexaoDB.obtemConexao();
             PreparedStatement ps = c.prepareStatement(sql)) {

            ps.setInt(1, triagem.getId());
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                triagem.setId(rs.getInt("id_triagem"));
                triagem.setPressao(rs.getInt("pressao"));
                triagem.setTemperatura(rs.getDouble("temperatura"));
                triagem.setSintomas(rs.getString("sintomas"));
                triagem.setBatimentos(rs.getInt("batimentos"));

                Timestamp ts = rs.getTimestamp("datahora");
                if (ts != null) {
                    triagem.setDataHora(ts.toLocalDateTime());
                }

                // Atualiza paciente
                Paciente paciente = new Paciente();
                paciente.setCpf(rs.getString("cpf_paciente"));
                triagem.setPaciente(paciente);

                // Atualiza enfermeiro
                Enfermeiro enfermeiro = new Enfermeiro();
                enfermeiro.setId(rs.getString("id"));  // mudou aqui
                triagem.setEnfermeiro(enfermeiro);

            } else {
                JOptionPane.showMessageDialog(null, "Triagem não encontrada!");
            }
            rs.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao consultar triagem");
            e.printStackTrace();
        }
    }

    public ArrayList<Triagem> listaTriagens() {
        ArrayList<Triagem> dados = new ArrayList<>();
        String sql = "SELECT * FROM triagem";  // Atenção: aqui estava "triagens", coloquei "triagem" supondo que a tabela correta seja essa
        try (Connection c = ConexaoDB.obtemConexao();
             PreparedStatement ps = c.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Triagem triagem = new Triagem();

                triagem.setId(rs.getInt("id_triagem"));
                triagem.setPressao(rs.getInt("pressao"));
                triagem.setTemperatura(rs.getDouble("temperatura"));
                triagem.setSintomas(rs.getString("sintomas"));
                triagem.setBatimentos(rs.getInt("batimentos"));

                Timestamp ts = rs.getTimestamp("datahora");
                if (ts != null) {
                    triagem.setDataHora(ts.toLocalDateTime());
                }

                Paciente paciente = new Paciente();
                paciente.setCpf(rs.getString("cpf_paciente"));
                triagem.setPaciente(paciente);

                Enfermeiro enfermeiro = new Enfermeiro();
                enfermeiro.setId(rs.getString("id"));  // mudou aqui
                triagem.setEnfermeiro(enfermeiro);

                dados.add(triagem);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao listar triagens");
            e.printStackTrace();
        }
        return dados;
    }
}

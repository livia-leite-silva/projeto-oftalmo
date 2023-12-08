package br.com.oftalmo.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import java.sql.Date;
import br.com.oftalmo.model.ConsultaMedica;

public class ConsultaMedicaDAO extends ConexaoDB{
    private static final String INSERT_CONSULTA_MEDICA_SQL = "INSERT INTO consultas_medicas (assinatura, dt_consulta, id_paciente, id_medico) VALUES (?, ?, ?, ?);";
    private static final String SELECT_CONSULTA_MEDICA_BY_ID = "SELECT id, assinatura, dt_consulta, id_paciente, id_medico FROM consultas_medicas WHERE id = ?;";
    private static final String SELECT_ALL_CONSULTA_MEDICA_SQL = "SELECT * FROM consultas_medicas";
    private static final String UPDATE_CONSULTA_MEDICA_SQL = "UPDATE consultas_medicas SET assinatura = ?, dt_consulta = ?, id_paciente = ?, id_medico = ? WHERE id = ?;";
    private static final String DELETE_CONSULTA_MEDICA_SQL = "DELETE FROM consultas_medicas WHERE id = ?";
    private static final String TOTAL = "SELECT count(1) FROM consultas_medicas";
    

    public Integer count() {
        Integer count = 0;
        try (PreparedStatement preparedStatement = prepararSQL(TOTAL)) {
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                count = rs.getInt("count");
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return count;
    }

    public void insertConsultaMedica(ConsultaMedica entidade) {
        try (PreparedStatement preparedStatement = prepararSQL(INSERT_CONSULTA_MEDICA_SQL)) {
            preparedStatement.setString(1, entidade.getAssinatura());
            preparedStatement.setDate(2, entidade.getDtConsulta());
            preparedStatement.setInt(3, entidade.getIdPaciente());
            preparedStatement.setInt(4, entidade.getIdMedico());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public ConsultaMedica selectConsultaMedica(int id) {
        ConsultaMedica entidade = null;
        try (PreparedStatement preparedStatement = prepararSQL(SELECT_CONSULTA_MEDICA_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String assinatura = rs.getString("assinatura");
                Date dt_consulta = rs.getDate("dt_consulta");
                int id_paciente = rs.getInt("id_paciente");
                int id_medico = rs.getInt("id_medico");
                entidade = new ConsultaMedica(id, assinatura, dt_consulta, id_paciente, id_medico);
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return entidade;
    }

    public List<ConsultaMedica> selectAllConsultaMedica() {
        List<ConsultaMedica> entidades = new ArrayList<>();
        try (PreparedStatement preparedStatement = prepararSQL(SELECT_ALL_CONSULTA_MEDICA_SQL)) {
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String assinatura = rs.getString("assinatura");
                Date dt_consulta = rs.getDate("dt_consulta");
                int id_paciente = rs.getInt("id_paciente");
                int id_medico = rs.getInt("id_medico");
                entidades.add(new ConsultaMedica(id, assinatura, dt_consulta, id_paciente, id_medico));
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return entidades;
    }

    public boolean deleteConsultaMedica(int id) throws SQLException {
        try (PreparedStatement statement = prepararSQL(DELETE_CONSULTA_MEDICA_SQL)) {
            statement.setInt(1, id);
            return statement.executeUpdate() > 0;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean updateConsultaMedica(ConsultaMedica entidade) throws SQLException {
        try (PreparedStatement statement = prepararSQL(UPDATE_CONSULTA_MEDICA_SQL)) {
            statement.setString(1, entidade.getAssinatura());
            statement.setDate(2, entidade.getDtConsulta());
            statement.setInt(3, entidade.getIdPaciente());
            statement.setInt(4, entidade.getIdMedico());
            statement.setInt(5, entidade.getId());

            return statement.executeUpdate() > 0;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

}




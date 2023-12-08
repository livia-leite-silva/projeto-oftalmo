package br.com.oftalmo.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import java.sql.Date;
import br.com.oftalmo.model.EspecialidadeMedica;

public class EspecialidadeMedicaDAO extends ConexaoDB {
    private static final String INSERT_ESPECIALIDADE_MEDICA_SQL = "INSERT INTO especialidades_medicas (observacao, dt_conclusao, id_especialidade, id_medico) VALUES (?, ?, ?, ?);";
    private static final String SELECT_ESPECIALIDADE_MEDICA_BY_ID = "SELECT id, assinatura, dt_consulta, id_especialidade, id_medico FROM especialidades_medicas WHERE id = ?;";
    private static final String SELECT_ALL_ESPECIALIDADE_MEDICA_SQL = "SELECT * FROM especialidades_medicas";
    private static final String UPDATE_ESPECIALIDADE_MEDICA_SQL = "UPDATE especialidades_medicas SET observacao = ?, dt_conclusao = ?, id_especialidade = ?, id_medico = ? WHERE id = ?;";
    private static final String DELETE_ESPECIALIDADE_MEDICA_SQL = "DELETE FROM especialidades_medicas WHERE id = ?";
    private static final String TOTAL = "SELECT count(1) FROM especialidades_medicas";
    
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

    public void insertEspecialidade(EspecialidadeMedica entidade) {
        try (PreparedStatement preparedStatement = prepararSQL(INSERT_ESPECIALIDADE_MEDICA_SQL)) {
            preparedStatement.setString(1, entidade.getObservacao());
            preparedStatement.setDate(2, entidade.getDtConclusao());
            preparedStatement.setInt(3, entidade.getIdEspecialidade());
            preparedStatement.setInt(4, entidade.getIdMedico());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public EspecialidadeMedica selectEspecialidade(int id) {
        EspecialidadeMedica entidade = null;
        try (PreparedStatement preparedStatement = prepararSQL(SELECT_ESPECIALIDADE_MEDICA_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String observacao = rs.getString("observacao");
                Date dt_conclusao = rs.getDate("dt_conclusao");
                int id_especialidade = rs.getInt("id_especialidade");
                int id_medico = rs.getInt("id_medico");
                entidade = new EspecialidadeMedica(id, observacao, dt_conclusao, id_especialidade, id_medico);
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return entidade;
    }

    public List<EspecialidadeMedica> selectAllEspecialidade() {
        List<EspecialidadeMedica> entidades = new ArrayList<>();
        try (PreparedStatement preparedStatement = prepararSQL(SELECT_ALL_ESPECIALIDADE_MEDICA_SQL)) {
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String observacao = rs.getString("observacao");
                Date dt_conclusao = rs.getDate("dt_conclusao");
                int id_especialidade = rs.getInt("id_especialidade");
                int id_medico = rs.getInt("id_medico");
                entidades.add(new EspecialidadeMedica(id, observacao, dt_conclusao, id_especialidade, id_medico));
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return entidades;
    }

    public boolean deleteEspecialidade(int id) throws SQLException {
        try (PreparedStatement statement = prepararSQL(DELETE_ESPECIALIDADE_MEDICA_SQL)) {
            statement.setInt(1, id);
            return statement.executeUpdate() > 0;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean updateEspecialidade(EspecialidadeMedica entidade) throws SQLException {
        try (PreparedStatement statement = prepararSQL(UPDATE_ESPECIALIDADE_MEDICA_SQL)) {
            statement.setString(1, entidade.getObservacao());
            statement.setDate(2, entidade.getDtConclusao());
            statement.setInt(3, entidade.getIdEspecialidade());
            statement.setInt(4, entidade.getIdMedico());
            statement.setInt(5, entidade.getId());

            return statement.executeUpdate() > 0;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}

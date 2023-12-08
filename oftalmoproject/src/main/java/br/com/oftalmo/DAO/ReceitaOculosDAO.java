package br.com.oftalmo.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import br.com.oftalmo.model.ReceitaOculos;
import java.sql.Date;


public class ReceitaOculosDAO extends ConexaoDB{
    private static final String INSERT_RECEITA_OCULOS_SQL = "INSERT INTO receitas_oculos (detalhamento, dt_consulta, id_consulta_medica) VALUES (?, ?, ?);";
    private static final String SELECT_RECEITA_OCULOS_BY_ID = "SELECT id, assinatura, dt_consulta, id_paciente, id_medico FROM receitas_oculos WHERE id = ?;";
    private static final String SELECT_ALL_RECEITA_OCULOS_SQL = "SELECT * FROM receitas_oculos";
    private static final String UPDATE_RECEITA_OCULOS_SQL = "UPDATE receitas_oculos SET assinatura = ?, dt_consulta = ? WHERE id = ?;";
    private static final String DELETE_RECEITA_OCULOS_SQL = "DELETE FROM receitas_oculos WHERE id = ?";
    private static final String TOTAL = "SELECT count(1) FROM receitas_oculos";
    

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

    public void insertReceitaOculos(ReceitaOculos entidade) {
        try (PreparedStatement preparedStatement = prepararSQL(INSERT_RECEITA_OCULOS_SQL)) {
            preparedStatement.setString(1, entidade.getDetalhamento());
            preparedStatement.setDate(2, entidade.getDtConsulta());
            preparedStatement.setInt(3, entidade.getIdConsultaMedica());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public ReceitaOculos selectReceitaOculos(int id) {
        ReceitaOculos entidade = null;
        try (PreparedStatement preparedStatement = prepararSQL(SELECT_RECEITA_OCULOS_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String detalhamento = rs.getString("detalhamento");
                Date dt_consulta = rs.getDate("dt_consulta");
                int id_consulta_medica = rs.getInt("id_consulta_medica");
                entidade = new ReceitaOculos(id, detalhamento, dt_consulta, id_consulta_medica);
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return entidade;
    }

    public List<ReceitaOculos> selectAllReceitaOculos() {
        List<ReceitaOculos> entidades = new ArrayList<>();
        try (PreparedStatement preparedStatement = prepararSQL(SELECT_ALL_RECEITA_OCULOS_SQL)) {
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String detalhamento = rs.getString("detalhamento");
                Date dt_consulta = rs.getDate("dt_consulta");
                int id_consulta_medica = rs.getInt("id_consulta_medica");
                entidades.add(new ReceitaOculos(id, detalhamento, dt_consulta, id_consulta_medica));
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return entidades;
    }

    public boolean deleteReceitaOculos(int id) throws SQLException {
        try (PreparedStatement statement = prepararSQL(DELETE_RECEITA_OCULOS_SQL)) {
            statement.setInt(1, id);
            return statement.executeUpdate() > 0;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean updateReceitaOculos(ReceitaOculos entidade) throws SQLException {
        try (PreparedStatement statement = prepararSQL(UPDATE_RECEITA_OCULOS_SQL)) {
            statement.setString(1, entidade.getDetalhamento());
            statement.setDate(2, entidade.getDtConsulta());
            statement.setInt(3, entidade.getIdConsultaMedica());
            statement.setInt(4, entidade.getId());

            return statement.executeUpdate() > 0;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}

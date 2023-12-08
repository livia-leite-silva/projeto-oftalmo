package br.com.oftalmo.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import br.com.oftalmo.model.EstruturaLente;

public class EstruturaLenteDAO extends ConexaoDB{
    private static final String INSERT_ESTRUTURA_LENTE_SQL = "INSERT INTO estruturas_lentes (tipo_correcao, distancia_pupilar, id_receita_oculos) VALUES (?, ?, ?);";
    private static final String SELECT_ESTRUTURA_LENTE_BY_ID = "SELECT id, tipo_correcao, distancia_pupilar, id_receita_oculos FROM estruturas_lentes WHERE id = ?;";
    private static final String SELECT_ALL_ESTRUTURA_LENTE_SQL = "SELECT * FROM estruturas_lentes";
    private static final String UPDATE_ESTRUTURA_LENTE_SQL = "UPDATE estruturas_lentes SET tipo_correcao = ?, distancia_pupilar = ?, id_receita_oculos = ?, WHERE id = ?;";
    private static final String DELETE_ESTRUTURA_LENTE_SQL = "DELETE FROM estruturas_lentes WHERE id = ?";
    private static final String TOTAL = "SELECT count(1) FROM estruturas_lentes";
    
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

    public void insertEspecialidade(EstruturaLente entidade) {
        try (PreparedStatement preparedStatement = prepararSQL(INSERT_ESTRUTURA_LENTE_SQL)) {
            preparedStatement.setString(1, entidade.getTipoCorrecao());
            preparedStatement.setInt(2, entidade.getDistanciaPupilar());
            preparedStatement.setInt(3, entidade.getIdReceitaOculos());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public EstruturaLente selectEspecialidade(int id) {
        EstruturaLente entidade = null;
        try (PreparedStatement preparedStatement = prepararSQL(SELECT_ESTRUTURA_LENTE_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String tipo_correcao = rs.getString("tipo_correcao");
                int distancia_pupilar = rs.getInt("distancia_pupilar");
                int id_receita_oculos = rs.getInt("id_receita_oculos");
                entidade = new EstruturaLente(id, tipo_correcao, distancia_pupilar, id_receita_oculos);
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return entidade;
    }

    public List<EstruturaLente> selectAllEspecialidade() {
        List<EstruturaLente> entidades = new ArrayList<>();
        try (PreparedStatement preparedStatement = prepararSQL(SELECT_ALL_ESTRUTURA_LENTE_SQL)) {
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String tipo_correcao = rs.getString("tipo_correcao");
                int distancia_pupilar = rs.getInt("distancia_pupilar");
                int id_receita_oculos = rs.getInt("id_receita_oculos");
                entidades.add(new EstruturaLente(id, tipo_correcao, distancia_pupilar, id_receita_oculos));
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return entidades;
    }

    public boolean deleteEspecialidade(int id) throws SQLException {
        try (PreparedStatement statement = prepararSQL(DELETE_ESTRUTURA_LENTE_SQL)) {
            statement.setInt(1, id);
            return statement.executeUpdate() > 0;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean updateEspecialidade(EstruturaLente entidade) throws SQLException {
        try (PreparedStatement statement = prepararSQL(UPDATE_ESTRUTURA_LENTE_SQL)) {
            statement.setString(1, entidade.getTipoCorrecao());
            statement.setInt(2, entidade.getDistanciaPupilar());
            statement.setInt(3, entidade.getIdReceitaOculos());
            statement.setInt(4, entidade.getId());

            return statement.executeUpdate() > 0;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}

package br.com.oftalmo.DAO;

import br.com.oftalmo.model.AtributoEstruturaLente;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class AtributoEstruturaLenteDAO extends ConexaoDB{

    private static final String INSERT_ATRIBUTO_ESTRUTURA_LENTE_SQL = "INSERT INTO atributos_estrutura_lente (descricao, lado_olho) VALUES (?, ?);";
    private static final String SELECT_ATRIBUTO_ESTRUTURA_LENTE_BY_ID = "SELECT id, descricao, lado_olho FROM atributos_estrutura_lente WHERE id = ?;";
    private static final String SELECT_ALL_ATRIBUTO_ESTRUTURA_LENTE_SQL = "SELECT * FROM atributos_estrutura_lente";
    private static final String UPDATE_ATRIBUTO_ESTRUTURA_LENTE_SQL = "UPDATE atributos_estrutura_lente SET descricao = ?, lado_olho = ? WHERE id = ?;";
    private static final String DELETE_ATRIBUTO_ESTRUTURA_LENTE_SQL = "DELETE FROM atributos_estrutura_lente WHERE id = ?";
    private static final String TOTAL = "SELECT count(1) FROM atributos_estrutura_lente";

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
    public void insertAtributoEstruturaLente(AtributoEstruturaLente entidade){
        try (PreparedStatement preparedStatement = prepararSQL(INSERT_ATRIBUTO_ESTRUTURA_LENTE_SQL)){
            preparedStatement.setString(1, entidade.getDescricao());
            preparedStatement.setString(2, entidade.getLadoOlho());
            preparedStatement.executeUpdate();
        } catch (SQLException e){
            printSQLException(e);
        } catch (ClassNotFoundException e){
            throw new RuntimeException(e);
        }
    }

    public AtributoEstruturaLente selectAtributoEstruturaLente(int id){
        AtributoEstruturaLente entidade = null;
        try (PreparedStatement preparedStatement = prepararSQL(SELECT_ATRIBUTO_ESTRUTURA_LENTE_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String descricao = rs.getString("descricao");
                String lado_olho = rs.getString("lado_olho");
                entidade = new AtributoEstruturaLente(descricao, lado_olho);
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return entidade;
    }

   
    public List<AtributoEstruturaLente> selectAllAtributoEstruturaLente() {
        List<AtributoEstruturaLente> entidades = new ArrayList<>();
        try (PreparedStatement preparedStatement = prepararSQL(SELECT_ALL_ATRIBUTO_ESTRUTURA_LENTE_SQL)) {
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String descricao = rs.getString("descricao");
                String lado_olho = rs.getString("lado_olho");
                entidades.add(new AtributoEstruturaLente(id, descricao, lado_olho));
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return entidades;
    }

    public boolean deleteAtributoEstruturaLente(int id) throws SQLException {
        try (PreparedStatement statement = prepararSQL(DELETE_ATRIBUTO_ESTRUTURA_LENTE_SQL)) {
            statement.setInt(1, id);
            return statement.executeUpdate() > 0;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean updateMedico(AtributoEstruturaLente entidade) throws SQLException {
        try (PreparedStatement statement = prepararSQL(UPDATE_ATRIBUTO_ESTRUTURA_LENTE_SQL)) {
            statement.setString(1, entidade.getDescricao());
            statement.setString(2, entidade.getLadoOlho());
            statement.setInt(3, entidade.getId());

            return statement.executeUpdate() > 0;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

}

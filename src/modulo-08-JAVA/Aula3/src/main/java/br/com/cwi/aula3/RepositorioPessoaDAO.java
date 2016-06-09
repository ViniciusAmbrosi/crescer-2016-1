package br.com.cwi.aula3;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author vinicius.ambrosi
 */
public class RepositorioPessoaDAO implements IPessoa {

    private static final Logger LOGGER = Logger.getLogger(Run.class.getName());

    private Connection getConnection() throws SQLException {
        return ConnectionUtils.getConnection();
    }

    @Override
    public void insert(Pessoa pessoa) {
        String insert = "INSERT INTO PESSOA (ID_PESSOA, NM_PESSOA) "
                + "VALUES ((SELECT MAX(ID_PESSOA) + 1 FROM PESSOA),?)";

        try (final Connection connection = getConnection();
                final PreparedStatement preparedStatement = connection.prepareStatement(insert)) {
            preparedStatement.setString(1, pessoa.getNome());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            LOGGER.severe(e.getMessage());
        }
    }

    @Override
    public void update(Pessoa pessoa) {
        String update = "UPDATE PESSOA SET NM_PESSOA = ? WHERE ID_PESSOA = ? ";
        if (pessoa.getId() == 0) {
            throw new IllegalArgumentException();
        }
        try (final Connection connection = getConnection();
                final PreparedStatement preparedStatement = connection.prepareStatement(update)) {
            preparedStatement.setString(1, pessoa.getNome());
            preparedStatement.setInt(2, pessoa.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.severe(e.getMessage());
        }
    }

    @Override
    public void delete(Pessoa pessoa) {
        String delete = "DELETE FROM PESSOA WHERE ID = ?";
        if (pessoa.getId() == 0) {
            throw new IllegalArgumentException();
        }
        try (final Connection connection = getConnection();
                final PreparedStatement preparedStatement = connection.prepareStatement(delete)) {

            preparedStatement.setInt(1, pessoa.getId());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            LOGGER.severe(e.getMessage());
        }
    }

    @Override
    public List<Pessoa> listAll() {
        List<Pessoa> lista = new ArrayList<>();
        String query = "SELECT * FROM PESSOA";
        try(final Connection connection = getConnection();
                final PreparedStatement preparedStatement = connection.prepareStatement(query);
                final ResultSet rs = preparedStatement.executeQuery(query)) {
            
            while (rs.next()) {
                lista.add(new Pessoa(rs.getString("NM_PESSOA"),rs.getInt(1)));
            }
            
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.severe(e.getMessage());
        }
        return lista;
    }

    @Override
    public List<Pessoa> findNome(String nome) {
        List<Pessoa> lista = new ArrayList<>();
        String query = "SELECT * FROM PESSOA WHERE NM_PESSOA LIKE ?";
        try(final Connection connection = getConnection();
                final PreparedStatement preparedStatement = connection.prepareStatement(query)){
            preparedStatement.setString(1, "%" + nome + "%");
            final ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                lista.add(new Pessoa(rs.getString("NM_PESSOA"),rs.getInt(1)));
            }
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.severe(e.getMessage());
        }
        return lista;
    }

}

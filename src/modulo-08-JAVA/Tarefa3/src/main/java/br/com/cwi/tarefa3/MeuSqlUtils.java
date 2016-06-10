package br.com.cwi.tarefa3;

import br.com.cwi.aula3.ConnectionUtils;
import br.com.cwi.aula3.Run;
import br.com.cwi.tarefa2.MeuReaderUtils;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 *
 * @author vinicius.ambrosi
 */
public class MeuSqlUtils {

    private static final Logger LOGGER = Logger.getLogger(Run.class.getName());

    public static void lerSql() throws IOException {
        String sql = MeuReaderUtils.lerArquivo("Pessoas.sql");
        String[] comandos = sql.split(";");
        try (final Connection connection = ConnectionUtils.getConnection();
                final Statement statement = connection.createStatement()) {
            for (String comando : comandos) {
                statement.addBatch(comando);
            }
            statement.executeBatch();
        } catch (SQLException e) {
            LOGGER.severe(e.getMessage());
        }
    }

    public static List<String> lerColunasELinhas(String sql) {
        List<String> linhas = new ArrayList();
        try (final Connection connection = ConnectionUtils.getConnection();
                final PreparedStatement preparedStatement = connection.prepareStatement(sql);
                final ResultSet rs = preparedStatement.executeQuery(sql)) {
            while (rs.next()) {
                if (linhas.isEmpty()) {
                    linhas.add(rs.getMetaData().getColumnName(1) + "  " + rs.getMetaData().getColumnName(2));
                } else {
                    linhas.add(rs.getRow() + "  " + rs.getString("NM_Pessoa"));
                }
            }
        } catch (SQLException e) {
            LOGGER.severe(e.getMessage());
        }
        return linhas;
    }

    public static void importarCsv(String csvFile, String tableName) throws IOException {
        if(tableName.trim().length() == 0)
            throw new IllegalArgumentException();
        try (final Connection connection = ConnectionUtils.getConnection();
                final Statement statement = connection.createStatement()) {
            List<String> comandos = readCsv(csvFile);
            if (comandos.size() > 2) {
                String header = comandos.remove(0);
                header = header.replace(";", ",");
                for (String comando : comandos) {
                    String[] atributos = comando.split(";");
                    String sql = String.format("INSERT INTO %s (%s) VALUES (%s,%s)", tableName, header, atributos[0], "'" + atributos[1] + "'");
                    statement.addBatch(sql);
                }
                statement.executeBatch();
            } else {
                throw new IllegalArgumentException();
            }
        } catch (SQLException e) {
            LOGGER.severe(e.getMessage());
        }
    }

    private static List<String> readCsv(String csv) throws IOException {
        try (Reader reader = new FileReader(csv);
                BufferedReader bufferReader = new BufferedReader(reader)) {

            List<String> linhas = new ArrayList();
            String line = null;

            while ((line = bufferReader.readLine()) != null) {
                linhas.add(line);
            }
            return linhas;

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.tarefa3;

import br.com.cwi.aula3.ConnectionUtils;
import br.com.cwi.aula3.Run;
import br.com.cwi.tarefa2.MeuReaderUtils;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
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
}

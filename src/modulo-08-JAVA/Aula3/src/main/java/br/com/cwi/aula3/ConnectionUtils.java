package br.com.cwi.aula3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author vinicius.ambrosi
 */
public class ConnectionUtils {

    private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
    private static final String USER = "CRESCER16";
    private static final String PASS = "CRESCER16";

    public static Connection getConnection() throws SQLException {
        final Connection connection;
        connection = DriverManager.getConnection(URL, USER, PASS);
        return connection;
    }
}

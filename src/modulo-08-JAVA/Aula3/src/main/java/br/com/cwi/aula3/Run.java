/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.aula3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author vinicius.ambrosi
 */
public class Run {

    public static void main(String[] args) {
        // Oracle Thin 
        // jdbc:oracle:thin:@<HOST>:<PORT>:<SID>
        // oracle.jdbc.driver.OracleDriver

        final String ddl = "CREATE TABLE PESSOA ("
                + " ID_PESSOA NUMBER(19,0) NOT NULL, "
                + " NM_PESSOA VARCHAR2(50) NOT NULL, "
                + " PRIMARY KEY (ID_PESSOA) "
                + ")";

        final String dml = "INSERT INTO PESSOA (ID_PESSOA, NM_PESSOA)"
                + " VALUES (1, 'CARLOS')";

        final String query = "SELECT * FROM PESSOA";
        
        final String injectionQuery = "UPDATE PESSOA SET NM_PESSOA = 'HACKEADO' WHERE ID_PESSOA = ";

        try (final Connection connection = ConnectionUtils.getConnection()) {
            try (final Statement statement = connection.createStatement();
                    final ResultSet rs = statement.executeQuery(query)) {
                //statement.executeUpdate(ddl);
                //statement.executeUpdate(dml);
                statement.executeUpdate(injectionQuery + "1 OR 1=1"); //injection sendo um parametro
                while (rs.next()) {
                    System.out.println(
                            String.format("%d, %s", rs.getInt(1), rs.getString("NM_PESSOA")));
                }
                //ou colocar o try if resource
            }
        } catch (SQLException e) {
            System.err.format("SQLException: %s", e);
        }
    }
}

/*
 * fuel-control
 * CopyRight Rech Informática Ltda. Todos os direitos reservados.
 */
package br.com.jpe.fuelcontrol.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import org.springframework.stereotype.Service;

/**
 * Factory for creating connections
 */
@Service
public class ConnFactory {

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            System.out.println("Falha ao carregar Driver JDBC");
        }
    }

    public Connection getConn() throws SQLException {
        // Define as propriedades da conexão
        Properties pt = new Properties();
        pt.setProperty("user", "perin");
        pt.setProperty("password", "1234");
        pt.setProperty("autoReconnect", "true");
        return DriverManager.getConnection("jdbc:mysql://vc-pedweb-vubu/perintst", pt);
    }

    public void rollback(Connection conn) throws SQLException {
        if (conn != null) {
            conn.rollback();
        }
    }

    public void close(Connection conn) throws SQLException {
        if (conn != null) {
            conn.close();
        }
    }

}

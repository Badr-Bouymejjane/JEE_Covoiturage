package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/db_covoiturage";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "";
    private static final String DB_DRIVER_MYSQL = "com.mysql.cj.jdbc.Driver";

    private static Connection connection = null;

    public static Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            try {
                if (DB_URL.startsWith("jdbc:mysql")) {
                    Class.forName(DB_DRIVER_MYSQL);
                }
                System.out.println("Driver JDBC chargé.");

                connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
                System.out.println("Connexion à la base de données établie !");

            } catch (ClassNotFoundException e) {
                System.err.println("Erreur: Driver JDBC non trouvé.");
                e.printStackTrace();
                throw new SQLException("Driver non trouvé", e);
            } catch (SQLException e) {
                System.err.println("Erreur de connexion à la base de données.");
                e.printStackTrace();
                throw e;
            }
        }
        return connection;
    }
}
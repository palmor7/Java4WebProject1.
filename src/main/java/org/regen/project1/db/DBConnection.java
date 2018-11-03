package org.regen.project1.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static final String DB_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DB_CONNECTION = "jdbc:mysql://localhost:3306/car_insurance?useUnicode=true" +
            "&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&useSSL=false";
    private String DB_USER=System.getenv("DB_USER");
    private String DB_PASSWORD=System.getenv("DB_PASSWORD");
    private Connection connection;

    public Connection getDBConnection() throws Exception {
        Class.forName(DB_DRIVER);
        connection = DriverManager.getConnection(DB_CONNECTION, DB_USER, DB_PASSWORD);
        return connection;
    }

    public void closeDBConnection() throws SQLException {
        if (connection != null) {
            connection.close();
        }
    }
}

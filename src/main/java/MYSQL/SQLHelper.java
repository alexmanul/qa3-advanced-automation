package MYSQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLHelper {

    final String URL = "jdbc:mysql://127.0.0.1:3306/qa3";
    final String USER = "test_user";
    final String PASSWORD = "123456";

    public Statement createStatement() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
        return con.createStatement();
    }


    public void executeSimpleQuery(String simpleQuery) throws SQLException {
        Statement statement = createStatement();
        statement.executeQuery(simpleQuery);
    }

    public void executeUpdateQuery(String updateQuery) throws SQLException {
        Statement statement = createStatement();
        statement.executeUpdate(updateQuery);
    }


}

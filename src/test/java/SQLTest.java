import org.junit.jupiter.api.Test;

import java.sql.*;

import static org.assertj.core.api.Assertions.assertThat;

public class SQLTest {

    @Test
    public void test1_find_and_assert_agent_data() throws SQLException {
        String user = "test_user";
        String password = "123456";
        String query1 = "SELECT * FROM qa3.agents WHERE agents.agent_name = 'Lucida'";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/qa3", user, password);
        Statement stmt = con.createStatement();
        ResultSet resultSet = stmt.executeQuery(query1);
        resultSet.next();
        assertThat(resultSet.getString(1)).isEqualTo("A012");
        assertThat(resultSet.getString(2)).isEqualTo("Lucida");
        assertThat(resultSet.getString(3)).isEqualTo("San Jose");
        assertThat(resultSet.getString(4)).isEqualTo("0.12");
        assertThat(resultSet.getString(5)).isEqualTo("044-52981425");
        assertThat(resultSet.getString(6)).isEqualTo("");
        con.close();
    }
}

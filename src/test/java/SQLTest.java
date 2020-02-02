import org.junit.jupiter.api.Test;

import java.sql.*;

import static org.assertj.core.api.Assertions.assertThat;

public class SQLTest {

    String user = "test_user";
    String password = "123456";

    /**
     * Task 1 – Simple validation
     * First of all check the Database what it is inside it
     * Create a test where we find agent with name Lucida and assert all his data (Check his id, name, city, phone number)
     * Can be done through assert or SoftAsserts
     */
    @Test
    public void test1() throws SQLException {
        String query = "SELECT * FROM qa3.agents WHERE agents.agent_name = 'Lucida'";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/qa3", user, password);
        Statement stmt = con.createStatement();
        ResultSet resultSet = stmt.executeQuery(query);
        resultSet.next();
        assertThat(resultSet.getString(1)).isEqualTo("A012");
        assertThat(resultSet.getString(2)).isEqualTo("Lucida");
        assertThat(resultSet.getString(3)).isEqualTo("San Jose");
        assertThat(resultSet.getString(4)).isEqualTo("0.12");
        assertThat(resultSet.getString(5)).isEqualTo("044-52981425");
        assertThat(resultSet.getString(6)).isEqualTo("");
        con.close();
    }

    /**
     * Task 2 – Add/Remove data
     * Create a test where we insert Agent – Test from Riga and PhoneNumber - 778-32556178
     * Create a test where we update Agent – Mukesh –
     * Change that he is from Bangladesh and PhoneNumber - 777-11111111
     */
    @Test
    public void test2() throws SQLException {
        String query = "SELECT * FROM qa3.agents WHERE agents.agent_name = 'Lucida'";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/qa3", user, password);
        Statement stmt = con.createStatement();
        ResultSet resultSet = stmt.executeQuery(query);
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

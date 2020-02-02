package Steps;

import MYSQL.SQLHelper;
import MYSQL.SQLQueryCatalog;
import cucumber.api.java.en.And;
import io.cucumber.datatable.DataTable;
import lombok.extern.log4j.Log4j;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

@Log4j
public class DatabaseSteps {

    SQLHelper sqlHelper = new SQLHelper();
    SQLQueryCatalog sqlQueryCatalog = new SQLQueryCatalog();

    @And("I verify '(.*)' table entity with '(.*)' agent name contains values")
    public void iVerifyTableInDBContainsExpectedValues(String tableDB, String name, DataTable table) throws Exception {
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        String findQuery = sqlQueryCatalog.findAllByAgentName(tableDB, name);
        Statement statement = sqlHelper.createStatement();
        log.info(findQuery);
        ResultSet resultSet = statement.executeQuery(findQuery);
        resultSet.next();

        for (Map<String, String> row : data) {
            String key = row.get("TABLE_KEY");
            String newValue = row.get("NEW_VALUE");
            assertThat(resultSet.getString(key)).isEqualTo(newValue);

        }
    }

    @And("I update '(.*)' table entity with '(.*)' agent name with new values")
    public void iUpdateTableInDBWith(String tableDB, String name, DataTable table) throws Exception {
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        for (Map<String, String> row : data) {
            String key = row.get("TABLE_KEY");
            String newValue = row.get("NEW_VALUE");
            String updateQuery = sqlQueryCatalog.updateAgentsByAgentName(tableDB, key, newValue, name);
            log.info(updateQuery);
            Statement statement = sqlHelper.createStatement();
            statement.executeUpdate(updateQuery);
        }
    }


}

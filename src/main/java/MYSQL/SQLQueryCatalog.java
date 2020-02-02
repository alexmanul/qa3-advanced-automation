package MYSQL;

public class SQLQueryCatalog {

    public String updateAgentsByAgentName(String tableDB, String key, String newValue, String name) {
        return "UPDATE " + tableDB + " SET " + key + " = '" + newValue + "' WHERE AGENT_NAME = '" + name + "'";
    }

    public String findAllByAgentName(String tableDB, String name) {
        return "SELECT * FROM " + tableDB + " WHERE AGENT_NAME = '" + name + "'";
    }

}

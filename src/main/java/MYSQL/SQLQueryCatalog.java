package MYSQL;

public class SQLQueryCatalog {

    public String updateAgentsByAgentName(String tableDB, String key, String newValue, String name) {
        return "UPDATE " + tableDB + " SET " + key + " = '" + newValue + "' WHERE AGENT_NAME = '" + name + "'";
    }

    public String findAllByAgentName(String tableDB, String name) {
        return "SELECT * FROM " + tableDB + " WHERE AGENT_NAME = '" + name + "'";
    }

    public String insertNewAgent(String tableDB, String agentCode, String agentName, String workingArea,
                                 String commission, String phoneNo, String country) {
        return "INSERT INTO " + tableDB + " VALUES (" +
                "'" + agentCode + "', " +
                "'" + agentName + "', " +
                "'" + workingArea + "', " +
                "'" + commission + "', " +
                "'" + phoneNo + "', " +
                "'" + country + "')";
    }

    public String insertNewEntity(String tableDB, String values) {
        return "INSERT INTO " + tableDB + " VALUES (" + values + ")";
    }

    public String deleteNewEntityByAgentName(String tableDB, String name) {
        return "DELETE FROM " + tableDB + " WHERE AGENT_NAME = '" + name + "'";
    }

}

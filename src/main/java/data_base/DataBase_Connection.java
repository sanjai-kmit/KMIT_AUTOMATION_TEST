package data_base;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * @author Sanjai on 02/26/2019.
 * @project KMIT_AUTOMATION_TEST
 */
public class DataBase_Connection {

    public static ResultSet resultSet;
    public static Connection connection;
    public static Statement statement;

    public void eComm_DB_Connection(String server, String port, String db_name, String userName, String password){
        String db_url = "jdbc:sqlserver://"+ server + ":" + port + ";databaseName=" + db_name;
        String db_driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";

        try {
            Class.forName(db_driver);
            connection = DriverManager.getConnection(db_url, userName, password);
            statement = connection.createStatement();
        } catch (Exception e){
            System.out.println("Exception on Data Base Connection: " + e.getMessage());
        }
    }
}

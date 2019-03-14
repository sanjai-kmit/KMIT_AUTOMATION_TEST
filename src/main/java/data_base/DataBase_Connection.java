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

    public static ResultSet kmware_resultSet;
    public static Connection kmware_connection;
    public static Statement kmware_statement;

    String db_url;
    String db_driver;

    public void eComm_DB_Connection(String server, String port, String db_name, String userName, String password){
        db_url = "jdbc:sqlserver://"+ server + ":" + port + ";databaseName=" + db_name;
        db_driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";

        try {
            Class.forName(db_driver);
            connection = DriverManager.getConnection(db_url, userName, password);
            statement = connection.createStatement();
        } catch (Exception e){
            System.out.println("Exception on EComm Data Base Connection: " + e.getMessage());
        }
    }

    public void kmware_DB_Connection(String server, String port, String db_name, String userName, String password){
        db_url = "jdbc:sqlserver://"+ server + ":" + port + ";databaseName=" + db_name;
        db_driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";

        try {
            Class.forName(db_driver);
            kmware_connection = DriverManager.getConnection(db_url, userName, password);
            kmware_statement = kmware_connection.createStatement();
        } catch (Exception e){
            System.out.println("Exception on KMWARE Data Base Connection: " + e.getMessage());
        }
    }
}

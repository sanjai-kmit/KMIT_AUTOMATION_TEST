package data_base;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
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

    public static FileInputStream file;
    public static XSSFWorkbook workbook;
    public static XSSFSheet sheet;

    public void eComm_DB_Connection(){

        getSheet();
        sheet = workbook.getSheet("DATABASE_CONNECTION");

        db_url = "jdbc:sqlserver://"+ sheet.getRow(2).getCell(1) + ":" + sheet.getRow(3).getCell(1).toString().trim().replaceAll(".0", "") + ";databaseName=" + sheet.getRow(4).getCell(1).toString();
        db_driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";

        try {
            Class.forName(db_driver);
            connection = DriverManager.getConnection(db_url, sheet.getRow(5).getCell(1).toString(), sheet.getRow(6).getCell(1).toString());
            statement = connection.createStatement();
        } catch (Exception e){
            System.out.println("Exception on EComm Data Base Connection: " + e.getMessage());
        }
    }

    public void kmware_DB_Connection(){

        getSheet();
        sheet = workbook.getSheet("DATABASE_CONNECTION");

        db_url = "jdbc:sqlserver://"+ sheet.getRow(9).getCell(1) + ":" + sheet.getRow(10).getCell(1).toString().trim().replaceAll(".0", "") + ";databaseName=" + sheet.getRow(11).getCell(1).toString();
        db_driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";

        try {
            Class.forName(db_driver);
            kmware_connection = DriverManager.getConnection(db_url, sheet.getRow(12).getCell(1).toString(), sheet.getRow(13).getCell(1).toString());
            kmware_statement = kmware_connection.createStatement();
        } catch (Exception e){
            System.out.println("Exception on KMWARE Data Base Connection: " + e.getMessage());
        }
    }

    void getSheet(){
        try {
            file = new FileInputStream(new File("src\\test\\java\\Utils\\TestData.xlsx").getAbsolutePath());
        }catch (FileNotFoundException e){
            System.out.println("Exception on TestData File: " + e.getMessage());
        }

        try {
            workbook = new XSSFWorkbook(file);
        } catch (Exception e){
            System.out.println("Exception on WorkBook: " + e.getMessage());
        }

    }
}

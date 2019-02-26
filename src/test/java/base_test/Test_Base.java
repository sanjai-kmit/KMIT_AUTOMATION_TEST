package base_test;

import data_base.DataBase_Connection;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;

import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author Sanjai on 02/26/2019.
 * @project KMIT_AUTOMATION_TEST
 */

@Listeners(listener.Listener.class)

public class Test_Base extends DataBase_Connection{

    public static WebDriver driver;
    public static String base_url;
    public static String test_site;
    public static String emailId;

    public static Test_Base dataBase_connection=  new Test_Base();

    public static Logger Log = Logger.getLogger(Test_Base.class.getName());



    @Parameters({"browser_name", "test_site", "base_url", "E_comm_server", "E_comm_port", "E_comm_data_base_name", "E_comm_userName", "E_comm_password"})
    @BeforeSuite
    public void open_driver(String browser_name, String test_site, String base_url, String E_comm_server, String E_comm_port, String E_comm_data_base_name, String E_comm_userName, String E_comm_password){

        DOMConfigurator.configure("src\\log4j.xml");

        try {
            dataBase_connection.eComm_DB_Connection(E_comm_server, E_comm_port, E_comm_data_base_name, E_comm_userName, E_comm_password);
            Log.info("Data Base Connection of EComm: Connected");
        } catch (Exception e){
            Log.error("Exception on data base connection on open: " + e.getMessage());
        }


        this.base_url = base_url;
        this.test_site = test_site;
        emailId = email_id() + "automatedemail@kmitsolutions.com";

        select_browser(browser_name);
        Log.info("Driver successfully got open");

        driver.get(base_url);
        Log.info("Testing URL: " + base_url);
    }

    @AfterSuite
    public void close_driver(){
        try {
            connection.close();
            Log.info("Data Base Connection of EComm: Disconnected");
        } catch (Exception e){
            Log.error("Exception on data base connection on close: " + e.getMessage());
        }
        driver.quit();
        Log.info("Driver closed successfully and completed the Test.");
    }


    /*select browser functionality*/
    void select_browser(String browser_name){
        if (browser_name.toLowerCase().equals("chrome")){
            System.setProperty("webdriver.chrome.driver", new File("src\\main\\java\\drivers\\chromedriver.exe").getAbsolutePath());
            driver = new ChromeDriver();
            Log.info("Driver: ChromeDriver");
        } else if (browser_name.toLowerCase().equals("firefox")){
            System.setProperty("webdriver.gecko.driver", new File("src\\main\\java\\drivers\\geckodriver.exe").getAbsolutePath());
            driver = new FirefoxDriver();
            Log.info("Driver: FireFoxDriver");
        }

        driver.manage().window().maximize();
    }

    /*create an email id functionality*/
    public String email_id(){

        DateTimeFormatter date_time = DateTimeFormatter.ofPattern("yyyyMMMdd_HH_mm_ss");
        LocalDateTime localDateTime = LocalDateTime.now();
        return date_time.format(localDateTime);
    }


}

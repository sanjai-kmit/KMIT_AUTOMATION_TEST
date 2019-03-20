package base_test;

import data_base.DataBase_Connection;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.*;
import util.Email_Config;
import util.Screen_Shot;
import java.io.File;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;

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
    public static String joinDate;
    public static String user;
    public static String exist_user;
    public static String passTypeCode;
    public static String order_number;
    public static String itemTitle;
    public static int childCount;
    public static int noOf_CareGivers;

    public static Test_Base dataBase_connection=  new Test_Base();
    public static Screen_Shot screen_shot = new Screen_Shot();

    public static ResourceBundle element;
    public static ResourceBundle property;

    public static Logger Log = Logger.getLogger(Test_Base.class.getName());

    public static Email_Config email_config = new Email_Config();

    public static WebDriverWait wait;
    public static List<String> site_with_timeStamp = new ArrayList<>();

    @Parameters({"browser_name", "test_site", "base_url",
            "E_comm_server", "E_comm_port", "E_comm_data_base_name", "E_comm_userName", "E_comm_password",
            "KMWARE_server", "KMWARE_port", "KMWARE_data_base_name", "KMWARE_userName", "KMWARE_password",
            "user", "userName"})
    @BeforeSuite(alwaysRun = true)
    public void open_driver(String browser_name, String test_site, String base_url,
                            String E_comm_server, String E_comm_port, String E_comm_data_base_name, String E_comm_userName, String E_comm_password,
                            String KMWARE_server, String KMWARE_port, String KMWARE_data_base_name, String KMWARE_userName, String KMWARE_password,
                            String user, String userName){

        DOMConfigurator.configure("src\\log4j.xml");

        dataBase_connection.eComm_DB_Connection(E_comm_server, E_comm_port, E_comm_data_base_name, E_comm_userName, E_comm_password);
        dataBase_connection.kmware_DB_Connection(KMWARE_server, KMWARE_port, KMWARE_data_base_name, KMWARE_userName, KMWARE_password);

        element = ResourceBundle.getBundle(test_site.toUpperCase() + "\\" + test_site.toLowerCase() + "_elements");
        property = ResourceBundle.getBundle(test_site.toUpperCase() + "\\" + test_site.toLowerCase() + "_property");

        this.base_url = base_url;
        this.test_site = test_site.toLowerCase();
        emailId = email_id() + "automatedemail@kmitsolutions.com";
        exist_user = userName;
        this.user = user;
        joinDate = getJoinDate();

        select_browser(browser_name);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        Log.info("Driver successfully got open");

        driver.get(base_url);
        Log.info("Testing URL: " + base_url);
    }

    @AfterSuite(alwaysRun = true, enabled = true)
    public void close_driver(){
        try {
            connection.close();
            Log.info("Data Base Connection of EComm: Disconnected");
        } catch (Throwable t){
            Log.error("Exception on data base connection on close: " + t.getMessage());
        }

        driver.quit();
        Log.info("Driver closed successfully and completed the Test.");

        email_config.send_email(test_site, base_url);
        Log.info("Email message sent with attached log file: Successfully");
    }


    @AfterMethod
    public void fail_screenshot(ITestResult result){
        if (ITestResult.FAILURE == result.getStatus()){
            String methodName = result.getName();
            screen_shot.takeScreenShot(driver, methodName + "-" + email_id());
        }
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
        wait = new WebDriverWait(driver, 20);
        driver.manage().window().maximize();
    }

    /*create an email id functionality*/
    public String email_id(){

        DateTimeFormatter date_time = DateTimeFormatter.ofPattern("yyyyMMMdd_HH_mm_ss");
        LocalDateTime localDateTime = LocalDateTime.now();
        return date_time.format(localDateTime);
    }

    public String getJoinDate(){

        SimpleDateFormat format;

        site_with_timeStamp.add("oreo");

        if (site_with_timeStamp.contains(test_site)){
            format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        } else {
            format = new SimpleDateFormat("yyyy-MM-dd 00:00:00.0");
        }
        Date date = new Date();
        return format.format(date);
    }


}

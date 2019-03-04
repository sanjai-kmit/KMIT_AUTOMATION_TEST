package util;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;

/**
 * @author Sanjai on 02/26/2019.
 * @project KMIT_AUTOMATION_TEST
 */
public class Screen_Shot {

    public void takeScreenShot(WebDriver driver, String name){
        TakesScreenshot screenshot = (TakesScreenshot)driver;
        File file = screenshot.getScreenshotAs(OutputType.FILE);

        String directory = new File("src\\failure_ScreenShots").getAbsolutePath();
        File path = new File(directory);

        if (!path.exists()){
            new File(directory).mkdirs();
        }

        try {
            FileUtils.copyFile(file, new File("src\\failure_ScreenShots" + "\\" + name + ".png"));
        } catch (Exception e){
            System.out.println("Exception on Screenshot Method: " + e.getMessage());
        }
    }

}


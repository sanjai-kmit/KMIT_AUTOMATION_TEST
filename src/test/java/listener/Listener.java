package listener;

import org.testng.*;
import util.Screen_Shot;

/**
 * @author Sanjai on 02/26/2019.
 * @project KMIT_AUTOMATION_TEST
 */
public class Listener implements ITestListener, ISuiteListener{

    /*ITestListener*/
    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("\nName of the testcase started: " + result.getName() + "\n");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("\nName of the testcase got success: " + result.getName() + "\n");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("\nThe name of the testcase failed is: " + result.getName());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("\nThe name of the testcase skipped is: " + result.getName());
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    @Override
    public void onStart(ITestContext context) {
        System.out.println("\nTest Suite been started: " + context.getName());
    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println("\nTest Suite been Finished: " + context.getName());
    }

    /*ISuiteListener*/
    @Override
    public void onStart(ISuite suite) {
        System.out.println("\nAbout to begin executing Suite: " + suite.getName() + "\n");
    }

    @Override
    public void onFinish(ISuite suite) {
        System.out.println("\nAbout to end executing Suite: " + suite.getName() + "\n");
    }
}

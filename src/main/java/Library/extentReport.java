package Library;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class extentReport {

    public static ExtentReports extentReports = null;
    public static ExtentTest extentTest = null;

    public void initializeReport() {
        try {
            if (extentReports == null)
                extentReports = new ExtentReports("src/test/resources/reports/Automation-Report.html");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void startTest(final String testName) {
        try {
            extentTest = extentReports.startTest(testName);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void passTest(String stepDescription) {
        try {
            extentTest.log(LogStatus.PASS, stepDescription);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void failTest(String stepDescription) {
        try {
            extentTest.log(LogStatus.FAIL, stepDescription);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void endReport() {
        try {
            extentReports.endTest(extentTest);
            extentReports.flush();
        } catch (Exception e) {
            failTest(e.getMessage());
            e.printStackTrace();
        }

    }

}

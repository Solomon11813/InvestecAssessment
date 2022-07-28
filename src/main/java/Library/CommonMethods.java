package Library;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class CommonMethods extends extentReport {

    public static WebDriver driver = null;
    public static Wait<WebDriver> verificationWait = null;


    @BeforeTest
    public void initializeTest() {
        try {
            initializeReport();
            System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\Drivers\\chromedriver.exe");
            ChromeOptions options = new ChromeOptions();
            options.setCapability(CapabilityType.PAGE_LOAD_STRATEGY, PageLoadStrategy.NORMAL);
            options.setCapability(CapabilityType.SUPPORTS_JAVASCRIPT, true);
            options.setCapability(CapabilityType.SUPPORTS_ALERTS, true);
            options.addArguments("test-type");
            driver = new ChromeDriver(options);
            driver.navigate().to("https://www.investec.com/");
            driver.manage().window().maximize();
            verificationWait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(10))
                    .ignoring(NoSuchElementException.class).pollingEvery(Duration.ofMillis(250));
        } catch (Exception e) {
            failTest(e.getMessage());
            e.printStackTrace();
        }
    }


    public synchronized void pause(long seconds) {
        try {
            driver.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
        } catch (Exception e) {
            failTest(e.getMessage());
            e.printStackTrace();
        }
    }


    public void clickElement(final By webElement) {
        try {
            verificationWait.until(ExpectedConditions.elementToBeClickable(webElement)).click();
        } catch (Exception e) {
            failTest(e.getMessage());
            e.printStackTrace();
        }
    }

    public void inputData(final By webElement, final String data) {
        try {
            verificationWait.until(ExpectedConditions.elementToBeClickable(webElement)).sendKeys(data);
        } catch (Exception e) {
            failTest(e.getMessage());
            e.printStackTrace();
        }
    }

    public boolean verifyElementIsPresent(final By webElement) {
        boolean condition = false;
        try {
            condition = verificationWait.until(ExpectedConditions.elementToBeClickable(webElement)).isDisplayed();
        } catch (Exception e) {
            failTest(e.getMessage());
            e.printStackTrace();
        }
        return condition;
    }


    public void scrollToElement(final By webElement) {
        try {
            WebElement element = driver.findElement(webElement);
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        } catch (Exception e) {
            failTest(e.getMessage());
            e.printStackTrace();
        }
    }

    public void clickElementUsingJScript(final By webElement) {
        try {
            WebElement element = driver.findElement(webElement);
            JavascriptExecutor executor = (JavascriptExecutor) driver;
            executor.executeScript("arguments[0].click();", element);
        } catch (Exception e) {
            failTest(e.getMessage());
            e.printStackTrace();
        }
    }


    @AfterTest
    public void endTest() {
        try {
            endReport();
            if (driver != null)
                driver.close();
        } catch (Exception e) {
            failTest(e.getMessage());
            e.printStackTrace();
        }

    }
}

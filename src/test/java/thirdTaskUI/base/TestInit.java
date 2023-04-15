package thirdTaskUI.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import thirdTaskUI.listener.TestListener;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Properties;

import static thirdTaskUI.listener.TestListener.saveScreenshot;

@Listeners(TestListener.class)
public class TestInit {
    public WebDriver driver;
    public static final String BASE_URL = "https://useinsider.com/";
    private static final String BROWSER_NAME = "chrome";
    protected static String env;

    @BeforeMethod
    public void setUp() throws Exception {
        switch (BROWSER_NAME) {
            case ("chrome") -> {
                driver = new ChromeDriver();
                driver.manage().deleteAllCookies();
                driver.manage().window().maximize();
            }
            case ("firefox") -> {
                driver = new FirefoxDriver();
                driver.manage().deleteAllCookies();
                driver.manage().window().maximize();
            }
            default -> throw new Exception("You chose not valid browser!");
        }
    }

    @AfterMethod
    public void afterMethod(ITestResult result) {
        Object currentClass = result.getInstance();
        WebDriver driver = ((TestInit) currentClass).getDriver();
        if (driver != null && result.getThrowable() != null) {
            result.getName();
            if (result.getStatus() == ITestResult.FAILURE) {
                saveScreenshot(driver);
            } else if (result.getStatus() == ITestResult.SKIP) {
                saveScreenshot(driver);
            }
        }
        driver.quit();
    }

    private void addAllureEnvProperties() {
        File f = new File("target/allure-results/environment.properties");

        Properties props = new Properties();
        props.setProperty("URL", env);

        try {
            if (f.createNewFile()) {
                OutputStream out = new FileOutputStream(f);
                props.store(out, "Allure report Environment variables");
            } else {
                System.out.println("Allure environment.properties file exists");
            }
        } catch (Exception e) {
            System.out.println("Allure environment.properties file was not created");
        }
    }

    public void openUrl(String url) {
        driver.get(url);
    }

    public WebDriver getDriver() {
        return driver;
    }
}

package thirdTaskUI.listener;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import thirdTaskUI.base.TestInit;

public class TestListener extends TestInit implements ITestListener {

    @Attachment(value = "Page screenshot", type = "image/png")
    public static byte[] saveScreenshot(WebDriver driver) {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }


//    @SneakyThrows
//    @Override
//    public void onTestFailure(ITestResult result) {
//        WebDriver driver = ((TestInit) result.getInstance()).getDriver();
//        //тут как-то передали драйвер, непонятный код.
//        screen(driver);
//    }
//
//    private void screen(WebDriver driver) throws IOException {
//        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//        FileUtils.copyFile(scrFile, new File("target/screen//" + scrFile.getName()));
//    }
}

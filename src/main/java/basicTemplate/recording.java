package basicTemplate;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;

import java.awt.*;
import java.io.File;
import java.util.Date;

public class recording {
    public static void ScreenCapturing() throws Exception {
        GraphicsConfiguration gc = GraphicsEnvironment
                .getLocalGraphicsEnvironment()
                .getDefaultScreenDevice()
                .getDefaultConfiguration();


        Date Currentdate = new Date();
        Currentdate.getTime();
        String timestamp = Currentdate.toString().replace(" ", "-").replace(":", "-");
        WebDriver driver = browserSelector.driver;

        myRecording.startRecording();


//        WebDriverWait wait = new WebDriverWait(driver,30);
//
//        // Wait for the page to be fully loaded
//        wait.until((ExpectedCondition<Boolean>) webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
////
//        JavascriptExecutor jsExecutor1 = (JavascriptExecutor)driver;
//        String currentFrame = (String) jsExecutor1.executeScript("return self.name");
//        WebElement frame = driver.findElement(By.xpath(currentFrame));
        WebElement focusedElement = (WebElement) ((JavascriptExecutor) driver).executeScript("return document.activeElement;");
        String name = focusedElement.getAttribute("name");
        WebElement ele = driver.findElement(By.name(name));

        //Page Scroll
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        // Scroll to the element


        //Full Screen
        TakesScreenshot ts = (TakesScreenshot) driver;
        File src = ts.getScreenshotAs(OutputType.FILE);
        File Trg = new File(".//Screensorts/FullScreen/" + timestamp + ".jpeg");
        FileUtils.copyFile(src, Trg);

        //Specific Frame
//        jsExecutor.executeScript("arguments[0].scrollIntoView(true);", frame);
//        File srcS = frame.getScreenshotAs(OutputType.FILE);
//        File TrgS = new File(".//Screensorts/SpecificFrame/" + timestamp + ".jpeg");
//        FileUtils.copyFile(srcS, TrgS);

        //Specific Element
        File srcFile = ele.getScreenshotAs(OutputType.FILE);
        File TrgFile = new File(".//Screensorts/SpecificElement/" + timestamp + ".jpeg");
        FileUtils.copyFile(srcFile, TrgFile);


    }

    public static void StopCapturing() throws Exception {
        myRecording.stopRecording();
    }
}

package basicTemplate;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.sql.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;


public class utils extends baseClass {

    public static void clickOnElement(By element) {
        driver.findElement(element).click();
    }

    public static void selectDropDownValueByText(By element, String Text) {
        driver.findElement(element).click();
    }

    public static void clearText(By by) {
        driver.findElement(by).clear();
    }

    public static void enterText(By by, String text) {
        driver.findElement(by).clear();
        driver.findElement(by).sendKeys(text);
    }

    public static String get_Text(By by) {
        return driver.findElement(by).getText();
    }

    public static String get_Attribute(By by, String attr) {
        return driver.findElement(by).getAttribute(attr);
    }

    public static String randomDate() {
        DateFormat format = new SimpleDateFormat("MMDDYYYYHHmmss");
        return format.format(new Date());
    }



    public static String timeStamp() {
        DateFormat dateFormat = new SimpleDateFormat("MMDDYYYY-HHmmss");
        Date date = new Date();
        return dateFormat.format(date);
    }

    public static void selectElementByValue(By by, String text) {
        Select select = new Select(driver.findElement(by));
        select.selectByValue(text);
    }

    public static void selectElementByVisibleText(By by, String text) {
        Select select = new Select(driver.findElement(by));
        select.selectByVisibleText(text);
    }

    public static void selectElementByIndex(By by, int integer) {
        Select select = new Select(driver.findElement(by));
        select.selectByIndex(integer);
    }

    public static void webDriverWaitImplicitly(int time) {
        driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
    }

    public static void webDriverWaitExplicitly(By by, Duration time) {
        WebDriverWait explicitlyWait = new WebDriverWait(driver, time);
        explicitlyWait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public static void waitUntil_ElementClickable(By by, Duration time) {
        WebDriverWait explicitlyWait = new WebDriverWait(driver, time);
        explicitlyWait.until(ExpectedConditions.elementToBeClickable(by));
    }

    public static boolean isTextPresent(String text) {
        return driver.findElement(By.tagName("body")).getText().contains(text);
    }

    public static boolean isElementPresent(By by) {
        return driver.findElement(by).isDisplayed();
    }

    public static void captureScreenShot() {

        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {

            FileUtils.copyFile(src, new File("src/test/Screenshot" + System.currentTimeMillis() + ".png"));
        } catch (IOException e) {
            e.getMessage();
        }
    }

    public static String getCurrentPageUrl() {
        String url = driver.getCurrentUrl();
        return url;
    }

    public static void UploadFile(By by, By args) {
        WebElement addFile = driver.findElement(by);
        File file = new File("C://Users//Nishit.Sheth//IdeaProjects//MRIEnergy_AutomationSuite//Extent-Report//PdfReport//extentPdf.pdf");
        addFile.sendKeys(file.getAbsolutePath());
        if (driver.findElement(args).isDisplayed()) {
            Assert.assertTrue(true, "Image Uploaded");
        } else {
            Assert.fail("Image not Uploaded");
        }

    }


    public static void createNewTab() {
        //Open a new tab using Ctrl + t
        driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL + "t");
    }

    public static void switchToNewTab() {
        //Switch between tabs using Ctrl + \t
        driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL + "\t");
    }

    public static void sleep(int time) {
        try {
            Thread.sleep(time * 1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static String getSaltString(int number) {
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < number) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr;

    }

    public static String getSaltStringNumeric(int number) {
        String SALTCHARS = "1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < number) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr;

    }

    public static String getSqlTableDataString(String table, int colum) throws ClassNotFoundException, SQLException {
        //Connection URL Syntax: "jdbc:mysql://ipaddress:portnumber/db_name"
        String dbUrl = "jdbc:mysql://localhost:3306/rajerp";
        //Database Username
        String username = "nishit";
        //Database Password
        String password = "12345678";
        //Query to Execute
        String query = "select *  from " + table + ";";
        //Load mysql jdbc driver
        Class.forName("com.mysql.cj.jdbc.Driver");
        //Create Connection to DB
        Connection con = DriverManager.getConnection(dbUrl, username, password);
        //Create Statement Object
        Statement stmt = con.createStatement();
        // Execute the SQL Query. Store results in ResultSet
        ResultSet rs = stmt.executeQuery(query);
        String data = null;
        while (rs.next()) {
            data = rs.getString(colum);
        }
        // closing DB Connection
        con.close();
        return data;
    }

    public static String todayDateString(String dateFormat) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern(dateFormat);
        LocalDateTime now = LocalDateTime.now();
        return (dtf.format(now));
    }

    public static String nextDateString() {
        String curDate = todayDateString("MMDDYYYY");
        final SimpleDateFormat format = new SimpleDateFormat("MMDDYYYY");
        Date date = null;
        try {
            date = format.parse(curDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        final Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_YEAR, 1);
        return format.format(calendar.getTime());

    }

    public static String addYearTodayDateString(String change, int year) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MMDDYYYY");
        LocalDate date = LocalDate.now();
        LocalDate returnvalue = null;
        switch (change) {
            case "m":
                returnvalue = date.plusMonths(year);
                break;
            case "y":
                returnvalue = date.plusYears(year);
                break;
            case "d":
                returnvalue = date.plusDays(year);
                break;
        }
        String newYear = (dtf.format(returnvalue));
        return newYear;
    }

    public static void selectRandomDropdownOption(By by) {
        Select dropdown = new Select(driver.findElement(by));
        //Get all options
        List<WebElement> dd = dropdown.getOptions();
        System.out.println("number of course: " + dd.size());
        int index = 0;//if list contains only one element it will take that element
        if (dd.size() > 1) {
            //Get a random number between 1, size of dd
            Random rand = new Random();
            index = rand.nextInt(dd.size() - 1);
            System.out.println("selected number of option: " + index);
        } else if (dd.isEmpty()) {
            System.out.println("Index out of bound");
            index = -1;
        }
        if (index >= 0) {
            try {
                dropdown.selectByIndex(index);
            } catch (Exception e) {

            }

        }
    }

    public static void zipFolder(Path source) throws IOException {

        // get folder name as zip file name
        String zipFileName = source.getFileName().toString() + timeStamp() + ".zip";

        try (
                ZipOutputStream zos = new ZipOutputStream(
                        Files.newOutputStream(Paths.get(System.getProperty("user.dir") + "/Reports/" + zipFileName)))
        ) {

            Files.walkFileTree(source, new SimpleFileVisitor<>() {

                public FileVisitResult visitFile(Path file,
                                                 BasicFileAttributes attributes) {

                    // only copy files, no symbolic links
                    if (attributes.isSymbolicLink()) {
                        return FileVisitResult.CONTINUE;
                    }

                    try (FileInputStream fis = new FileInputStream(file.toFile())) {

                        Path targetFile = source.relativize(file);
                        zos.putNextEntry(new ZipEntry(targetFile.toString()));

                        byte[] buffer = new byte[1024];
                        int len;
                        while ((len = fis.read(buffer)) > 0) {
                            zos.write(buffer, 0, len);
                        }

                        // if large file, throws out of memory
                        //byte[] bytes = Files.readAllBytes(file);
                        //zos.write(bytes, 0, bytes.length);

                        zos.closeEntry();

                        System.out.printf("Zip file : %s%n", file);

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    return FileVisitResult.CONTINUE;
                }


                public FileVisitResult visitFileFailed(Path file, IOException exc) {
                    System.err.printf("Unable to zip : %s%n%s%n", file, exc);
                    return FileVisitResult.CONTINUE;
                }
            });

        }

    }


    public static String removeLastCharacterOfString(String str) {
        if (str != null && str.length() > 0) {
            str = str.substring(0, str.length() - 1);
        }
        return str;
    }

    public static void reloadPage() {
        driver.navigate().refresh();
        sleep(5);
    }

    public static String configReader(String key) throws IOException {
        Properties prop = new Properties();
        FileInputStream myFile;
        myFile = new FileInputStream(System.getProperty("user.dir") + "/Files/config.properties");
        prop.load(myFile);
        String value = prop.getProperty(key);
        return value;
    }

    public boolean isFileDownloaded(String fileName) {
        String downloadPath = System.getProperty("user.dir") + "/Download";
        File dir = new File(downloadPath);
        File[] dirContents = dir.listFiles();

        for (int i = 0; i < dirContents.length; i++) {
            if (dirContents[i].getName().equals(fileName)) {
                // File has been found, it can now be deleted:
                dirContents[i].delete();
                return true;
            }
        }
        return false;
    }

    public String getScreenShotPath(String TestName) throws IOException, AWTException {

        TakesScreenshot ts = ((TakesScreenshot) driver);
        File source = ts.getScreenshotAs(OutputType.FILE);
        String destPath = System.getProperty("user.dir") + "//Reports//" + TestName + utils.timeStamp() + ".png";
        File file = new File(destPath);
        FileUtils.copyFile(source, file);
        return destPath;
    }

    public String getScreenBase64(String TestName) throws IOException {

        String ts = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
        File source = OutputType.FILE.convertFromBase64Png(ts);
        String destPath = System.getProperty("user.dir") + "//Reports//" + TestName + utils.timeStamp() + ".png";
        File file = new File(destPath);
        FileUtils.copyFile(source, file);
        return ts;
    }

}

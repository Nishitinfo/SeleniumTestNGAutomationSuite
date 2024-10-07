package basicTemplate.pages;


import basicTemplate.configs.browserSelector;
import basicTemplate.configs.loadProps;
import basicTemplate.configs.utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.List;


public class login extends utils {

    public static String U_name = loadProps.getProperty("Username");
    public static String URL = loadProps.getProperty("URL");
    public static String P_word = loadProps.getProperty("Password");
    public static By username = new By.ByXPath("//input[@id='Username']");

    public static By password = new By.ByXPath("//input[@id='Password']");

    public static By SignInButton = new By.ByXPath("//button[@name='button']");
    public static By SignInButtosn = new By.ByXPath("//button[@name='buttons']");//failed login
    public static By UserIcon = new By.ByXPath("//span[@class='menu_user_title']");
    public static By logoutButton = new By.ByXPath("//*[@id=\"Logout\"]/li[1]/a/div/span");

    @Test
    public static void login() {
        List<WebElement> elements = driver.findElements(username);
        int usernamecount = elements.size();
        if (usernamecount > 0) {
            clickOnElement(username);
            enterText(username, U_name);
            clickOnElement(password);
            enterText(password, P_word);
            clickOnElement(SignInButton);
        } else {
            System.out.println("User Already logged in");
        }
    }

    @Test
    public static void Failed_login() {
        clickOnElement(username);
        enterText(username, U_name);
        clickOnElement(password);
        enterText(password, P_word);
        clickOnElement(SignInButtosn);

    }

    public static void logout() {
        if (isElementPresent(logoutButton)) {
            clickOnElement(logoutButton);
        } else {
            driver.get(URL);
        }
    }

    @AfterTest
    public void closeBrowser() throws Exception {
        browserSelector.closeBrowser();
    }


    @BeforeTest
    @Parameters("Browser")
    public void launchBrowser(String Browser) throws Exception {
        browserSelector.LaunchBrowser(Browser);
    }

//    @Test
//    public void verifyDropdown(){
//        driver.get("url");
//        clickOnElement(dropdown);
//        WebElement divElement = driver.findElement(DropdownOptions); // Replace "your-div-class-name" with the actual class name
//        String script = "arguments[0].style.display='block';";
//        ((JavascriptExecutor) driver).executeScript(script, divElement);
//        List<WebElement> hiddenElements = divElement.findElements(By.tagName("div"));
//      // Assuming the hidden elements are also divs
//        for (WebElement element : hiddenElements) {
//            if(element.getText().equals("ESS")) {
//                element.click();
//                break;
//            }
//        }
//
//    }
}

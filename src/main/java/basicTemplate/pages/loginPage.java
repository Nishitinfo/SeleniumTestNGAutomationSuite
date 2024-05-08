package basicTemplate.pages;


import basicTemplate.browserSelector;
import basicTemplate.loadProps;
import basicTemplate.utils;
import org.openqa.selenium.By;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class loginPage extends utils {

    public static String U_name = loadProps.getProperty("Username");

    public static String P_word = loadProps.getProperty("Password");
    public static By username = new By.ByXPath("//input[@id='Username']");

    public static By password = new By.ByXPath("//input[@id='Password']");

    public static By SignInButton = new By.ByXPath("//button[@name='button']");

    public static By UserIcon = new By.ByXPath("//span[@class='menu_user_title']");

    @Test
    public static void login() {
        clickOnElement(username);
        enterText(username, U_name);
        clickOnElement(password);
        enterText(password, P_word);
        clickOnElement(SignInButton);

    }

    @AfterTest
    public void closeBrowser() {
        browserSelector.closeBrowser();
    }

    @Parameters("Browser")
    @BeforeTest
    public void launchBrowser(String Browser) {
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

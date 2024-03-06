package basicTemplate.pages;


import basicTemplate.browserSelector;
import basicTemplate.utils;
import org.openqa.selenium.By;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class loginPage extends utils {


    public By username = new By.ByXPath("//input[@id='Username']");

    public By password = new By.ByXPath("//input[@id='Password']");

    public By SignInButton = new By.ByXPath("//button[@name='button']");

    public By UserIcon = new By.ByXPath("//span[@class='menu_user_title']");


    @Parameters("browser")
    @BeforeTest
    public void launchBrowser(String Browser) {
        browserSelector.LaunchBrowser(Browser);
    }

    @AfterTest
    public void closeBrowser() {
        browserSelector.closeBrowser();
    }

    @Test
    public void enterDetailsInLoginPage() {
        clickOnElement(username);
        enterText(username, "admin");
        clickOnElement(password);
        enterText(password, "admin");
        clickOnElement(SignInButton);

    }

//    @Test
//    public void verifyDropdown(){
//        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/admin/viewSystemUsers");
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

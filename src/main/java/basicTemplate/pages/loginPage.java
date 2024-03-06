package basicTemplate.pages;


import basicTemplate.browserSelector;
import basicTemplate.utils;
import org.openqa.selenium.By;
import org.testng.annotations.*;


public class homePage extends utils {


    public By searchbar = new By.ByXPath("//textarea[@id='APjFqb' and @class='gLFyf']");

    public By searchBox = new By.ByXPath("//textarea[@id='APjFqb' and @class='gLFyf']");

    public By dropdown = new By.ByXPath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[2]/div/div[2]/div/div[1]");

    public By DropdownOptions = new By.ByXPath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[2]/div/div[2]/div");


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
    public void verifyHomePage() {
        clickOnElement(searchbar);
        clickOnElement(searchBox);

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

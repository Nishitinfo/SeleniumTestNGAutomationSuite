package basicTemplate.pages;

import basicTemplate.browserSelector;
import basicTemplate.loadProps;
import basicTemplate.utils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class manageInvoicePage extends utils {

    public static String AccountNumber = loadProps.getProperty("AccountNumber");
    public static String InvoiceType = loadProps.getProperty("InvoiceType");
    public static String InvoiceNumber = loadProps.getProperty("InvoiceNumber");
    public static String InvoiceCurrency = loadProps.getProperty("InvoiceCurrency");
    public static String InvoiceForwardBalance = loadProps.getProperty("InvoiceForwardBalance");
    public static String InvoiceNetTotal = loadProps.getProperty("InvoiceNetTotal");
    public static String InvoiceTaxTotal = loadProps.getProperty("InvoiceTaxTotal");
    public static String InvoiceTotal = loadProps.getProperty("InvoiceTotal");
    public static String InvoiceInternalNotes = loadProps.getProperty("InvoiceInternalNotes");
    public static String InvoiceExternalNotes = loadProps.getProperty("InvoiceExternalNotes");
    public static String InvoiceSearchTaxCharge = loadProps.getProperty("InvoiceSearchTaxCharge");
    public static String SearchMeterText = loadProps.getProperty("SearchMeterText");
    public static String InvoiceTax = loadProps.getProperty("InvoiceTax");
    public static String SearchRateDescription = loadProps.getProperty("RateDescription");
    public static String InvoiceStartDay = loadProps.getProperty("InvoiceStartDay");
    public static String InvoiceStartDate = loadProps.getProperty("InvoiceStartDate");
    public static String DueDate = loadProps.getProperty("DueDate");
    public static String EndMonth = loadProps.getProperty("EndMonth");
    public static String EndDate = loadProps.getProperty("EndDate");
    public static String InvoiceDate = loadProps.getProperty("InvoiceDate");
    public static String ReceivedDate = loadProps.getProperty("ReceivedDate");
    public static By invoiceValidationMenu = By.xpath("/html/body/form/div[5]/div[1]/div[3]/div[1]/ul/li[6]/a/div/span");
    public static By manageInvoiceLink = By.linkText("Manage Invoices");
    public static By portfolio = By.xpath("/html/body/div[1]/div[2]/div/div/div/div/div[1]/div/form/div/div[1]/div[1]/div[1]/span/button");
    public static By selectPortfolio = By.xpath("/html[1]/body[1]/div[8]/div[1]/div[1]/div[1]/div[1]/ul[1]/li[3]");
    public static By addButton = By.xpath("/html/body/div[1]/div[2]/div/div/div[2]/div/div[1]/button[1]");
    public static By searchAccount = By.xpath("/html/body/div[1]/div[2]/div/div/div/div/div[1]/div/form/div/div[1]/div[1]/div[2]/span/input");
    public static By selectAccount = By.xpath("/html[1]/body[1]/div[9]/div[1]/div[1]/div[1]/div[2]/ul[1]/li[1]");
    public static By searchInvoiceType = By.xpath("/html/body/div[1]/div[2]/div/div/div/div/div[1]/div/form/div/div[1]/div[3]/div[1]/span/input");
    public static By selectInvoiceType = By.xpath("/html[1]/body[1]/div[12]/div[1]/div[1]/div[1]/div[1]/ul[1]/li[1]/span[1]");
    public static By enterInvoiceNumber = By.xpath("//input[@id='invoiceNumber']");
    public static By clickOnStartDateCalender = By.xpath("/html/body/div[1]/div[2]/div/div/div/div/div[1]/div/form/div/div[1]/div[5]/div[1]/div[1]/div[1]/span/button");
    public static By selectStartMonthList = By.xpath("/html[1]/body[1]/div[3]/div[1]/div[1]/div[1]/div[1]/button[1]/span[1]");
    public static By selectStartMonth = By.xpath("/html/body/div[3]/div/div/div/div[2]/table/tbody/tr[3]/td[3]/span");
    public static By selectStartDate = By.xpath("//td[@title='" + InvoiceStartDay + " " + InvoiceStartDate + "']//span[@class='k-link'][normalize-space()='1']");
    public static By clickOnEndDateCalender = By.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[1]/div[1]/div[5]/div[1]/div[1]/div[2]/span[1]/button[1]");
    public static By selectEndMonthList = By.xpath("/html/body/div[4]/div/div/div/div[1]/button/span");
    public static By selectEndMonth = By.xpath("//td[@title='" + EndMonth + "']");
    public static By selectEndDate = By.xpath("//span[normalize-space()='" + EndDate + "']");
    public static By clickOnInvoiceDateCalender = By.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[1]/div[1]/div[5]/div[1]/div[2]/div[1]/span[1]/button[1]");
    public static By selectInvoiceDate = By.xpath("//span[normalize-space()='" + InvoiceDate + "']");
    public static By clickOnReceivedDateCalender = By.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[1]/div[1]/div[5]/div[1]/div[2]/div[2]/span[1]/button[1]");
    public static By selectReceivedDate = By.xpath("//span[normalize-space()='" + ReceivedDate + "']");
    public static By clickOnDueDateCalender = By.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[1]/div[1]/div[5]/div[1]/div[3]/div[1]/span[1]/button[1]");
    public static By selectDueDate = By.xpath("//span[normalize-space()='" + DueDate + "']");
    public static By clickOnCurrencyDropdown = By.xpath("/html/body/div[1]/div[2]/div/div/div/div/div[1]/div/form/div/div[1]/div[6]/div[1]/span/input");
    public static By selectCurrency = By.xpath("//span[@class='k-list-item-text']");
    public static By netTotal = By.xpath("/html/body/div[1]/div[2]/div/div/div/div/div[1]/div/form/div/div[1]/div[7]/div[1]/span/input");
    public static By invoiceTotal = By.xpath("/html/body/div[1]/div[2]/div/div/div/div/div[1]/div/form/div/div[1]/div[7]/div[3]/span/input");
    public static By taxTotal = By.xpath("/html/body/div[1]/div[2]/div/div/div/div/div[1]/div/form/div/div[1]/div[7]/div[2]/span/input");
    public static By forwardBalance = By.xpath("/html/body/div[1]/div[2]/div/div/div/div/div[1]/div/form/div/div[1]/div[6]/div[2]/span/input");
    public static By internalReference = By.xpath("/html/body/div[1]/div[2]/div/div/div/div/div[1]/div/form/div/div[1]/div[8]/div[1]/span/input");
    public static By externalReference = By.xpath("/html/body/div[1]/div[2]/div/div/div/div/div[1]/div/form/div/div[1]/div[8]/div[2]/span/input");
    public static By finalInvoice = By.xpath("/html/body/div[1]/div[2]/div/div/div/div/div[1]/div/form/div/div[1]/div[9]/div/span");
    public static By clickOnNext = By.xpath("//button[@class='telerik-blazor k-button k-button-solid k-rounded-full k-button-md k-button-solid-primary']");
    public static By clickOnAttachmentIcon = By.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/span[2]/div[2]/button[1]");
    public static By clickOnAddAttachment = By.xpath("/html/body/div[3]/div[2]/div[2]/div/div/div[1]/button[1]");
    public static By clickOnUploadAttachment = By.xpath("//button[@class='telerik-blazor k-button k-button-solid k-rounded-sm k-button-md k-button-solid-primary']");
    public static By clickOnCloseAttachmentIcon = By.xpath("//button[@title='Close']");
    public static By selectFileManager = By.xpath(".//input[@type='file']");
    public static By SelectFileInFileManager = By.xpath("//button[contains(@aria-label,'Select files... .')]");
    public static By clickOnAddConsumption = By.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[3]/button[1]");
    public static By clickOnRemoveConsumption = By.xpath("//div[15]//button[1]");
    public static By meterSelection = By.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[4]/div[1]/div[2]/span[1]/button[1]");
    public static By clickOnRateDescription = By.xpath("//input[@id='ddChargeDescription']");
    public static By selectRateDescription = By.xpath("//*/text()[normalize-space(.)='Energy Charge - Day']/parent::*");
    public static By searchRateDescription = By.xpath("/html/body/div[1]/div[2]/div/div/div/div/div[1]/div/form/div[4]/div[1]/div[6]/span/input");
    public static By selectMeterNumber = By.xpath("//li/span");
    public static By clickOnNextButtonForCharges = By.xpath("//button[5]");
    public static By addPrice = By.xpath("/html/body/div[1]/div[2]/div/div/div/div/div[1]/div/form/div[1]/div/div[2]/div/div[2]/div[2]/div[2]/div[1]/div/table/tbody/tr[1]/td[4]");
    public static By enterPrice = By.xpath("/html/body/div[1]/div[2]/div/div/div/div/div[1]/div/form/div[1]/div/div[2]/div/div[2]/div[2]/div[2]/div[1]/div/table/tbody/tr[1]/td[4]/span[1]/input");
    public static By addUnit = By.xpath("/html/body/div[1]/div[2]/div/div/div/div/div[1]/div/form/div[1]/div/div[2]/div/div[2]/div[2]/div[2]/div[1]/div/table/tbody/tr[1]/td[5]");
    public static By enterUnits = By.xpath("/html/body/div[1]/div[2]/div/div/div/div/div[1]/div/form/div[1]/div/div[2]/div/div[2]/div[2]/div[2]/div[1]/div/table/tbody/tr[1]/td[5]/span/input");
    public static By addMeter = By.xpath("/html/body/div[1]/div[2]/div/div/div/div/div[1]/div/form/div[1]/div/div[2]/div/div[1]/button[1]");
    public static By removeMeter = By.xpath("//tbody/tr[2]/td[10]/span[1]/button[1]");
    public static By removeTaxCharge = By.xpath("/html/body/div[1]/div[2]/div/div/div/div/div[1]/div/form/div[4]/div/div[2]/div/div[2]/div[2]/div[2]/div[1]/div/table/tbody/tr[2]/td[8]/span/button");
    public static By addTaxCharge = By.xpath("//div[@aria-label='Grid toolbar']//div//div//button[@type='button']");
    public static By searchTaxCharge = By.xpath("//input[@role='combobox']");
    public static By selectTaxCharge = By.xpath("//span[@class='k-list-item-text']");
    public static By enterMeter = By.xpath("//input[contains(@placeholder,'Please select')]");
    public static By clickOnSelectMeter = By.xpath("/html/body/div[1]/div[2]/div/div/div/div/div[1]/div/form/div[4]/div/div[2]/div/div[2]/div[2]/div[2]/div[1]/div/table/tbody/tr/td[2]/div");
    public static By selectMeter = By.xpath("//span[normalize-space()='" + SearchMeterText + "']");
    public static By addTaxRate = By.xpath("/html/body/div[1]/div[2]/div/div/div/div/div[1]/div/form/div[4]/div/div[2]/div/div[2]/div[2]/div[2]/div[1]/div/table/tbody/tr/td[3]");
    public static By clearTaxCharge = By.xpath("//*[name()='path' and contains(@d,'M416 141.3')]");
    public static By clickOnTaxCharge = By.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[4]/div[1]/div[2]/div[1]/div[2]/div[2]/div[2]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[1]/div[1]");
    public static By enterTaxRate = By.xpath("//input[@role='spinbutton']");
    public static By clickOnNextForValidationReview = By.xpath("//div[@class='telerik-blazor k-split-button k-rounded-full k-button-group']//button[1]");
    public static By ClickToRevalidate = By.xpath("//div[@aria-label='Grid toolbar']//button[@type='button']");
    public static By clickOnSaveAndClose = By.xpath("/html/body/div[1]/div[2]/div/div[3]/span[3]/button");
    public static By clickOnSaveAndContinue = By.xpath("/html/body/div[1]/div[2]/div/div/div/div/div[2]/span[2]/button[7]");
    //    public static By clickOnAddNoteIcon = By.xpath("/html/body/div[1]/div[2]/div/div/div/div/div[2]/span[2]/div[1]/button");
    //    public static By addNote = By.xpath("");
    //
    public static By ClickOnPath = By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Path'])[1]/following::p[1]");
    public static By SelectPath = By.xpath("//*/text()[normalize-space(.)='Master Company']/parent::*");
    public static By clickOnStartDateCalenderOnListing = By.xpath("//div[@id='MainPane']/div/div/div/div[6]/div/span/button");
    public static By clickOnStartMonthCalender = By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='items per page'])[1]/following::button[1]");
    public static By selectStartMonthOnCalender = By.xpath("//*/text()[normalize-space(.)='Jan']/parent::*");
    public static By selectStartDateOnMonth = By.xpath("/html/body/div[3]/div/div/div/div[2]/table/tbody/tr[1]/td[1]");
    public static By clickOnEndDateCalenderOnListing = By.xpath("//div[@id='MainPane']/div/div/div/div[6]/div/span[2]/button");
    public static By clickOnEndMonthCalender = By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='items per page'])[1]/following::button[1]");
    public static By selectEndMonthOnCalender = By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Reload'])[1]/preceding::span[1]");
    public static By selectEndDateOnMonth = By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Reload'])[1]/preceding::span[6]");
    public static By ApplyFilterButton = By.xpath("//*[@id=\"MainPane\"]/div/div/span/span[1]/button");
    public static By selectRawInGrid = By.xpath("//tbody/tr[1]/td[1]/span[1]/span[1]/input[1]");
    public static By clickOnOptions = By.xpath("/html/body/div[1]/div[2]/div/div/div[2]/div/div[3]/div[2]/div[2]/div[1]/div/table/tbody/tr[1]/td[24]/span/div/button");
    public static By selectDeleteOption = By.xpath("/html/body/div[5]/div/div/ul/li[12]/span/div/div[2]");
    public static By deleteText = By.xpath("/html/body/div[3]/div[2]/div[2]/div/div[1]/div[3]/span/input");
    public static By SubmitButtonOnDeleteModel = By.xpath("/html/body/div[3]/div[2]/div[2]/div/div[2]/div[1]/button");

    //=
    @Parameters("browser")
    @BeforeTest
    public void launchBrowser(String Browser) throws Exception {
        browserSelector.LaunchBrowser(Browser);
    }

    public void redirectToInvoiceList() throws InterruptedException {
        loginPage.login();
        clickOnElement(invoiceValidationMenu);
        Thread.sleep(1000);
        clickOnElement(manageInvoiceLink);
        Thread.sleep(1000);
    }

    public void createInvoice() throws InterruptedException {
        invoiceDetail();
        invoiceConsumption();
        invoiceCharges();
        validationSummary();


    }

    public void invoiceDetail() throws InterruptedException {
        Thread.sleep(1000);
        clickOnElement(addButton);
        Thread.sleep(1000);
        clickOnElement(portfolio);
        isElementPresent(selectPortfolio);
        Thread.sleep(1000);
        clickOnElement(selectPortfolio);
        enterText(searchAccount, AccountNumber);
        Thread.sleep(200);
        clickOnElement(selectAccount);
        Thread.sleep(1000);
        enterText(searchInvoiceType, InvoiceType);
        Thread.sleep(1000);
        clickOnElement(selectInvoiceType);
        enterText(enterInvoiceNumber, InvoiceNumber);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        Thread.sleep(1000);
        isElementPresent(clickOnStartDateCalender);
        clickOnElement(clickOnStartDateCalender);
        Thread.sleep(2000);
        clickOnElement(selectStartMonthList);
        Thread.sleep(1000);
        clickOnElement(selectStartMonth);
        Thread.sleep(1000);
        System.out.println(selectStartDate);
        isElementPresent(selectStartDate);
        clickOnElement(selectStartDate);
        Thread.sleep(1000);
        clickOnElement(clickOnEndDateCalender);
        Thread.sleep(1000);
        clickOnElement(selectEndMonthList);
        clickOnElement(selectEndMonth);
        Thread.sleep(1000);
        clickOnElement(selectEndDate);
        Thread.sleep(1000);
        clickOnElement(clickOnInvoiceDateCalender);
        Thread.sleep(1000);
        clickOnElement(selectInvoiceDate);
        Thread.sleep(1000);
        clickOnElement(clickOnReceivedDateCalender);
        Thread.sleep(1000);
        clickOnElement(selectReceivedDate);
        Thread.sleep(1000);
        clickOnElement(clickOnDueDateCalender);
        clickOnElement(selectDueDate);
        Thread.sleep(1000);
        enterText(clickOnCurrencyDropdown, InvoiceCurrency);
        Thread.sleep(1000);
        clickOnElement(selectCurrency);
        enterText(forwardBalance, InvoiceForwardBalance);
        enterText(netTotal, InvoiceNetTotal);
        enterText(taxTotal, InvoiceTaxTotal);
        enterText(invoiceTotal, InvoiceTotal);
        enterText(internalReference, InvoiceInternalNotes);
        enterText(externalReference, InvoiceExternalNotes);
        clickOnElement(finalInvoice);
        clickOnElement(clickOnAttachmentIcon);
        Thread.sleep(1000);
        clickOnElement(clickOnAddAttachment);
        Thread.sleep(1000);
        UploadFile(selectFileManager, SelectFileInFileManager);
        Thread.sleep(2000);
        clickOnElement(clickOnUploadAttachment);
        Thread.sleep(3000);
        clickOnElement(clickOnCloseAttachmentIcon);
        Thread.sleep(2000);
        clickOnElement(clickOnNext);
    }

    public void invoiceConsumption() throws InterruptedException {
        Thread.sleep(1000);
        clickOnElement(clickOnAddConsumption);
        Thread.sleep(1000);
        clickOnElement(clickOnRemoveConsumption);
        Thread.sleep(1000);
        clickOnElement(clickOnRemoveConsumption);
//        clickOnElement(clickOnAddConsumption);
//        Thread.sleep(1000);
//        clickOnElement(meterSelection);
//        Thread.sleep(1000);
//        clickOnElement(selectMeterNumber);
        Thread.sleep(1000);
        clickOnElement(clickOnRateDescription);
        enterText(searchRateDescription, SearchRateDescription);
        Thread.sleep(2000);
        clickOnElement(selectRateDescription);
        clickOnElement(clickOnNextButtonForCharges);
    }

    public void invoiceCharges() throws InterruptedException {
        webDriverWaitImplicitly(10);
        driver.findElement(By.cssSelector(".k-master-row:nth-child(1) > .k-table-td:nth-child(4) > div")).click();
        driver.findElement(By.cssSelector(".k-numerictextbox > .k-input-inner")).click();
        driver.findElement(By.cssSelector(".k-numerictextbox > .k-input-inner")).sendKeys("10");
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div/div/div/div[1]/div/form/div[1]/div/div[2]/div/div[1]")).click();
//        driver.findElement(By.cssSelector(".k-master-row:nth-child(1) > .k-table-td:nth-child(5) > div")).click();
//        driver.findElement(By.cssSelector(".k-numerictextbox > .k-input-inner")).click();
//        driver.findElement(By.cssSelector(".k-numerictextbox > .k-input-inner")).sendKeys("100");
//        clickOnElement(addPrice);
//        Thread.sleep(500);
//        isElementPresent(enterPrice);
//        enterText(enterPrice,"25");
//        Thread.sleep(100);
//        clickOnElement(addUnit);
//        Thread.sleep(100);
//        enterText(enterUnits,"10");
        clickOnElement(addMeter);
        Thread.sleep(1000);
        clickOnElement(removeMeter);
        Thread.sleep(1000);
        clickOnElement(removeMeter);
        Thread.sleep(1000);
        clickOnElement(addTaxCharge);
        Thread.sleep(1000);
        clickOnElement(removeTaxCharge);
        Thread.sleep(1000);
        clickOnElement(removeTaxCharge);
        Thread.sleep(1000);
        clickOnElement(clickOnTaxCharge);
        Thread.sleep(1000);
        clickOnElement(clearTaxCharge);
        Thread.sleep(2000);
        enterText(searchTaxCharge, InvoiceSearchTaxCharge);
        Thread.sleep(1000);
        clickOnElement(selectTaxCharge);
        Thread.sleep(1000);
        clickOnElement(clickOnSelectMeter);
        enterText(enterMeter, SearchMeterText);
        clickOnElement(selectMeter);
        clickOnElement(addTaxRate);
        Thread.sleep(1000);
        enterText(enterTaxRate, InvoiceTax);
    }

    public void validationSummary() throws InterruptedException {
        Thread.sleep(5000);
        clickOnElement(clickOnNextForValidationReview);
        Thread.sleep(5000);
        clickOnElement(ClickToRevalidate);
        Thread.sleep(10000);
        clickOnElement(clickOnSaveAndClose);
        Thread.sleep(2000);
        //    clickOnElement(clickOnSaveAndContinue); For continuing the creation of invoice

    }

    public void deleteInvoice() throws InterruptedException {
        Thread.sleep(5000);
        clickOnElement(ClickOnPath);
        clickOnElement(SelectPath);
        Thread.sleep(100);
        clickOnElement(clickOnStartDateCalenderOnListing);
        clickOnElement(clickOnStartMonthCalender);
        Thread.sleep(1000);
        clickOnElement(selectStartMonthOnCalender);
        clickOnElement(selectStartDateOnMonth);
        Thread.sleep(500);
        clickOnElement(clickOnEndDateCalenderOnListing);
        Thread.sleep(1000);
        clickOnElement(clickOnEndMonthCalender);
        clickOnElement(selectEndMonthOnCalender);
        Thread.sleep(500);
        clickOnElement(selectEndDateOnMonth);
        Thread.sleep(1000);
        clickOnElement(ApplyFilterButton);
        Thread.sleep(1000);

        if (isElementPresent(selectRawInGrid)) {
            Thread.sleep(500);
            clickOnElement(selectRawInGrid);
            Thread.sleep(500);
            clickOnElement(clickOnOptions);
            Thread.sleep(500);
            clickOnElement(selectDeleteOption);
            Thread.sleep(500);
            enterText(deleteText, loginPage.U_name);
            Thread.sleep(500);
            clickOnElement(SubmitButtonOnDeleteModel);
            System.out.println("Invoice Deleted Successfully.");
        }
    }

    @AfterTest
    public void closeBrowser() throws Exception {
        browserSelector.closeBrowser();
    }
}

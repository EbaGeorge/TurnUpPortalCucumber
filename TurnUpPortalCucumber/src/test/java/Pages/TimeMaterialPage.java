package Pages;

import Utilities.Wait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class TimeMaterialPage extends Wait
{
    private final By createNewButtonLocator = By.xpath("//*[@id='container']/p/a");
    WebElement createNewButton;
    private final By typeCodeButtonLocator = By.xpath("//*[@id='TimeMaterialEditForm']/div/div[1]/div/span[1]/span");
    WebElement typeCodeButton;
    private final By timeOptionLocator = By.xpath("//*[@id='TypeCode_listbox']/li[2]");
    WebElement timeOption;
    private final By codeTextboxLocator = By.id("Code");
    WebElement codeTextbox;
    private final By descriptionTextboxLocator = By.id("Description");
    WebElement descriptionTextbox;
    private final By overlapTextboxLocator = By.xpath("//*[@id='TimeMaterialEditForm']/div/div[4]/div/span[1]/span/input[1]");
    WebElement overlapTextbox;
    private final By priceTextboxLocator = By.id("Price");
    WebElement priceTextbox;
    private final By fileInputLocator = By.id("files");
    WebElement fileInput;
    private final By saveButtonLocator = By.id("SaveButton");
    WebElement saveButton;
    private final By goToLastPageLocator = By.xpath("//*[@id='tmsGrid']/div[4]/a[4]/span");
    WebElement goToLastPage;
    private final By lastCodeLocator = By.xpath("//*[@id='tmsGrid']/div[3]/table/tbody/tr[last()]/td[1]");
    WebElement lastCode;
    private final By editButtonLocator = By.xpath("//*[@id='tmsGrid']/div[3]/table/tbody/tr[last()]/td[5]/a[1]");
    WebElement editButton;
    private final By materialOptionLocator = By.xpath("//*[@id='TypeCode_listbox']/li[1]");
    WebElement materialOption;
    private final By deleteButtonLocator = By.xpath("//*[@id='tmsGrid']/div[3]/table/tbody/tr[last()]/td[5]/a[2]");
    WebElement deleteButton;

    public void createNewTimeRecord(WebDriver driver,String code,String price,String description) throws InterruptedException {
        try
        {
            Wait.waitToBeVisible(driver, "xpath", "//*[@id='container']/p/a",6);
            createNewButton = driver.findElement(createNewButtonLocator);
            createNewButton.click();
        }
        catch (Exception ex)
        {
            Assert.fail("Create New Button is not selectable" + ex.getMessage());
        }

        Wait.waitToBeVisible(driver, "xpath", "//*[@id='TimeMaterialEditForm']/div/div[1]/div/span[1]/span", 6);
        typeCodeButton = driver.findElement(typeCodeButtonLocator);
        typeCodeButton.click();
        Wait.waitToBeVisible(driver, "xpath", "//*[@id='TypeCode_listbox']/li[2]", 6);
        timeOption = driver.findElement(timeOptionLocator);
        timeOption.click();

        codeTextbox = driver.findElement(codeTextboxLocator);
        codeTextbox.sendKeys(code);

        descriptionTextbox = driver.findElement(descriptionTextboxLocator);
        descriptionTextbox.sendKeys(description);

        Wait.waitToBeVisible(driver, "xpath", "//*[@id='TimeMaterialEditForm']/div/div[4]/div/span[1]/span/input[1]", 6);
        overlapTextbox = driver.findElement(overlapTextboxLocator);
        overlapTextbox.click();

        priceTextbox = driver.findElement(priceTextboxLocator);
        priceTextbox.sendKeys(price);

        fileInput = driver.findElement(fileInputLocator);
        fileInput.sendKeys("D:/Eba/Industry Connect/DemoImage.jpg");

        Wait.waitToBeVisible(driver,"id","SaveButton",6);

        saveButton = driver.findElement(saveButtonLocator);
        saveButton.click();
        Wait.waitToBeVisible(driver, "xpath", "//*[@id=\"tmsGrid\"]/div[4]", 6);
        try
        {
            Wait.waitToBeVisible(driver, "xpath", "//*[@id='tmsGrid']/div[4]/a[4]/span", 6);
            goToLastPage = driver.findElement(goToLastPageLocator);
            goToLastPage.click();
        }
        catch (Exception ex)
        {
            Assert.fail("GoToLastPage Button is not selectable" + ex.getMessage());
        }
    }

    public String getCode(WebDriver driver)
    {
        Wait.waitToBeVisible(driver, "xpath", "//*[@id='tmsGrid']/div[3]/table/tbody/tr[last()]/td[1]", 5);
        WebElement newTimeModule = driver.findElement(lastCodeLocator);
        return newTimeModule.getText();
    }

    public void editTimeRecord(WebDriver driver,String editedCode,String editedPrice,String editedDescription) throws InterruptedException
    {
        Thread.sleep(1000);
        try
        {
            goToLastPage = driver.findElement(goToLastPageLocator);
            goToLastPage.click();
        }
        catch (Exception ex)
        {
            Assert.fail("GoToLastPage Button is not selectable" + ex.getMessage());
        }
        Wait.waitToBeVisible(driver, "xpath", "//*[@id='tmsGrid']/div[3]/table/tbody/tr[last()]/td[5]/a[1]", 5);
        editButton = driver.findElement(editButtonLocator);
        editButton.click();

        Wait.waitToBeClickable(driver, "xpath", "//*[@id='TimeMaterialEditForm']/div/div[1]/div/span[1]/span", 7);
        typeCodeButton = driver.findElement(typeCodeButtonLocator);
        typeCodeButton.click();
        Wait.waitToBeClickable(driver, "xpath", "//*[@id='TypeCode_listbox']/li[1]", 7);
        materialOption = driver.findElement(materialOptionLocator);
        materialOption.click();

        codeTextbox = driver.findElement(codeTextboxLocator);
        codeTextbox.clear();
        codeTextbox.sendKeys(editedCode);

        descriptionTextbox = driver.findElement(descriptionTextboxLocator);
        descriptionTextbox.clear();
        descriptionTextbox.sendKeys(editedDescription);
        Wait.waitToBeVisible(driver, "xpath", "//*[@id='TimeMaterialEditForm']/div/div[4]/div/span[1]/span/input[1]", 5);
        try
        {
            overlapTextbox = driver.findElement(overlapTextboxLocator);
            overlapTextbox.click();
            Wait.waitToBeVisible(driver, "id", "Price", 5);
            priceTextbox = driver.findElement(priceTextboxLocator);
            priceTextbox.clear();
            overlapTextbox.click();
            priceTextbox.sendKeys(editedPrice);
        }
        catch (Exception ex)
        {
            Assert.fail("Price textbox is not interactable" + ex.getMessage());
        }

        fileInput = driver.findElement(fileInputLocator);
        fileInput.sendKeys("D:/Eba/Industry Connect/Demo2.jpg");
        Wait.waitToBeVisible(driver, "Id", "SaveButton", 5);
        saveButton = driver.findElement(saveButtonLocator);
        saveButton.click();
        Wait.waitToBeVisible(driver, "xpath", "//*[@id=\"tmsGrid\"]/div[4]", 6);
        try
        {
            Wait.waitToBeVisible(driver, "xpath", "//*[@id='tmsGrid']/div[4]/a[4]/span", 6);
            goToLastPage = driver.findElement(goToLastPageLocator);
            goToLastPage.click();
        }
        catch (Exception ex)
        {
            Assert.fail("GoToLastPage Button is not selectable" + ex.getMessage());
        }
    }

    public void deleteTimeRecord(WebDriver driver,String code) throws InterruptedException
    {
        Thread.sleep(1000);
        try
        {
            goToLastPage = driver.findElement(goToLastPageLocator);
            goToLastPage.click();
        }
        catch (Exception ex)
        {
            Assert.fail("GoToLastPage Button is not selectable" + ex.getMessage());
        }
        Wait.waitToBeVisible(driver,"xpath","//*[@id='tmsGrid']/div[3]/table/tbody/tr[last()]/td[5]/a[2]",6);
        deleteButton = driver.findElement(deleteButtonLocator);
        deleteButton.click();
        driver.switchTo().alert().accept();
        driver.navigate().refresh();
        try
        {

            Wait.waitToBeVisible(driver, "xpath", "//*[@id='tmsGrid']/div[4]/a[4]/span", 6);
            goToLastPage = driver.findElement(goToLastPageLocator);
            goToLastPage.click();
        }
        catch (Exception ex)
        {
            Assert.fail("GoToLastPageButton is not selectable" + ex.getMessage());
        }

    }
}

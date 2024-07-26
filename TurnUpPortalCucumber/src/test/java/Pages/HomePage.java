package Pages;
import Utilities.Wait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class HomePage extends Wait
{
    private final By timeMaterialOptionLocator = By.xpath("/html/body/div[3]/div/div/ul/li[5]/ul/li[3]/a");
    private final By adminTabLocator=By.xpath("/html/body/div[3]/div/div/ul/li[5]/a");
    public void navigationToTimeAndMaterialPage(WebDriver driver)
    {
        try
        {
            WebElement administartionTab = driver.findElement(adminTabLocator);
            administartionTab.click();
            //Wait.waitToBeVisible(driver,"xpath","/html/body/div[3]/div/div/ul/li[5]/ul/li[3]/a",5);
            WebElement timeAndMaterialModule = driver.findElement(timeMaterialOptionLocator);
            timeAndMaterialModule.click();
        }
        catch (Exception ex)
        {
            Assert.fail("TurnUpPortal Time and Material Page is not loaded"+ ex.getMessage());
        }
    }
    public void userVerification(WebDriver driver)
    {
       WebElement helloHari = driver.findElement(By.xpath("//*[@id='logoutForm']/ul/li/a"));
       String actualCode=helloHari.getText();
       String expectedCode="Hello hari!";
       Assert.assertEquals(actualCode,expectedCode);
    }
    public void navigationToEmployeesPage(WebDriver driver)
    {
        WebElement administartionTabEmployee = driver.findElement(By.xpath("/html/body/div[3]/div/div/ul/li[5]/a"));
        administartionTabEmployee.click();
        WebElement employeeTab = driver.findElement(By.xpath("/html/body/div[3]/div/div/ul/li[5]/ul/li[2]/a"));
        employeeTab.click();
    }
}


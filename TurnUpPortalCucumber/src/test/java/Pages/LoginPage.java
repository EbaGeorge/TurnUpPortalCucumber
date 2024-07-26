package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class LoginPage
{
    public void loginActions(WebDriver driver)
    {
        driver.navigate().to("http://horse.industryconnect.io/");
        driver.manage().window().maximize();
        WebElement usernameTextbox = driver.findElement(By.id("UserName"));
        usernameTextbox.sendKeys("hari");
        WebElement passwordTextbox = driver.findElement(By.id("Password"));
        passwordTextbox.sendKeys("123123");
        try
        {
            WebElement loginButton = driver.findElement(By.xpath("//*[@id='loginForm']/form/div[3]/input[1]"));
            loginButton.click();
        }
        catch(ElementNotInteractableException ex)
        {
            Assert.fail("Login Button is not clickable" + ex.getMessage());
        }
    }
}

package Utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class Wait
{
    public static void waitToBeClickable(WebDriver driver, String locatorType, String locatorValue, int seconds)
    {
        if (locatorType == "xpath")
        {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath(locatorValue)));
        }
        if(locatorType =="id")
        {
            WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(seconds));
            wait.until(ExpectedConditions.elementToBeClickable(By.id(locatorValue)));
        }
    }
    public static void waitToBeVisible(WebDriver driver,String locatorType,String locatorValue,int seconds)
    {
        if (locatorType == "xpath")
        {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locatorValue)));
        }
        if (locatorType == "id")
        {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(locatorValue)));
        }
    }
}

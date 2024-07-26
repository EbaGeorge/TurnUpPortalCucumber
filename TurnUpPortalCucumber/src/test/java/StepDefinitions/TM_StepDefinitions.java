package StepDefinitions;

import Pages.HomePage;
import Pages.LoginPage;
import Pages.TimeMaterialPage;
import Utilities.CommonDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TM_StepDefinitions extends CommonDriver
{
    LoginPage loginPageObj=new LoginPage();
    HomePage homePageObj=new HomePage();
    TimeMaterialPage timeMaterialPageObj=new TimeMaterialPage();
    @Before
    public void setUp()
    {
        driver = new ChromeDriver();
    }
    @Given("I logged into TurnUp portal successfully")
    public void iLoggedIntoTurnUpPortalSuccessfully()
    {
        loginPageObj.loginActions(driver);
    }
    @When("I navigate to the Time and Material page")
    public void iNavigateToTheTimeAndMaterialPage()
    {
        homePageObj.navigationToTimeAndMaterialPage(driver);
    }

    @When("I created a new Time record with {string},{string},{string}")
    public void iCreatedANewTimeRecordWithCodePriceDescription(String code,String price,String description) throws InterruptedException {
        timeMaterialPageObj.createNewTimeRecord(driver,code,price,description);
    }

    @Then("the Time record should be created successfully with new {string},{string},{string}")
    public void theTimeRecordShouldBeCreatedSuccessfullyWithNewCodePriceDescription(String code,String price,String description)
    {
       String actualCode= timeMaterialPageObj.getCode(driver);
        Assert.assertEquals(actualCode, code,"Actual code and Expected code does not match");
    }

    @When("I updated the {string},{string},{string} of Time record")
    public void iUpdatedTheEditedCodeEditedPriceEditedDescriptionOfTimeRecord(String editedCode,String editedPrice,String editedDescription) throws InterruptedException {
        timeMaterialPageObj.editTimeRecord(driver,editedCode,editedPrice,editedDescription);
    }

    @Then("the time record should be updated with new {string},{string},{string}")
    public void theTimeRecordShouldBeUpdatedWithNewEditedCodeEditedPriceEditedDescription(String editedCode,String editedPrice,String editedDescription)
    {
        String actualCode=timeMaterialPageObj.getCode(driver);
        Assert.assertEquals(actualCode, editedCode,"Actual Code and Expected Code does not match");
    }

    @When("I deleted a Time record with {string}")
    public void iDeletedATimeRecordWithCode(String code) throws InterruptedException {
        timeMaterialPageObj.deleteTimeRecord(driver,code);
    }

    @Then("the Time record with {string} should be deleted successfully")
    public void theTimeRecordWithCodeShouldBeDeletedSuccessfully(String code)
    {
        String actualCode= timeMaterialPageObj.getCode(driver);
        Assert.assertNotEquals(actualCode, code,"Time record is not deleted");
    }
    @After
    public void closeBrowser()
    {
        driver.quit();
    }
}

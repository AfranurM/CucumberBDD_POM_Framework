package POM;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class RegisterPage extends BasePOM{

    public RegisterPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "ico-register")
    private WebElement registerMain;

    @FindBy(id = "gender-female")
    private WebElement femaleGender;

    @FindBy(id = "FirstName")
    private WebElement firstNameInput;

    @FindBy(id = "LastName")
    private WebElement lastNameInput;

    @FindBy(id = "Email")
    private WebElement emailInput;

    @FindBy(id = "Password")
    private WebElement passwordInput;

    @FindBy(id = "ConfirmPassword")
    private WebElement confirmPasswordInput;

    @FindBy(id = "register-button")
    private WebElement registerButton;


    @FindBy(css = "div[class='result']")
    private WebElement registrationResult;

    private String expectedRegisterPageUrl = "http://demowebshop.tricentis.com/register";
    private String firstNameStr = "Chandler";
    private String lastNameStr = "Bing";
    private String emailStr = "chandlermuriel@bing.com";
    private String passwordStr = "123456"; //questions here, to confirm password should I create another string or reuse this
    private String expectedRegResult = "Your registration completed";
    private String expectedUrlAfterRegistration = "http://demowebshop.tricentis.com/registerresult/1";

    public void validateOnRegisterPage() {
        registerMain.click();
        wait.until(ExpectedConditions.visibilityOf(femaleGender));
        Assert.assertTrue(femaleGender.isDisplayed());
        Assert.assertTrue(firstNameInput.isDisplayed());
        Assert.assertTrue(lastNameInput.isDisplayed());  //question here, do we need all these assertions NOPE
        Assert.assertTrue(emailInput.isDisplayed());
        Assert.assertTrue(passwordInput.isDisplayed());
        Assert.assertTrue(confirmPasswordInput.isDisplayed());
        Assert.assertTrue(registerButton.isDisplayed());
        Assert.assertEquals(driver.getCurrentUrl(), expectedRegisterPageUrl);

    }
    public void userEnterCredentials () {
        femaleGender.click();
        firstNameInput.sendKeys(firstNameStr);
        lastNameInput.sendKeys(lastNameStr);
        emailInput.sendKeys(emailStr);
        passwordInput.sendKeys(passwordStr);
        confirmPasswordInput.sendKeys(passwordStr);
        registerButton.click();
    }
    public void validateUserSuccessfullyRegistered() {
        wait.until(ExpectedConditions.visibilityOf(registrationResult));
        Assert.assertTrue(registrationResult.isDisplayed());
        Assert.assertTrue(registrationResult.getText().contains(expectedRegResult));
        Assert.assertTrue(driver.getCurrentUrl().contains(expectedUrlAfterRegistration));
    }
}

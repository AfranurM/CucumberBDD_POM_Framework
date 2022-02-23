package POM;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class LoginPage extends BasePOM {

    public LoginPage() {
        PageFactory.initElements(driver, this);
    }
    @FindBy(className = "ico-login")
    private WebElement loginMain;

    @FindBy(id = "Email")
    private WebElement emailInput;

    @FindBy(id = "Password")
    private WebElement passwordInput;

    @FindBy(xpath = "//input[@value='Log in']")
    private WebElement loginButton;

    @FindBy(css = "a[class='account']")
    private WebElement displayedEmailAfterLogin;

    private String expectedLoginUrl = "http://demowebshop.tricentis.com/login";
    private String emailStr = "chandler@bing.com";
    private String passwordStr = "123456";
    private String expectedUrlAfterLogin = "http://demowebshop.tricentis.com/";

    public void validateOnLoginPage() {
        loginMain.click();
        Assert.assertTrue(emailInput.isDisplayed());
        Assert.assertEquals(driver.getCurrentUrl(), expectedLoginUrl);

    }

    public void userInputValidEmailAndPassword() {
        emailInput.sendKeys(emailStr);
        passwordInput.sendKeys(passwordStr);
        loginButton.click();
    }
    public void validateUserSuccessfullyLoggedIn() {
        wait.until(ExpectedConditions.visibilityOf(displayedEmailAfterLogin));
        Assert.assertTrue(displayedEmailAfterLogin.isDisplayed());
        Assert.assertTrue(displayedEmailAfterLogin.getText().contains(emailStr));
        Assert.assertTrue(driver.getCurrentUrl().contains(expectedUrlAfterLogin));
    }
}

package StepDefinations;

import POM.LoginPage;
import io.cucumber.java.en.*;

public class LoginDemoShopSteps {

    LoginPage loginPage;

    @Given("User is on login page")
    public void user_is_on_login_page() {
        loginPage = new LoginPage();
        loginPage.validateOnLoginPage();

    }
    @When("User enter valid email and password")
    public void user_enter_valid_email_and_password() {
        loginPage = new LoginPage();
        loginPage.userInputValidEmailAndPassword();

    }
    @Then("User should login successfully")
    public void user_should_login_successfully() {
        loginPage = new LoginPage();
        loginPage.validateUserSuccessfullyLoggedIn();

    }
}

package StepDefinations;

import POM.RegisterPage;
import io.cucumber.java.en.*;

public class RegisterDemoShopSteps {

    RegisterPage registerPage;

    @Given("User is on main register page")
    public void user_is_on_main_register_page() {
        registerPage = new RegisterPage();
        registerPage.validateOnRegisterPage();

    }
    @When("User enter credentials as input")
    public void user_enter_credentials_as_input() {
        registerPage = new RegisterPage();
        registerPage.userEnterCredentials();

    }
    @Then("User should register successfully")
    public void user_should_register_successfully() {
        registerPage = new RegisterPage();
        registerPage.validateUserSuccessfullyRegistered();
    }
}

package StepDefinations;

import POM.HomePage;
import io.cucumber.java.en.*;

public class SearchDemoShopSteps {

    HomePage homePage;

    @Given("User is main page")
    public void user_is_main_page() {
        homePage = new HomePage();
        homePage.validateOnMainPage();

    }
    @When("User enter {string} on search label")
    public void user_enter_on_search_label(String input) {
        homePage = new HomePage();
        homePage.userEnterInputToSearch(input);


    }
    @Then("User should see the related results for {string}")
    public void user_should_see_the_related_results_for(String item) {
        homePage = new HomePage();
        homePage.validateUserSeeTheRelatedResults(item);

    }
}

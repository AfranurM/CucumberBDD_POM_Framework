package POM;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class HomePage extends BasePOM {

    public HomePage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "small-searchterms")
    private WebElement searchInput;

    @FindBy(css = "input[value='Search']")
    private WebElement searchButton;

    @FindAll({@FindBy(tagName = "h2")})
    private List<WebElement> searchResultItems;

    private String expectedUrl = "http://demowebshop.tricentis.com/";

    public void validateOnMainPage() {

        Assert.assertTrue(driver.getCurrentUrl().contains(expectedUrl));
    }

    public void userEnterInputToSearch(String item) {
        searchInput.sendKeys(item);
        searchButton.click();

    }

    public void validateUserSeeTheRelatedResults(String item) {

        for (WebElement element : searchResultItems) {
            String elementName = element.getText();
            System.out.println(elementName);
            Assert.assertTrue(elementName.toLowerCase().contains(item));
        }
    }
}

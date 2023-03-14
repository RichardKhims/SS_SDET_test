package khims.richard.sauce;

import khims.richard.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutInformationPage extends PageObject {
    @FindBy(id = "first-name")
    private WebElement firstNameInput;

    @FindBy(id = "last-name")
    private WebElement lastNameInput;

    @FindBy(id = "postal-code")
    private WebElement postalCodeInput;

    @FindBy(id = "continue")
    private WebElement continueBtn;

    public CheckoutInformationPage(WebDriver driver) {
        super(driver);
    }

    public void inputFirstName(String firstName) {
        firstNameInput.sendKeys(firstName);
    }

    public void inputLastName(String lastName) {
        lastNameInput.sendKeys(lastName);
    }

    public void inputPostalCode(String postalCode) {
        postalCodeInput.sendKeys(postalCode);
    }

    public CheckoutOverviewPage proceed() {
        continueBtn.click();
        return new CheckoutOverviewPage(driver);
    }
}

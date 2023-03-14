package khims.richard.sauce;

import khims.richard.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutCompletePage extends PageObject {

    @FindBy(className = "complete-header")
    private WebElement completeHeader;

    public CheckoutCompletePage(WebDriver driver) {
        super(driver);
    }

    public String completeHeaderText() {
        return completeHeader.getText();
    }
}

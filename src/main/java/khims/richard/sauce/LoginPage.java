package khims.richard.sauce;

import khims.richard.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends PageObject {
    private static final String LOGIN_PAGE_URL = "https://www.saucedemo.com/";

    @FindBy(id = "user-name")
    private WebElement loginInput;

    @FindBy(css = "#password")
    private WebElement passwordInput;

    @FindBy(xpath = "//*[@id='login-button']")
    private WebElement loginButton;

    @FindBy(xpath = "//*[@data-test='error']")
    private WebElement errorHint;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.get(LOGIN_PAGE_URL);
    }

    public InventoryPage login(String user, String password) {
        loginInput.sendKeys(user);
        passwordInput.sendKeys(password);
        loginButton.click();

        return new InventoryPage(driver);
    }

    public boolean isErrorHintVisible() {
        return errorHint.isDisplayed();
    }

    public String errorHintText() {
        return errorHint.getText();
    }
}

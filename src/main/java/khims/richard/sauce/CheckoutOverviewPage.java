package khims.richard.sauce;

import khims.richard.PageObject;
import khims.richard.sauce.widgets.CartListWidget;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutOverviewPage extends PageObject {
    private CartListWidget cartList;

    @FindBy(id = "finish")
    private WebElement finishBtn;

    public CheckoutOverviewPage(WebDriver driver) {
        super(driver);
        cartList = new CartListWidget(driver);
    }

    public CartListWidget getCartList() {
        return cartList;
    }

    public CheckoutCompletePage finish() {
        finishBtn.click();
        return new CheckoutCompletePage(driver);
    }
}

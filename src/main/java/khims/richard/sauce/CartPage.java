package khims.richard.sauce;

import khims.richard.PageObject;
import khims.richard.sauce.model.CartItem;
import khims.richard.sauce.widgets.CartListWidget;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

public class CartPage extends PageObject {

    private CartListWidget cartList;
    @FindBy(id = "checkout")
    private WebElement checkoutBtn;

    public CartPage(WebDriver driver) {
        super(driver);
        cartList = new CartListWidget(driver);
    }

    public CheckoutInformationPage checkout() {
        checkoutBtn.click();
        return new CheckoutInformationPage(driver);
    }

    public CartListWidget getCartList() {
        return cartList;
    }
}

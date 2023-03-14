package khims.richard.sauce.widgets;

import khims.richard.PageObject;
import khims.richard.sauce.model.CartItem;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

public class CartListWidget extends PageObject {

    @FindBy(xpath = "//*[@class='cart_list']")
    private WebElement cartList;

    public CartListWidget(WebDriver driver) {
        super(driver);
    }

    public List<CartItem> getInventoryItemList() {
        List<WebElement> cartItems = cartList.findElements(By.className("cart_item"));
        return cartItems.stream().map(item -> {
            WebElement inventoryItemName = item.findElement(By.className("inventory_item_name"));
            String itemName = inventoryItemName.getText();
            WebElement cartQuantity = item.findElement(By.className("cart_quantity"));
            int quantity = Integer.parseInt(cartQuantity.getText());
            return new CartItem(itemName, quantity);
        }).collect(Collectors.toList());
    }
}

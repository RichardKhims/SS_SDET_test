package khims.richard.sauce;

import khims.richard.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class InventoryPage extends PageObject {
    @FindBy(xpath = "//*[@class='inventory_list']")
    private WebElement inventoryList;

    @FindBy(id = "shopping_cart_container")
    private WebElement cartBtn;

    public InventoryPage(WebDriver driver) {
        super(driver);
    }

    public void addToCart(int inventoryIndex) {
        WebElement inventoryItem = inventoryList.findElements(By.className("inventory_item")).get(inventoryIndex);
        WebElement btn = inventoryItem.findElement(By.xpath(".//*[contains(@class, 'btn_inventory')]"));
        btn.click();
    }

    public CartPage moveToCart() {
        cartBtn.click();
        return new CartPage(driver);
    }
}

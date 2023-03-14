package khims.richard;

import khims.richard.sauce.*;
import khims.richard.sauce.model.CartItem;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class SauceTest {
    private static WebDriver driver;
    @BeforeAll
    public static void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\adm\\Downloads\\chromedriver_win32\\chromedriver.exe");
        System.setProperty("webdriver.http.factory", "jdk-http-client");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void checkoutCompleteTest() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        InventoryPage inventoryPage = loginPage.login("standard_user", "secret_sauce");

        inventoryPage.addToCart(0);
        CartPage cartPage = inventoryPage.moveToCart();

        List<CartItem> inventoryItemList = cartPage.getCartList().getInventoryItemList();
        Assertions.assertEquals(1, inventoryItemList.size());
        CartItem cartItem = inventoryItemList.get(0);
        Assertions.assertEquals(1, cartItem.getQuantity());
        Assertions.assertEquals("Sauce Labs Backpack", cartItem.getName());
        CheckoutInformationPage checkoutInformationPage = cartPage.checkout();

        checkoutInformationPage.inputFirstName("test");
        checkoutInformationPage.inputLastName("test");
        checkoutInformationPage.inputPostalCode("test");
        CheckoutOverviewPage checkoutOverviewPage = checkoutInformationPage.proceed();

        inventoryItemList = checkoutOverviewPage.getCartList().getInventoryItemList();
        Assertions.assertEquals(1, inventoryItemList.size());
        cartItem = inventoryItemList.get(0);
        Assertions.assertEquals(1, cartItem.getQuantity());
        Assertions.assertEquals("Sauce Labs Backpack", cartItem.getName());
        CheckoutCompletePage checkoutCompletePage = checkoutOverviewPage.finish();

        Assertions.assertEquals("https://www.saucedemo.com/checkout-complete.html", checkoutCompletePage.currentUrl());
//        Assertions.assertEquals("Thank you for your order!", checkoutCompletePage.completeHeaderText());
        Assertions.assertEquals("THANK YOU FOR YOUR ORDER", checkoutCompletePage.completeHeaderText());
    }

}

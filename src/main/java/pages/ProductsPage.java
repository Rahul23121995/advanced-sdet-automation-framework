package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage {

    WebDriver driver;

    By backpack = By.id("add-to-cart-sauce-labs-backpack");

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void addProduct() {
        driver.findElement(backpack).click();
    }
}
package tests;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProductsPage;

public class ProductTest extends BaseTest {

    @Test
    public void addProductToCartTest() {

        LoginPage login = new LoginPage(driver);
        login.login("standard_user", "secret_sauce");

        ProductsPage products = new ProductsPage(driver);
        products.addProduct();
    }
}
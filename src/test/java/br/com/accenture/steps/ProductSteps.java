package br.com.accenture.steps;

import br.com.accenture.core.Driver;
import br.com.accenture.pages.ProductPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;

public class ProductSteps {

    ProductPage productPage = new ProductPage();

    @And("add to cart")
    public void addToCart() {
        Driver.printScreen("add to cart");
        productPage.clickAddCart();
    }
}

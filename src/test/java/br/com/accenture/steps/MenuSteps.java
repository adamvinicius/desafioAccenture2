package br.com.accenture.steps;

import br.com.accenture.pages.CartPage;
import br.com.accenture.pages.MenuPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;

public class MenuSteps {
    public MenuPage menuPage = new MenuPage();
    public CartPage cartPage = new CartPage();

    @And("click on place holder")
    public void clickOnPlaceHolder() {
        menuPage.clickCart();
        cartPage.clickPlaceOrder();
    }
}

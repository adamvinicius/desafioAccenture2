package br.com.accenture.steps;

import br.com.accenture.core.Driver;
import br.com.accenture.pages.CartPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.LinkedHashMap;
import java.util.Map;

public class CartSteps {

    CartPage cartPage = new CartPage();

    @When("fill in the fields with the following information")
    public void fillInTheFieldsWithTheFollowingInformation(Map<String, String> map) {

        cartPage.setName(map.get("name"))
                .setCountry(map.get("Country"))
                .setCity(map.get("City"))
                .setCard(map.get("Credit Card"))
                .setMonth(map.get("Month"))
                .setYear(map.get("Year"))
                .clickPurchase();
    }


    @Then("validate the following information")
    public void validateTheFollowingInformation(Map<String, String> map) {
        Map<String, String> mapResult = cartPage.getThakYou();

        Driver.printScreen("Then validate the following information");
        Assert.assertFalse(mapResult.get("Id").isBlank());
        Assert.assertEquals(mapResult.get("Amount"), map.get("Amount"));
        Assert.assertEquals(mapResult.get("Name"), map.get("Name"));

        cartPage.clickOK();

    }

    @And("dont fill in the credit card field")
    public void dontFillInTheCreditCardField() {
        cartPage.setName("John Doe")
                .setCountry("Portugual")
                .setCity("Lisbon")
                .setCard("")
                .setMonth("02")
                .setYear("2030")
                .clickPurchase();
    }

    @Then("validate the error message {string}")
    public void validateTheErrorMessage(String msg) {
        Assert.assertEquals(msg, cartPage.getError());

    }
}

package br.com.accenture.steps;

import br.com.accenture.core.Driver;
import br.com.accenture.pages.HomePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class HomeSteps {
    public HomePage homePage;

    @Given("that it is on the index page")
    public void thatItIsOnTheIndexPage() {
        Driver.getDriver().get("https://demoblaze.com");
        homePage = new HomePage();
    }

    @When("I search for MacBook Pro")
    public void iSearchForMacBookPro() {
        homePage.clickLapTop()
                .clickMacPro();
    }

}

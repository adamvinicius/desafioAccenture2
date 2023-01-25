package br.com.accenture.pages;

import br.com.accenture.core.Driver;
import br.com.accenture.mapsWeb.HomeMap;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class HomePage {
    HomeMap homeMap;

    public HomePage() {
        homeMap = new HomeMap();
        PageFactory.initElements(Driver.getDriver(), homeMap);
    }

    public HomePage clickLapTop() {
        Driver.printScreen("that it is on the index page");
        homeMap.linkLapTop.click();
        return this;
    }

    public HomePage clickMacPro() {
        Driver.visibilityOf(homeMap.linkMacPro);
        Driver.printScreen("I search for MacBook Pro");
        homeMap.linkMacPro.click();
        return this;
    }
}

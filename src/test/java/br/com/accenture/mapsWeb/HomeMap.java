package br.com.accenture.mapsWeb;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomeMap {

    @FindBy(linkText = "Laptops")
    public WebElement linkLapTop;

    @FindBy(linkText = "MacBook Pro")
    public WebElement linkMacPro;

}

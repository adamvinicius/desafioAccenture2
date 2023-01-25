package br.com.accenture.mapsWeb;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartMap {
    @FindBy(xpath = "//button[contains(text(), 'Place Order')]")
    public WebElement btnPlaceOrder;

    @FindBy(css = "#name")
    public WebElement inpName;

    @FindBy(css = "#country")
    public WebElement inpCountry;

    @FindBy(css = "#city")
    public WebElement inpCity;

    @FindBy(css = "#card")
    public WebElement inpCard;

    @FindBy(css = "#month")
    public WebElement inpMonth;

    @FindBy(css = "#year")
    public WebElement inpYear;

    @FindBy(xpath = "//button[text() = 'Purchase']")
    public WebElement btnPurchase;

    @FindBy(css = "p.lead")
    public WebElement textThakYou;

    @FindBy(xpath = "//button[text() = 'OK']")
    public WebElement btnOK;


}

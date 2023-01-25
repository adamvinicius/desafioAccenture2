package br.com.accenture.pages;

import br.com.accenture.core.Driver;
import br.com.accenture.mapsWeb.CartMap;
import org.openqa.selenium.support.PageFactory;

import java.util.LinkedHashMap;
import java.util.Map;

public class CartPage {
    CartMap cartMap;
    public CartPage(){
        cartMap = new CartMap();
        PageFactory.initElements(Driver.getDriver(), cartMap);
    }

    public CartPage clickPlaceOrder(){
        Driver.visibilityOf(cartMap.btnPlaceOrder);
        Driver.printScreen("click on place holder");
        cartMap.btnPlaceOrder.click();
        return this;
    }
    public CartPage setName(String name){
        Driver.visibilityOf(cartMap.inpName);
        cartMap.inpName.sendKeys(name);
        return this;
    }
    public CartPage setCountry(String country){
        cartMap.inpCountry.sendKeys(country);
        return this;
    }
    public CartPage setCity(String city){
        cartMap.inpCity.sendKeys(city);
        return this;
    }
    public CartPage setCard(String card){
        cartMap.inpCard.sendKeys(card);
        return this;
    }
    public CartPage setMonth(String month){
        cartMap.inpMonth.sendKeys(month);
        return this;
    }
    public CartPage setYear(String year){
        cartMap.inpYear.sendKeys(year);
        Driver.printScreen("fill in the fields with the following information");
        return this;
    }
    public CartPage clickPurchase(){
        cartMap.btnPurchase.click();
        return this;
    }
    public Map<String, String> getThakYou(){
        String message = cartMap.textThakYou.getText();
        Map<String, String> mapResult = new LinkedHashMap<String, String>();
        for(String keyValue : message.split("\\n")) {
            String[] pairs = keyValue.split(":", 2);
            mapResult.put(pairs[0], pairs.length == 1 ? "" : pairs[1].trim());
        }
        return mapResult;
    }
    public CartPage clickOK(){
        cartMap.btnOK.click();
        return this;
    }

    public String getError(){
       return Driver.getAlertMsg();
    }
}
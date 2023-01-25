package br.com.accenture.pages;

import br.com.accenture.core.Driver;
import br.com.accenture.mapsWeb.MenuMap;
import org.openqa.selenium.support.PageFactory;

public class MenuPage {
    MenuMap menuMap;
    public MenuPage(){
        menuMap = new MenuMap();
        PageFactory.initElements(Driver.getDriver(), menuMap);
    }

    public MenuPage clickCart(){
        Driver.closeAlert();
        menuMap.linkCart.click();
        return this;
    }
}

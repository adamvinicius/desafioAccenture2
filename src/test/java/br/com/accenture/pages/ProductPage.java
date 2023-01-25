package br.com.accenture.pages;

import br.com.accenture.core.Driver;
import br.com.accenture.mapsWeb.ProductMap;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {
    ProductMap productMap;
    public ProductPage(){
        productMap = new ProductMap();
        PageFactory.initElements(Driver.getDriver(), productMap);
    }

    public ProductPage clickAddCart(){
        Driver.visibilityOf(productMap.btnAddCart);
        productMap.btnAddCart.click();
        return this;
    }
}

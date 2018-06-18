package com.andersenlab;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class SearchPage {
    By geoButton = By.cssSelector(".link_geosuggest_yes");
    By input = By.cssSelector(".input__control");
    By moreSwitcher = By.cssSelector(".home-tabs__more-switcher");
    By moreLinks = By.cssSelector(".home-tabs__more-link");

    private final WebDriver driver;

    public SearchPage(WebDriver driver) {
        this.driver = driver;
    }

    public void setLocation(String location) {
        (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.elementToBeClickable(geoButton));
        driver.findElement(geoButton).click();
        driver.findElement(input).clear();
        driver.findElement(input).sendKeys(location);
        WebElement city = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.elementToBeClickable(By.cssSelector(".b-autocomplete-item__reg")));
        city.click();
    }

    public List getLinks() {
        List<WebElement> elementsText;
        driver.findElement(moreSwitcher).click();
        List<WebElement> elements = driver.findElements(moreLinks);
        for (int i = 0; i < elements.size(); i++) {
            elementsText.add(elements.get(i).getText() );
        }
        return elementsText;
    }



}

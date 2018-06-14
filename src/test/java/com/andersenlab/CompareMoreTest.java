package com.andersenlab;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertTrue;

public class CompareMoreTest extends BaseTest {

    private static SearchPage searchPage;

    @BeforeTest
    public void func () {
        searchPage = new SearchPage(driver);
    }



    @Test
    public void CompareMoreTest() {


        driver.get("https://yandex.by/");
        searchPage.setLocation("Лондон");
        List<WebElement> elemLon = searchPage.getLinks();
        searchPage.setLocation("Париж");
        List<WebElement> elemPar = searchPage.getLinks();

        for (WebElement elemLonIt : elemLon) {
            for (WebElement elemParIt : elemPar) {
                assertTrue(elemLonIt.getText()==elemParIt.getText());
            }
        }

    }

}

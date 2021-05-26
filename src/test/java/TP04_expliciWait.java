import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TP04_expliciWait {

    WebDriver driver;

    @BeforeMethod
    public void ouvrirChrome(){
        driver = new ChromeDriver();
        //driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);   deconseillé
        driver.get("https://www.amazon.fr/");
        driver.manage().window().maximize();
        driver.findElement(By.id("sp-cc-accept")).click();
    }
    @Test
    public void test(){

        //Arrang


        //Act
        By bouttonAllSelector = By.id("nav-hamburger-menu");
        driver.findElement(bouttonAllSelector).click();

        By amazonPrimeVideoSelector = By.cssSelector(".hmenu-item[data-menu-id='2']");

        WebDriverWait wait = new WebDriverWait(driver,3); // la on difinit le maximum d'attente
        wait.until(ExpectedConditions.elementToBeClickable(amazonPrimeVideoSelector)); // la on attent que amazonPrimeVideo soit visible et cliquable
        driver.findElement(amazonPrimeVideoSelector).click();

        By filmSelector = By.cssSelector(".hmenu-visible [data-menu-id='2'] li:nth-of-type(4)");
        wait.until(ExpectedConditions.elementToBeClickable(filmSelector)); // la on attent que amazonPrimeVideo soit visible et cliquable
        driver.findElement(filmSelector).click();

        By accueilButton = By.cssSelector("#pv-nav-home");
        driver.findElement(accueilButton).click();

    }
}

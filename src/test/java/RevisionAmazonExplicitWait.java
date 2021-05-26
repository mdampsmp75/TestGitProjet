import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class RevisionAmazonExplicitWait {

    WebDriver driver;

    @BeforeMethod
    public void ouvrirChrome(){
        driver = new ChromeDriver();
        //driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);   deconseillé
        driver.get("https://www.amazon.fr/");
        driver.manage().window().maximize();
        //driver.findElement(By.id("sp-cc-accept")).click();
    }

    @AfterMethod
    public void closeChrome(){
        //driver.quit();
    }

    @Test
    public void test(){
        //Arrang
        String resultatAttendu = "MUSIQUE EN HD POUR TOUS";
        //Act
        By humbergerSelector = By.cssSelector("#nav-hamburger-menu");
        driver.findElement(humbergerSelector).click();

        By amazonMusicSelector = By.cssSelector("[data-menu-id='3'].hmenu-item");
        WebDriverWait wait = new WebDriverWait(driver,3);
        wait.until(ExpectedConditions.elementToBeClickable(amazonMusicSelector));
        driver.findElement(amazonMusicSelector).click();

        By amazonMusicHdSelector = By.cssSelector(".hmenu-visible[data-menu-id=\"3\"] li:nth-of-type(4)");
        wait.until(ExpectedConditions.elementToBeClickable(amazonMusicSelector));
        driver.findElement(amazonMusicHdSelector).click();

        //Assert

        By resultatTrouveSelector = By.xpath("//h1[contains(text(),'MUSIQUE EN HD POUR TOUS')]");
        String resultatTrouve = driver.findElement(resultatTrouveSelector).getText();
        Assert.assertEquals(resultatTrouve,resultatAttendu);

    }
}

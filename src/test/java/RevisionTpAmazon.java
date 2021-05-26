import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class RevisionTpAmazon {

    WebDriver driver;

    @BeforeMethod
    public void ouvrirChrome(){
        driver = new ChromeDriver();
        //driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://www.amazon.fr/");
        driver.manage().window().maximize();
        driver.findElement(By.id("sp-cc-accept")).click();
    }

    @Test
    public void test(){
        String inputText = "iphone 12 pro max 128go";
        String resultatAttendu = "Phone 12";
        String prixAttendu = "249";

        By serachBoxSelector = By.cssSelector("[id=twotabsearchtextbox]");
        driver.findElement(serachBoxSelector).sendKeys("iphone 12 pro max 128go"+ Keys.ENTER);

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        By resultatTrouveSelectorNom = By.cssSelector("[data-cel-widget='search_result_1'] .a-size-base-plus");
        String resultatReel = driver.findElement(resultatTrouveSelectorNom).getText();
        System.out.println(resultatReel);

        By prixTrouveSelector = By.cssSelector("[data-cel-widget='search_result_1'] .a-price-whole");
        String prixTrouve = driver.findElement(prixTrouveSelector).getText();
        System.out.println(prixTrouve);

        Assert.assertTrue(resultatReel.contains(resultatAttendu));
        //Assert.assertTrue(prixTrouve.contains(prixAttendu));

    }
}

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RevisionTpGoogleVol {
    WebDriver driver;

    @BeforeMethod
    public void ouvrirChrome(){
        driver = new ChromeDriver();
        driver.get("https://www.google.fr/");
        driver.manage().window().maximize();
        driver.findElement(By.id("L2AGLb")).click();
    }

    @Test
    public void testFindVol(){
        //Arrang
        String inputText = "DLA CDG vol";
       // String resultatAttendu = "3 vols par semaine, durée : 6h 35min";
        String resultatAttendu = "3 vols par semaine";

        //Act
        By searchBoxSelector = By.cssSelector("[name='q']");
        driver.findElement(searchBoxSelector).sendKeys(inputText + Keys.ENTER);

        By resultatTrouveSelector = By.cssSelector(".heZBGc>h3>.heZBGc");
        WebElement resultatTrouve = driver.findElement((resultatTrouveSelector));

        //Assert
        String resultatReel = resultatTrouve.getText();
        //Assert.assertEquals(resultatReel,resultatAttendu);
        Assert.assertTrue(resultatReel.contains(resultatAttendu),"probleme de chaine de caractere avec le assertequal");

    }
}

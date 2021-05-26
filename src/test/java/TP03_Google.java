import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TP03_Google {

    WebDriver driver;

    @BeforeMethod
    public void ouvrirChrome(){

        driver = new ChromeDriver();
        driver.get("https://www.google.fr/");
        driver.manage().window().maximize();
        driver.findElement(By.id("L2AGLb")).click();
    }

    @AfterMethod
    public void closeChorome(){
        //driver.quit();
    }

    @Test
    public void test(){

        //Arrange
        String recherche = "dla cdg";
        String resultatAttendu = "6h 35min";
        //Act
        By barreRecherche = By.xpath("//input[@class='gLFyf gsfi']");
        driver.findElement(barreRecherche).sendKeys(recherche + Keys.ENTER);

        By resultatRechercheSelector = By.cssSelector("h3 div");
        WebElement resultatRecherche = driver.findElement(resultatRechercheSelector);

    }

}

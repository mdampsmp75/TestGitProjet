import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TP3 {
    WebDriver driver;

    @BeforeMethod
    public void ouvrirChrome(){

        driver = new ChromeDriver();
        driver.get("https://wwws.airfrance.fr/");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//button[@id='accept_cookies_btn']")).click();
    }

    @AfterMethod
    public void closeChorome(){
        //driver.quit();
    }

    @Test
    public void test(){

        //Arrange
        String aeroportDepart = "DLA";
        String aeroportArrivee = "CDG";
        String resultatAttendu = "De Douala à Paris, en ECONOMY";

        //Act
        By champsTextDepart = By.id("mat-input-0");
        By champsTextArrivee = By.id("mat-input-1");
        By rechercheVol = By.id("[type='submit']");

        driver.findElement(champsTextDepart).click();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(champsTextDepart).sendKeys("DLA");
        driver.findElement(champsTextArrivee).sendKeys("CDG" +Keys.ENTER);

        //Action de faire Assert
    }


}

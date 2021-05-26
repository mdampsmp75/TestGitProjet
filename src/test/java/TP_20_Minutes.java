import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class TP_20_Minutes {

    WebDriver driver;

    @BeforeMethod
    public void ouvrirChrome(){

        driver = new ChromeDriver();
        driver.get("https://www.20minutes.fr/");
        driver.manage().window().maximize();
        // accepte cookies:
        driver.findElement(By.xpath("//*[@id=\"didomi-notice-agree-button\"]/span")).click();
    }

    @Test
    public void openPrincipalPage(){

        driver.findElement(By.cssSelector(".box.preview-cover")).click();
        // ou bien css = .full-height >.box
        //(//*[@id="tab-live"]/ul/li)[2]/a

    }

    @Test
    public void clicOnSeondElement(){

        driver.findElement(By.xpath("(//*[@id=\"tab-live\"]/ul/li)[2]/a")).click();
    }

    @Test
    public void openSencondPage(){
        //css ne marche pas alors on ulilise xpath
       // driver.findElement(By.xpath("//*[@id=\"didomi-notice-agree-button\"]/span")).click();

        //avec webelements   #tab-live li --> donner tous les id egale = tab-live li

      List<WebElement> l = driver.findElements(By.cssSelector("#tab-live li"));
      l.get(2).click();

    }

    @AfterMethod
    public void closeChorome(){
      //driver.quit();
    }


}

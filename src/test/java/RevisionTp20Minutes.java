import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class RevisionTp20Minutes {

    WebDriver driver;

    @BeforeMethod
    public void ouvrirChrome(){
        driver = new ChromeDriver();
        driver.get("https://www.20minutes.fr/");
        driver.manage().window().maximize();
        driver.findElement(By.id("didomi-notice-agree-button")).click();
    }

    @AfterMethod
    public void closeChrome(){
        //driver.quit();
    }

    @Test
    public void testPrincipalElement(){
        String principalElementCss = ".lt-hoth-section>.lt-hoth-section-content>.lt-hoth-row-cover";
        WebElement goToLinkOfPrincipalElement = driver.findElement(By.cssSelector(principalElementCss));
        goToLinkOfPrincipalElement.click();
    }

    @Test
    public void testSecondElementOnPage(){
       /* String secondPgaeCss = ".block-list-item>.color-economy>.media>.media-wrap>.b-loaded";
        WebElement goToSecondElement = driver.findElement(By.cssSelector(secondPgaeCss));
        goToSecondElement.click();*/

        String secondPgaeCss = "#tab-live li";
        List<WebElement> goToSecondElement = driver.findElements(By.cssSelector("#tab-live li"));
        goToSecondElement.get(1).click();

    }



}

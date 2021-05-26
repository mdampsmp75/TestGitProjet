import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RevisionTpBanquePostale {

    WebDriver driver;

    @BeforeMethod
    public void ouvrirChrome(){
        driver = new ChromeDriver();
        driver.get("https://www.labanquepostale.fr/");
        driver.manage().window().maximize();
    }

    @Test
    public void testHomePage(){



    }
}

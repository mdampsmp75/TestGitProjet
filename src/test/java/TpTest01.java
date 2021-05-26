import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

public class TpTest01 {

    WebDriver driver;

    @BeforeMethod
    public void ouvrirChrome(){

        driver = new ChromeDriver();
        driver.get("https://www.amazon.fr");
        driver.manage().window().maximize();
    }

    @Test
    public void test1() {

        String acceptCookiesXpath1 = "//*[@id='sp-cc-accept']";
        WebElement cookiesButton1 = driver.findElement(By.xpath(acceptCookiesXpath1));
        cookiesButton1.click();

        String xpathTextInput = "//*[@id='twotabsearchtextbox']";
        WebElement champText = driver.findElement(By.xpath(xpathTextInput));
        champText.sendKeys("iphone 11");

        String xpathValidateSearch = "//input[@id='nav-search-submit-button']";
        WebElement validate = driver.findElement(By.xpath(xpathValidateSearch));
        validate.click();
        driver.navigate().back();

        String acceptCookiesXpath2 = "//*[@id='sp-cc-accept']";
        WebElement cookiesButton2 = driver.findElement(By.xpath(acceptCookiesXpath2));
        cookiesButton2.click();

       /* String xpathProdcast = "//img[@alt='Amazon Music' and @class='landscape-image']";
        WebElement prodcastImage = driver.findElement(By.xpath(xpathProdcast));
        prodcastImage.click();*/
    }

    @AfterMethod
    public void fermerChrome(){
        driver.quit();
    }
}
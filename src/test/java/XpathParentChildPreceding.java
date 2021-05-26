import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class XpathParentChildPreceding {

    @Test
    public void xpathTrainning(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.hyrtutorials.com/p/add-padding-to-containers.html");
        driver.manage().window().maximize();

        //following-sibling
        String firstNameXpath = "//label[contains(text(),'First Name')]/following-sibling::input[1]";
        WebElement putFristName = driver.findElement(By.xpath(firstNameXpath));
        putFristName.sendKeys("Fouad");

        String emailXpayth = "//label[contains(text(),'Email')]/following-sibling::input[1]";
        WebElement putEmail = driver.findElement(By.xpath(emailXpayth));
        putEmail.sendKeys("fouadjouadi1@gmail.com");


        //preceding-sibling
        String checkBoxXpayth = "//td[text()='Maria Anders']/preceding-sibling::td/child::input";
        WebElement clic = driver.findElement(By.xpath(checkBoxXpayth));
        clic.click();



    }
}

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;

public class findElementsOnPage {

    @Test
    public void getdNombreOfLink() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.ebay.com/");
        driver.manage().window().maximize();

        // find links
        List<WebElement> linksFound =  driver.findElements(By.tagName("a"));

        //size of links on the page
        System.out.println(linksFound.size());

        //get the text of each link
        for(int i=0;i<linksFound.size();i++){
           String printList = linksFound.get(i).getText();
            System.out.println(printList);
        }


    }
}

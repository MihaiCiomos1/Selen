package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.util.List;

public class InteractionsFormTest {
    public WebDriver driver;

    @Test
    public void parcurgereListaMethod()  {

        driver = new ChromeDriver();

        driver.get("https://demoqa.com/sortable");

        driver.manage().window().maximize();
        Actions actions= new Actions (driver);
        List <WebElement> list = driver.findElements(By.xpath("//div[@id='demo-tabpane-list']//div[@class='list-group-item list-group-item-action']"));
        for (int i=0; i<list.size()-1; i++){
            WebElement webElement = list.get(i);
            WebElement nextWebElement = list.get(i+1);
            System.out.println("Numarul elementului este " + webElement.getText());
            actions.clickAndHold(webElement)
                    .moveToElement(nextWebElement)
                    .release()
                    .build()
                    .perform();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
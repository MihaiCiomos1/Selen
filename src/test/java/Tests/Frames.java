package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Frames {
    public WebDriver driver;

    @Test
    public void automationMethod() {
        //deschidem un browser de chrome
        driver = new ChromeDriver();
        //accesam o pagina web
        driver.get("https://demoqa.com/");
        //maximize browser
        driver.manage().window().maximize();

        WebElement elementsField = driver.findElement(By.xpath("//h5[text()='Alerts, Frame & Windows']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,400)"); //x=0,y=400 (axa)
        elementsField.click();
        WebElement frameElement = driver.findElement(By.xpath("//span[text()='Frames']"));
        frameElement.click();


        WebElement frameTextElement = driver.findElement(By.id("frame1"));
        driver.switchTo().frame(frameTextElement);
        WebElement sampleHeadingFrameElement = driver.findElement(By.id("sampleHeading"));
        System.out.println("Textul din new frame este: " +sampleHeadingFrameElement.getText());
        //ne ducem cu focusul pe pagina principala
        driver.switchTo().defaultContent();


        WebElement frame2TextElement = driver.findElement(By.id("frame2"));
        driver.switchTo().frame(frame2TextElement);
        js.executeScript("window.scrollBy(200,200)");


    }
    }

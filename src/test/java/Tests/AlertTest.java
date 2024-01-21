package Tests;

import HelperMethods.AlertMethods;
import HelperMethods.ElementsMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class AlertTest {
    public WebDriver driver;
    public ElementsMethods elementMethods;
    public AlertMethods alertMethods;

    @Test
    public void automationMethod() {
        //deschidem un browser de chrome
        driver = new ChromeDriver();
        //accesam o pagina web
        driver.get("https://demoqa.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //maximize browser
        driver.manage().window().maximize();

        elementMethods = new ElementsMethods(driver);
        alertMethods = new AlertMethods(driver);

        WebElement elementsField = driver.findElement(By.xpath("//h5[text()='Alerts, Frame & Windows']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,400)"); //x=0,y=400 (axa)
        elementMethods.clickOnElements(elementsField);


        WebElement alertElement = driver.findElement(By.xpath("//span[text()='Alerts']"));
        elementMethods.clickOnElements(alertElement);


        WebElement alertOKElement = driver.findElement(By.id("alertButton"));
        elementMethods.clickOnElements(alertOKElement);

        alertMethods.interractWithAlertsOK();


        WebElement alertDelayElement = driver.findElement(By.id("timerAlertButton"));
        elementMethods.clickOnElements(alertDelayElement);

//
//        //definim un wait explicit ca sa astepte dupa alerta
        alertMethods.interractWithDelayAlert();
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        wait.until(ExpectedConditions.alertIsPresent());
//
//        Alert alertDelay = driver.switchTo().alert();
//        alertDelay.accept();

//
//        WebElement confirmElement = driver.findElement(By.id("confirmButton"));
//       confirmElement.click();
//
//        Alert alertConfirm = driver.switchTo().alert();
//        alertConfirm.dismiss();
//
//        WebElement alertPromtElement = driver.findElement(By.id("promtButton"));
//        alertPromtElement.click();
//
//        Alert alertPromt = driver.switchTo().alert();
//        alertPromt.sendKeys("test");
//        alertPromt.accept();
//
//
//

    }
}

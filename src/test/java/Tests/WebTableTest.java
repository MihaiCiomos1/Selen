package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class WebTableTest {
    public WebDriver driver;

    @Test
    public void automationMethod() {
        //deschidem un browser de chrome
        driver = new ChromeDriver();
        //accesam o pagina web
        driver.get("https://demoqa.com/");
        //maximize browser
        driver.manage().window().maximize();
        //declaram un element
        WebElement elementsField = driver.findElement(By.xpath("//h5[text()='Elements']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,400)"); //x=0,y=400 (axa)
        elementsField.click();

        WebElement elementsTable = driver.findElement(By.xpath("//span[text()='Web Tables']"));
        elementsTable.click();

        List<WebElement> tableElements = driver.findElements(By.xpath("//div[@class='rt-tbody']/div/div[@class='rt-tr -even' or @class='rt-tr -odd']"));
        Integer actualTableSize = tableElements.size();
        System.out.println("Size-ul este: " + actualTableSize);


        WebElement addNewEntry = driver.findElement(By.id("addNewRecordButton"));
        addNewEntry.click();

        WebElement addFirstName = driver.findElement(By.id("firstName"));
        String addFirstNameValue = "Lee";
        addFirstName.sendKeys(addFirstNameValue);

        WebElement addLastName = driver.findElement(By.id("lastName"));
        String addLastNameValue = "Jay-Wook";
        addLastName.sendKeys(addLastNameValue);

        WebElement addEmail = driver.findElement(By.id("userEmail"));
        String addEmailValue = "Lee.Jay-Wook@email.com";
        addEmail.sendKeys(addEmailValue);

        WebElement addAge = driver.findElement(By.id("age"));
        String addAgeValue = "32";
        addAge.sendKeys(addAgeValue);

        WebElement addSalary = driver.findElement(By.id("salary"));
        String addSalaryValue = "22000";
        addSalary.sendKeys(addSalaryValue);

        WebElement addDepartment = driver.findElement(By.id("department"));
        String addDepartmentValue = "IT";
        addDepartment.sendKeys(addDepartmentValue);

        WebElement submitNewEntry = driver.findElement(By.id("submit"));
        submitNewEntry.click();


        List<WebElement> expectedTableElements = driver.findElements(By.xpath("//div[@class='rt-tbody']/div/div[@class='rt-tr -even' or @class='rt-tr -odd']"));

        Integer expectedTableSize = actualTableSize + 1;
        Assert.assertEquals(expectedTableElements.size(), expectedTableSize);
        String actualTableValue = expectedTableElements.get(3).getText();
        System.out.println("Elementul este " + actualTableValue);
        Assert.assertTrue(actualTableValue.contains(addFirstNameValue));
        Assert.assertTrue(actualTableValue.contains(addLastNameValue));
        Assert.assertTrue(actualTableValue.contains(addEmailValue));
        Assert.assertTrue(actualTableValue.contains(addAgeValue));
        Assert.assertTrue(actualTableValue.contains(addSalaryValue));
        Assert.assertTrue(actualTableValue.contains(addDepartmentValue));
    }
}

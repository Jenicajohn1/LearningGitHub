package qatek_automation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class QaTek {
    WebDriver driver;

    @BeforeMethod
    public void openbrowser() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://qateksolutions-lms.com/login");
        driver.manage().window().maximize();

    }

    public void enterData() {
        // driver.findElement(By.id("outlined-basic")).click();
        driver.findElement(By.id("outlined-basic")).sendKeys("jenicajohn349@gmail.com");

        // driver.findElement(By.id("outlined-password-input")).click();
        driver.findElement(By.id("outlined-password-input")).sendKeys("KITkat@65");


    }

    @Test

    public void LoginPage() {
        enterData();
        driver.findElement(By.xpath("[@id=root]/div[3]/div[3]/div/form/div[3]/div/button/span[1]")).click();
        driver.findElement(By.xpath("/html/body/div/div[3]/div/div[12]/div/p/div/div[2]/div/p/div[1]/div/div/div/div/span"));
        String expectedTotalMonthlyPayment = "video";
        String formattedXpath = String.format("[//*[@id=\"root\"]/div[2]/header/div/div/a[2]");

        boolean present = driver.findElement(By.xpath(formattedXpath)).isDisplayed();

        Assert.assertTrue(present, "Total monthly payment is not presented");
    }

    @AfterMethod
    public void closeBrowser() {
        driver.quit();
    }

}




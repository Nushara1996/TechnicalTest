package login.web.com.globaltradingnetwork;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class loginPageTest {

    WebDriver driver;

    @BeforeMethod
    public void beforeMethod() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://difc.globaltradingnetwork.com/web/login");
        driver.manage().window().maximize();
        Thread.sleep(10000);
    }

    // Test for the Login Test Cases

    // 1. Empty fields then login

    @Test
    public void emptyFieldLogin() throws InterruptedException {
        driver.findElement(By.id("LoginButton")).click();
        String ErrorMsg1 = driver.findElement(By.xpath("//div[@class='login_error_msg']")).getText();
        Thread.sleep(1000);
        System.out.println("Empty field error msg: " + ErrorMsg1);
    }

    // 2. Random Credentials Login
    @Test
    public void randomCredentialsLogin() throws InterruptedException {
        driver.findElement(By.id("form-input-live-u")).sendKeys("Nusharatest@1");
        driver.findElement(By.id("form-input-live-p")).sendKeys("Test@123");
        driver.findElement(By.id("LoginButton")).click();
        String ErrorMsg2 = driver.findElement(By.xpath("//div[@class='login_error_msg'][1]")).getText();
        Thread.sleep(5000);
        System.out.println("Random Credentials Login error msg 1: " + ErrorMsg2);
        Thread.sleep(8000);
        String ErrorMsg3 = driver.findElement(By.xpath("//div[@class='login_error_msg'][1]")).getText();
        System.out.println("Random Credentials Login error msg 2: " + ErrorMsg3);
        Thread.sleep(3000);
    }


    @AfterMethod
    public void afterMethod(){
        driver.close();
    }


}

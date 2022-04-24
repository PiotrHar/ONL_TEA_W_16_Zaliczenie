package Zadanie1;

import io.cucumber.java.en.Given;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class Zadanie2 {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/drivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://mystore-testlab.coderslab.pl");
        driver.findElement(By.xpath("//*[@id=\"_desktop_user_info\"]/div/a/span")).click();

        WebElement logInEmailInput = driver.findElement(By.name("email"));
        logInEmailInput.sendKeys("john.wick@mystore.com");
        WebElement logInEmailPassword = driver.findElement(By.name("password"));
        logInEmailPassword.sendKeys("johnwick");
        driver.findElement(By.id("submit-login")).click();

        driver.findElement(By.xpath("//*[@id=\"category-3\"]/a")).click();

        driver.findElement(By.xpath("//*[@id=\"js-product-list\"]/div[1]/article[2]/div/a")).click();

        WebElement sizeElement = driver.findElement(By.id("group_1"));
        sizeElement.sendKeys("M");



        WebElement quantityElement = driver.findElement(By.xpath("//*[@id=\"quantity_wanted\"]"));
        quantityElement.clear();
        quantityElement.sendKeys("5");
        driver.findElement(By.xpath("//*[@id=\"add-to-cart-or-refresh\"]/div[2]/div/div[2]/button")).click();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(By.xpath("//*[@id=\"blockcart-modal\"]/div/div/div[2]/div/div[2]/div/div/a")).click();
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(By.xpath("//*[@id=\"main\"]/div/div[2]/div[1]/div[2]/div/a")).click();
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.findElement(By.xpath("//*[@id=\"checkout-addresses-step\"]/div/div/form/div[2]/button")).click();

        driver.findElement(By.xpath("//*[@id=\"js-delivery\"]/div/div[1]/div[1]/label/div/div[1]/div/div/span")).click();

        driver.findElement(By.xpath("//*[@id=\"js-delivery\"]/button")).click();

        driver.findElement(By.xpath("//*[@id=\"payment-option-1-container\"]/label/span")).click();

        driver.findElement(By.xpath("//*[@id=\"conditions_to_approve[terms-and-conditions]\"]")).click();

        driver.findElement(By.xpath("//*[@id=\"payment-confirmation\"]/div[1]/button")).click();


    }
}

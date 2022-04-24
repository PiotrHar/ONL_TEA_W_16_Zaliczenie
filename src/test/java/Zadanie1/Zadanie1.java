package Zadanie1;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObjects.CreateNewAddressPage;

public class Zadanie1 {

  private WebDriver driver;

    @Given("user is logged in on account page")
    public void userIsLoggedInOnAccountPage() {

        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/drivers/chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://mystore-testlab.coderslab.pl");
        driver.findElement(By.xpath("//*[@id=\"_desktop_user_info\"]/div/a/span")).click();

        WebElement logInEmailInput = driver.findElement(By.name("email"));
        logInEmailInput.sendKeys("john.wick@mystore.com");
        WebElement logInEmailPassword = driver.findElement(By.name("password"));
        logInEmailPassword.sendKeys("johnwick");
        driver.findElement(By.id("submit-login")).click();
    }

    @When("user click on addresses")
    public void userClickOnAddresses() {

        driver.findElement(By.xpath("//*[@id=\"addresses-link\"]")).click();
    }

    @When("user click add address")
    public void userClickAddAddress() {

        driver.findElement(By.xpath("//*[@id=\"content\"]/div[3]/a/span")).click();
    }

    @When("user fills form with data {string}, {string}, {string}, {string}, {string}, {string}")
    public void userFillsFormWitchData(String alias, String address, String city, String postalCode, String country, String homePhone){
        CreateNewAddressPage createNewAddressPage = new CreateNewAddressPage(driver);
        createNewAddressPage.fillForm (alias, address, postalCode, city, country, homePhone);
    }
    @And("click Save button to add first address")
    public void clickSaveButtonToAddFirstAddress() {
        CreateNewAddressPage createNewAddressPage = new CreateNewAddressPage(driver);
        createNewAddressPage.createAddress();
    }
    @Then("first address is added")
    public void firstAddressIsAdded() {
        WebElement firstAddress = driver.findElement(By.xpath("//*[@id=\"notifications\"]/div/article/ul/li"));
        Assertions.assertTrue(firstAddress.isDisplayed());
    }
}

package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewAddressPage {

    private WebDriver driver;

    @FindBy(css = "#content > div > div > form > section > div:nth-child(5) > div.col-md-6 > input")
    private WebElement aliasInput;

    @FindBy(css = "#content > div > div > form > section > div:nth-child(10) > div.col-md-6 > input")
    private WebElement addressInput;

    @FindBy(css = "#content > div > div > form > section > div:nth-child(12) > div.col-md-6 > input")
    private WebElement cityInput;

    @FindBy(css = "#content > div > div > form > section > div:nth-child(13) > div.col-md-6 > input")
    private WebElement postcodeInput;

    @FindBy(css = "#content > div > div > form > section > div:nth-child(14) > div.col-md-6 > select")
    private WebElement countryDropdown;

    @FindBy(css = "#content > div > div > form > section > div:nth-child(15) > div.col-md-6 > input")
    private WebElement phoneInput;

    @FindBy(xpath = "//*[@id=\"content\"]/div/div/form/footer/button")
    private WebElement createButton;

    public CreateNewAddressPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void fillForm(String alias, String address, String postalCode, String city, String country, String homePhone){
        aliasInput.sendKeys(alias);
        addressInput.sendKeys(address);
        postcodeInput.sendKeys(postalCode);
        cityInput.sendKeys(city);
        phoneInput.sendKeys(homePhone);
        countryDropdown.sendKeys(country);
    }
    public void createAddress(){
        createButton.click();
    }
}

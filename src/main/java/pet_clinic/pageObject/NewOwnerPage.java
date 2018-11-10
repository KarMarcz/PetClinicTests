package pet_clinic.pageObject;

import org.json.simple.JSONObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pet_clinic.utils.Waits;

public class NewOwnerPage {
    @FindBy(id = "firstName")
    private WebElement firstNameField;

    @FindBy(id = "lastName")
    private WebElement lastNameField;

    @FindBy(id = "address")
    private WebElement addressField;

    @FindBy(id = "city")
    private WebElement cityField;

    @FindBy(id = "telephone")
    private WebElement telephoneField;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement addOwnerButton;

    private WebDriver driver;
    private Waits waits;

    public NewOwnerPage(WebDriver driver){
        this.driver = driver;
        waits = new Waits(driver);

        PageFactory.initElements(driver, this);
    }

    public void fillingNewOwnerFields(JSONObject owner) {
        waits.waitForElementToBeVisible(firstNameField);
        firstNameField.sendKeys((String) owner.get("first_name"));
        lastNameField.sendKeys((String) owner.get("last_name"));
        addressField.sendKeys((String) owner.get("address"));
        cityField.sendKeys((String) owner.get("City"));
        telephoneField.sendKeys((String) owner.get("Telephone"));
        addOwnerButton.click();
    }
}

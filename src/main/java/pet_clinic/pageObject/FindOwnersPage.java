package pet_clinic.pageObject;

import org.json.simple.JSONObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pet_clinic.utils.Waits;

public class FindOwnersPage {
    @FindBy(xpath = "//a[@class='btn btn-default']")
    private WebElement addOwnerButton;

    @FindBy(id = "lastName")
    private WebElement lastNameField;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement findOwnerButtonUnderLastNameField;

    private WebDriver driver;
    private Waits waits;

    public FindOwnersPage(WebDriver driver){
        this.driver = driver;
        waits = new Waits(driver);

        PageFactory.initElements(driver, this);
    }

    public void clickAddOwnerButton(){
        waits.waitForElementToBeVisible(addOwnerButton);
        addOwnerButton.click();
    }

    public void fillingLastNameFieldAndClickingFindOwnerButton(JSONObject owner) {
        waits.waitForElementToBeVisible(lastNameField);
        lastNameField.sendKeys((String) owner.get("last_name"));
        findOwnerButtonUnderLastNameField.click();
    }
}

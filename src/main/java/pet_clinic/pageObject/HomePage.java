package pet_clinic.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pet_clinic.utils.Waits;

public class HomePage {

    @FindBy(xpath = "//a[@title='find owners']")
    private WebElement findOwnersButton;

    private WebDriver driver;
    private Waits waits;

    public HomePage(WebDriver driver){
        this.driver = driver;
        waits = new Waits(driver);

        PageFactory.initElements(driver, this);
    }

    public void clickfindOwnersButton() {
        waits.waitForElementToBeVisible(findOwnersButton);
        findOwnersButton.click();
    }

}

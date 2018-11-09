package pet_clinic.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pet_clinic.utils.Waits;

public class FindOwnersPage {
    @FindBy(xpath = "//a[@class='btn btn-default']")
    private WebElement addOwnerButton;

    private WebDriver driver;
    private Waits waits;

    public FindOwnersPage(WebDriver driver){
        this.driver = driver;
        waits = new Waits(driver);

        PageFactory.initElements(driver, this);
    }

    public void clickAddOwnerButton(){
        addOwnerButton.click();
    }
}

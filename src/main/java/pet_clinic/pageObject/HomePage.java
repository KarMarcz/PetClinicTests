package pet_clinic.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    @FindBy(xpath = "//a[@title='find owners']")
    private WebElement findOwnersButton;

    WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver ;

        PageFactory.initElements(driver, this);
    }

    public void clickfindOwnersButton() {
        findOwnersButton.click();
    }

}

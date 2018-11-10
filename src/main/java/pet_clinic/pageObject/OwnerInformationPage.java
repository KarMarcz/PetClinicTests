package pet_clinic.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pet_clinic.utils.Waits;

public class OwnerInformationPage {

    @FindBy(xpath = "//tbody//tr[1]//td[1]")
    private WebElement nameElementForAssertion;

    @FindBy(xpath = "//li//a//span[@class='glyphicon  glyphicon-search']")
    private WebElement findOwnerButton;

    private WebDriver driver;
    private Waits waits;

    public OwnerInformationPage(WebDriver driver){
        this.driver = driver;
        waits = new Waits(driver);

        PageFactory.initElements(driver, this);
    }

    public String returnFullName() {
        return nameElementForAssertion.getText();
    }

    public void clickFindOwnerButton() {
        findOwnerButton.click();
    }
}

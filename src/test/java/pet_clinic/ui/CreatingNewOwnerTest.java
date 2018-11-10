package pet_clinic.ui;

import org.json.simple.JSONObject;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.WebDriver;
import pet_clinic.ownerGenerator.OwnerDataGenerator;
import pet_clinic.pageObject.FindOwnersPage;
import pet_clinic.pageObject.HomePage;
import pet_clinic.pageObject.NewOwnerPage;
import pet_clinic.pageObject.OwnerInformationPage;
import pet_clinic.utils.WebDriverCreators;
import pet_clinic.utils.WebDriverProvider;

import static org.assertj.core.api.Assertions.assertThat;

public class CreatingNewOwnerTest {
    private WebDriver driver;

    private HomePage homePage;
    private FindOwnersPage findOwnersPage;
    private OwnerInformationPage ownerInformationPage;
    private static NewOwnerPage newOwnerPage;

    private static OwnerDataGenerator ownerDataGenerator = new OwnerDataGenerator();

    @BeforeEach
    public void setUp() {
        driver = new WebDriverProvider(WebDriverCreators.CHROME).getDriver();
        driver.manage().window().maximize();

        homePage = new HomePage(driver);
        findOwnersPage = new FindOwnersPage(driver);
        newOwnerPage = new NewOwnerPage(driver);
        ownerInformationPage = new OwnerInformationPage(driver);
        driver.get("http://localhost:8080/");
    }
    @AfterEach
    public void tearDown() {
        driver.close();
    }

    @ParameterizedTest
    @MethodSource
    public void creatingNewOwner(JSONObject owner) {
        homePage.clickfindOwnersButton();
        findOwnersPage.clickAddOwnerButton();
        newOwnerPage.fillingNewOwnerFields(owner);
        assertThat(owner.get("first_name") + " " + owner.get("last_name")).isEqualTo(ownerInformationPage.returnFullName());
    }

    @ParameterizedTest
    @MethodSource
    public void findOwner(JSONObject owner) {
        creatingNewOwner(owner);
        ownerInformationPage.clickFindOwnerButton();
        findOwnersPage.fillingLastNameFieldAndClickingFindOwnerButton(owner);
        assertThat(owner.get("first_name") + " " + owner.get("last_name")).isEqualTo(ownerInformationPage.returnFullName());
    }

    static JSONObject[][] creatingNewOwner() {
        return new JSONObject[][] {
                new JSONObject[] { ownerDataGenerator.randomDataFromJson() },
        };
    }
    static JSONObject[][] findOwner() {
        return new JSONObject[][] {
                new JSONObject[] { ownerDataGenerator.randomDataFromJson() },
        };
    }
}

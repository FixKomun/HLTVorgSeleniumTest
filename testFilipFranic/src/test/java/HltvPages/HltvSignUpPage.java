package HltvPages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.Select;

public class HltvSignUpPage {
    WebDriver driver;
   // JavascriptExecutor jse;
    public HltvSignUpPage(WebDriver driver)
    {
        this.driver=driver;
    }

    //Locating the elements using @Findby
    @FindBy (id = "usernameInput")
    WebElement usernameTextBox;
    @FindBy(id="passwordInput")
    WebElement passwordTextBox;
    @FindBy (id="emailInput")
    WebElement emailTextBox;
    @FindBy (id = "confirmPasswordInput")
    WebElement confirmPasswordTextBox;
    @FindBy(id = "confirmEmailInput")
    WebElement confirmEmailTextBox;
    @FindBy (name="nationality")
    WebElement nationalitySelect;
    @FindBy (xpath="//form[@method='post']//select[@name='timezone']")
    WebElement timezoneSelect;
    @FindBy(id = "signup-validate-button")
    WebElement createAccountButton;

    //Defining all the users methods/functions
    public void signUp(String username,
                       String password,
                       String email,
                       String confirmPassword,
                       String confirmEmail,
                       String nationality,
                       String timezone) throws InterruptedException {
        usernameTextBox.sendKeys(username);
        passwordTextBox.sendKeys(password);
        emailTextBox.sendKeys(email);
        confirmPasswordTextBox.sendKeys(confirmPassword);
        confirmEmailTextBox.sendKeys(confirmEmail);
        //Using select for drop down list
        Select selectNationality=new Select(nationalitySelect);
        selectNationality.selectByVisibleText(nationality);
        //Using java script (EFWD) to scroll for 500px/5000px in a drop down list and find hidden/searched element
        EventFiringWebDriver event=new EventFiringWebDriver(driver);
        event.executeScript("document.querySelector('select[name=\"nationality\"]').scrollTop=500");
        Select selectTimezone=new Select(timezoneSelect);
        selectTimezone.selectByVisibleText(timezone);
        event.executeScript("document.querySelector('form[method=\"post\"] select[name=\"timezone\"]').scrollTop=5000");
        Thread.sleep(3000);
        createAccountButton.click();
        Thread.sleep(3000);
    }
}

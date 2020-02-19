package HltvPages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Objects;

public class HltvHomePage {
    WebDriver driver;
    JavascriptExecutor jse; //for java script

    public HltvHomePage(WebDriver driver)
    {
        this.driver= Objects.requireNonNull(driver);
    }
//Locating the elements using @Findby
    @FindBy(name = "query")
     WebElement searchTextBox;
    @FindBy(className = "navsearchicon")
     WebElement searchIcon;
    @FindBy(xpath = "//*[@href='https://www.facebook.com/HLTV.org']")
     WebElement facebookIcon;
    @FindBy(xpath = "//div[contains(text(),'Sign in')]")
    WebElement signInLabel;
    @FindBy(xpath = "//a[contains(text(),'Sign up')]")
    WebElement signUpLabel;
    @FindBy(xpath = "//*[@id=\"loginpopup\"]/form/input[1]")
    WebElement usernameTextBox;
    @FindBy(xpath = "//*[@id=\"loginpopup\"]/form/input[2]")
    WebElement passwordTextBox;
    @FindBy(name = "autologin")
    WebElement rememberCheckBox;
    @FindBy(name = "login")
    WebElement loginButton;


//Defining all the users methods/functions
    public void setSearchTextBox(String searchText)
    {
        searchTextBox.sendKeys(searchText);
    }
    public void clickOnSearchIcon(){
        searchIcon.click();
    }
    public void clickOnFacebookIcon() throws InterruptedException {
        jse=(JavascriptExecutor)driver;
        jse.executeScript("scroll(0, 3000)"); //scrolling to bottom of the page
        facebookIcon.click();
        Thread.sleep(3000);
    }
    public void clickOnSignInSignUpLabel(){
        signInLabel.click();
        signUpLabel.click();
    }
    public void singIn(String username,String password) throws InterruptedException {
        signInLabel.click();
        usernameTextBox.sendKeys(username);
        passwordTextBox.sendKeys(password);
        rememberCheckBox.click();
        loginButton.click();
        Thread.sleep(3000);
    }

}

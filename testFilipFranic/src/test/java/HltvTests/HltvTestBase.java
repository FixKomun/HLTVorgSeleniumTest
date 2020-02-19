package HltvTests;

import HltvPages.HltvHomePage;
import HltvPages.HltvSearchPage;
import HltvPages.HltvSignUpPage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class HltvTestBase {

    public static WebDriver driver=null;
    JavascriptExecutor jse;

    //Cross browser testing for firefox,chrome and IE
    @BeforeMethod
    @Parameters("browser")
    public void invokeBrowser(String browserName)
    {
        if(browserName.equalsIgnoreCase("Firefox"))
        {
            System.setProperty("webdriver.gecko.driver","F:\\geckodriver.exe");
            driver=new FirefoxDriver();
        }
        else if(browserName.equalsIgnoreCase("Chrome"))
        {
            System.setProperty("webdriver.chrome.driver","F:\\chromedriver.exe");
            driver= new ChromeDriver();
        }
        else if(browserName.equalsIgnoreCase("InternetExplorer"))
        {
            System.setProperty("ie.chrome.driver","F:\\IEDriverServer.exe");
            driver=new InternetExplorerDriver();
        }

        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        //synchronizing code and webpage (Max=30sec,min=0sec)
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);
        driver.get(InputStrings.URL);

    }

//Tests going to be run on the website set by URL

    @Test
    public void searchInput() throws InterruptedException {
        HltvHomePage homePage = PageFactory.initElements(driver, HltvHomePage.class);
        homePage.setSearchTextBox(InputStrings.SEARCH_STRING);
        homePage.clickOnSearchIcon();
    }

    @Test
    public void searchTeam() throws InterruptedException {
        HltvHomePage homePage = PageFactory.initElements(driver, HltvHomePage.class);
        homePage.setSearchTextBox(InputStrings.SEARCHTEAM_STRING);
        homePage.clickOnSearchIcon();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(10,TimeUnit.SECONDS);
        HltvSearchPage searchPage = PageFactory.initElements(driver, HltvSearchPage.class);
        searchPage.CheckNameEqual(InputStrings.SEARCHTEAM_STRING);
        searchPage.ClickOnSearchedTeam();
    }

    @Test
    public void facebookPage() throws InterruptedException {
        HltvHomePage homePage=PageFactory.initElements(driver,HltvHomePage.class);
        homePage.clickOnFacebookIcon();

    }

    @Test
    public void signInMethod() throws InterruptedException {
        HltvHomePage homePage=PageFactory.initElements(driver,HltvHomePage.class);
        homePage.singIn(InputStrings.IN_USERNAME_STRING,InputStrings.IN_PASSWORD_STRING);

    }

    @Test
    public void signUpMethod() throws InterruptedException{
        HltvHomePage homePage=PageFactory.initElements(driver,HltvHomePage.class);
        homePage.clickOnSignInSignUpLabel();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(10,TimeUnit.SECONDS);
        HltvSignUpPage signUpPage=PageFactory.initElements(driver,HltvSignUpPage.class);
        signUpPage.signUp(
                InputStrings.UP_USERNAME_STRING,
                InputStrings.UP_PASSWORD_STRING,
                InputStrings.UP_EMAIL_STRING,
                InputStrings.UP_CONFIRMPASSWORD_STRING,
                InputStrings.UP_CONFIRMEMAIL_STRING,
                InputStrings.UP_NATIONALITY_STRING,
                InputStrings.UP_TIMEZONE_STRING);
    }

    //Shutting down browser
    @AfterMethod
    public void testShutdown()
    {
        driver.quit();
    }
}

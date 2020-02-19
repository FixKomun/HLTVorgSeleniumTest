package HltvPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class HltvSearchPage {
    WebDriver driver;

    public HltvSearchPage(WebDriver driver)
    {
        this.driver=driver;
    }
    //Locating the elements using @Findby
    @FindBy(css = "table:nth-of-type(1) > tbody > tr:nth-of-type(2) > td > a")
    private WebElement searchedTeam;

    //Defining all the users methods/functions
    public void ClickOnSearchedTeam() throws InterruptedException {
    searchedTeam.findElements(By.cssSelector("table:nth-of-type(1) > tbody > tr:nth-of-type(2) > td > a"));
    searchedTeam.click();
    Thread.sleep(5000);
    }

    public void CheckNameEqual(String SEARCHTEAM_STRING){
        Assert.assertEquals(searchedTeam.getText(), SEARCHTEAM_STRING);
        System.out.println("Searched team is found on the team list!");

    }
}

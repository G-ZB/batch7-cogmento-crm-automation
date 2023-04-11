package com.cogmento.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class Home {

    private WebDriver driver;
    private SoftAssert softAssert;
    private WebDriverWait wait;
    public Home(WebDriver driver, SoftAssert softAssert){
        this.driver = driver;
        this.softAssert = softAssert;
        this.wait = new WebDriverWait(this.driver, Duration.ofSeconds(20));
        PageFactory.initElements(driver,this);

    }

    @FindBy(xpath = "//div[@class='header item']")
    protected WebElement logo; //protected because it will be inheritance otherwise if it is private will not be inherited

    @FindBy(xpath = "//div[@class='header item']/following-sibling::b")
    protected WebElement organizationName;

    @FindBy(xpath = "//span[@class = 'user-display']")
    protected WebElement userName;

    @FindBy(xpath = "//input[@placeholder = 'search']")
    protected WebElement searchInput;

    @FindBy(xpath = "(//i[@class = 'settings icon'])[1]")
    protected WebElement settingsGear;

//   protected String settingNavigation = "//div[@class='menu transition visible']/a"; //OR
   protected String settingNavigation = "//div[@class='menu transition visible']/a//span[text()='";
    protected void logout() {
        settingsGear.click();
//      driver.findElement(By.xpath(settingNavigation + [7]]"));
        driver.findElement(By.xpath(settingNavigation + "Log Out']")).click();
    }
        protected void navigateToSettings() {
            settingsGear.click();
            driver.findElement(By.xpath(settingNavigation + "Settings']")).click();
        }
            protected void navigateToProducts(){
                settingsGear.click();
                driver.findElement(By.xpath(settingNavigation + "Products']")).click();
    }

    protected void navigateToImport(){
        settingsGear.click();
        driver.findElement(By.xpath(settingNavigation + "Import']")).click();
    }
    protected void navigateToTools(){
        settingsGear.click();
        driver.findElement(By.xpath(settingNavigation + "Tools']")).click();
    }

}

package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TourSearch extends AbstractPage {
    protected TourSearch(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//iframe[@id='tcjsfr_dcf123fa87fd459f532eefda037008fd']")
    private WebElement frameSearchMenu;
    @FindBy(xpath = "//iframe[@id='popup_tcjsfr_dcf123fa87fd459f532eefda037008fd']")
    private WebElement frameCityChoose;
    @FindBy(xpath = "//iframe[@id='select_tcjsfr_dcf123fa87fd459f532eefda037008fd']")
    private WebElement frameNumberValueChoose;
    @FindBy(xpath = "//*[@id='module_dcf123fa87fd459f532eefda037008fd']//tr[1]/td[1]//div[2]/div")
    private WebElement dropDownCityFrom;
    @FindBy(xpath = "//*[@id='module_dcf123fa87fd459f532eefda037008fd']//tr[1]/td[2]//div[2]/div")
    private WebElement dropDownCityTo;
    @FindBy(xpath = "//td[1]//a[contains(@id,'sbToggle')]")
    private WebElement dropDownNightsFrom;
    @FindBy(xpath = "//td[5]//a[contains(@id,'sbToggle')]")
    private WebElement dropDownAdultsNumber;
    private String patternPathCityName = "//div[contains(text(),'%s')]";
    private String patternPathResortName = "//*[@id='resort_4']//span[contains(text(),'%s')]";
    private String patternNumberValue= "//li[@class='durationf_%s']";


    private void switchToFrame(WebElement frame) {
        driver.switchTo().defaultContent();
        driver.switchTo().frame(frame);

    }

    public TourSearch chooseCityTourFrom(String cityTourFrom) {
        switchToFrame(frameSearchMenu);
        dropDownCityFrom.click();
        switchToFrame(frameCityChoose);
        driver.findElement(By.xpath(String.format(patternPathCityName, cityTourFrom))).click();
        return this;
    }

    public TourSearch chooseCityTourTo(String cityTourTo) throws InterruptedException {
        switchToFrame(frameSearchMenu);
        Thread.sleep(1000);
        dropDownCityTo.click();
        switchToFrame(frameCityChoose);
        waitForElementToBeClickable(driver.findElement(By.xpath(String.format(patternPathCityName, cityTourTo)))).click();
        Thread.sleep(3000);
        return this;
    }

    public TourSearch chooseResort(String resortName) {
        switchToFrame(frameSearchMenu);
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(By.xpath(String.format(patternPathResortName, resortName)))).click().build().perform();
        return this;
    }

    public TourSearch chooseNumberOfNights(String value) {
        dropDownNightsFrom.click();
        switchToFrame(frameNumberValueChoose);
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(By.xpath(String.format(patternNumberValue, value)))).click().build().perform();
return this;
    }
    public TourSearch chooseNumberOfAdults(String value) {
        dropDownNightsFrom.click();
        switchToFrame(frameNumberValueChoose);
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(By.xpath(String.format(patternNumberValue, value)))).click().build().perform();
        return this;
    }

}

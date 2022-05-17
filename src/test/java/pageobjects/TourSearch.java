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
    private WebElement buttonDropDownCityFrom;
    @FindBy(xpath = "//*[@id='module_dcf123fa87fd459f532eefda037008fd']//tr[1]/td[2]//div[2]/div")
    private WebElement buttonDropDownCityTo;
    @FindBy(xpath = "//td[1]//a[contains(@id,'sbToggle')]")
    private WebElement buttonDropDownNightsFrom;
    @FindBy(xpath = "//td[5]//a[contains(@id,'sbToggle')]")
    private WebElement buttonDropDownAdultsNumber;
    @FindBy(xpath = "//td[2]//a[contains(@id,'sbToggle')]")
    private WebElement buttonDropDownChildrenNumber;
    @FindBy(xpath = "//td[4]//a[contains(@id,'sbToggle')]")
    private WebElement buttonDropDownFirstChildAge;
    @FindBy(xpath = "//td[6]//a[contains(@id,'sbToggle')]")
    private WebElement buttonDropDownSecondChildAge;
    @FindBy(xpath = "//td[1]/div[contains(@class,'date-value')]")
    private WebElement buttonDropDownDateFlightFrom;
    @FindBy(xpath = "//a[contains(@class,'search-form-btn')]")
    private WebElement buttonSearch;
    private String patternPathCityName = "//div[contains(text(),'%s')]";
    private String patternPathResortName = "//li[contains(@id,'resort')]//span[contains(text(),'%s')]";
    private String patternPathNumberOfNights = "//body/div/ul/li[@class='durationf_%s']";
    private String patternPathNumberOfAdults = "//li[contains(@class,'adults_%s')]";
    private String patternPathNumberOfChildren = "//li[contains(@class,'children_%s')]";
    private String patternPathChildAge = "//*[contains(@class,'sbOptions')]//a[@title='%s']";
    private String patternPathDateFlightFrom = "//*[@id='ls-ui-datepicker-div']/div//a[contains(text(),'%s')]";

    private void switchToFrame(WebElement frame) {

        driver.switchTo().defaultContent().switchTo().frame(frame);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            logger.warn(e.getMessage());
        }
    }

    public TourSearch chooseCityTourFrom(String cityTourFrom) {
        switchToFrame(frameSearchMenu);
        buttonDropDownCityFrom.click();
        switchToFrame(frameCityChoose);
        driver.findElement(By.xpath(String.format(patternPathCityName, cityTourFrom))).click();
        return this;
    }

    public TourSearch chooseCityTourTo(String cityTourTo) {
        switchToFrame(frameSearchMenu);
        buttonDropDownCityTo.click();
        switchToFrame(frameCityChoose);
        waitForElementToBeClickable(driver.findElement(By.xpath(String.format(patternPathCityName, cityTourTo)))).click();
        return this;
    }

    public TourSearch chooseResort(String resortName) {
        switchToFrame(frameSearchMenu);
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(By.xpath(String.format(patternPathResortName, resortName)))).click().build().perform();
        return this;
    }

    public TourSearch chooseNumberOfNights(String value) {
        switchToFrame(frameSearchMenu);
        buttonDropDownNightsFrom.click();
        switchToFrame(frameNumberValueChoose);
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(By.xpath(String.format(patternPathNumberOfNights, value)))).click().build().perform();
        return this;
    }

    public TourSearch chooseNumberOfAdults(String value) {
        switchToFrame(frameSearchMenu);
        buttonDropDownAdultsNumber.click();
        switchToFrame(frameNumberValueChoose);
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(By.xpath(String.format(patternPathNumberOfAdults, value)))).click().build().perform();
        return this;
    }

    public TourSearch chooseNumberOfChildren(String value) {
        switchToFrame(frameSearchMenu);
        buttonDropDownChildrenNumber.click();
        switchToFrame(frameNumberValueChoose);
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(By.xpath(String.format(patternPathNumberOfChildren, value)))).click().build().perform();
        return this;
    }

    public TourSearch chooseFirstChildAge(String value) {
        switchToFrame(frameSearchMenu);
        buttonDropDownFirstChildAge.click();
        switchToFrame(frameNumberValueChoose);
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(By.xpath(String.format(patternPathChildAge, value)))).click().build().perform();
        return this;
    }

    public TourSearch chooseSecondChildAge(String value) {
        switchToFrame(frameSearchMenu);
        buttonDropDownSecondChildAge.click();
        switchToFrame(frameNumberValueChoose);
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(By.xpath(String.format(patternPathChildAge, value)))).click().build().perform();
        return this;
    }

    public TourSearch chooseDateFlight(String value) {
        switchToFrame(frameSearchMenu);
        buttonDropDownDateFlightFrom.click();
        switchToFrame(frameCityChoose);
        driver.findElement(By.xpath(String.format(patternPathDateFlightFrom, value))).click();
        return this;
    }

    public SearchResultPage clickButtonSearch() {
        switchToFrame(frameSearchMenu);
        buttonSearch.click();
        return new SearchResultPage(driver);
    }
}

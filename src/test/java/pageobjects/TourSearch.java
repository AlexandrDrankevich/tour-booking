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
    @FindBy(xpath = "//td[2]//a[contains(@id,'sbToggle')]")
    private WebElement dropDownChildrenNumber;
    @FindBy(xpath = "//td[4]//a[contains(@id,'sbToggle')]")
    private WebElement dropDownFirstChildAge;
    @FindBy(xpath = "//td[6]//a[contains(@id,'sbToggle')]")
    private WebElement dropDownSecondChildAge;
    @FindBy(xpath = "//td[1]/div[contains(@class,'date-value')]")
    private WebElement dropDownDateFlightFrom;
    private String patternPathCityName = "//div[contains(text(),'%s')]";
    private String patternPathResortName = "//li[contains(@id,'resort')][@data-text='%s']";
    private String patternPathNumberNights = "//li[@class='durationf_%s']";
    private String patternPathNumberAdults = "//li[contains(@class,'adults_%s')]";
    private String patternPathNumberChildren = "//li[contains(@class,'children_%s')]";
    private String patternPathChildAge = "//*[contains(@class,'sbOptions')]//a[@title='%s']";
    private String patternPathDateFlightFrom = "//*[@id='ls-ui-datepicker-div']/div//a[contains(text(),'%s')]";

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

    public TourSearch chooseNumberOfNights(String value) throws InterruptedException {
        switchToFrame(frameSearchMenu);
        dropDownNightsFrom.click();
        switchToFrame(frameNumberValueChoose);
        //Thread.sleep(3000);
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(By.xpath(String.format(patternPathNumberNights, value)))).click().build().perform();
        return this;
    }

    public TourSearch chooseNumberOfAdults(String value) {
        switchToFrame(frameSearchMenu);
        dropDownAdultsNumber.click();
        switchToFrame(frameNumberValueChoose);
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(By.xpath(String.format(patternPathNumberAdults, value)))).click().build().perform();
        return this;
    }

    public TourSearch chooseNumberOfChidren(String value) {
        switchToFrame(frameSearchMenu);
        dropDownChildrenNumber.click();
        switchToFrame(frameNumberValueChoose);
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(By.xpath(String.format(patternPathNumberChildren, value)))).click().build().perform();
        return this;
    }

    public TourSearch chooseFirstChildAge(String value) {
        switchToFrame(frameSearchMenu);
        dropDownFirstChildAge.click();
        switchToFrame(frameNumberValueChoose);
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(By.xpath(String.format(patternPathChildAge, value)))).click().build().perform();
        return this;
    }

    public TourSearch chooseSecondChildAge(String value) {
        switchToFrame(frameSearchMenu);
        dropDownSecondChildAge.click();
        switchToFrame(frameNumberValueChoose);
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(By.xpath(String.format(patternPathChildAge, value)))).click().build().perform();
        return this;
    }

    public TourSearch chooseDateFlight(String value) {
        switchToFrame(frameSearchMenu);
        dropDownDateFlightFrom.click();
        switchToFrame(frameCityChoose);
        driver.findElement(By.xpath(String.format(patternPathDateFlightFrom, value))).click();
        return this;
    }

}

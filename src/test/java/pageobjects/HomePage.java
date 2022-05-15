package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends AbstractPage {
    private final String BASE_URL = "https://belturizm.by/";
    private String patternButtonNavigationMenu = "//*[@id='site-navigation']//a[contains(text(), '%s')]";

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public HomePage openPage() {
        driver.get(BASE_URL);
        return this;
    }

    public TourSearch navigateToTourSearch(String tourType) {
        driver.findElement(By.xpath(String.format(patternButtonNavigationMenu, tourType))).click();
        return new TourSearch(driver);
    }
}

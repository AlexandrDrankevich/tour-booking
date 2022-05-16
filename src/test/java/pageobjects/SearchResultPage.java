package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.stream.Collectors;

public class SearchResultPage extends AbstractPage {

    List<String> listResorts;

    protected SearchResultPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        getListResorts();
    }

    @FindBy(xpath = "//iframe[@id='tcjsfr_7bcf672ed6f2f653cc2abf8929877414']")
    private WebElement frameResult;
    private String searchResultPath = "//div[@class='search-results-place-wrap']/a";

    public void getListResorts() {
        driver.switchTo().defaultContent().switchTo().frame(frameResult);
        List<WebElement> elements = driver.findElements(By.xpath(searchResultPath));
        listResorts = elements.stream().map(s -> s.getText()).collect(Collectors.toList());
        logger.info(listResorts);
    }

    public boolean isResultsSearchContainsResort(String resortName) {
        return listResorts.contains(resortName);
    }

    public boolean isAllResultsSearchContainsResort(String resortName) {
        return listResorts.stream().allMatch(s -> s.contains(resortName));
    }
}




package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.HomePage;
import pageobjects.SearchResultPage;

public class BelturizmTest extends AbstractTest {
    @Test
    public void testTourSearch() {
        String tourType = "Авиатуры";
        String cityTourFrom = "Минск";
        String cityTourTo = "Египет";
        String resortName = "Хургада";
        String numberOfNights = "11";
        String numberOfAdults = "2";
        String numberOfChildren = "2";
        String childAge = "3";
        String dateFlight = "24";

        SearchResultPage searchResultPage = new HomePage(driver).openPage()
                .navigateToTourSearch(tourType)
                .chooseCityTourFrom(cityTourFrom)
                .chooseCityTourTo(cityTourTo)
                .chooseResort(resortName)
                .chooseNumberOfNights(numberOfNights)
                .chooseNumberOfAdults(numberOfAdults)
                .chooseNumberOfChildren(numberOfChildren)
                .chooseFirstChildAge(childAge)
                .chooseSecondChildAge(childAge)
                .chooseDateFlight(dateFlight)
                .clickButtonSearch();
        Assert.assertTrue(searchResultPage.isResultsSearchContainsResort(resortName));
        Assert.assertTrue(searchResultPage.isAllResultsSearchContainsResort(resortName));
    }
}

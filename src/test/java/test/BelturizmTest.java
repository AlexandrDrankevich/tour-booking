package test;

import org.testng.annotations.Test;
import pageobjects.HomePage;

public class BelturizmTest extends AbstractTest {
    @Test
    public void testTourSearch() throws InterruptedException {
        String tourType = "Авиатуры";
        String cityTourFrom = "Минск";
        String cityTourTo = "Египет";
        String resortName = "Хургада";
        String numberOfNights = "11";
        String numberOfAdults = "2";
        String numberOfChildren = "2";
        String childAge = "3";
        String dateFlight= "24";


        new HomePage(driver).openPage()
                .navigateToTourSearch(tourType)
                .chooseCityTourFrom(cityTourFrom)
                .chooseCityTourTo(cityTourTo)
                .chooseResort(resortName)
                .chooseNumberOfNights(numberOfNights)
               .chooseNumberOfAdults(numberOfAdults)
                .chooseNumberOfChidren(numberOfChildren)
                .chooseFirstChildAge(childAge)
        .chooseSecondChildAge(childAge).chooseDateFlight(dateFlight).clickButtonSearch();


        Thread.sleep(10000);

    }
}

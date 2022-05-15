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


        new HomePage(driver).openPage()
                .navigateToTourSearch(tourType)
                .chooseCityTourFrom(cityTourFrom)
                .chooseCityTourTo(cityTourTo)
                .chooseResort(resortName)
                .chooseNumberOfNights(numberOfNights)
               .chooseNumberOfAdults(numberOfAdults);
        Thread.sleep(3000);

    }
}

package tests.negativeTests;

import io.qameta.allure.TmsLink;
import org.testng.annotations.Test;
import pages.MortgageCalculatorPage;
import tests.BaseTest;

import static config.Constants.INTEREST_RATE;
import static config.Constants.NEGATIVE;

public class VerifyInterestRateFieldWontAcceptOutOfBoundariesValuesTest extends BaseTest {

    MortgageCalculatorPage mortgageCalculatorPage = new MortgageCalculatorPage();

    @Test(groups = {NEGATIVE}, description = "Verify that “Interest rate” field won’t accept out of boundaries values")
    @TmsLink("NT-2")
    public void verifyInterestRateFieldWontAcceptOutOfBoundariesValuesTest() {
        stepName("1. Open \"MortgageCalculator\"");
        openMainPage();
        mortgageCalculatorPage.shouldSeeMortgageCalculatorPage();

        stepName("2. Type “101” value in to the “Interest rate” field");
        mortgageCalculatorPage.setValueForField(INTEREST_RATE, "101")
                .clickOutside()
                .shouldSeeErrorForInterestsRateField("Rate must be less than or equal to 100");

        stepName("3. Type “100,1” value in to the “Interest rate” field");
        mortgageCalculatorPage.setValueForField(INTEREST_RATE, "100,1")
                .clickOutside()
                .shouldSeeErrorForInterestsRateField("Rate must be less than or equal to 100");
    }
}
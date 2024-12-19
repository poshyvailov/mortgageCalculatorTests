package tests.negativeTests;

import io.qameta.allure.TmsLink;
import org.testng.annotations.Test;
import pages.MortgageCalculatorPage;
import tests.BaseTest;

import static config.Constants.*;

public class VerifyInterestRateFieldWontAcceptNegativeValuesTest extends BaseTest {

    MortgageCalculatorPage mortgageCalculatorPage = new MortgageCalculatorPage();

    @Test(groups = {NEGATIVE}, description = "Verify that “Interest rate” field won’t accept negative values")
    @TmsLink("NT-1")
    public void verifyInterestRateFieldWontAcceptNegativeValuesTest() {
        stepName("1. Open \"MortgageCalculator\"");
        openMainPage();
        mortgageCalculatorPage.shouldSeeMortgageCalculatorPage();

        stepName("2. Type “ -1” value in to the “Interest rate” field");
        mortgageCalculatorPage.setValueForField(INTEREST_RATE, "-1")
                .clickOutside()
                .shouldSeeErrorForInterestsRateField("Rate must be greater than or equal to 0");
    }
}
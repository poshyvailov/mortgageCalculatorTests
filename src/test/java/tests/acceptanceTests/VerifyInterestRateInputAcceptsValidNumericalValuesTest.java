package tests.acceptanceTests;

import io.qameta.allure.TmsLink;
import org.testng.annotations.Test;
import pages.MortgageCalculatorPage;
import tests.BaseTest;

import static config.Constants.*;


public class VerifyInterestRateInputAcceptsValidNumericalValuesTest extends BaseTest {

    MortgageCalculatorPage mortgageCalculatorPage = new MortgageCalculatorPage();

    @Test(groups = {ACCEPTANCE}, description = "Verify the interest rate input accepts valid numerical values")
    @TmsLink("AT-1")
    public void verifyInterestRateInputAcceptsValidNumericalValuesTest() {
        stepName("1. Open \"MortgageCalculator\"");
        openMainPage();
        mortgageCalculatorPage.shouldSeeMortgageCalculatorPage();

        stepName("2. Enter a valid interest rate to the “Interest rate” field (e.g., 5.5).");
        int fieldValue = mortgageCalculatorPage.getPaymentValue(YOUR_PAYMENT,0);
        mortgageCalculatorPage.setValueForField(INTEREST_RATE, "5.5");

        stepName("3. Click outside the field to trigger the calculation");
        mortgageCalculatorPage.clickOutside();

        stepName("4. Check data in the chart in the “Breakdown” tab");
        mortgageCalculatorPage.shouldSeeChangedValue(YOUR_PAYMENT, fieldValue);
    }
}
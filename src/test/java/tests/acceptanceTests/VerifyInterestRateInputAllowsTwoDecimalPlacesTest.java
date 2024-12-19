package tests.acceptanceTests;

import io.qameta.allure.TmsLink;
import org.testng.annotations.Test;
import pages.MortgageCalculatorPage;
import tests.BaseTest;

import static config.Constants.*;

public class VerifyInterestRateInputAllowsTwoDecimalPlacesTest extends BaseTest {

    MortgageCalculatorPage mortgageCalculatorPage = new MortgageCalculatorPage();

    @Test(groups = {ACCEPTANCE}, description = "Verify interest rate input allows two decimal places")
    @TmsLink("AT-2")
    public void verifyInterestRateInputAllowsTwoDecimalPlacesTest() {
        stepName("1. Open \"MortgageCalculator\"");
        openMainPage();
        mortgageCalculatorPage.shouldSeeMortgageCalculatorPage();

        stepName("2. Enter two decimal places value (e.g.: “4.25”) to the “Interest rate” field");
        int fieldValue = mortgageCalculatorPage.getPaymentValue(YOUR_PAYMENT,0);
        mortgageCalculatorPage.setValueForField(INTEREST_RATE, "4.25");

        stepName("3. Click outside the field to trigger the calculation");
        mortgageCalculatorPage.clickOutside();

        stepName("4. Check data in the chart in the “Breakdown” tab");
        mortgageCalculatorPage.shouldSeeChangedValue(YOUR_PAYMENT, fieldValue);
    }
}